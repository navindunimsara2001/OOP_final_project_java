package com.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Customer;
import com.service.impl.CustomerService;
import com.util.Views;

@WebServlet
public class AdminManageUsersServlet extends HttpServlet {
    final CustomerService cs = new CustomerService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // create Arraylist
        ArrayList<Customer> customerList;
        // assign user details list
        customerList = cs.getCustomers();

        request.setAttribute("customerList", customerList);

        // redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.MANAGE_USERS);
        dispatcher.forward(request, response);
    }

}
