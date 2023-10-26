package com.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Customer;
import com.service.impl.CustomerService;
import com.util.*;
import com.util.exceptions.ValidationError;

/**
 * Servlet implementation class AdminEditUser
 */
@WebServlet
public class AdminEditUserServlet extends HttpServlet {
    // create service object
    final CustomerService cs = new CustomerService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            // get edited data from form
            int ID = Parse.Number(request.getParameter("ID"), "User Id");

            Customer cus = cs.getCustomerById(ID);
            String name = Parse.Name(request.getParameter("name"));
            String phone = Parse.Phone(request.getParameter("phone"));
            String DOB = Parse.Date(request.getParameter("DOB"));
            String district = request.getParameter("district");


            cus.setName(name);
            cus.setPhone(phone);
            cus.setDOB(DOB);
            cus.setDistrict(district);

            // pass values to update database
            cs.updateCustomer(ID, cus);

            Notify.add(request, Notify.Type.Success, "Customer Data Updated Successfully");
        } catch (ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }

        //redirect
        response.sendRedirect(URLS.urlFor(request, URLS.MANAGE_USERS));
    }

}
