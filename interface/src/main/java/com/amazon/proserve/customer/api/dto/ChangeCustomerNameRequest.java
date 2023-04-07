package com.amazon.proserve.customer.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

@Builder
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ChangeCustomerNameRequest {
    private BigInteger customerNo;
    private String customerNm;
}
