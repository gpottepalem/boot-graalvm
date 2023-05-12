package com.giri.boot.graalvm.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * @author pottepalemg
 * created May 08, 2023
 */
public record Address(
    @NotNull
    @Schema(example = "85 Stillwater Rd", type = "string")
    String address1,

    @Schema(example = "Apt no. 10", type = "string")
    String address2,

    @NotNull
    @Schema(example = "Canton", type = "string")
    String city,

    @NotNull
    @Schema(example = "MA", type = "string")
    String state,

    @NotNull
    @Schema(example = "02021", type = "string")
    String zip) {
}
