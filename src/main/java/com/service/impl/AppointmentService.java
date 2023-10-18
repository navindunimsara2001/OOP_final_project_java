package com.service.impl;

import com.model.Appointment;
import com.service.IAppointmentService;

import java.util.ArrayList;

public class AppointmentService implements IAppointmentService {
    /**
     * add appointment to the database
     *
     * @param app the object of Appointment
     */
    @Override
    public void addAppointment(Appointment app) {

    }

    /**
     * get Appointment object using ID
     *
     * @param id the id of appointment
     * @return object of Appointment
     */
    @Override
    public Appointment getAppointmentById(int id) {
        return null;
    }

    /**
     * get all Appointments
     *
     * @return
     */
    @Override
    public ArrayList<Appointment> getAppointments() {
        return null;
    }

    /**
     * update appointment status
     *
     * @param ID  the id of appointment
     * @param app object of appointment
     */
    @Override
    public void updataAppointment(int ID, Appointment app) {

    }

    /**
     * delete Appointment from database
     *
     * @param ID the id of the Appointment
     */
    @Override
    public void removeAppointment(int ID) {

    }
}
