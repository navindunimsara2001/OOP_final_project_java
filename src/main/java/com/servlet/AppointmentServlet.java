package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Appointment;
import com.service.IAppointmentService;
import com.service.ICustomerService;
import com.service.impl.AppointmentService;
import com.service.impl.CustomerService;
import com.util.SessionUtil;
import com.util.URLS;

/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet
public class AppointmentServlet extends HttpServlet {
    private final IAppointmentService appointmentService = new AppointmentService();
    private final ICustomerService customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Appointment app = new Appointment();

        app.setBrand(request.getParameter("brand"));
        app.setModel(request.getParameter("model"));
        app.setYear(request.getParameter("year"));
        app.setType(request.getParameter("serviceType"));
        app.setDate(request.getParameter("appointmentDate"));
        app.setComment(request.getParameter("comments"));
        app.setCus(customerService.getCustomerById(SessionUtil.getUserId(request, 4)));
        app.setStatus("pending");

        // set data to services for insert DB
        appointmentService.addAppointment(app);

        response.sendRedirect(URLS.urlFor(request, URLS.USER_APPOINTMENT));

    }

}
