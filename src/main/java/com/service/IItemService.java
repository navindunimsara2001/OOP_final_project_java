package com.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.model.Item;

public interface IItemService {
    // initialize logger
    Logger logger = Logger.getLogger(IItemService.class.getName());
    
    /**
     * 
     * @param name the name of item
     * @param qty the quantity of items
     */
    public void addItem(String name , int qty);

    Item getItemById(int ID);

    public ArrayList<Item> getAllItemList();

    ArrayList<Item> getAllItemListBySearch(String str);
    
    void updateItemByID(int Id , int qty);
}
