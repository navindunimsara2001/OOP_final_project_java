package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Appointment;
import com.model.Customer;
import com.service.IAppointmentService;
import com.service.ICustomerService;
import com.service.impl.AppointmentService;
import com.service.impl.CustomerService;
import com.util.NotifyUtil;
import com.util.Parse;
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

        try {
            Customer cus = customerService.getCustomerById(SessionUtil.getUserId(request));

            String brand = Parse.String(request.getParameter("brand"), "Brand");
            String model = Parse.String(request.getParameter("model"), "Model");
            String year = Parse.String(request.getParameter("year"), "Year");
            String serviceType = Parse.String(request.getParameter("serviceType"), "Service Type");
            String comments = request.getParameter("comments");
            String appointmentDate = Parse.Date(request.getParameter("appointmentDate"));

            Appointment app = new Appointment();
            app.setBrand(brand);
            app.setModel(model);
            app.setYear(year);
            app.setType(serviceType);
            app.setDate(appointmentDate);
            app.setComment(comments);
            app.setCus(cus);
            app.setStatus("pending");

            // set data to services for insert DB
            appointmentService.addAppointment(app);

            NotifyUtil.addNotify(request, NotifyUtil.Type.Success, "Appointment created successfully");
        } catch (Parse.ValidationError e) {
            NotifyUtil.addNotify(request, NotifyUtil.Type.Error, e.getMessage());
        }

        response.sendRedirect(URLS.urlFor(request, URLS.USER_APPOINTMENT));

    }

}
