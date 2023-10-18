package com.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.model.Fuel;

public interface IFuelService {
	// initialize logger
	static Logger logger = Logger.getLogger(IItemRequestService.class.getName());
	
	/**
	 * 
	 * @param ID the id of fuel(type)
	 * @return fuel object
	 */
	public Fuel getFuelTypeByID(int ID);
	
	/**
	 * 
	 * @return fuel list
	 */
	public ArrayList<Fuel> getFueleTypes();
	
	/**
	 * 
	 * @param ID id of fuel type
	 * @param fuel object
	 */
	public void updateFuel(int ID , Fuel fuel);
}
