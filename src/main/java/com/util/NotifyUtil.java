package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotifyUtil {

    private static final Logger logger = Logger.getLogger(NotifyUtil.class.getName());


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

    public static void addNotify(HttpServletRequest request, Type level, String msg) {
        ArrayList<Message> msgList = getNotifications(request);
        if (Objects.isNull(msgList)) {
            msgList = new ArrayList<>();
        }
        msgList.add(new Message(level, msg));

        HttpSession session = request.getSession();
        session.setAttribute("notify", msgList);
    }


    public static ArrayList<Message> getNotifications(HttpServletRequest request) {
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

    public static ArrayList<Message> fetchNotifications(HttpServletRequest request) {
        ArrayList<Message> msgs = getNotifications(request);
        if (!Objects.isNull(msgs) && !msgs.isEmpty()) {
            request.getSession().removeAttribute("notify");
        }

        return msgs;
    }
}
