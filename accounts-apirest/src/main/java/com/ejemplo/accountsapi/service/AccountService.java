package com.ejemplo.accountsapi.service;

import com.ejemplo.accountsapi.dto.CreateAccountRequest;
import com.ejemplo.accountsapi.exception.ResourceNotFoundException;
import com.ejemplo.accountsapi.model.Account;
import com.ejemplo.accountsapi.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account create(CreateAccountRequest request) {
        Account account = new Account(
            UUID.randomUUID(),
            request.holderName().trim(),
            request.currency().toUpperCase(),
            request.initialBalance(),
            Instant.now()
        );
        return repository.save(account);
    }

    public List<Account> findAll() {
        return repository.findAll();
    }

    public Account findById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con ID: " + id));
    }

    public Account deposit(UUID id, BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto del depósito debe ser mayor que cero");
        }
        Account account = findById(id);
        account.setBalance(account.getBalance().add(amount));
        return repository.save(account);
    }
}
