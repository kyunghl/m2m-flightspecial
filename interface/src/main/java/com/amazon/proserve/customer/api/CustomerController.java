package com.amazon.proserve.customer.api;

import com.amazon.proserve.application.customer.command.ChangeCustomerNameCommand;
import com.amazon.proserve.application.customer.usecase.ChangeCustomerNameUseCase;
import com.amazon.proserve.customer.api.dto.ApiResult;
import com.amazon.proserve.customer.api.dto.ChangeCustomerNameRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
@RequiredArgsConstructor
public class CustomerController {
        private final ChangeCustomerNameUseCase usecase;

        @PostMapping(value = "/{prfId}/nickname", produces = "application/json")
        public ResponseEntity<ApiResult<String>> changePetName(@PathVariable(name = "prfId") String profileId,
                        @RequestBody ChangeCustomerNameRequest request) {
                ChangeCustomerNameCommand command = ChangeCustomerNameCommand.of(request.getCustomerNo(),
                                request.getCustomerNm());
                usecase.changeCustomerName(command);
                ApiResult<String> result = ApiResult.<String>builder()
                                .sccsYn("Y")
                                .staMsg("Success")
                                .stsCd("20001000")
                                .data("")
                                .build();
                return new ResponseEntity<>(result, HttpStatus.OK);
        }
}
