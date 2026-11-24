package com.ejemplo.accountsapi.repository;

import com.ejemplo.accountsapi.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccountRepository {

    private final Map<UUID, Account> storage = new ConcurrentHashMap<>();

    public Account save(Account account) {
        storage.put(account.getId(), account);
        return account;
    }

    public List<Account> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Account> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }
}
