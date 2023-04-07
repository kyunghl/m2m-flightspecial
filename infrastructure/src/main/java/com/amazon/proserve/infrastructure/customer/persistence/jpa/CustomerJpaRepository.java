package com.amazon.proserve.infrastructure.customer.persistence.jpa;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerJpaEntity, Long> {
    Optional<CustomerJpaEntity> findCustomerJpaEntityByCustomerNo(BigInteger customerNo);

    Optional<CustomerJpaEntity> findCustomerJpaEntityByCustomerName(String customerName);
}
