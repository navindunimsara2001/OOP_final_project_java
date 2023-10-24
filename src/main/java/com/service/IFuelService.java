package com.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.model.Fuel;

public interface IFuelService {
    // initialize logger
    Logger logger = Logger.getLogger(IItemRequestService.class.getName());

    /**
     * Gets the fuel type with the given id.
     *
     * @param ID the id of fuel(type)
     * @return fuel object
     */
    Fuel getFuelTypeByID(int ID);

    /**
     * Gets a list of all fuel types in the database
     *
     * @return fuel list
     */
    ArrayList<Fuel> getFuelTypes();

    /**
     * Updates the data of the fuel type with the given id.
     *
     * @param ID the id of fuel type
     * @param amount the amount of fuel decreased
     */
    void updateFuelAmount(int ID , double amount);
    
    /**
     * 
     * @param ID the id of fuel type
     * @param price new price
     */
    void changeFuelPrice(int ID , double price);
}
