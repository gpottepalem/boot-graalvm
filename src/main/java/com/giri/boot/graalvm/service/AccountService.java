package com.giri.boot.graalvm.service;

import com.giri.boot.graalvm.domain.Account;

import java.math.BigDecimal;

/**
 * Account Service, provides interface for {@link Account} transactions.
 *
 * @author pottepalemg
 * created May 12, 2023
 */
public interface AccountService {
    /** Deposits given amount into the Account */
    Account deposit(Account account, BigDecimal amount);

    /** Withdraws given amount from the Account */
    Account withdraw(Account account, BigDecimal amount);
}
