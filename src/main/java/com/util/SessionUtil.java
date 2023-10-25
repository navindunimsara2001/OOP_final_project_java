package com.util;

import com.model.Customer;
import com.model.Staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.Enumeration;
import java.util.Objects;

public class SessionUtil {


    public static class NotLoggedInException extends RuntimeException {
        public NotLoggedInException() {
            super("User is not logged in");
        }

        public NotLoggedInException(String err) {
            super("User is not logged in: " + err);
        }
    }

    public enum UserType {
        User, Staff
    }

   
    public static int getId(HttpServletRequest req, UserType type, int def) {
        return type == UserType.User ? getUserId(req, def) : getStaffId(req, def);
    }

    public static boolean isLoggedIn(HttpServletRequest req, UserType type) {
        try {
            getId(req, type);
            return true;
        } catch (NotLoggedInException e) {
            return false;
        }
    }


    public static int getUserId(HttpServletRequest req, int defaultV) {
        try {
            return getId(req, UserType.User);
        } catch (NotLoggedInException e) {
            System.out.println("Falling back to default value " + defaultV);
            return defaultV;
        }
    }


    public static int getStaffId(HttpServletRequest req, int defaultV) {
        try {
            return getId(req, UserType.Staff);
        } catch (NotLoggedInException e) {
            System.out.println("Falling back to default value " + defaultV);
            return defaultV;
        }
    }

    private static int getId(HttpServletRequest req, UserType type) {
        HttpSession session = req.getSession(false);
        if (Objects.isNull(session)) {
            throw new NotLoggedInException();
        }

        Object idObj = session.getAttribute("id");
        if (Objects.isNull(idObj) || !(idObj instanceof Integer)) {
            throw new NotLoggedInException("user id not set");
        }
        int ID = (int) idObj;

        Object isStaffObj = session.getAttribute("isStaff");
        if (Objects.isNull(isStaffObj) || !(isStaffObj instanceof Boolean)) {
            throw new NotLoggedInException("isStaff not set");
        }

        boolean shouldBeStaff = type == UserType.Staff;
        if (isStaffObj.equals(shouldBeStaff)) {
            throw new NotLoggedInException("wrong session type");
        }

        return ID;
    }


}
