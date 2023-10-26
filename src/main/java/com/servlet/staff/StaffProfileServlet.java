package com.servlet.staff;

import com.model.Staff;
import com.service.impl.StaffService;
import com.util.*;
import com.util.exceptions.ValidationError;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StaffProfileServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(StaffProfileServlet.class.getName());

    private final StaffService staffService = new StaffService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int ID = SessionUtil.getStaffId(request);
        String action = request.getParameter("action");
        if (Objects.equals("delete", action)) {
            this.deleteProfile(ID, request, response);
        } else {
            this.showProfile(ID, request, response);
        }

    }

    private void showProfile(int ID, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // create staff object
        Staff staff = this.staffService.getStaffById(ID);


        if (Objects.isNull(staff)) {
            logger.log(Level.WARNING, "No user in db for id " + ID);
        }

        request.setAttribute("ID", staff.getID());
        request.setAttribute("name", staff.getName());
        request.setAttribute("email", staff.getEmail());
        request.setAttribute("phone", staff.getPhone());
        request.setAttribute("DOB", staff.getDOB());
        request.setAttribute("url", request.getRequestURI());
        request.setAttribute("staff", true);


        boolean isEditing = Objects.equals(request.getParameter("edit"), "true");

        request.setAttribute("edit", isEditing);
        //redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.STAFF_PROFILE_VIEW);
        dispatcher.forward(request, response);
    }

    private void deleteProfile(int ID, HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.staffService.removeStaff(ID);
        response.sendRedirect(URLS.urlFor(request, URLS.LOGOUT));
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // get user id
        int ID = SessionUtil.getStaffId(request);

        if (Objects.equals(request.getParameter("action"), "password")) {
            changePassword(ID, request, response);
            return;
        }

        try {
            // get values from edit page
            String name = Parse.Name(request.getParameter("name"));
            String phone = Parse.Phone(request.getParameter("phone"));
            String DOB = Parse.Date(request.getParameter("DOB"));

            // assign values to customer object
            Staff staff = staffService.getStaffById(ID);
            if (Objects.isNull(staff)) {
                throw new ValidationError("Staff member does not exist");
            }

            staff.setName(name);
            staff.setPhone(phone);
            staff.setDOB(DOB);

            // pass values to update database
            staffService.updateStaff(ID, staff);


            Notify.add(request, Notify.Type.Success, "Profile updated successfully");
        } catch (ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }

        //redirect
        response.sendRedirect(URLS.urlFor(request, URLS.STAFF_PROFILE));
    }

    private void changePassword(int ID, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String password = Parse.Password(request.getParameter("password"));

            // assign values to customer object
            Staff staff = staffService.getStaffById(ID);
            if (Objects.isNull(staff)) {
                throw new ValidationError("Staff member does not exist");
            }

            staff.setPassword(password);

            // pass values to update database
            staffService.updateStaff(ID, staff);

            Notify.add(request, Notify.Type.Success, "Password changed successfully");
        } catch (ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }

        //redirect
        response.sendRedirect(URLS.urlFor(request, URLS.STAFF_PROFILE));
    }

}
