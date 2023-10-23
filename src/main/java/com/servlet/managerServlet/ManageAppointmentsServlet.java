package com.servlet.managerServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Appointment;
import com.model.Staff;
import com.service.impl.AppointmentService;
import com.service.impl.StaffService;

public class ManageAppointmentsServlet extends HttpServlet {
    // create Appointment object
    Appointment app = new Appointment();
    // create AppointmentService object
    AppointmentService appService = new AppointmentService();
    // create Staff members object
    Staff stf = new Staff();
    // create StaffService object
    StaffService stfService = new StaffService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Appointment> appList = new ArrayList<>();
        ArrayList<Staff> stfList = new ArrayList<>();
        // get appointment list
        appList = appService.getAppointments();
        // get staff List
        stfList = stfService.getOnlyStaffs();
        stfList = stfService.getOnlyStaffs();
        // set value to pass
        request.setAttribute("appList", appList);
        request.setAttribute("stfList", stfList);

        // redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher("manageAppointments.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String AID = request.getParameter("AID");
        String sId = request.getParameter("assigned");

        if (!Objects.isNull(sId) && !sId.isEmpty() && !Objects.isNull(AID)) {
            // get ID values
            int appID = Integer.parseInt(AID);
            int staffID = Integer.parseInt(sId);
            // set values
            app.setStatus(request.getParameter("status"));
            stf = stfService.getStaffById(staffID);
            app.setStaff(stf);
            // pass value to update
            appService.updateAppointment(appID, app);
        }
        // redirect
        response.sendRedirect("./manageAppointment");

    }

}
