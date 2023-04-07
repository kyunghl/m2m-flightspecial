package com.amazon.proserve.domain.customer.vo;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value(staticConstructor = "of")
public class CustomerName {
    @NotNull
    String value;
}
