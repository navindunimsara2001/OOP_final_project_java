package com.util.exceptions;

/**
 * ValidationError is an exception thrown when parsing invalid data is sent from the browser by the Parse class.
 */
public class ValidationError extends RuntimeException {
    public ValidationError(String err) {
        super(err);
    }
}
