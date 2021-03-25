package com.example.cinema.exception;

import static java.lang.String.format;

public class NotFoundException extends RuntimeException {
    public NotFoundException(final String message, final Object ... params) {
        super(format(message, params));
    }
}
