package com.servlet;

import com.model.Customer;
import com.service.impl.CustomerService;
import com.util.URLS;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class CustomerRegisterServlet extends HttpServlet {

    private final static Pattern pattern = Pattern.compile("^(.+)@(.+)$");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Customer cus = new Customer();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String DOB = request.getParameter("DOB");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String district = request.getParameter("district");

        //email validation
        Matcher matcher = pattern.matcher(email);

        // need to check email exist or not

        if (matcher.matches() && password.length() >= 8) {
            System.out.println("valid");
            cus.setName(name);
            cus.setEmail(email);
            cus.setPhone(phone);
            cus.setDOB(DOB);
            cus.setPassword(password);
            cus.setGender(gender);
            cus.setDistrict(district);

            CustomerService cs = new CustomerService();
            cs.addCustomer(cus);

            response.sendRedirect(URLS.urlFor(request, URLS.USER_LOGIN));
        }

    }

}
