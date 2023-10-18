package com.service.impl;

import com.model.Staff;
import com.service.IStaffService;

import java.util.ArrayList;

public class StaffService implements IStaffService {
    /**
     * Gets the staff member with the given id.
     *
     * @param id the id of the staff member.
     * @return the staff member.
     */
    @Override
    public Staff getStaffById(int id) {
        return null;
    }

    /**
     * Gets all staff members in the database
     *
     * @return a list of all staff members
     */
    @Override
    public ArrayList<Staff> getStaffs() {
        return null;
    }

    /**
     * Adds the given staff member to the database
     *
     * @param mgr the staff object
     */
    @Override
    public void addStaff(Staff mgr) {

    }

    /**
     * Removes the staff member with the given id from the database.
     *
     * @param mgrId the id of the staff member
     */
    @Override
    public void removeStaff(int mgrId) {

    }

    /**
     * Updates the staff member details for the staff member with the given id.
     *
     * @param mgrId the id of the staff member.
     * @param mgr   the new staff member details.
     */
    @Override
    public void updateStaff(int mgrId, Staff mgr) {

    }
}
