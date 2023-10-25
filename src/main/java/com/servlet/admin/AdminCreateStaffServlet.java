package com.servlet.admin;

import com.model.Staff;
import com.service.impl.StaffService;
import com.util.NotifyUtil;
import com.util.URLS;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CreateManagerServlet
 */

public class AdminCreateStaffServlet extends HttpServlet {
    // create service object
    final StaffService stfS = new StaffService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String DOB = request.getParameter("DOB");
        String password = request.getParameter("password");
        int role = Integer.parseInt(request.getParameter("role"));

        // create Staff object
        final Staff stf = new Staff();
        stf.setName(name);
        stf.setEmail(email);
        stf.setPhone(phone);
        stf.setDOB(DOB);
        stf.setPassword(password);
        stf.setRole(role == 1 ? Staff.Role.Manager : Staff.Role.Staff);
        stfS.addStaff(stf);

        NotifyUtil.addNotify(request, NotifyUtil.Type.Success, "Created User Successfully.");
        response.sendRedirect(URLS.urlFor(request, URLS.MANAGE_STAFF));
    }
}
