package com.amazon.proserve.domain.customer.repository;

import com.amazon.proserve.domain.customer.Customer;
import com.amazon.proserve.domain.customer.vo.CustomerNo;

public interface CustomerRepository {
    CustomerNo save(Customer customer);

    Customer findByCustomerNo(CustomerNo customerNo);
}
