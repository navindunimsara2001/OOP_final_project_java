package com.servlet;

import com.util.Notify;
import com.util.SessionUtil;
import com.util.URLS;

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

    Logger logger = Logger.getLogger(AuthFilter.class.getName());

    private SessionUtil.UserType type;
    private String loginURL;
    private String homeURL;

    @Override
    public void init(FilterConfig config) {
        String admin = config.getInitParameter("admin");
        boolean isAdmin = !Objects.isNull(admin) && Boolean.parseBoolean(admin);

        this.type = isAdmin ? SessionUtil.UserType.Staff : SessionUtil.UserType.User;
        this.loginURL = isAdmin ? URLS.ADMIN_LOGIN : URLS.USER_LOGIN;
        this.homeURL = isAdmin ? URLS.STAFF_HOME : URLS.HOME;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;

        if (isLoginPage(request)) {
            logger.log(Level.INFO, "Trying to access login page ");
            chain.doFilter(req, res);
            return;
        }

        HttpSession sess = request.getSession(false);
        if (Objects.isNull(sess)) {
            logger.log(Level.INFO, "No session set for user");
            this.redirect(request, (HttpServletResponse) res);
            return;
        }

        if (!SessionUtil.isLoggedIn(request, this.type)) {
            logger.log(Level.INFO, "Not logged in or wrong session type");
            this.redirect(request, (HttpServletResponse) res);
            return;
        }

        if (!checkAccess(req, res)) {
            logger.log(Level.INFO, "Tried to access blocked url");
            Notify.add(request, Notify.Type.Error, "Unable to Access Page: Permission Denied");
            ((HttpServletResponse) res).sendRedirect(URLS.urlFor(request, this.homeURL));
            return;
        }

        chain.doFilter(req, res);
    }

    protected boolean checkAccess(ServletRequest request, ServletResponse response) {
        return true;
    }

    private boolean isLoginPage(ServletRequest request) {
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        String loginURI = URLS.urlFor((HttpServletRequest) request, this.loginURL);

        return (requestURI.equals(loginURI));
    }

    private void redirect(HttpServletRequest request, HttpServletResponse res) throws IOException {
        String redirect = this.loginURL;
        try {
            redirect += "?to=" + new URI(request.getRequestURI()).getPath();
        } catch (URISyntaxException ignored) {
        }
        res.sendRedirect(URLS.urlFor(request, redirect));
    }
}
