package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.impl.CustomerService;

/**
 * Servlet implementation class CustomerDeleteServlet
 */

public class CustomerDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get id from url	
		int ID = Integer.parseInt(request.getParameter("ID"));
		// create customer service object
		CustomerService cs = new CustomerService();
		//delete method
		cs.removeCustomer(ID);
		
		//redirect to register page
		response.sendRedirect("registration.html");
	}
}
