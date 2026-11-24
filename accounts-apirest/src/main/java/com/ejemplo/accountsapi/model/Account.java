package com.ejemplo.accountsapi.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Account {
    private final UUID id;
    private String holderName;
    private String currency;
    private BigDecimal balance;
    private final Instant createdAt;

    public Account(UUID id, String holderName, String currency, BigDecimal balance, Instant createdAt) {
        this.id = id;
        this.holderName = holderName;
        this.currency = currency;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
    public Instant getCreatedAt() { return createdAt; }
}
