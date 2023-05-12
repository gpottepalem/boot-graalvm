package com.giri.boot.graalvm.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pottepalemg
 * created May 08, 2023
 */
public class AddressTests {
    @Test
    void assertj_examine_object() {
        // given new address
        Address address = new Address("43 Bella Rd", null, "Sharon", "MA", "02067");

        // verify
        assertThat(address)
            .hasAllNullFieldsOrPropertiesExcept("address1", "city", "state", "zip")
//            .extracting("address1").isEqualTo("43 Bella Rd")
//            .extracting("city").isEqualTo("Sharon") // extracting works only for extracting multiple properties once and checking all, No getter for property 'city' in java.lang.String
            .returns("43 Bella Rd", Address::address1)
            .returns("Sharon", Address::city)
            .returns("MA", Address::state)
            .returns("02067", Address::zip)
            .extracting("city").isEqualTo("Sharon")
        ;

    }
}
