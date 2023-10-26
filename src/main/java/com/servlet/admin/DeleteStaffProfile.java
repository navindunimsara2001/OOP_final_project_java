package com.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.impl.StaffService;
import com.util.Notify;
import com.util.Parse;
import com.util.URLS;
import com.util.exceptions.ValidationError;

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

            Notify.add(request, Notify.Type.Success, "Deleted Staff Account Successfully");
        } catch (ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }
        response.sendRedirect(URLS.urlFor(request, URLS.MANAGE_STAFF));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
