package com.ejemplo.accountsapi.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record CreateAccountRequest(
    @NotBlank(message = "El nombre del titular es obligatorio")
    @Size(max = 120)
    String holderName,

    @NotBlank(message = "La moneda es obligatoria")
    @Size(min = 3, max = 3)
    String currency,

    @NotNull
    @DecimalMin(value = "0.00", message = "El saldo inicial no puede ser negativo")
    BigDecimal initialBalance
) {}
