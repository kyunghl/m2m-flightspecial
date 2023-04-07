package com.amazon.proserve.infrastructure.customer.persistence;

import com.amazon.proserve.domain.customer.Customer;
import com.amazon.proserve.domain.customer.repository.CustomerRepository;
import com.amazon.proserve.domain.customer.vo.*;
import com.amazon.proserve.infrastructure.customer.persistence.jpa.CustomerJpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.transaction.Transactional;

import static java.math.BigInteger.ONE;

//@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = TestApplication.class)
@Transactional
public class CustomerPersistenceAdapterTest {
    @Autowired
    CustomerJpaRepository repository;

    @Test
    public void saveAndGet() {
        CustomerRepository CustomerRepository = new CustomerPersistenceAdapter(repository);
        Customer customer = Customer.builder()
                .customerNo(CustomerNo.of(ONE))
                .customerName(CustomerName.of("Bingo"))
                .build();
        CustomerRepository.save(customer);
        CustomerRepository.findByCustomerNo(customer.getCustomerNo());
    }
}
