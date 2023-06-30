package com.abhishek.taxcalculator.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
@Builder
public class APIResponse<T> {

    private int status;
    private String message;
    private T data;

    public APIResponse() {
        this.status = HttpStatus.OK.value();
        this.message = "Operation was successful";
    }

}
