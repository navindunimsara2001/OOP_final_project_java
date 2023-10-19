package com.servlet;

import com.model.Person;
import com.util.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthFilter extends HttpFilter {

    private boolean isAdmin;

    @Override
    public void init(FilterConfig config) {
        String admin = config.getInitParameter("admin");
        this.isAdmin = !Objects.isNull(admin) && Boolean.parseBoolean(admin);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;

        HttpSession sess = request.getSession(false);
        Logger.getLogger("auth").log(Level.INFO, String.format("Session: %s %b", sess, Objects.isNull(sess)));
        if (Objects.isNull(sess)) {
            this.redirect(request, (HttpServletResponse) res);
            return;
        }

        Person u;
        if (this.isAdmin) {
            u = SessionUtil.getStaff(request);
        } else {
            u = SessionUtil.getCustomer(request);
        }

        if (Objects.isNull(u)) {
            this.redirect(request, (HttpServletResponse) res);
            return;
        }

        chain.doFilter(req, res);
    }

    private void redirect(HttpServletRequest request, HttpServletResponse res) throws IOException {
        String redirect = this.isAdmin ? "admin/login.html" : "login.html";
        try {
            redirect += "?to=" + new URI(request.getRequestURI()).getPath();
        } catch (URISyntaxException ignored) {
        }
        res.sendRedirect(redirect);
    }
}
