package com.util;

import com.util.exceptions.NotLoggedInException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SessionUtil contains functions for handling login sessions
 */
public class SessionUtil {
    private static final Logger logger = Logger.getLogger(SessionUtil.class.getName());

    private static final boolean NO_SESSIONS = false;
    private static final int DEFAULT_ID = 7;


    /**
     * User types
     */
    public enum UserType {
        User, Staff
    }


    /**
     * Returns if the user is logged in.
     *
     * @param req  the servlet request
     * @param type the UserType to check for
     * @return if the user is logged as the given type
     */
    public static boolean isLoggedIn(HttpServletRequest req, UserType type) {
        try {
            getId(req, type);
            return true;
        } catch (NotLoggedInException e) {
            logger.log(Level.INFO, "Not logged in", e);
            return false;
        }
    }


    /**
     * Gets the user id of a logged-in user
     *
     * @param req the servlet request
     * @return the user id
     * @throws NotLoggedInException if the user is not logged in
     */
    public static int getUserId(HttpServletRequest req) {
        return getId(req, UserType.User);
    }


    /**
     * Gets the staff id of a logged-in staff member
     *
     * @param req the servlet request
     * @return the staff id
     * @throws NotLoggedInException if the staff member is not logged in
     */
    public static int getStaffId(HttpServletRequest req) {
        return getId(req, UserType.Staff);
    }

    private static int getId(HttpServletRequest req, UserType type) {
        // disable sessions for testing
        if (NO_SESSIONS) {
            return DEFAULT_ID;
        }

        // get session from request
        HttpSession session = req.getSession(false);
        if (Objects.isNull(session)) {
            throw new NotLoggedInException();
        }

        // try to get the id from the session
        Object idObj = session.getAttribute("id");
        if (Objects.isNull(idObj) || !(idObj instanceof Integer)) {
            throw new NotLoggedInException("user id not set");
        }
        int ID = (int) idObj;

        // try to get the user type
        Object isStaffObj = session.getAttribute("isStaff");
        if (Objects.isNull(isStaffObj) || !(isStaffObj instanceof Boolean)) {
            throw new NotLoggedInException("isStaff not set");
        }

        // check if the user type is the required types
        boolean shouldBeStaff = type == UserType.Staff;
        if (!isStaffObj.equals(shouldBeStaff)) {
            throw new NotLoggedInException("wrong session type");
        }

        return ID;
    }


}
