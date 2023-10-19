package com.servlet;

import com.model.Person;
import com.service.ICustomerService;
import com.service.IStaffService;
import com.service.impl.CustomerService;
import com.service.impl.StaffService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String loginType = req.getParameter("type");
        
        if (!Objects.equals(loginType, "staff") && !Objects.equals(loginType, "user")) {
            resp.sendRedirect("/");
            return;
        }


        boolean isStaff = loginType.equals("staff");

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (Objects.isNull(email) || Objects.isNull(password)) {
            resp.sendRedirect(isStaff ? "/admin/login.html" : "/login.html");
            return;
        }

        Person user = getUser(email, password, isStaff);

        if (Objects.isNull(user)) {
            resp.sendRedirect(isStaff ? "/admin/login.html" : "/login.html");
            return;
        }

        HttpSession sess = req.getSession(true);
        sess.setAttribute("user", user);
        sess.setAttribute("isStaff", isStaff);

        String redirect = isStaff ? "/admin/" : "/";


        String redirectParam = req.getParameter("to");
        if (!Objects.isNull(redirectParam)) {
            try {
                URI uri = new URI(redirectParam);
                redirect = uri.getPath();
            } catch (URISyntaxException ignored) {
            }
        }

        resp.sendRedirect(redirect);
    }

    private Person getUser(String email, String password, boolean isStaff) {
        Person user;
        if (isStaff) {
            IStaffService ss = new StaffService();
            user = ss.getStaffByEmail(email);
        } else {
            ICustomerService cs = new CustomerService();
            user = cs.getCustomerByEmail(email);
        }


        if (Objects.isNull(user) || !Objects.equals(user.getPassword(), password)) {
            return null;
        }

        return user;
    }

}
