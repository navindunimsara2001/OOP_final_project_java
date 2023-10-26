package com.util.exceptions;

public class ValidationError extends RuntimeException {
    public ValidationError(String err) {
        super(err);
    }
}
