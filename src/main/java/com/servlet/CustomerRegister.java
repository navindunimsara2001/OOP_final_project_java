package com.servlet;

import com.model.Customer;
import com.service.impl.CustomerService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerRegister")
public class CustomerRegister extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");

		Customer cus = new Customer();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String DOB = request.getParameter("DOB");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String district = request.getParameter("District");

		final String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		if (matcher.matches() && password.length() >= 8) {
			cus.setName(name);
			cus.setEmail(email);
			cus.setPhone(phone);
			cus.setDOB(DOB);
			cus.setPassword(password);
			cus.setGender(gender);
			cus.setDistrict(district);
		}
		
		CustomerService cs = new CustomerService();
		cs.addCustomer(cus);
	}

}
