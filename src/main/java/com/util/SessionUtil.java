package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SessionUtil {
    private static final Logger logger = Logger.getLogger(SessionUtil.class.getName());

    private static final boolean NO_SESSIONS = false;
    private static final int DEFAULT_ID = 7;

    public static class NotLoggedInException extends RuntimeException {
        public NotLoggedInException() {
            super("User is not logged in");
        }

        public NotLoggedInException(String err) {
            super("User is not logged in: " + err);
        }
    }

    public enum UserType {
        User, Staff
    }


    public static boolean isLoggedIn(HttpServletRequest req, UserType type) {
        try {
            getId(req, type);
            return true;
        } catch (NotLoggedInException e) {
            logger.log(Level.INFO, "Not logged in", e);
            return false;
        }
    }


    public static int getUserId(HttpServletRequest req) {
        return getId(req, UserType.User);
    }


    public static int getStaffId(HttpServletRequest req) {
        return getId(req, UserType.Staff);
    }

    private static int getId(HttpServletRequest req, UserType type) {
        if (NO_SESSIONS) {
            return DEFAULT_ID;
        }

        HttpSession session = req.getSession(false);
        if (Objects.isNull(session)) {
            throw new NotLoggedInException();
        }

        Object idObj = session.getAttribute("id");
        if (Objects.isNull(idObj) || !(idObj instanceof Integer)) {
            throw new NotLoggedInException("user id not set");
        }
        int ID = (int) idObj;

        Object isStaffObj = session.getAttribute("isStaff");
        if (Objects.isNull(isStaffObj) || !(isStaffObj instanceof Boolean)) {
            throw new NotLoggedInException("isStaff not set");
        }

        boolean shouldBeStaff = type == UserType.Staff;
        if (!isStaffObj.equals(shouldBeStaff)) {
            throw new NotLoggedInException("wrong session type");
        }

        return ID;
    }


}
