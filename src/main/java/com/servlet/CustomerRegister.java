package com.servlet;

import com.model.Customer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerRegister")
public class CustomerRegister extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        Customer cus = new Customer();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String DOB = request.getParameter("DOB");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String district = request.getParameter("District");

        cus.setName(name);
        cus.setEmail(email);
        cus.setPhone(phone);
        cus.setDOB(DOB);
        cus.setPassword(password);
        cus.setGender(gender);
        cus.setDistrict(district);
    }

}
