package com.giri.boot.graalvm.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pottepalemg
 * created May 08, 2023
 */
public class AccountHolderTests {
    @Test
    void assertj_examine_object() {
        // given
        AccountHolder accountHolder = new AccountHolder(
            "Giri",
            "Potte",
            List.of(
                new Address("43 Bella Rd", null, "Sharon", "MA", "02067"),
                new Address("85 Stillwater Rd", null, "Canton", "MA", "02021")
            )
        );

        // verify
        assertThat(accountHolder)
            .hasNoNullFieldsOrProperties()
            .returns("Giri", AccountHolder::firstName)
            .returns("Potte", AccountHolder::lastName)
            .extracting("addresses").isNotNull().asList().hasSize(2);

    }

    @Test
    void assertj_verify() {
        // given
        AccountHolder accountHolder = new AccountHolder(
            "Giri",
            "Potte",
            List.of(
                new Address("43 Bella Rd", null, "Sharon", "MA", "02067"),
                new Address("85 Stillwater Rd", null, "Canton", "MA", "02021")
            )
        );

    }
}
