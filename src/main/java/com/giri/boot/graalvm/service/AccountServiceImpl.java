package com.giri.boot.graalvm.service;

import com.giri.boot.graalvm.domain.Account;
import com.giri.boot.graalvm.domain.Transaction;
import com.giri.boot.graalvm.domain.TransactionType;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * A concrete implementation of {@link AccountService}
 *
 * @author pottepalemg
 * created May 12, 2023
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService{

    @Override
    public Account deposit(@NonNull Account account, @NonNull BigDecimal amount) {
        return executeAccountTransaction(account, TransactionType.DEPOSIT, amount);
    }

    @Override
    public Account withdraw(@NonNull Account account, @NonNull BigDecimal amount) {
        return executeAccountTransaction(account, TransactionType.WITHDRAWAL, amount);
    }

    private Account transact(@NonNull Transaction transaction) {
        switch (transaction.transactionType()) {
            case WITHDRAWAL -> {
                var balance = transaction.account().getBalance();
                if (balance.subtract(transaction.amount()).compareTo(BigDecimal.valueOf(0)) == -1) {
                    throw new IllegalArgumentException("Amount for withdrawal: " + transaction.amount() + " exceeds current balance.");
                }
                transaction.account().setBalance(transaction.account().getBalance().subtract(transaction.amount()));
            }
            case DEPOSIT -> transaction.account().setBalance(transaction.account().getBalance().add(transaction.amount()));
        }
        return transaction.account();
    }

    private Account executeAccountTransaction(@NonNull Account account, @NonNull TransactionType transactionType, @NonNull BigDecimal amount) {
        switch (transactionType) {
            case WITHDRAWAL -> {
                var balance = account.getBalance();
                if (balance.subtract(amount).compareTo(BigDecimal.valueOf(0)) == -1) {
                    throw new IllegalArgumentException("Amount for withdrawal: " + amount + " exceeds current balance.");
                }
                account.setBalance(account.getBalance().subtract(amount));
            }
            case DEPOSIT -> account.setBalance(account.getBalance().add(amount));
        }
        return account;
    }
}
