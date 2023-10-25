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
import com.util.NotifyUtil;
import com.util.Parse;
import com.util.URLS;
import com.util.Views;

/**
 * Servlet implementation class EditStaffProfile
 */
@WebServlet
public class DeleteStaffProfile extends HttpServlet {
    private final StaffService staffService = new StaffService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int ID = Parse.Number(request.getParameter("id"));

            staffService.removeStaff(ID);

            NotifyUtil.addNotify(request, NotifyUtil.Type.Success, "Deleted Staff Account Successfully");
        } catch (Parse.ValidationError e) {
            NotifyUtil.addNotify(request, NotifyUtil.Type.Error, e.getMessage());
        }
        response.sendRedirect(URLS.urlFor(request, URLS.MANAGE_STAFF));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
