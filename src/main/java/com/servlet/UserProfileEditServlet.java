package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Customer;
import com.service.impl.CustomerService;


public class UserProfileEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // create customer object for database operation
    Customer cus = new Customer();
    // create service object
    final CustomerService cs = new CustomerService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get user ID detail form url
        int ID = Integer.parseInt(request.getParameter("ID"));
        // get customer details from database
        cus = cs.getCustomerById(ID);

        request.setAttribute("ID", ID);
        request.setAttribute("name", cus.getName());
        request.setAttribute("phone", cus.getPhone());
        request.setAttribute("DOB", cus.getDOB());
        request.setAttribute("district", cus.getDistrict());
        request.setAttribute("password", cus.getPassword());
        // redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher("customerEditProfile.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // get values from edit page
        int ID = Integer.parseInt(request.getParameter("ID"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String DOB = request.getParameter("DOB");
        String district = request.getParameter("district");
        String password = request.getParameter("password");
        // assign values to customer object
        cus.setID(ID);
        cus.setName(name);
        cus.setPhone(phone);
        cus.setDOB(DOB);
        cus.setDistrict(district);
        cus.setPassword(password);

        // pass values to update database
        cs.updateCustomer(ID, cus);
        //redirect
        response.sendRedirect("./showUserProfile");


    }

}
