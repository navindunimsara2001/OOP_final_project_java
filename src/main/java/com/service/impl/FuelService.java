package com.service.impl;

import com.model.Fuel;
import com.service.IFuelService;

import java.util.ArrayList;

public class FuelService implements IFuelService {
    /**
     * @param ID the id of fuel(type)
     * @return fuel object
     */
    @Override
    public Fuel getFuelTypeByID(int ID) {
        return null;
    }

    /**
     * @return fuel list
     */
    @Override
    public ArrayList<Fuel> getFueleTypes() {
        return null;
    }

    /**
     * @param ID   id of fuel type
     * @param fuel object
     */
    @Override
    public void updateFuel(int ID, Fuel fuel) {

    }
}
