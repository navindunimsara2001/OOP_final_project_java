package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Customer;
import com.service.impl.CustomerService;

@WebServlet("/UserProfileEdit")
public class UserProfileEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get user detail form url
		int ID = Integer.parseInt(request.getParameter("ID"));

		// create service object
		CustomerService cs = new CustomerService();
		// create customer object
		Customer cus = new Customer();
		// get customer details from database
		cus = cs.getCustomerById(ID);
		
		request.setAttribute("name",cus.getName());
		request.setAttribute("phone", cus.getPhone());
		request.setAttribute("district",cus.getDistrict());
		request.setAttribute("password", cus.getPassword());
		// redirect
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerEditProfile.jsp");
		dispatcher.forward(request, response);
	}

}
