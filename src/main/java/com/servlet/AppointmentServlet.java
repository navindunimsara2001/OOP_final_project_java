package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Appointment;
import com.service.impl.AppointmentService;
import com.util.SessionUtil;

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
		app.setDate(request.getParameter("appointmentDate"));
		app.setComment(request.getParameter("comment"));
		app.setCus(SessionUtil.getCustomer(request));
		app.setStatus("pending");
		
		
		AppointmentService appser = new AppointmentService();
		appser.addAppointment(app);
		
		String rediret = "home.html";
		response.sendRedirect(rediret);
		
	}

}
