package com.servlet.admin;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.impl.CustomerService;
import com.util.Notify;
import com.util.Parse;
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
        try {
            int ID = Parse.Number(request.getParameter("ID"), "User Id");

            // get delete operation from Service class
            cs.removeCustomer(ID);

            Notify.add(request, Notify.Type.Success, "Deleted User Successfully.");
        } catch (Parse.ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }

        // redirect
        response.sendRedirect(URLS.urlFor(request, URLS.MANAGE_USERS));
    }

}
