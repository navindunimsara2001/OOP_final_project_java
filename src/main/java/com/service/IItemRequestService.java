package com.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.model.ItemRequest;

public interface IItemRequestService {
    //initialize logger
    Logger logger = Logger.getLogger(IItemRequestService.class.getName());

    /**
     * add Item request to database
     *
     * @param ir the id of Item Request
     */
    void addItemRequest(ItemRequest ir);

    /**
     * get Item request by using ID
     *
     * @param ID the id of the Item Request
     * @return object of
     */
    ItemRequest getItemRequestById(int ID);

    /**
     * get all ItemRequest objects
     *
     * @return list of ItemRequest objects
     */
    ArrayList<ItemRequest> getAllItemRequest();

    /**
     * update Item request from database
     *
     * @param ID the id of Item Request
     */
    void updateItemRequest(int ID, ItemRequest ir);

    /**
     * delete Item Request from database
     *
     * @param ID the id of Item Request
     */
    void removeItemRequest(int ID);
    
    /**
     * 
     * @param ID the id of staff member
     * @return List of item requests that staff member requested
     */
    ArrayList<ItemRequest> getItemRequestByStaffId(int ID);
    
    /**
     * 
     * @param ID the id of request
     * @param status the status of request
     */
    void updateStatus(int ID , String status);
}
