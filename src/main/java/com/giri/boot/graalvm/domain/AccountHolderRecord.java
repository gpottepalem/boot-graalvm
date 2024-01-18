package com.giri.boot.graalvm.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * @author pottepalemg
 * created May 08, 2023
 */
public record AccountHolderRecord(
    @NotNull
    @Schema(example = "John", type = "string")
    String firstName,

    @NotNull
    @Schema(example = "Doe", type = "string")
    String lastName,

    @NotNull
    List<AddressRecord> addresses) {
}
