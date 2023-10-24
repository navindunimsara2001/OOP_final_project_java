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


@WebServlet("")
public class ShowUserAppointments extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int ID = SessionUtil.getUserId(request, 0);
		
		ArrayList<Appointment> appList = new AppointmentService().getAppointmentByCustomerId(3);
		
		request.setAttribute("appList", appList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/userAppointments.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
