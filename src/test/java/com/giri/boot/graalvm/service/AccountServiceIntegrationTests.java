package com.giri.boot.graalvm.service;

import com.giri.boot.graalvm.domain.Account;
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
    void deposit_() {
        // given: account
        var account = new Account("test-1", BigDecimal.valueOf(100.129));

        // when: valid amount is deposited
        accountService.deposit(account, BigDecimal.valueOf(1000));
        // then: expect correct balance
        assertThat(account.getBalance()).isEqualTo(BigDecimal.valueOf(1100.13));
    }
}
