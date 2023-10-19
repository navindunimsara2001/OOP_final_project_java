package com.servlet;

import com.model.Person;
import com.service.ICustomerService;
import com.service.IStaffService;
import com.service.impl.CustomerService;
import com.service.impl.StaffService;
import com.util.URLS;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
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
    private boolean isStaff;

    @Override
    public void init(ServletConfig config) {
        String admin = config.getInitParameter("admin");
        this.isStaff = !Objects.isNull(admin) && Boolean.parseBoolean(admin);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
        req.setAttribute("staff", this.isStaff);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (Objects.isNull(email) || Objects.isNull(password)) {
            logger.log(Level.INFO, "username or password not set");
            resp.sendRedirect(isStaff ? URLS.ADMIN_LOGIN : URLS.USER_LOGIN);
            return;
        }

        // get the user
        Person user;
        if (isStaff) {
            IStaffService ss = new StaffService();
            user = ss.getStaffByEmail(email);
        } else {
            ICustomerService cs = new CustomerService();
            user = cs.getCustomerByEmail(email);
        }

        // check if the login details are valid.
        if (Objects.isNull(user) || !Objects.equals(user.getPassword(), password)) {
            logger.log(Level.INFO, "incorrect password");
            resp.sendRedirect(isStaff ? URLS.ADMIN_LOGIN : URLS.USER_LOGIN);
            return;
        }

        // create session
        HttpSession sess = req.getSession(true);
        sess.setAttribute("user", user);
        sess.setAttribute("isStaff", isStaff);

        // redirect user
        String redirect = isStaff ? URLS.ADMIN_HOME : URLS.HOME;
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

}
