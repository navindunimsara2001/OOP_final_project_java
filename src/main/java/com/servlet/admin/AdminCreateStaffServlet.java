package com.servlet.admin;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Staff;
import com.service.impl.StaffService;
import com.util.URLS;

import java.io.IOException;

/**
 * Servlet implementation class CreateManagerServlet
 */

public class AdminCreateStaffServlet extends HttpServlet {
    // create service object
    final StaffService stfS = new StaffService();
    // create Staff object
    final Staff stf = new Staff();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String DOB = request.getParameter("DOB");
        String password = request.getParameter("password");
        int role = Integer.parseInt(request.getParameter("role"));


        stf.setName(name);
        stf.setEmail(email);
        stf.setPhone(phone);
        stf.setDOB(DOB);
        stf.setPassword(password);
        stf.setRole(role == 1 ? Staff.Role.Manager : Staff.Role.Staff);
        stfS.addStaff(stf);

        response.sendRedirect(URLS.urlFor(request, URLS.MANAGE_STAFF));
    }
}
