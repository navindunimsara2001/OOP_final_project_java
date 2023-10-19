package com.service;

import com.model.Staff;

import java.util.ArrayList;
import java.util.logging.Logger;

public interface IStaffService {
    // initialize logger
    Logger logger = Logger.getLogger(IStaffService.class.getName());

    /**
     * Gets the staff member with the given id.
     *
     * @param id the id of the staff member.
     * @return the staff member.
     */
    Staff getStaffById(int id);


    /**
     * Gets the staff with the given email
     *
     * @param email the email address
     * @return the staff or null
     */
    Staff getStaffByEmail(String email);

    /**
     * Gets all staff members in the database
     *
     * @return a list of all staff members
     */
    ArrayList<Staff> getStaffs();

    /**
     * Adds the given staff member to the database
     *
     * @param mgr the staff object
     */
    void addStaff(Staff mgr);


    /**
     * Removes the staff member with the given id from the database.
     *
     * @param mgrId the id of the staff member
     */
    void removeStaff(int mgrId);


    /**
     * Updates the staff member details for the staff member with the given id.
     *
     * @param mgrId the id of the staff member.
     * @param mgr   the new staff member details.
     */
    void updateStaff(int mgrId, Staff mgr);
}
