package com.amazon.proserve.application.customer.usecase;

import com.amazon.proserve.application.customer.command.ChangeCustomerNameCommand;

public interface ChangeCustomerNameUseCase {
    void changeCustomerName(ChangeCustomerNameCommand command);
}
