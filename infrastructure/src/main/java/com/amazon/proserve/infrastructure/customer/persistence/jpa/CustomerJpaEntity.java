package com.amazon.proserve.infrastructure.customer.persistence.jpa;

import lombok.*;

import javax.persistence.*;

import com.amazon.proserve.domain.customer.Customer;
import com.amazon.proserve.domain.customer.vo.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "Customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerJpaEntity {
        @Id
        @Column(name = "CustomerNo", nullable = false)
        private BigInteger customerNo;

        @Column(name = "CustomerName", nullable = false)
        private String customerName;

        @Column(name = "RegDateTime", nullable = false, columnDefinition = "TIMESTAMP")
        private LocalDateTime registrationDateTime;

        @Column(name = "ModDateTime", nullable = false, columnDefinition = "TIMESTAMP")
        private LocalDateTime modifyDateTime;

        public static CustomerJpaEntity fromDomainEntity(Customer domainEntity) {
                return CustomerJpaEntity.builder()
                                .customerNo(domainEntity.getCustomerNo().getValue())
                                .customerName(domainEntity.getCustomerName().getValue())
                                .registrationDateTime(domainEntity.getRegistrationDateTime())
                                .modifyDateTime(domainEntity.getModifyDateTime())
                                .build();
        }

        public Customer toDomainEntity() {
                return Customer.builder()
                                .customerNo(CustomerNo.of(this.customerNo))
                                .customerName(CustomerName.of(this.customerName))
                                .registrationDateTime(this.registrationDateTime)
                                .modifyDateTime(this.modifyDateTime)
                                .build();
        }
}
