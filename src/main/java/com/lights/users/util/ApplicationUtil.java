package com.lights.users.util;

import com.lights.users.model.ErrorDetails;
import com.lights.users.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

@Slf4j
public class ApplicationUtil {

    public static ErrorResponse buildErrorResponse(String message, List<ErrorDetails> errors) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorId(UUID.randomUUID());
        errorResponse.setErrors(errors);
        errorResponse.setMessage(message);
        return errorResponse;
    }

    public static ErrorResponse buildErrorResponse(String message) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorId(UUID.randomUUID());
        errorResponse.setMessage(message);
        return errorResponse;
    }

    public static ErrorDetails buildValidationError(String message, String field) {
        ErrorDetails error = new ErrorDetails();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        error.setField(field);
        error.setMessage(message);
        return error;
    }

    public static ErrorDetails buildValidationError(String message) {
        ErrorDetails error = new ErrorDetails();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(message);
        return error;
    }
}
