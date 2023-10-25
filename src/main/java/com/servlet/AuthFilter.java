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

    private boolean isAdmin;
    private SessionUtil.UserType type;

    @Override
    public void init(FilterConfig config) {
        String admin = config.getInitParameter("admin");
        this.isAdmin = !Objects.isNull(admin) && Boolean.parseBoolean(admin);
        this.type = isAdmin ? SessionUtil.UserType.Staff : SessionUtil.UserType.User;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;

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

    private void redirect(HttpServletRequest request, HttpServletResponse res) throws IOException {
        String redirect = this.isAdmin ? URLS.ADMIN_LOGIN : URLS.USER_LOGIN;
        try {
            redirect += "?to=" + new URI(request.getRequestURI()).getPath();
        } catch (URISyntaxException ignored) {
        }
        res.sendRedirect(URLS.urlFor(request, redirect));
    }
}
