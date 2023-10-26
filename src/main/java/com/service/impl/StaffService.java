package com.service.impl;

import com.model.Staff;
import com.service.IStaffService;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

public class StaffService implements IStaffService {
    private static final String ADD_QUERY = "insert into `staff` (`name`, `email`, `password`, `phone`, `dob`, `role`) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_QUERY = "select * from `staff` where id=?";
    private static final String GET_QUERY_EMAIL = "select * from `staff` where email=?";
    private static final String GET_ALL_QUERY = "select * from `staff`";
    private static final String GET_ALL_STAFF_QUERY = "select * from `staff` where role = " + Staff.Role.Staff.ordinal();
    private static final String UPDATE_QUERY = "update `staff` set `name`=?, `email`=?, `phone`=?, `dob`=?, role=? where id=?";
    private static final String REMOVE_QUERY = "delete from `staff` where id=?";

    /**
     * Gets the staff with the given id.
     *
     * @param id the id of the staff
     * @return the staff.
     */
    @Override
    public Staff getStaffById(int id) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_QUERY)) {
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            if (!result.next()) {
                return null;
            }

            return loadStaff(result);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get staff", e);
        }
        return null;
    }

    /**
     * Gets the staff with the given email
     *
     * @param email the email address
     * @return the staff or null
     */
    @Override
    public Staff getStaffByEmail(String email) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_QUERY_EMAIL)) {
            stmt.setString(1, email);

            ResultSet result = stmt.executeQuery();
            if (!result.next()) {
                return null;
            }

            return loadStaff(result);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get staff", e);
        }
        return null;
    }

    /**
     * Gets all staff in the database
     *
     * @return a list of all staffs
     */
    @Override
    public ArrayList<Staff> getStaffs() {
        ArrayList<Staff> allStaff = new ArrayList<>();

        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_ALL_QUERY)) {
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                allStaff.add(loadStaff(result));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get staffs", e);
        }

        return allStaff;
    }

    /**
     * gets a list of all staff members (staff members not manager)
     *
     * @return a list of all staff members
     */
    public ArrayList<Staff> getOnlyStaffs() {
        ArrayList<Staff> staff = new ArrayList<>();

        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_ALL_STAFF_QUERY)) {
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                staff.add(loadStaff(result));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get staffs", e);
        }

        return staff;
    }


    /**
     * Loads the data from a single row into a Staff object
     *
     * @param result the ResultSet that contains the row
     * @return the staff object
     * @throws SQLException if any errors occur while reading the data.
     */
    private Staff loadStaff(ResultSet result) throws SQLException {
        Staff stf = new Staff();
        stf.setID(result.getInt("id"));
        stf.setName(result.getString("name"));
        stf.setEmail(result.getString("email"));
        stf.setPassword(result.getString("password"));
        stf.setPhone(result.getString("phone"));
        stf.setDOB(result.getString("dob"));
        stf.setRole(Staff.Role.byId(result.getInt("role")));
        return stf;
    }

    /**
     * Adds the given staff to the database
     *
     * @param stf the staff object
     */
    @Override
    public void addStaff(Staff stf) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(ADD_QUERY)) {
            stmt.setString(1, stf.getName());
            stmt.setString(2, stf.getEmail());
            stmt.setString(3, stf.getPassword());
            stmt.setString(4, stf.getPhone());
            stmt.setString(5, stf.getDOB());
            stmt.setInt(6, stf.getRole().ordinal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to add staff", e);
        }
    }

    /**
     * Removes the staff with the given id from the database.
     *
     * @param stfId the id of the staff
     */
    @Override
    public void removeStaff(int stfId) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(REMOVE_QUERY)) {
            stmt.setInt(1, stfId);
            stmt.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to delete staff", e);
        }

    }

    /**
     * Updates the staff details for the staff with the given id.
     *
     * @param stfId the id of the staff.
     * @param stf   the new staff details.
     */
    @Override
    public void updateStaff(int stfId, Staff stf) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(UPDATE_QUERY)) {
            stmt.setString(1, stf.getName());
            stmt.setString(2, stf.getEmail());
            stmt.setString(3, stf.getPhone());
            stmt.setString(4, stf.getDOB());
            stmt.setInt(5, stf.getRole().ordinal());
            stmt.setInt(6, stfId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to update staff", e);
        }
    }
}
