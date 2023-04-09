package com.amazon.proserve.flight.api;

import com.amazon.proserve.application.flight.usecase.GetFlightSpecialUseCase;
import com.amazon.proserve.domain.flight.FlightSpecial;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class FlightController {
        private final GetFlightSpecialUseCase usecase;

        // @PostMapping(value = "/{prfId}/nickname", produces = "application/json")
        // public ResponseEntity<ApiResponse> changePetName(@PathVariable(name =
        // "prfId") String profileId,
        // @RequestBody ApiResponse request) {
        // ChangeCustomerNameCommand command =
        // ChangeCustomerNameCommand.of(request.getCustomerNo(),
        // request.getCustomerNm());
        // usecase.changeCustomerName(command);
        // ApiResult<String> result = ApiResult.<String>builder()
        // .sccsYn("Y")
        // .staMsg("Success")
        // .stsCd("20001000")
        // .data("")
        // .build();
        // return new ResponseEntity<>(result, HttpStatus.OK);
        // }

        @GetMapping({ "/flightspecials" })
        public List<FlightSpecial> getFlightSpecial() {
                return usecase.getFlightSpecial();
        }
}
