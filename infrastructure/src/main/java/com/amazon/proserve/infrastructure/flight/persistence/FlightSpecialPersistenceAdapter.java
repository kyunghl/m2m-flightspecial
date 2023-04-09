package com.amazon.proserve.infrastructure.flight.persistence;

import com.amazon.proserve.domain.flight.FlightSpecial;
import com.amazon.proserve.domain.flight.repository.FlightSpecialRepository;
import com.amazon.proserve.infrastructure.flight.persistence.jpa.FlightSpecialJpaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

@Component
@RequiredArgsConstructor
public class FlightSpecialPersistenceAdapter implements FlightSpecialRepository {
    private final FlightSpecialJpaRepository repository;

    // @Override
    // public CustomerNo save(Customer customer) {
    // CustomerJpaEntity entity = CustomerJpaEntity.fromDomainEntity(customer);
    // CustomerJpaEntity savedEntity = repository.saveAndFlush(entity);
    // return CustomerNo.of(savedEntity.getCustomerNo());
    // }

    // @Override
    // public Customer findByCustomerNo(CustomerNo customerNo) {
    // return repository.findCustomerJpaEntityByCustomerNo(customerNo.getValue())
    // .orElseThrow(NoResultException::new)
    // .toDomainEntity();
    // }

    @Override
    public List<FlightSpecial> findAll() {
        // TODO Auto-generated method stub
        return repository.findAll().stream().map(x -> x.toDomainEntity()).collect(Collectors.toList());
    }
}
