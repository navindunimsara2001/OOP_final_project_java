package com.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.model.Appointment;

public interface IAppointmentService {
    // initialize logger
    Logger logger = Logger.getLogger(IAppointmentService.class.getName());

    /**
     * add appointment to the database
     *
     * @param app the object of Appointment
     */
    void addAppointment(Appointment app);

    /**
     * get Appointment object using ID
     *
     * @param id the id of appointment
     * @return object of Appointment
     */
    Appointment getAppointmentById(int id);

    /**
     * get all Appointments
     *
     * @return a list of all appointment
     */
    ArrayList<Appointment> getAppointments();

    /**
     * update appointment status
     *
     * @param ID  the id of appointment
     * @param app object of appointment
     */
    public void updateAppointment(int ID, Appointment app);

    /**
     * delete Appointment from database
     *
     * @param ID the id of the Appointment
     */
    void removeAppointment(int ID);
}
