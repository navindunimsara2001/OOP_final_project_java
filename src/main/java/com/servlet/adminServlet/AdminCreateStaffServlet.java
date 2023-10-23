package com.servlet.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Staff;
import com.service.impl.StaffService;

/**
 * Servlet implementation class CreateManagerServlet
 */

public class AdminCreateStaffServlet extends HttpServlet {
	// create service object
	StaffService stfS = new StaffService();
	// create Staff object
	Staff stf = new Staff();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String DOB = request.getParameter("DOB");
		String password = request.getParameter("password");
		int role = Integer.parseInt(request.getParameter("role"));

		if (role == 1) { // for create manager
			int is_manager = 1;

			stf.setName(name);
			stf.setEmail(email);
			stf.setPhone(phone);
			stf.setDOB(DOB);
			stf.setPassword(password);
			stf.setRole(is_manager);

			stfS.addStaff(stf);
		} else {  // for create  Staff member
			int is_manager = 0;

			stf.setName(name);
			stf.setEmail(email);
			stf.setPhone(phone);
			stf.setDOB(DOB);
			stf.setPassword(password);
			stf.setRole(is_manager);

			stfS.addStaff(stf);
		}

		// need to add redirection path #########
	}
}
