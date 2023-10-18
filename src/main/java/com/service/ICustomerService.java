package com.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.model.Customer;

public interface ICustomerService {
    // initialize logger
    public static final Logger logger = Logger.getLogger(ICustomerService.class.getName());

    /**
     * add customer to database
     *
     * @param cus the customer
     */
    public void addCustomer(Customer cus);

    /**
     * get customer details by using id
     *
     * @param ID the id of the customer
     * @return the customer
     */
    public Customer getCustomerById(int ID);

    /**
     * get all customers in database
     *
     * @return a list of all customers
     */
    public ArrayList<Customer> getAllCustomers();

    /**
     * update customer details
     *
     * @param ID  the id of the customer
     * @param cus the new details of the customer.
     */
    public void updateCustomer(int ID, Customer cus);

}
