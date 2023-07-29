package com.lights.users.exception;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class InternalServerException extends RuntimeException {

    public InternalServerException(String message) {
        super(message);
    }
}
