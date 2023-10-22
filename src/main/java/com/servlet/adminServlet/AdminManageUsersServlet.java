package com.servlet.adminServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Customer;
import com.service.impl.CustomerService;

@WebServlet("/AdminManageUsersServlet")
public class AdminManageUsersServlet extends HttpServlet {
	CustomerService cs = new CustomerService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// create Arraylist
		ArrayList<Customer> customerList = new ArrayList<>();
		// assign user details list
		customerList = cs.getCustomers();

		request.setAttribute("customerList", customerList);

		// redirect
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminManageUsers.jsp");
		dispatcher.forward(request, response);
	}

}
