package com.servlet;

import com.model.Person;
import com.model.Staff;
import com.service.ICustomerService;
import com.service.IStaffService;
import com.service.impl.CustomerService;
import com.service.impl.StaffService;
import com.util.URLS;
import com.util.Views;

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

@WebServlet
public class LoginServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());
    private boolean isStaff;
    private String loginURL;
    private String homeURL;
    private String loginJSP;

    @Override
    public void init(ServletConfig config) {
        String admin = config.getInitParameter("admin");
        this.isStaff = !Objects.isNull(admin) && Boolean.parseBoolean(admin);
        this.loginURL = isStaff ? URLS.ADMIN_LOGIN : URLS.USER_LOGIN;
        this.homeURL = isStaff ? URLS.ADMIN_HOME : URLS.HOME;
        this.loginJSP = isStaff ? Views.STAFF_LOGIN : Views.USER_LOGIN;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(loginJSP);
        req.setAttribute("staff", this.isStaff);
        req.setAttribute("incorrect", !Objects.isNull(req.getParameter("incorrect")));
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (Objects.isNull(email) || Objects.isNull(password)) {
            logger.log(Level.INFO, "username or password not set");
            resp.sendRedirect(URLS.urlFor(req, loginURL));
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
            String redirect = loginURL + "?incorrect=true";
            String targetPath = getRedirectPath(req, null);
            if (!Objects.isNull(targetPath)) {
                redirect += "&to=" + targetPath;
            }

            resp.sendRedirect(URLS.urlFor(req, redirect));
            return;
        }

        // create session

        HttpSession sess = req.getSession(true);
        sess.setAttribute("id", user.getID());
        sess.setAttribute("isStaff", isStaff);
        if (isStaff) {
            assert user instanceof Staff;
            sess.setAttribute("role", ((Staff) user).getRole());
        }

        // redirect user
        String redirect = this.getRedirectPath(req, URLS.urlFor(req, homeURL));
        resp.sendRedirect(redirect);
    }

    private String getRedirectPath(HttpServletRequest req, String defaultUrl) {
        String redirectParam = req.getParameter("to");
        if (!Objects.isNull(redirectParam)) {
            try {
                URI uri = new URI(redirectParam);
                return uri.getPath();
            } catch (URISyntaxException ignored) {
            }
        }
        return defaultUrl;
    }

}
