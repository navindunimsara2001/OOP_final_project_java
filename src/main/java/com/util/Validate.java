package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

public class Validate {
    private final static Pattern EMAIL_PATTERN = Pattern.compile("^(.+)@(.+)$");
    private final static Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

    public static class ValidationError extends RuntimeException {
        ValidationError(String err) {
            super(err);
        }
    }

    public static void Username(String s) {
        if (Objects.isNull(s) || s.length() < 6) {
            throw new ValidationError("Invalid Username");
        }
    }

    public static void Password(String s) {
        if (Objects.isNull(s) || s.length() < 8) {
            throw new ValidationError("Invalid Password");
        }
    }

    public static void Email(String s) {
        if (Objects.isNull(s) || !EMAIL_PATTERN.matcher(s).matches()) {
            throw new ValidationError("Invalid email address");
        }
    }

    public static void Phone(String s) {
        if (Objects.isNull(s) || !PHONE_PATTERN.matcher(s).matches()) {
            throw new ValidationError("Invalid phone number");
        }
    }

    public static void Date(String s) {
        // TODO: check date
    }

    public static void Number(String s) {
        if (Objects.isNull(s)) {
            throw new ValidationError("Invalid number");
        }

        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new ValidationError("Not a number");
        }

    }

    public static void Float(String s) {
        if (Objects.isNull(s)) {
            throw new ValidationError("Invalid number");
        }

        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new ValidationError("Not a float");
        }
    }
}
