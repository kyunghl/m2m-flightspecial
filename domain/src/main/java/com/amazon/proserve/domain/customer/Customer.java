package com.amazon.proserve.domain.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import com.amazon.proserve.domain.customer.vo.*;

@Builder
@Getter
@ToString
public final class Customer {
    @NotNull
    private CustomerNo customerNo;

    @NotNull
    private CustomerName customerName;

    @NotNull
    @Builder.Default
    private LocalDateTime registrationDateTime = LocalDateTime.now();

    @NotNull
    @Builder.Default
    private LocalDateTime modifyDateTime = LocalDateTime.now();

    public void changeCustomerName(final String newCustomerName) {
        this.customerName = com.amazon.proserve.domain.customer.vo.CustomerName.of(newCustomerName);
    }
}