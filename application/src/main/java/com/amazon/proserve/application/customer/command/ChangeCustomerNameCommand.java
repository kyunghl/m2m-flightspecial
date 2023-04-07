package com.amazon.proserve.application.customer.command;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Value(staticConstructor = "of")
public class ChangeCustomerNameCommand {
    @NotNull
    @PositiveOrZero
    Integer customerNo;
    @NotBlank
    String newCustomerName;
}
