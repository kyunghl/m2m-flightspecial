package com.amazon.proserve.flight.api;

import com.amazon.proserve.application.flight.usecase.GetFlightSpecialUseCase;
import com.amazon.proserve.application.flight.view.FlightSpecialView;

import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class FlightController {
        private final GetFlightSpecialUseCase usecase;

        @GetMapping({ "/flightspecials" })
        public List<FlightSpecialView> getFlightSpecial() {
                return usecase.getFlightSpecial();
        }
}
