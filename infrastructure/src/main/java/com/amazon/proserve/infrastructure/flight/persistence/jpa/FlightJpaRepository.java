package com.amazon.proserve.infrastructure.flight.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FlightJpaRepository extends JpaRepository<FlightJpaEntity, BigInteger> {
}
