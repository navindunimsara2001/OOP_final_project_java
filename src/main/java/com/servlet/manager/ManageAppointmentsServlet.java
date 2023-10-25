package com.servlet.manager;

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
import com.util.Notify;
import com.util.Parse;
import com.util.URLS;
import com.util.Views;

@WebServlet
public class ManageAppointmentsServlet extends HttpServlet {
    // create AppointmentService object
    final AppointmentService appService = new AppointmentService();
    // create StaffService object
    final StaffService stfService = new StaffService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Appointment> appList;
        ArrayList<Staff> stfList;
        // get appointment list
        appList = appService.getAppointments();
        // get staff List
        stfList = stfService.getOnlyStaffs();
        // set value to pass
        request.setAttribute("appList", appList);
        request.setAttribute("stfList", stfList);

        // redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.MANAGE_APPOINTMENTS);
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            // get ID values
            int appID = Parse.Number(request.getParameter("AID"), "Appointment ID");


            // get Appointment object
            Appointment app = appService.getAppointmentById(appID);
            if (Objects.isNull(app)) {
                throw new Parse.ValidationError("Appointment does not exist");
            }
            app.setStatus(request.getParameter("status"));

            if (!Objects.isNull(request.getParameter("assigned"))) {
                int staffID = Parse.Number(request.getParameter("assigned"), "Assigned Staff Member");
                Staff stf = stfService.getStaffById(staffID);
                if (Objects.isNull(stf)) {
                    throw new Parse.ValidationError("Staff member does not exist");
                }
                app.setStaff(stf);
            } else {
                app.setStatus(null);
            }


            // pass value to update
            appService.updateAppointment(appID, app);

            Notify.add(request, Notify.Type.Success, "Appointment updated successfully");
        } catch (Parse.ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }
        // redirect
        response.sendRedirect(URLS.urlFor(request, URLS.MANAGE_APPOINTMENT));

    }

}
