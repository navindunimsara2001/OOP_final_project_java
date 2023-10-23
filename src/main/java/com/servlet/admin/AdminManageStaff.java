package com.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Staff;
import com.service.impl.StaffService;
import com.util.Views;

/**
 * Servlet implementation class AdminManageStaff
 */
@WebServlet("/AdminManageStaff")
public class AdminManageStaff extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StaffService stfService = new StaffService();

        ArrayList<Staff> stfList = stfService.getStaffs();

        request.setAttribute("stfList", stfList);

        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.MANAGE_STAFF);
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
