package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class URLS {
    public static final String HOME = "index.jsp";
    public static final String USER_LOGIN = "login";
    public static final String USER_REGISTER = "register.jsp";
    public static final String USER_PROFILE = "user/profile";
    public static final String ITEM_REQUEST = "staff/requestItem";
    public static final String ADMIN_HOME = "staff/";
    public static final String ADMIN_LOGIN = "staff/login";
    public static final String MANAGE_USERS = "staff/manageUsers";
    public static final String MANAGE_STAFF = "staff/manageStaff";
    public static final String USER_APPOINTMENT = "user/appointments";
    public static final String LOGOUT = "logout";
    public static final String VIEW_ITEM_LIST = "staff/viewItemList";
    public static final String FUEL_MANAGEMENT = "staff/FuelManageServlet";
    public static final String UPDATE_FUEL = "staff/UpdateFuelServlet";
    public static final String MANAGE_APPOINTMENT = "staff/manageAppointment";

    public static String urlFor(HttpServletRequest req, String s) {
        return req.getContextPath() + "/" + s;
    }

    public static void redirect(HttpServletRequest req, HttpServletResponse res, String s) throws IOException {
        res.sendRedirect(urlFor(req, s));
    }
}
