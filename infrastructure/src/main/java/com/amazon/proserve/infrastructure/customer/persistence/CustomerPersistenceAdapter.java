package com.amazon.proserve.infrastructure.customer.persistence;

import com.amazon.proserve.domain.customer.Customer;
import com.amazon.proserve.domain.customer.repository.CustomerRepository;
import com.amazon.proserve.domain.customer.vo.CustomerNo;
import com.amazon.proserve.infrastructure.customer.persistence.jpa.CustomerJpaEntity;
import com.amazon.proserve.infrastructure.customer.persistence.jpa.CustomerJpaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;

@Component
@RequiredArgsConstructor
public class CustomerPersistenceAdapter implements CustomerRepository {
    private final CustomerJpaRepository repository;

    @Override
    public CustomerNo save(Customer customer) {
        CustomerJpaEntity entity = CustomerJpaEntity.fromDomainEntity(customer);
        CustomerJpaEntity savedEntity = repository.saveAndFlush(entity);
        return CustomerNo.of(savedEntity.getCustomerNo());
    }

    @Override
    public Customer findByCustomerNo(CustomerNo customerNo) {
        return repository.findCustomerJpaEntityByCustomerNo(customerNo.getValue())
                .orElseThrow(NoResultException::new)
                .toDomainEntity();
    }
}
