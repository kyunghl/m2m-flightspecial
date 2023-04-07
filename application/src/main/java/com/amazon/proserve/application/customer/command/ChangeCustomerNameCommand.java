package com.amazon.proserve.application.customer.command;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;

@Value(staticConstructor = "of")
public class ChangeCustomerNameCommand {
    @NotNull
    @PositiveOrZero
    BigInteger customerNo;
    @NotBlank
    String newCustomerName;
}
