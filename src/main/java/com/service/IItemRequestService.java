package com.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.model.ItemRequest;

public interface IItemRequestService {
	//initialize logger
	 static Logger logger = Logger.getLogger(IItemRequestService.class.getName());

	/**
	 * add Item request to database
	 * @param ir the id of Item Request
	 */
	public void addItemRequest(ItemRequest ir);
	
	/**
	 * get Item request by using ID
	 * @param ID the id of the Item Request
	 * @return object of 
	 */
	public ItemRequest getItemRequestById(int ID);
	
	/**
	 * get all ItemRequest objects
	 * @return list of ItemRequest objects
	 */
	public ArrayList<ItemRequest> getAllItemRequest();
	
	/**
	 * update Item request from database
	 * @param ID the id of Item Request
	 */
	public void updateItemRequest(int ID , ItemRequest ir);
	
	/**
	 *  delete Item Request from database
	 * @param ID the id of Item Request
	 */
	public void removeItemRequest(int ID);
}
