package com.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.model.Fuel;

public interface IFuelService {
    // initialize logger
    static Logger logger = Logger.getLogger(IItemRequestService.class.getName());

    /**
     * Gets the fuel type with the given id.
     *
     * @param ID the id of fuel(type)
     * @return fuel object
     */
    public Fuel getFuelTypeByID(int ID);

    /**
     * Gets a list of all fuel types in the database
     *
     * @return fuel list
     */
    public ArrayList<Fuel> getFuelTypes();

    /**
     * Updates the data of the fuel type with the given id.
     *
     * @param ID   id of fuel type
     * @param fuel the new data of the fuel object
     */
    public void updateFuel(int ID, Fuel fuel);
}
