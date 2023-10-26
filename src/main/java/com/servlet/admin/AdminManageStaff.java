package com.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Staff;
import com.model.Staff.Role;
import com.service.impl.StaffService;
import com.util.*;
import com.util.exceptions.ValidationError;

/**
 * Servlet implementation class AdminManageStaff
 */
@WebServlet
public class AdminManageStaff extends HttpServlet {
    private final StaffService staffService = new StaffService();
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StaffService stfService = new StaffService();

        ArrayList<Staff> stfList = stfService.getStaffs();

        request.setAttribute("stfList", stfList);

        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.MANAGE_STAFF);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int ID = Parse.Number(request.getParameter("ID"), "Staff ID");
            String name = Parse.Name(request.getParameter("name"));
            String email = Parse.Email(request.getParameter("email"));
            String phone = Parse.Phone(request.getParameter("phone"));
            String DOB = Parse.Date(request.getParameter("DOB"));

            Staff stf = staffService.getStaffById(ID);
            if (Objects.isNull(stf)) {
                throw new ValidationError("Invalid Staff ID");
            }

            stf.setName(name);
            stf.setEmail(email);
            stf.setPhone(phone);
            stf.setDOB(DOB);

            Role role = Parse.Role(request.getParameter("role"));
            stf.setRole(role);

            staffService.updateStaff(ID, stf);
            Notify.add(request, Notify.Type.Success, "Staff Member Updated Successfully.");
        } catch (ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }

        response.sendRedirect(URLS.urlFor(request, URLS.MANAGE_STAFF));
    }

}
