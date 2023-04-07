package com.amazon.proserve.customer.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Getter
public class ApiResult<T> {
    private String sccsYn;
    private String stsCd;
    private String staMsg;
    private T data;
}
