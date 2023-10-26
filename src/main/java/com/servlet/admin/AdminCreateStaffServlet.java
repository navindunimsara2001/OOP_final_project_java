package com.servlet.admin;

import com.model.Staff;
import com.service.impl.StaffService;
import com.util.Notify;
import com.util.URLS;
import com.util.Parse;
import com.util.exceptions.ValidationError;

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
        try {
            String name = Parse.Name(request.getParameter("name"));
            String email = Parse.Email(request.getParameter("email"));
            String phone = Parse.Phone(request.getParameter("phone"));
            String DOB = Parse.Date(request.getParameter("DOB"));
            String password = Parse.Password(request.getParameter("password"));
            Staff.Role role = Parse.Role(request.getParameter("role"));

            // create Staff object
            final Staff stf = new Staff();
            stf.setName(name);
            stf.setEmail(email);
            stf.setPhone(phone);
            stf.setDOB(DOB);
            stf.setPassword(password);
            stf.setRole(role);
            stfS.addStaff(stf);

            Notify.add(request, Notify.Type.Success, "Created User Successfully.");

        } catch (ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }


        response.sendRedirect(URLS.urlFor(request, URLS.MANAGE_STAFF));
    }
}
