package com.util;

import com.model.Customer;
import com.model.Staff;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class SessionUtil {


    public static class NotLoggedInException extends RuntimeException {
        public NotLoggedInException() {
            super("User is not logged in");
        }
    }


    public static int getUserId(HttpServletRequest req) {
        Customer cus = getCustomer(req);
        if (Objects.isNull(cus)) {
            throw new NotLoggedInException();
        }
        return cus.getID();
    }


    public static int getUserId(HttpServletRequest req, int defaultV) {
        try {
            return getUserId(req);
        } catch (NotLoggedInException e) {
            System.out.println("Falling back to default value " + defaultV);
            return defaultV;
        }
    }

    public static int getStaffId(HttpServletRequest req) {
        Staff staff = getStaff(req);
        if (Objects.isNull(staff)) {
            throw new NotLoggedInException();
        }
        return staff.getID();
    }


    public static int getStaffId(HttpServletRequest req, int defaultV) {
        try {
            return getStaffId(req);
        } catch (NotLoggedInException e) {
            System.out.println("Falling back to default value " + defaultV);
            return defaultV;
        }
    }

    private static Customer getCustomer(HttpServletRequest req) {
        try {
            return (Customer) req.getSession(false).getAttribute("user");
        } catch (NullPointerException | ClassCastException ignored) {
            return null;
        }
    }


    private static Staff getStaff(HttpServletRequest req) {
        try {
            return (Staff) req.getSession(false).getAttribute("user");
        } catch (NullPointerException | ClassCastException ignored) {
            return null;
        }
    }
}
