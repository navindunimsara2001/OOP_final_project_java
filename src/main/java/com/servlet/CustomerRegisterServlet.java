package com.servlet;

import com.model.Customer;
import com.service.impl.CustomerService;
import com.util.NotifyUtil;
import com.util.Parse;
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
    private final CustomerService cs = new CustomerService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Customer cus = new Customer();


        try {
            String name = Parse.Name(request.getParameter("name"));
            String email = Parse.Email(request.getParameter("email"));
            String phone = Parse.Phone(request.getParameter("phone"));
            String DOB = Parse.Date(request.getParameter("DOB"));
            String password = Parse.Password(request.getParameter("password"));
            String gender = request.getParameter("gender");
            String district = request.getParameter("district");


            // Todo: need to check email exist or not

            cus.setName(name);
            cus.setEmail(email);
            cus.setPhone(phone);
            cus.setDOB(DOB);
            cus.setPassword(password);
            cus.setGender(gender);
            cus.setDistrict(district);

            cs.addCustomer(cus);

        } catch (Parse.ValidationError e) {
            NotifyUtil.addNotify(request, NotifyUtil.Type.Error, e.getMessage());
            response.sendRedirect(URLS.urlFor(request, URLS.USER_REGISTER));
            return;
        }

        response.sendRedirect(URLS.urlFor(request, URLS.USER_LOGIN));

    }

}
