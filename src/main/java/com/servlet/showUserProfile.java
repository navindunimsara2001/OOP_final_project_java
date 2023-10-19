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
import com.util.SessionUtil;


@WebServlet("/showUserProfile")
public class showUserProfile extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int ID = SessionUtil.getCustomer(request).getID();
//		
//		CustomerService cs = new CustomerService();
//		
//		Customer cus = new Customer();
//		
//		cus = cs.getCustomerById(ID);
//		
//		request.setAttribute("name",cus.getName());
//		request.setAttribute("email",cus.getEmail());
//		request.setAttribute("phone",cus.getPhone());
//		request.setAttribute("DOB",cus.getDOB());
//		request.setAttribute("district",cus.getDistrict());
		
		request.setAttribute("name1","hello");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerProfile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
