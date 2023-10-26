package com.util;

import com.model.Staff;
import com.util.exceptions.ValidationError;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * The Parse class contains helper methods for parsing various data types.
 */
public class Parse {
    private final static Pattern EMAIL_PATTERN = Pattern.compile("^(.+)@(.+)$");
    private final static Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");
    private final static Pattern DATE_PATTERN = Pattern.compile("^\\d\\d\\d\\d-\\d\\d-\\d\\d$");

    /**
     * Parses a name
     *
     * @param s a string that may contain valid data or null
     * @return a name
     * @throws ValidationError if the data is not valid
     */
    public static String Name(String s) {
        if (Objects.isNull(s) || s.length() < 4) {
            throw new ValidationError("Invalid Name");
        }
        return s;
    }

    /**
     * Parses a string
     *
     * @param s a string that may contain valid data or null
     * @return a string
     * @throws ValidationError if the data is not valid
     */
    public static String String(String s, String name) {
        if (Objects.isNull(s) || s.isEmpty()) {
            throw new ValidationError("Invalid " + name);
        }
        return s;
    }

    /**
     * Parses a password
     *
     * @param s a string that may contain valid data or null
     * @return a password
     * @throws ValidationError if the data is not valid
     */
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

    /**
     * Parses an email
     *
     * @param s a string that may contain valid data or null
     * @return a email
     * @throws ValidationError if the data is not valid
     */
    public static String Email(String s) {
        if (Objects.isNull(s) || !EMAIL_PATTERN.matcher(s).matches()) {
            throw new ValidationError("Invalid email address");
        }
        return s;
    }

    /**
     * Parses a phone number
     *
     * @param s a string that may contain valid data or null
     * @return a phone number
     * @throws ValidationError if the data is not valid
     */
    public static String Phone(String s) {
        if (Objects.isNull(s) || !PHONE_PATTERN.matcher(s).matches()) {
            throw new ValidationError("Invalid phone number");
        }
        return s;
    }

    /**
     * Parses a date
     *
     * @param s a string that may contain valid data or null
     * @return a date
     * @throws ValidationError if the data is not valid
     */
    public static String Date(String s) {
        if (Objects.isNull(s) || !DATE_PATTERN.matcher(s).matches()) {
            throw new ValidationError("Invalid date");
        }
        return s;
    }

    /**
     * Parses a number
     *
     * @param s a string that may contain valid data or null
     * @return a number
     * @throws ValidationError if the data is not valid
     */
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


    /**
     * Parses a floating point number
     *
     * @param s a string that may contain valid data or null
     * @return a number
     * @throws ValidationError if the data is not valid
     */
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

    /**
     * Parses a Staff role
     *
     * @param s a string that may contain valid data or null
     * @return a role
     * @throws ValidationError if the data is not valid
     */
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
