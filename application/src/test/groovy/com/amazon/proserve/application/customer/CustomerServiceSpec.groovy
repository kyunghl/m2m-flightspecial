package com.amazon.proserve.application.customer

import com.amazon.proserve.application.customer.command.ChangeCustomerNameCommand
import com.amazon.proserve.application.customer.service.ChangeCustomerNameService
import com.amazon.proserve.application.customer.usecase.ChangeCustomerNameUseCase
import com.amazon.proserve.domain.customer.Customer
import com.amazon.proserve.domain.customer.repository.CustomerRepository
import com.amazon.proserve.domain.customer.vo.*
import spock.lang.Specification

import static java.math.BigInteger.ONE

class CustomerServiceSpec extends Specification {
    def "change name test"() {
        given:
        Customer Customer = Customer.builder()
                .customerNo(CustomerNo.of(ONE))
                .name(CustomerName.of("Bingo"))
                .build()
        CustomerRepository repository = Mock()
        repository.findByCustomerNo(CustomerNo.of(ONE)) >> Customer

        ChangeCustomerNameUseCase useCase = new ChangeCustomerNameService(repository)
        ChangeCustomerNameCommand command = ChangeCustomerNameCommand.of(ONE, "Sally")

        when:
        useCase.changeCustomerName(command)

        then:
        1 * repository.save(Customer)
        Customer.getName().value == "Sally"
    }
}
