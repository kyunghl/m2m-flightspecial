package com.amazon.proserve.infrastructure.flight.persistence.jpa;

import com.amazon.proserve.domain.flight.entity.FlightNameHistory;
import com.amazon.proserve.domain.flight.vo.FlightName;
import com.amazon.proserve.domain.flight.vo.FlightNameHistoryNo;
import com.amazon.proserve.domain.flight.vo.FlightNo;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight_name_history")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FlightNameHistoryJpaEntity {
    @Id
    @Column(name = "flight_name_history_no", nullable = false)
    private BigInteger flightNameHistoryNo;

    @Column(name = "flight_no", nullable = false)
    private BigInteger flightNo;

    @Column(name = "flight_name", nullable = false)
    private String flightName;

    @Column(name = "history_registration_date_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime historyRegistrationDateTime;

    public static FlightNameHistoryJpaEntity fromDomainEntity(FlightNameHistory domainEntity) {
        return FlightNameHistoryJpaEntity.builder()
                .flightNameHistoryNo(domainEntity.getFlightNameHistoryNo().getValue())
                .flightNo(domainEntity.getFlightNo().getValue())
                .flightName(domainEntity.getFlightName().getValue())
                .historyRegistrationDateTime(domainEntity.getHistoryRegistrationDateTime())
                .build();
    }

    public FlightNameHistory toDomainEntity() {
        return FlightNameHistory.of(
                FlightNo.of(this.flightNo),
                FlightNameHistoryNo.of(this.flightNameHistoryNo),
                FlightName.of(this.flightName),
                this.historyRegistrationDateTime);
    }
}
