package com.amazon.proserve.domain.flight.vo;

import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Value(staticConstructor = "of")
public class QuizGameNo {
    @NotNull
    BigInteger value;
}
