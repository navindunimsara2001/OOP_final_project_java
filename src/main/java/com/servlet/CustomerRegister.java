package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Customer;

@WebServlet("/CustomerRegister")
public class CustomerRegister extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Customer cus = new Customer();
		
		String name =  request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String DOB = request.getParameter("DOB");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String district = request.getParameter("District");
		
		cus.setName(name);
		cus.setEmail(email);
		cus.setPhone(phone);
		cus.setDOB(DOB);
		cus.setPassword(password);
		cus.setGender(gender);
		cus.setDistrict(district);
	}

}
