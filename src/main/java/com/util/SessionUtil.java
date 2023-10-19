package com.util;

import com.model.Customer;
import com.model.Person;
import com.model.Staff;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {

    public static Customer getCustomer(HttpServletRequest req) {
        Person u;
        try {
            return (Customer) req.getSession(false).getAttribute("user");
        } catch (NullPointerException | ClassCastException ignored) {
            return null;
        }
    }

    public static Staff getStaff(HttpServletRequest req) {
        Person u;
        try {
            return (Staff) req.getSession(false).getAttribute("user");
        } catch (NullPointerException | ClassCastException ignored) {
            return null;
        }
    }
}
