package com.servlet;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Customer;
import com.model.Staff;
import com.service.impl.CustomerService;
import com.util.*;
import com.util.SessionUtil.UserType;
import com.util.exceptions.ValidationError;


public class UserProfileServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(UserProfileServlet.class.getName());
    private final CustomerService customerService = new CustomerService();


    private UserType userType;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int ID = SessionUtil.getUserId(request);

        String action = request.getParameter("action");
        if (Objects.equals("delete", action)) {
            this.deleteProfile(ID, request, response);
        } else {
            this.showProfile(ID, request, response);
        }

    }

    private void showProfile(int ID, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // create person object
        Customer cus = this.customerService.getCustomerById(ID);


        if (Objects.isNull(cus)) {
            logger.log(Level.WARNING, "No user in db for id " + ID);
        }


        request.setAttribute("ID", cus.getID());
        request.setAttribute("name", cus.getName());
        request.setAttribute("email", cus.getEmail());
        request.setAttribute("phone", cus.getPhone());
        request.setAttribute("DOB", cus.getDOB());
        request.setAttribute("district", cus.getDistrict());
        request.setAttribute("url", request.getRequestURI());

        boolean isEditing = Objects.equals(request.getParameter("edit"), "true");
        request.setAttribute("edit", isEditing);

        //redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.USER_PROFILE_VIEW);
        dispatcher.forward(request, response);
    }

    private void deleteProfile(int ID, HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.customerService.removeCustomer(ID);
        response.sendRedirect(URLS.urlFor(request, URLS.LOGOUT));
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // get user id
        int ID = SessionUtil.getUserId(request);

        if (Objects.equals(request.getParameter("action"), "password")) {
            changePassword(ID, request, response);
            return;
        }

        try {
            // get values from edit page
            String name = Parse.Name(request.getParameter("name"));
            String phone = Parse.Phone(request.getParameter("phone"));
            String DOB = Parse.Date(request.getParameter("DOB"));
            String district = request.getParameter("district");

            // assign values to customer object
            Customer cus = customerService.getCustomerById(ID);

            cus.setName(name);
            cus.setPhone(phone);
            cus.setDOB(DOB);
            cus.setDistrict(district);
            // pass values to update database
            customerService.updateCustomer(ID, cus);
            Notify.add(request, Notify.Type.Success, "Profile updated successfully");
        } catch (ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }

        //redirect
        response.sendRedirect(URLS.urlFor(request, URLS.USER_PROFILE));
    }

    private void changePassword(int ID, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String password = Parse.Password(request.getParameter("password"));

            // assign values to customer object
            Customer cus = customerService.getCustomerById(ID);
            if (Objects.isNull(cus)) {
                throw new ValidationError("Staff member does not exist");
            }

            cus.setPassword(password);

            // pass values to update database
            customerService.updateCustomer(ID, cus);

            Notify.add(request, Notify.Type.Success, "Password changed successfully");
        } catch (ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }

        //redirect
        response.sendRedirect(URLS.urlFor(request, URLS.USER_PROFILE));
    }


}
