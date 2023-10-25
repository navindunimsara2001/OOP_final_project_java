package com.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Staff;
import com.model.Staff.Role;
import com.service.impl.StaffService;
import com.util.URLS;
import com.util.Views;

/**
 * Servlet implementation class EditStaffProfile
 */
@WebServlet("/DeleteStaffProfile")
public class DeleteStaffProfile extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID = Integer.parseInt(request.getParameter("ID"));
		
		new StaffService().removeStaff(ID);
		
		response.sendRedirect(URLS.MANAGE_STAFF);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
