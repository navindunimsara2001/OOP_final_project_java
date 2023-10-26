package com.util.exceptions;

public class NotLoggedInException extends RuntimeException {
    public NotLoggedInException() {
        super("User is not logged in");
    }

    public NotLoggedInException(String err) {
        super("User is not logged in: " + err);
    }
}
