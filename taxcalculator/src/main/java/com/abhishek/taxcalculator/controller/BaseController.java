package com.abhishek.taxcalculator.controller;

import com.abhishek.taxcalculator.common.APIResponse;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.ResponseEntity;

import java.util.Locale;

public class BaseController {

    private static final int DEFAULT_STATUS_CODE = 200;
    private ResourceBundleMessageSource messageSource;

    public BaseController(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getRes(String key) {
        if (key == "") {
            return key;
        }
        return messageSource.getMessage(key, null, Locale.US);
    }

    public <T> ResponseEntity wrapResponse(T data, String message, int status) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setData(data);
        apiResponse.setMessage(getRes(message));
        apiResponse.setStatus(status);

        return ResponseEntity.ok().body(apiResponse);
    }

    public ResponseEntity wrapResponse(String message) {
        return wrapResponse(null, message, DEFAULT_STATUS_CODE);
    }
    public <T> ResponseEntity wrapResponse(T data) {
        return wrapResponse(data, "", DEFAULT_STATUS_CODE);
    }
    public <T> ResponseEntity wrapResponse(T data, String message) {
        return wrapResponse(data, message, DEFAULT_STATUS_CODE);
    }


}
