package com.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.model.Appointment;

public interface IAppointmentService {
	// initialize logger
    static Logger logger = Logger.getLogger(IAppointmentService.class.getName());
    
    /**
     * add appointment to the database
     * @param app the object of Appointment
     */
    public void addAppointment(Appointment app);
    
    /**
     * get Appointment object using ID
     * @param id the id of appointment
     * @return object of Appointment
     */
    public Appointment getAppointmentById(int id);
    
    /**
     * get all Appointments
     * @return
     */
    public ArrayList<Appointment> getAppointments();
    
    /**
     * update appointment status
     * @param ID the id of appointment
     * @param app object of appointment
     */
    public void updataAppointment(int ID ,  Appointment app);
    
    /**
     * delete Appointment from database
     * @param ID the id of the Appointment
     */
    public void removeAppointment(int ID);
}
