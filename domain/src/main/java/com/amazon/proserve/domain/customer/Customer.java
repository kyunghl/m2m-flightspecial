package com.amazon.proserve.domain.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.amazon.proserve.domain.customer.vo.*;

@Builder
@Getter
@ToString
public final class Customer {
    @NotNull
    private CustomerNo customerNo;

    @NotNull
    private CustomerName name;

    private Email email;

    private Address address;

    private LocalDate dateOfBirth;

    public void changeCustomerName(final String newCustomerName) {
        this.name = com.amazon.proserve.domain.customer.vo.CustomerName.of(newCustomerName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer customer = (Customer) obj;
            if (name.equals(customer.getName())
                    && email.equals(customer.getEmail())
                    && address.equals(customer.getAddress())
                    && dateOfBirth.equals(customer.getDateOfBirth()))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, address, dateOfBirth);
    }
}