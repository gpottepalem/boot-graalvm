package com.giri.boot.graalvm.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pottepalemg
 * created May 08, 2023
 */
public class AccountHolderRecordTest {
    @Test
    void assertj_examine_object() {
        // given
        AccountHolderRecord accountHolder = new AccountHolderRecord(
            "Giri",
            "Potte",
            List.of(
                new AddressRecord("43 Bella Rd", null, "Sharon", "MA", "02067"),
                new AddressRecord("85 Stillwater Rd", null, "Canton", "MA", "02021")
            )
        );

        // verify
        assertThat(accountHolder)
            .hasNoNullFieldsOrProperties()
            .returns("Giri", AccountHolderRecord::firstName)
            .returns("Potte", AccountHolderRecord::lastName)
            .extracting("addresses").isNotNull().asList().hasSize(2);

    }

    @Test
    void assertj_verify() {
        // given
        AccountHolderRecord accountHolder = new AccountHolderRecord(
            "Giri",
            "Potte",
            List.of(
                new AddressRecord("43 Bella Rd", null, "Sharon", "MA", "02067"),
                new AddressRecord("85 Stillwater Rd", null, "Canton", "MA", "02021")
            )
        );

    }
}
