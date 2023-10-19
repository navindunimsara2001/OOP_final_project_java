package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Appointment;
import com.model.Staff;
import com.service.impl.AppointmentService;
import com.service.impl.CustomerService;
import com.service.impl.StaffService;
import com.util.SessionUtil;
import com.util.URLS;

/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet("/appointmentservlet")
public class AppointmentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Appointment app = new Appointment();

        app.setBrand(request.getParameter("brand"));
        app.setModel(request.getParameter("model"));
        app.setYear(request.getParameter("year"));
        app.setType(request.getParameter("serviceType"));
        app.setDate(request.getParameter("date"));
        app.setComment(request.getParameter("comment"));
        CustomerService cs = new CustomerService();
        app.setCus(cs.getCustomerById(1));


        AppointmentService appser = new AppointmentService();
        appser.addAppointment(app);

        response.sendRedirect(URLS.HOME);

    }

}
