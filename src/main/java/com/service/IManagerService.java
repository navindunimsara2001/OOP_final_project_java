package com.service;

import com.model.Manager;

import java.util.ArrayList;
import java.util.logging.Logger;

public interface IManagerService {
    public static Logger logger = Logger.getLogger(IManagerService.class.getName());

    /**
     * Gets the manager with the given id.
     *
     * @param id the id of the manager
     * @return the manager.
     */
    public Manager getManagerById(int id);


    /**
     * Gets all manager in the database
     *
     * @return a list of all managers
     */
    public ArrayList<Manager> getManagers();

    /**
     * Adds the given manager to the database
     *
     * @param mgr the manager object
     */
    public void addManager(Manager mgr);


    /**
     * Removes the manager with the given id from the database.
     *
     * @param mgrId the id of the manager
     */
    public void removeManager(int mgrId);


    /**
     * Updates the manager details for the manager with the given id.
     *
     * @param mgrId the id of the manager.
     * @param mgr   the new manager details.
     */
    public void updateManager(int mgrId, Manager mgr);
}
