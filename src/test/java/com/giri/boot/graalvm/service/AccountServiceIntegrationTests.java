package com.giri.boot.graalvm.service;

import com.giri.boot.graalvm.domain.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

/**
 * @author pottepalemg
 * created May 12, 2023
 */
@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class AccountServiceIntegrationTests {
    @Autowired
    AccountService accountService;

    @Test
    void deposit_is_protected_for_null_arguments() {
        // given: account
        var account = new Account("test-1", BigDecimal.valueOf(100.129));
        // expect: invalid amount withdrawal throws exception
        Assertions.assertThrows(NullPointerException.class, () -> {
            accountService.deposit(null, BigDecimal.valueOf(1000));
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            accountService.deposit(account, null);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            accountService.deposit(null, null);
        });
    }

    @Test
    void withdraw_is_protected_for_null_arguments() {
        // given: account
        var account = new Account("test-1", BigDecimal.valueOf(100.129));
        // expect: invalid amount withdrawal throws exception
        Assertions.assertThrows(NullPointerException.class, () -> {
            accountService.withdraw(null, BigDecimal.valueOf(1000));
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            accountService.withdraw(account, null);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            accountService.withdraw(null, null);
        });
    }

    @Test
    @DisplayName("Deposited amount should be added to the balance.")
    void deposit_aads_to_balance() {
        // given: account
        var account = new Account("test-1", BigDecimal.valueOf(100.129));
        // when: valid amount is deposited
        accountService.deposit(account, BigDecimal.valueOf(1000));
        // then: expect correct balance
        assertThat(account.getBalance()).isEqualTo(BigDecimal.valueOf(1100.13));
    }

    @Test
    @DisplayName("Withdrawal amount should be subtracted from the balance.")
    void withdraw_updates_blance() {
        // given: account
        var account = new Account("test-1", BigDecimal.valueOf(1000.129));
        // when: valid amount is withdrawn
        accountService.withdraw(account, BigDecimal.valueOf(100));
        // then: expect correct balance
        assertThat(account.getBalance()).isEqualTo(BigDecimal.valueOf(900.13));
    }

    @Test
    @DisplayName("Withdrawal amount exceeding the balance should result into exception.")
    void withdrawal_amount_exceeding_balance_result_into_exception() {
        // given: account
        var account = new Account("test-1", BigDecimal.valueOf(100.129));
        // expect: invalid amount withdrawal throws exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            accountService.withdraw(account, BigDecimal.valueOf(200));
        });
    }
}
