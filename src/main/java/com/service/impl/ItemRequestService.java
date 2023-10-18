package com.service.impl;

import com.model.ItemRequest;
import com.service.IItemRequestService;

import java.util.ArrayList;

public class ItemRequestService implements IItemRequestService {
    /**
     * add Item request to database
     *
     * @param ir the id of Item Request
     */
    @Override
    public void addItemRequest(ItemRequest ir) {

    }

    /**
     * get Item request by using ID
     *
     * @param ID the id of the Item Request
     * @return object of
     */
    @Override
    public ItemRequest getItemRequestById(int ID) {
        return null;
    }

    /**
     * get all ItemRequest objects
     *
     * @return list of ItemRequest objects
     */
    @Override
    public ArrayList<ItemRequest> getAllItemRequest() {
        return null;
    }

    /**
     * update Item request from database
     *
     * @param ID the id of Item Request
     * @param ir
     */
    @Override
    public void updateItemRequest(int ID, ItemRequest ir) {

    }

    /**
     * delete Item Request from database
     *
     * @param ID the id of Item Request
     */
    @Override
    public void removeItemRequest(int ID) {

    }
}
