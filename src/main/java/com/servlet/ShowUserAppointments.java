package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Appointment;
import com.service.impl.AppointmentService;
import com.util.SessionUtil;
import com.util.Views;


@WebServlet
public class ShowUserAppointments extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = SessionUtil.getUserId(request);

        ArrayList<Appointment> appList = new AppointmentService().getAppointmentByCustomerId(ID);

        request.setAttribute("appList", appList);

        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.USER_APPOINTMENTS);
        dispatcher.forward(request, response);
    }
}
