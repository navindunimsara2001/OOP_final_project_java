package com.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.model.Customer;

public interface ICustomerService {
    // initialize logger
    Logger logger = Logger.getLogger(ICustomerService.class.getName());

    /**
     * add customer to database
     *
     * @param cus the customer
     */
    void addCustomer(Customer cus);

    /**
     * get customer details by using id
     *
     * @param ID the id of the customer
     * @return the customer
     */
    Customer getCustomerById(int ID);

    /**
     * get all customers in database
     *
     * @return a list of all customers
     */
    ArrayList<Customer> getCustomers();

    /**
     * update customer details
     *
     * @param ID  the id of the customer
     * @param cus the new details of the customer.
     */
    void updateCustomer(int ID, Customer cus);

}
