package com.service;

import java.util.logging.Logger;

import com.model.ItemRequest;

public interface IItemRequestService {
	//initialize logger
	 static Logger logger = Logger.getLogger(IItemRequestService.class.getName());

	/**
	 * 
	 * @param ir the id of Item Request
	 */
	public void addItemRequest(ItemRequest ir);
	
	/**
	 * 
	 * @param ID the id of the Item Request=
	 * @return object of 
	 */
	public ItemRequest getItemRequest(int ID);
}
