package com.service.impl;

import com.model.Manager;
import com.service.IManagerService;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

public class ManagerService implements IManagerService {
    private static final String ADD_QUERY = "insert into `staff` (`name`, `email`, `password`, `phone`, `dob`, `is_manager`) VALUES (?, ?, ?, ?, ?, 1)";
    private static final String GET_QUERY = "select * from `staff` where id=? and is_manager=1";
    private static final String GET_ALL_QUERY = "select * from `staff` where is_manager=1";
    private static final String UPDATE_QUERY = "update `staff` set `name`=?, `email`=?, `password`=?, `phone`=?, `dob`=? where id=? and is_manager=1";
    private static final String REMOVE_QUERY = "delete from `staff` where id=? and is_manager=1";

    /**
     * Gets the manager with the given id.
     *
     * @param id the id of the manager
     * @return the manager.
     */
    @Override
    public Manager getManagerById(int id) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_QUERY)) {
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            if (!result.next()) {
                return null;
            }

            return loadManager(result);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get manager", e);
        }
        return null;
    }

    /**
     * Gets all manager in the database
     *
     * @return a list of all managers
     */
    @Override
    public ArrayList<Manager> getManagers() {
        ArrayList<Manager> manager = new ArrayList<>();

        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_ALL_QUERY)) {
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                manager.add(loadManager(result));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get managers", e);
        }

        return manager;
    }


    /**
     * Loads the data from a single row into a Manager object
     *
     * @param result the ResultSet that contains the row
     * @return the manager object
     * @throws SQLException if any errors occur while reading the data.
     */
    private Manager loadManager(ResultSet result) throws SQLException {
        Manager mgr = new Manager();
        mgr.setID(result.getInt("id"));
        mgr.setName(result.getString("name"));
        mgr.setEmail(result.getString("email"));
        mgr.setPassword(result.getString("password"));
        mgr.setPhone(result.getString("phone"));
        mgr.setDOB(result.getString("dob"));
        return mgr;
    }

    /**
     * Adds the given manager to the database
     *
     * @param mgr the manager object
     */
    @Override
    public void addManager(Manager mgr) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(ADD_QUERY)) {
            stmt.setString(1, mgr.getName());
            stmt.setString(2, mgr.getEmail());
            stmt.setString(3, mgr.getPassword());
            stmt.setString(4, mgr.getPhone());
            stmt.setString(5, mgr.getDOB());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to add manager", e);
        }
    }

    /**
     * Removes the manager with the given id from the database.
     *
     * @param mgrId the id of the manager
     */
    @Override
    public void removeManager(int mgrId) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(REMOVE_QUERY)) {
            stmt.setInt(1, mgrId);
            stmt.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to delete manager", e);
        }

    }

    /**
     * Updates the manager details for the manager with the given id.
     *
     * @param mgrId the id of the manager.
     * @param mgr   the new manager details.
     */
    @Override
    public void updateManager(int mgrId, Manager mgr) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(UPDATE_QUERY)) {
            stmt.setString(1, mgr.getName());
            stmt.setString(2, mgr.getEmail());
            stmt.setString(3, mgr.getPassword());
            stmt.setString(4, mgr.getPhone());
            stmt.setString(5, mgr.getDOB());
            stmt.setInt(6, mgrId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to update manager", e);
        }
    }
}
