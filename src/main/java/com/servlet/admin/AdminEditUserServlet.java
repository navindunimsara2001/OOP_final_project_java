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
import com.util.Notify;
import com.util.URLS;
import com.util.Parse;
import com.util.Views;

/**
 * Servlet implementation class AdminEditUser
 */
@WebServlet
public class AdminEditUserServlet extends HttpServlet {
    // create service object
    final CustomerService cs = new CustomerService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int ID = Integer.parseInt(request.getParameter("ID"));
        // get customer details using ID and set to request
        Customer cus = cs.getCustomerById(ID);
        request.setAttribute("ID", ID);
        request.setAttribute("name", cus.getName());
        request.setAttribute("phone", cus.getPhone());
        request.setAttribute("DOB", cus.getDOB());
        request.setAttribute("district", cus.getDistrict());

        // redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.USER_PROFILE_EDIT_ADMIN);
        dispatcher.forward(request, response);

    }

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
        } catch (Parse.ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }

        //redirect
        response.sendRedirect(URLS.urlFor(request, URLS.MANAGE_USERS));
    }

}
