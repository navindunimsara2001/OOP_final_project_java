package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Notify {

    private static final Logger logger = Logger.getLogger(Notify.class.getName());


    /**
     * Type is the type of the notification type.
     */
    public enum Type {
        Info, Success, Error
    }

    public static class Message {
        private final Type type;
        private final String msg;

        public Message(Type level, String msg) {
            this.type = level;
            this.msg = msg;
        }

        public Type getType() {
            return type;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * Creates a new notification message for this session
     *
     * @param request the servlet request
     * @param level   the message leve
     * @param msg     the message to display
     */
    public static void add(HttpServletRequest request, Type level, String msg) {
        ArrayList<Message> msgList = getNotifications(request);
        if (Objects.isNull(msgList)) {
            msgList = new ArrayList<>();
        }
        msgList.add(new Message(level, msg));

        HttpSession session = request.getSession();
        session.setAttribute("notify", msgList);
    }


    /**
     * Fetch gets all the notifications for the given session after removing them from the session
     *
     * @param request the servlet request
     * @return a list of Messages
     */
    public static ArrayList<Message> fetch(HttpServletRequest request) {
        ArrayList<Message> msgs = getNotifications(request);
        if (!Objects.isNull(msgs) && !msgs.isEmpty()) {
            request.getSession().removeAttribute("notify");
        }

        return msgs;
    }

    /**
     * gets a list of notifications for the session
     *
     * @param request the servlet request
     * @return a list of Messages or null
     */
    private static ArrayList<Message> getNotifications(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (Objects.isNull(session)) {
            return null;
        }

        Object pendingNotifyObj = session.getAttribute("notify");
        if (Objects.isNull(pendingNotifyObj)) {
            return null;
        } else {
            try {
                return (ArrayList<Message>) pendingNotifyObj;
            } catch (ClassCastException e) {
                logger.log(Level.SEVERE, "session has invalid notify type");
                return null;
            }
        }
    }


}
