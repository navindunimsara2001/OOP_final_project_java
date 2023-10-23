package com.servlet;

import com.service.impl.CustomerService;
import com.util.URLS;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CustomerDeleteServlet
 */

public class CustomerDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // get id from url
        int ID = Integer.parseInt(request.getParameter("ID"));
        // create customer service object
        CustomerService cs = new CustomerService();
        //delete method
        cs.removeCustomer(ID);

        //redirect to register page
        response.sendRedirect(URLS.USER_REGISTER);
    }
}
