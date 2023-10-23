package com.servlet.adminServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Customer;
import com.service.impl.CustomerService;

/**
 * Servlet implementation class AdminEditUser
 */

public class AdminEditUserServlet extends HttpServlet {
	// create service object
	CustomerService cs = new CustomerService();
	// create customer object
	Customer cus = new Customer();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int ID = Integer.parseInt(request.getParameter("ID"));
		// get customer details using ID and set to request

		cus = cs.getCustomerById(ID);
		request.setAttribute("ID", ID);
		request.setAttribute("name", cus.getName());
		request.setAttribute("phone", cus.getPhone());
		request.setAttribute("DOB", cus.getDOB());
		request.setAttribute("district", cus.getDistrict());

		// redirect
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminEditCustomerProfile.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get edited data from form
		int ID = Integer.parseInt(request.getParameter("ID"));
		cus.setName(request.getParameter("name"));
		cus.setPhone(request.getParameter("phone"));
		cus.setDOB(request.getParameter("DOB"));
		cus.setDistrict(request.getParameter("district"));
		
		// pass values to update database
		cs.updateCustomer(ID, cus);
		
		//redirect
		response.sendRedirect("./adminManageUsers"); 
		
	}

}
