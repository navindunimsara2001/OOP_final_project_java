package com.servlet;

import com.model.Person;
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

public class AuthFilter extends HttpFilter {

    private SessionUtil.UserType type;
    private String loginURL;

    @Override
    public void init(FilterConfig config) {
        String admin = config.getInitParameter("admin");
        boolean isAdmin = !Objects.isNull(admin) && Boolean.parseBoolean(admin);

        this.type = isAdmin ? SessionUtil.UserType.Staff : SessionUtil.UserType.User;
        this.loginURL = isAdmin ? URLS.ADMIN_LOGIN : URLS.USER_LOGIN;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;

        if (isLoginPage(request)) {
            chain.doFilter(req, res);
            return;
        }

        HttpSession sess = request.getSession(false);
        if (Objects.isNull(sess)) {
            this.redirect(request, (HttpServletResponse) res);
            return;
        }

        if (!SessionUtil.isLoggedIn(request, this.type) || !checkAccess(req, res)) {
            this.redirect(request, (HttpServletResponse) res);
            return;
        }

        chain.doFilter(req, res);
    }

    protected boolean checkAccess(ServletRequest request, ServletResponse response) {
        return true;
    }

    private boolean isLoginPage(ServletRequest request) {
        return (!((HttpServletRequest) request).getRequestURI().equals(this.loginURL));
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
