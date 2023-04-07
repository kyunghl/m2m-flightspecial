package com.amazon.proserve.infrastructure.customer.persistence.jpa;

import lombok.*;

import javax.persistence.*;

import com.amazon.proserve.domain.customer.Customer;
import com.amazon.proserve.domain.customer.vo.*;

import java.time.LocalDate;

@Entity
@Table(name = "Customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerJpaEntity {
        @Id
        @Column(name = "customer_no", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer customerNo;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "email", nullable = true)
        private String email;

        @Column(name = "address", nullable = true)
        private String address;

        @Column(name = "date_of_birth", columnDefinition = "DATE")
        private LocalDate dateOfBirth;

        public static CustomerJpaEntity fromDomainEntity(Customer domainEntity) {
                return CustomerJpaEntity.builder()
                                .customerNo(domainEntity.getCustomerNo().getValue())
                                .name(domainEntity.getName().getValue())
                                .email(domainEntity.getEmail() != null ? domainEntity.getEmail().getValue() : "")
                                .address(domainEntity.getAddress() != null ? domainEntity.getAddress().getValue() : "")
                                .dateOfBirth(domainEntity.getDateOfBirth())
                                .build();
        }

        public Customer toDomainEntity() {
                return Customer.builder()
                                .customerNo(CustomerNo.of(this.customerNo))
                                .name(CustomerName.of(this.name))
                                .email(Email.of(this.email))
                                .address(Address.of(this.address))
                                .dateOfBirth(this.dateOfBirth)
                                .build();
        }
}
