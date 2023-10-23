package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Customer;
import com.service.impl.CustomerService;


public class ShowUserProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //int ID = SessionUtil.getCustomer(request).getID();

        int ID = 3; // testing

        // create service object
        CustomerService cs = new CustomerService();
        // create customer object
        Customer cus;
        //get customer details from database
        cus = cs.getCustomerById(ID);

        request.setAttribute("name", cus.getName());
        request.setAttribute("email", cus.getEmail());
        request.setAttribute("phone", cus.getPhone());
        request.setAttribute("DOB", cus.getDOB());
        request.setAttribute("district", cus.getDistrict());
        request.setAttribute("ID", cus.getID());
        //redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher("customerProfile.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

}
