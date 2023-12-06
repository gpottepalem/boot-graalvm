package com.giri.boot.graalvm.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration test for {@link Account}
 *
 * @author pottepalemg
 * created Apr 25, 2023
 */
@JsonTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class AccountIT {
    @Autowired
    private JacksonTester<Account> json;

    @Test
    public void account_with_positive_balance_serialized_contains_balance_amount() throws IOException {
        // given: account with positive balance
        var account = new Account("ABC-1", BigDecimal.valueOf(100.99));

        // when: account is serialized
        JsonContent<Account> accountJson = json.write(account);

        // then: verify that serialized data looks as expected
        assertThat(accountJson)
            .extractingJsonPathValue("$.number").isEqualTo("ABC-1");
        assertThat(accountJson)
            .extractingJsonPathValue("$.balance").isEqualTo(100.99);
    }

    @Test
    public void account_with_negative_balance_serialized_contains_Negative_String_as_balance() throws IOException {
        // given: account with negative balance
        Account account = new Account("ABC-2", BigDecimal.valueOf(-100.99));

        // when: account is serialized
        JsonContent<Account> accountJson = json.write(account);

        // then: verify that serialized data looks as expected
        assertThat(accountJson)
            .extractingJsonPathValue("$.number").isEqualTo("ABC-2");
        assertThat(accountJson)
            .extractingJsonPathValue("$.balance").isEqualTo("Negative");
    }
}
