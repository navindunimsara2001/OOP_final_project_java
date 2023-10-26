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


/**
 * A filter used to check if a user is authenticated
 */
public class AuthFilter extends HttpFilter {

    Logger logger = Logger.getLogger(AuthFilter.class.getName());

    private SessionUtil.UserType type;
    private String loginURL;
    private String homeURL;


    /**
     * Reads the config of the filter from web.xml
     *
     * @param config the <code>FilterConfig</code> object
     *               that contains configuration
     *               information for this filter
     */
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

        // checks if the page is a login page.
        // if the page is a login page, bypass the session check
        if (isLoginPage(request)) {
            logger.log(Level.INFO, "Trying to access login page ");
            chain.doFilter(req, res);
            return;
        }

        // checks if the user has a session
        HttpSession sess = request.getSession(false);
        if (Objects.isNull(sess)) {
            logger.log(Level.INFO, "No session set for user");
            this.redirect(request, (HttpServletResponse) res);
            return;
        }

        // check if the user is logged in
        if (!SessionUtil.isLoggedIn(request, this.type)) {
            logger.log(Level.INFO, "Not logged in or wrong session type");
            this.redirect(request, (HttpServletResponse) res);
            return;
        }

        // check if the user can access the page
        if (!checkAccess(req, res)) {
            logger.log(Level.INFO, "Tried to access blocked url");
            Notify.add(request, Notify.Type.Error, "Unable to Access Page: Permission Denied");
            ((HttpServletResponse) res).sendRedirect(URLS.urlFor(request, this.homeURL));
            return;
        }

        // call the next filter
        chain.doFilter(req, res);
    }

    protected boolean checkAccess(ServletRequest request, ServletResponse response) {
        return true;
    }

    /**
     * Checks if the given request is trying to access a login page
     *
     * @param request the request
     * @return if the page is a login page
     */
    private boolean isLoginPage(ServletRequest request) {
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        String loginURI = URLS.urlFor((HttpServletRequest) request, this.loginURL);

        return (requestURI.equals(loginURI));
    }


    /**
     * Redirects the user to the login page after setting the `to` url parameter
     *
     * @param request the request
     * @param res     the response (used for redirecting)
     */
    private void redirect(HttpServletRequest request, HttpServletResponse res) throws IOException {
        String redirect = this.loginURL;
        try {
            redirect += "?to=" + new URI(request.getRequestURI()).getPath();
        } catch (URISyntaxException ignored) {
        }
        res.sendRedirect(URLS.urlFor(request, redirect));
    }
}
