package com.util;

import javax.servlet.http.HttpServletRequest;

public class URLS {
    public static final String HOME = "index.jsp";
    public static final String LOGOUT = "logout";
    public static final String USER_LOGIN = "login";
    public static final String USER_REGISTER = "register.jsp";
    public static final String USER_PROFILE = "user/profile";
    public static final String USER_APPOINTMENT = "user/appointments";
    public static final String ADMIN_HOME = "staff/";
    public static final String ADMIN_LOGIN = "staff/login";
    public static final String MANAGE_USERS = "staff/manageUsers";
    public static final String MANAGE_STAFF = "staff/manageStaff";
    public static final String MANAGE_APPOINTMENT = "staff/manageAppointment";
    public static final String ITEM_REQUEST = "staff/requestItem";
    public static final String VIEW_REQUEST = "staff/requestedItem";
    public static final String MANAGE_REQUEST = "staff/ManageItemRequest";
    public static final String FUEL_SALES = "staff/fuelSales";
    public static final String UPDATE_FUEL = "staff/UpdateFuelServlet";
    public static final String VIEW_ITEM_LIST = "staff/viewItemList";
    public static final String STAFF_PROFILE = "staff/profile";
    public static final String STAFF_HOME = "staff/index.jsp";

    public static String urlFor(HttpServletRequest req, String s) {
        return req.getContextPath() + "/" + s;
    }

}
