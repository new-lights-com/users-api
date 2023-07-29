package com.lights.users.exception;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class JWTValidationException extends RuntimeException {

    public JWTValidationException(String message) {
        super(message);
    }
}
