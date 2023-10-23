package com.servlet.admin;

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
    final StaffService stfS = new StaffService();
    // create Staff object
    final Staff stf = new Staff();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String DOB = request.getParameter("DOB");
        String password = request.getParameter("password");
        int role = Integer.parseInt(request.getParameter("role"));

        int is_manager;
        if (role == 1) { // for create manager
            is_manager = 1;

        } else {  // for create  Staff member
            is_manager = 0;

        }
        stf.setName(name);
        stf.setEmail(email);
        stf.setPhone(phone);
        stf.setDOB(DOB);
        stf.setPassword(password);
        stf.setRole(is_manager);
        stfS.addStaff(stf);

        // need to add redirection path #########
    }
}
