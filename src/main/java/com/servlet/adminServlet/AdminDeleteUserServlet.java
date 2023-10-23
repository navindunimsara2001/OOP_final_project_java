package com.servlet.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.impl.CustomerService;

/**
 * Servlet implementation class AdminDeleteUserServlet
 */

public class AdminDeleteUserServlet extends HttpServlet {
    // create service object
    final CustomerService cs = new CustomerService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // get ID from URL
        int ID = Integer.parseInt(request.getParameter("ID"));
        // get delete operation from Service class
        cs.removeCustomer(ID);
        // redirect
        response.sendRedirect("./adminManageUsers");
    }

}
