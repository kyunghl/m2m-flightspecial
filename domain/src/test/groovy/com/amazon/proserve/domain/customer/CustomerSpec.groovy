package com.amazon.proserve.domain.customer

import com.amazon.proserve.domain.customer.Customer
import com.amazon.proserve.domain.customer.vo.CustomerName
import com.amazon.proserve.domain.customer.vo.CustomerNo

import spock.lang.Specification

class CustomerNameSpec extends Specification {
    def "normal case"() {
        when:
        CustomerName CustomerName = CustomerName.of("Bingo")

        then:
        "Bingo" == CustomerName.getValue()
    }
}

class CustomerSpec extends Specification {
    def "creation"() {
        when:
        Customer Customer = Customer.builder()
                .customerNo(CustomerNo.of(BigInteger.ONE))
                .customerName(CustomerName.of("Bingo"))
                .build()

        then:
        Customer != null && Customer instanceof Customer
    }
    def "change customer name"() {
        given:
        Customer Customer = Customer.builder()
                .customerNo(CustomerNo.of(BigInteger.ONE))
                .customerName(CustomerName.of("Bingo"))
                .build()

        when:
        Customer.changeCustomerName("Happy")
        then:
        Customer.getCustomerName() == CustomerName.of("Happy")
    }
}
