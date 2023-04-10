package com.amazon.proserve.flight.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

@Builder
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ChangeFlightNameRequest {
    private BigInteger flightNo;
    private String flightName;
}
