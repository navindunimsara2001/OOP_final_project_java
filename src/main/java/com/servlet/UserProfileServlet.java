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
import com.service.impl.CustomerService;
import com.util.SessionUtil;
import com.util.URLS;
import com.util.Views;


public class UserProfileServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(UserProfileServlet.class.getName());
    private final CustomerService cs = new CustomerService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int ID = SessionUtil.getUserId(request, 7);

        // create customer object
        Customer cus;
        //get customer details from database
        cus = cs.getCustomerById(ID);

        if (Objects.isNull(cus)) {
            logger.log(Level.WARNING, "No user in db for id " + ID);
        }

        request.setAttribute("ID", cus.getID());
        request.setAttribute("name", cus.getName());
        request.setAttribute("email", cus.getEmail());
        request.setAttribute("phone", cus.getPhone());
        request.setAttribute("DOB", cus.getDOB());
        request.setAttribute("district", cus.getDistrict());

        boolean isEditing = Objects.equals(request.getParameter("edit"), "true");
        String jspFile = isEditing ? Views.USER_PROFILE_EDIT : Views.USER_PROFILE_VIEW;

        //redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspFile);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // get user id from session
        int ID = SessionUtil.getUserId(request, 2);

        // get values from edit page
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String DOB = request.getParameter("DOB");
        String district = request.getParameter("district");
        String password = request.getParameter("password");

        // assign values to customer object
        Customer cus = new Customer();
        cus.setID(ID);
        cus.setName(name);
        cus.setPhone(phone);
        cus.setDOB(DOB);
        cus.setDistrict(district);
        cus.setPassword(password);

        // pass values to update database
        cs.updateCustomer(ID, cus);
        //redirect
        response.sendRedirect(URLS.USER_PROFILE);
    }


}
