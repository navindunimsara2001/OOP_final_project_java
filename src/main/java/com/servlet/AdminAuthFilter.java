package com.servlet;

import com.model.Staff;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.logging.Level;

/**
 * Authenticates an admin dashboard request
 */

public class AdminAuthFilter extends AuthFilter {


    /**
     * Contains all urls in the dashboard and the role needed to access them
     */

    private final static HashMap<String, Staff.Role> URL_AUTH = new HashMap<>();
    /**
     * Contains the urls common to all users
     */
    private final static HashSet<String> COMMON_URLS = new HashSet<>();

    static {
        String[] staffUrls = new String[]{
                "/staff/requestItem",
                "/staff/assignedAppointments",
                "/staff/requestedItem",
                "/staff/fuelSales",
        };

        String[] managerUrls = new String[]{
                "/staff/viewItemList",
                "/staff/manageAppointment",
                "/staff/ManageItemRequest",
                "/staff/UpdateFuelServlet",
                "/staff/createItem",

        };

        String[] adminUrls = new String[]{
                "/staff/manageStaff",
                "/staff/manageUsers",
                "/staff/adminCreateStaff",
                "/staff/DeleteStaffProfile",
                "/staff/editUser",
                "/staff/deleteUser",
        };

        // set up the URL_AUTH map from the above data

        for (String url : staffUrls) {
            URL_AUTH.put(url, Staff.Role.Staff);
        }

        for (String url : managerUrls) {
            URL_AUTH.put(url, Staff.Role.Manager);
        }

        for (String url : adminUrls) {
            URL_AUTH.put(url, Staff.Role.Admin);
        }


        COMMON_URLS.add("/staff/index.jsp");
        COMMON_URLS.add("/staff/");
        COMMON_URLS.add("/staff");
        COMMON_URLS.add("/staff/profile");


    }


    @Override
    protected boolean checkAccess(ServletRequest request, ServletResponse response) {
        HttpSession session = ((HttpServletRequest) request).getSession();

        // check if the user has a role set
        Object roleObj = session.getAttribute("role");
        if (Objects.isNull(roleObj) || !(roleObj instanceof Staff.Role)) {
            logger.log(Level.WARNING, "Role not set for staff member");
            return false;
        }


        Staff.Role role = (Staff.Role) roleObj;

        // get the request url from the request
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        String ctxPath = ((HttpServletRequest) request).getContextPath();
        if (ctxPath.length() < requestURI.length()) {
            requestURI = requestURI.substring(ctxPath.length());
        }

        // bypass the role check if the url is a common url (can be accessed by any staff member)
        if (COMMON_URLS.contains(requestURI)) {
            return true;
        }

        // get the role for the requested url
        Staff.Role requiredRole = URL_AUTH.get(requestURI);
        if (Objects.isNull(requiredRole)) {
            logger.log(Level.SEVERE, "No role set for url " + requestURI);
            return false;
        }

        // check if the user has the required role
        if (!Objects.equals(role, requiredRole)) {
            logger.log(Level.INFO, "Tried access blocked url " + requestURI + " role " + role + " required role " + requiredRole);
            return false;
        }

        return true;
    }
}
