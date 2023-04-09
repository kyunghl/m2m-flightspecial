package com.amazon.proserve.application.flight.usecase;

import java.util.List;

import com.amazon.proserve.domain.flight.FlightSpecial;

public interface GetFlightSpecialUseCase {
    List<FlightSpecial> getFlightSpecial();
}
