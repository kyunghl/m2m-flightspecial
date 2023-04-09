package com.amazon.proserve

import com.amazon.proserve.customer.api.dto.ApiResult
import com.amazon.proserve.customer.api.dto.ChangeCustomerNameRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerApiTest extends Specification {
    @LocalServerPort
    private int port

    @Autowired
    private TestRestTemplate restTemplate

    def "change Customer name"() {
        given:
        ChangeCustomerNameRequest request = ChangeCustomerNameRequest.builder()
                .customerNo(BigInteger.ONE)
                .customerNm("Sally")
                .build();

        when:
        def entity = this.restTemplate.postForEntity("/customer/1/nickname", request, ApiResult)

        then:
        entity.getStatusCode() == HttpStatus.OK
    }
}
