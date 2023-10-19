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
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String loginType = req.getParameter("type");

        // check if the login type is valid
        if (!Objects.equals(loginType, "staff") && !Objects.equals(loginType, "user")) {
            logger.log(Level.INFO, "invalid login type");
            resp.sendRedirect("/");
            return;
        }


        boolean isStaff = loginType.equals("staff");

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (Objects.isNull(email) || Objects.isNull(password)) {
            logger.log(Level.INFO, "username or password not set");
            resp.sendRedirect(isStaff ? "/admin/login.html" : "/login.html");
            return;
        }

        // get the user
        Person user = getUser(email, isStaff);

        // check if the login details are valid.
        if (Objects.isNull(user) || !Objects.equals(user.getPassword(), password)) {
            logger.log(Level.INFO, "incorrect password");
            resp.sendRedirect(isStaff ? "/admin/login.html" : "/login.html");
            return;
        }

        // create session
        HttpSession sess = req.getSession(true);
        sess.setAttribute("user", user);
        sess.setAttribute("isStaff", isStaff);

        // redirect user
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

    /**
     * Gets the user with the given email
     *
     * @param email   the email address
     * @param isStaff is the user is trying to log in as a staff member
     * @return the user or null
     */
    private Person getUser(String email, boolean isStaff) {
        if (isStaff) {
            IStaffService ss = new StaffService();
            return ss.getStaffByEmail(email);
        } else {
            ICustomerService cs = new CustomerService();
            return cs.getCustomerByEmail(email);
        }
    }

}
