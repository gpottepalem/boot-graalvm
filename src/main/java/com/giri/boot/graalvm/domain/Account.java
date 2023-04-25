package com.giri.boot.graalvm.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * A simple Account record.
 *
 * @author pottepalemg
 * created Apr 24, 2023
 */
public record Account(
    @NotNull
    @Schema(example = "ABC123", type = "string")
    String number,

    @NotNull
    @Schema(example = "100.99", type = "number")
    @JsonSerialize(using = NegativeBalanceSerializer.class)
    BigDecimal balance) {
}

/**
 * Negative balance serializer. Serializes BigDecimal property to String "Negative"
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
