package com.amazon.proserve.application.flight.service;

import com.amazon.proserve.application.flight.usecase.GetFlightSpecialUseCase;
import com.amazon.proserve.domain.flight.FlightSpecial;
import com.amazon.proserve.domain.flight.repository.FlightSpecialRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetFlightSpecialService implements GetFlightSpecialUseCase {
    private final FlightSpecialRepository repository;

    // @Override
    // public void changeCustomerName(ChangeCustomerNameCommand command) {
    // Customer Customer =
    // repository.findByCustomerNo(CustomerNo.of(command.getCustomerNo()));
    // Customer.changeCustomerName(command.getNewCustomerName());
    // repository.save(Customer);
    // }

    @Override
    public List<FlightSpecial> getFlightSpecial() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFlightSpecial'");
    }
}
