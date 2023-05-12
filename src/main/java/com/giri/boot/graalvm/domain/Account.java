package com.giri.boot.graalvm.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A simple Account record.
 * NOTE:
 * The balance is always set by rounding it to 2 decimal scale and rounded to {@link RoundingMode#HALF_UP} for both
 * setter and builder method.
 *
 * @author pottepalemg
 * created Apr 24, 2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
//@Setter(AccessLevel.NONE)
@Slf4j
public class Account {
    @NotNull
    @Schema(example = "ABC123", type = "string")
    String number;

    @NotNull
    @Schema(example = "100.99", type = "number")
    @JsonSerialize(using = NegativeBalanceSerializer.class)
    BigDecimal balance;

    /** Override Lombok setter to set decimal scale */
    public void setBalance(BigDecimal amount) {
        balance = amount;
        balance = balance.setScale(2, RoundingMode.HALF_UP);
    }

    /** Override Lombok builder method for balance to set decimal scale */
    public static class AccountBuilder {
        public AccountBuilder balance(BigDecimal amount) {
            balance = amount;
            balance = balance.setScale(2, RoundingMode.HALF_UP);
            return this;
        }
    }
}

/**
 * Negative balance serializer. Serializes BigDecimal property to String "Negative" when it is negative.
 * NOTE:
 * For GraalVM native compilation this requires enabling reflection (reflection-config.json) and native compile flag
 * -H:ReflectionConfigurationFiles in build file: pom.xml
 */
class NegativeBalanceSerializer extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal balance, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (balance.compareTo(BigDecimal.valueOf(0L)) < 0) {
            jsonGenerator.writeString("Negative");
        } else {
            jsonGenerator.writeObject(balance);
        }
    }
}
