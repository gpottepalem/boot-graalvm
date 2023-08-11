package com.giri.boot.graalvm.domain;

import lombok.NonNull;

import java.math.BigDecimal;

/**
 * @author pottepalemg
 * created May 13, 2023
 */
public record Transaction(@NonNull Account account, @NonNull BigDecimal amount, @NonNull TransactionType transactionType) {}
