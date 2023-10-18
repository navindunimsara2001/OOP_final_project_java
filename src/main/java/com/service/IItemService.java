package com.service;

import java.util.logging.Logger;

import com.model.Item;

public interface IItemService {
	// initialize logger
    Logger logger = Logger.getLogger(IItemService.class.getName());
    
    Item getItemById(int ID);
}
