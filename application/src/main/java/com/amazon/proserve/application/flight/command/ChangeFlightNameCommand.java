package com.amazon.proserve.application.flight.command;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;

@Value(staticConstructor = "of")
public class ChangeFlightNameCommand {
    @NotNull
    @PositiveOrZero
    BigInteger flightNo;
    @NotBlank
    String newFlightName;
}
