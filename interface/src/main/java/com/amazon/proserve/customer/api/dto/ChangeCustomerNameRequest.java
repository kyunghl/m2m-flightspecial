package com.amazon.proserve.customer.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ChangeCustomerNameRequest {
    private Integer customerNo;
    private String customerNm;
}
