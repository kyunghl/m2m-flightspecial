package com.amazon.proserve.domain.customer.vo;

import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Value(staticConstructor = "of")
public class CustomerNo {
    @NotNull
    BigInteger value;
}
