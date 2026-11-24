package com.ejemplo.accountsapi.controller;

import com.ejemplo.accountsapi.dto.CreateAccountRequest;
import com.ejemplo.accountsapi.model.Account;
import com.ejemplo.accountsapi.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Account> create(@Valid @RequestBody CreateAccountRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Account> deposit(
        @PathVariable UUID id,
        @RequestParam BigDecimal amount
    ) {
        return ResponseEntity.ok(service.deposit(id, amount));
    }
}
