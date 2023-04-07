package com.amazon.proserve.application.customer.service;

import com.amazon.proserve.application.customer.command.ChangeCustomerNameCommand;
import com.amazon.proserve.application.customer.usecase.ChangeCustomerNameUseCase;
import com.amazon.proserve.domain.customer.Customer;
import com.amazon.proserve.domain.customer.repository.CustomerRepository;
import com.amazon.proserve.domain.customer.vo.CustomerNo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeCustomerNameService implements ChangeCustomerNameUseCase {
    private final CustomerRepository repository;

    @Override
    public void changeCustomerName(ChangeCustomerNameCommand command) {
        Customer Customer = repository.findByCustomerNo(CustomerNo.of(command.getCustomerNo()));
        Customer.changeCustomerName(command.getNewCustomerName());
        repository.save(Customer);
    }
}
