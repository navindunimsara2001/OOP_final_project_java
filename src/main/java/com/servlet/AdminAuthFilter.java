package com.servlet;

import com.model.Staff;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;

public class AdminAuthFilter extends AuthFilter {

    private final static HashMap<String, Staff.Role> URL_AUTH = new HashMap<>();

    static {
        String[] staffUrls = new String[]{
                "/staff/profile",
                "/staff/DeleteStaffProfile",
                "/staff/requestItem",
                "/staff/assignedAppointments",
                "/staff/requestedItem",
                "/staff/fuelSales",
                "/staff/index.jsp"
        };

        String[] managerUrls = new String[]{
                "/staff/manageStaff",
                "/staff/adminCreateStaff",
                "/staff/viewItemList",
                "/staff/manageAppointment",
                "/staff/ManageItemRequest",
                "/staff/UpdateFuelServlet",
                "/staff/manageUsers",
                "/staff/editUser",
                "/staff/deleteUser",

        };

        for (String url : staffUrls) {
            URL_AUTH.put(url, Staff.Role.Staff);
        }

        for (String url : managerUrls) {
            URL_AUTH.put(url, Staff.Role.Manager);
        }

    }


    @Override
    protected boolean checkAccess(ServletRequest request, ServletResponse response) {
        HttpSession session = ((HttpServletRequest) request).getSession();
        Object roleObj = session.getAttribute("role");
        if (Objects.isNull(roleObj) || !(roleObj instanceof Staff.Role)) {
            logger.log(Level.WARNING, "Role not set for staff member");
            return false;
        }


        Staff.Role role = (Staff.Role) roleObj;
        role = role == Staff.Role.Admin ? Staff.Role.Manager : role;

        String requestURI = ((HttpServletRequest) request).getRequestURI();
        Staff.Role requiredRole = URL_AUTH.get(requestURI);
        if (Objects.isNull(requiredRole)) {
            logger.log(Level.SEVERE, "No role set for url " + requestURI);
            return false;
        }

        return Objects.equals(role, requiredRole);
    }
}
