package com.servlet.staff;

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

/**
 * Servlet implementation class ViewAssignedAppointment
 */
@WebServlet
public class ViewAssignedAppointment extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = SessionUtil.getStaffId(request);

        ArrayList<Appointment> appList = new AppointmentService().getAppointmentBystaffId(ID);

        request.setAttribute("appList", appList);

        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.SHOW_APPOINTMENTS);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
