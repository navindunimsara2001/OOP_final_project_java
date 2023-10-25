package com.servlet.admin;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.impl.CustomerService;
import com.util.URLS;

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
        response.sendRedirect(URLS.urlFor(request, URLS.MANAGE_USERS));
    }

}
