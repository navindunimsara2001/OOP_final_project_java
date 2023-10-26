package com.util;

import com.model.Staff;
import com.util.exceptions.ValidationError;

import java.util.Objects;
import java.util.regex.Pattern;

public class Parse {
    private final static Pattern EMAIL_PATTERN = Pattern.compile("^(.+)@(.+)$");
    private final static Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

    public static String Username(String s) {
        if (Objects.isNull(s) || s.length() < 6) {
            throw new ValidationError("Invalid Username");
        }
        return s;
    }

    public static String Name(String s) {
        if (Objects.isNull(s) || s.length() < 4) {
            throw new ValidationError("Invalid Name");
        }
        return s;
    }

    public static String String(String s, String name) {
        if (Objects.isNull(s) || s.isEmpty()) {
            throw new ValidationError("Invalid " + name);
        }
        return s;
    }

    public static String Password(String s) {
        if (Objects.isNull(s) || s.length() < 8) {
            throw new ValidationError("Invalid Password length");
        }

//        if (!s.matches(".*[A-Z].*")) {
//            throw new ValidationError("Password must contain at least one uppercase letter.");
//        } else if (!s.matches(".*\\d.*")) {
//            throw new ValidationError("Password must contain at least one digit.");
//        }
        return s;
    }

    public static String Email(String s) {
        if (Objects.isNull(s) || !EMAIL_PATTERN.matcher(s).matches()) {
            throw new ValidationError("Invalid email address");
        }
        return s;
    }

    public static String Phone(String s) {
        if (Objects.isNull(s) || !PHONE_PATTERN.matcher(s).matches()) {
            throw new ValidationError("Invalid phone number");
        }
        return s;
    }

    public static String Date(String s) {
        // TODO: check date
        return s;
    }


    public static int Number(String s, String name) {
        if (!name.isEmpty()) {
            name += ": ";
        }

        if (Objects.isNull(s)) {
            throw new ValidationError(name + "Invalid number");
        }

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new ValidationError(name + "Not a number");
        }
    }


    public static Double Float(String s, String name) {
        if (!name.isEmpty()) {
            name += ": ";
        }

        if (Objects.isNull(s)) {
            throw new ValidationError(name + "Invalid number");
        }

        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new ValidationError(name + "Not a float");
        }
    }

    public static Staff.Role Role(String s) {
        if (Objects.isNull(s)) {
            throw new ValidationError("Empty role");
        }

        int role = Number(s, "role");
        if (role < 0 || role > 1) {
            throw new ValidationError("Invalid role selected");
        }

        return Staff.Role.byId(role);
    }
}
