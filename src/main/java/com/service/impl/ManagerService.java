package com.service.impl;

import com.model.Manager;
import com.service.IManagerService;

import java.util.ArrayList;

public class ManagerService implements IManagerService {
    /**
     * Gets the manager with the given id.
     *
     * @param id the id of the manager
     * @return the manager.
     */
    @Override
    public Manager getManagerById(int id) {
        return null;
    }

    /**
     * Gets all manager in the database
     *
     * @return a list of all managers
     */
    @Override
    public ArrayList<Manager> getManagers() {
        return null;
    }

    /**
     * Adds the given manager to the database
     *
     * @param mgr the manager object
     */
    @Override
    public void addManager(Manager mgr) {

    }

    /**
     * Removes the manager with the given id from the database.
     *
     * @param mgrId the id of the manager
     */
    @Override
    public void removeManager(int mgrId) {

    }

    /**
     * Updates the manager details for the manager with the given id.
     *
     * @param mgrId the id of the manager.
     * @param mgr   the new manager details.
     */
    @Override
    public void updateManager(int mgrId, Manager mgr) {

    }
}
