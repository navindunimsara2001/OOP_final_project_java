package com.servlet;

import java.io.IOException;
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
import com.util.*;
import com.util.exceptions.ValidationError;

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
        	//get customer ID using session
            Customer cus = customerService.getCustomerById(SessionUtil.getUserId(request));
            
            // get values form from
            // use string function in Parse class to validate if string is empty or not
            String brand = Parse.String(request.getParameter("brand"), "Brand");
            String model = Parse.String(request.getParameter("model"), "Model");
            String year = Parse.String(request.getParameter("year"), "Year");
            String serviceType = Parse.String(request.getParameter("serviceType"), "Service Type");
            String comments = request.getParameter("comments");
            String appointmentDate = Parse.Date(request.getParameter("appointmentDate"));
            
            // create an Appointment object for store values
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
            // notify success message
            Notify.add(request, Notify.Type.Success, "Appointment created successfully");
        } catch (ValidationError e) {
        	// notify
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }

        response.sendRedirect(URLS.urlFor(request, URLS.USER_APPOINTMENT));

    }

}
