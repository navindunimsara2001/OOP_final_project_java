package com.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.model.Item;

public interface IItemService {
    // initialize logger
    Logger logger = Logger.getLogger(IItemService.class.getName());

    /**
     * @param item the item
     */
    public void addItem(Item item);

    Item getItemById(int ID);

    public ArrayList<Item> getAllItemList();

    ArrayList<Item> getAllItemListBySearch(String str);

    void updateItemByID(int Id, int qty);
}
