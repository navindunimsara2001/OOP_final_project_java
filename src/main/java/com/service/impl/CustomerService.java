package com.service.impl;

import com.model.Customer;
import com.service.ICustomerService;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

public class CustomerService implements ICustomerService {
    private static final String addQuery = "insert into `customer` (`name`, `email`, `password`, `phone`, `district`,`dob`,`gender`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String getQuery = "select * from `customer` where id=?";
    private static final String getAllQuery = "select * from `customer`";
    private static final String updateQuery = "update `customer` set `name`=?, `email`=?, `password`=?, `phone`=?, `district`=?,`dob`=?,`gender`=? where id=?";


    /**
     * add customer to database
     *
     * @param cus the customer
     */
    @Override
    public void addCustomer(Customer cus) {
        try (Connection con = DBUtil.connect()) {
            PreparedStatement stmt = con.prepareStatement(addQuery);
            stmt.setString(1, cus.getName());
            stmt.setString(2, cus.getEmail());
            stmt.setString(3, cus.getPassword());
            stmt.setString(4, cus.getPhone());
            stmt.setString(5, cus.getDistrict());
            stmt.setString(6, cus.getDOB());
            stmt.setString(7, cus.getGender());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to add customer", e);
        }
    }

    public static void testCreate() {
        CustomerService cs = new CustomerService();
        Customer c = new Customer();
        c.setName("test");
        c.setEmail("a@b.com");
        c.setPassword("SecurePassword");
        c.setPhone("0717171717");
        c.setDistrict("District 1");
        c.setDOB("2000/01/01");
        c.setGender("Male");

        cs.addCustomer(c);
    }

    /**
     * get customer details by using id
     *
     * @param ID the id of the customer
     * @return the customer
     */
    @Override
    public Customer getCustomerById(int ID) {
        try (Connection con = DBUtil.connect()) {
            PreparedStatement stmt = con.prepareStatement(getQuery);
            stmt.setInt(1, ID);

            ResultSet result = stmt.executeQuery();
            if (!result.next()) {
                return null;
            }

            return loadCustomer(result);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get customer", e);
        }
        return null;
    }

    private Customer loadCustomer(ResultSet result) throws SQLException {
        Customer cus = new Customer();
        cus.setID(result.getInt("id"));
        cus.setName(result.getString("name"));
        cus.setEmail(result.getString("email"));
        cus.setPassword(result.getString("password"));
        cus.setPhone(result.getString("phone"));
        cus.setDistrict(result.getString("district"));
        cus.setDOB(result.getString("dob"));
        cus.setGender(result.getString("gender"));
        return cus;
    }

    /**
     * get all customers in database
     *
     * @return a list of all customers
     */
    @Override
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        try (Connection con = DBUtil.connect()) {
            PreparedStatement stmt = con.prepareStatement(getAllQuery);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                customers.add(loadCustomer(result));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get customer", e);
        }

        return customers;
    }

    public static void testGet() {
        CustomerService cs = new CustomerService();
        System.out.println(cs.getAllCustomers());
    }

    /**
     * update customer details
     *
     * @param ID the id of the customer
     * @param c  the new details of the customer.
     */
    @Override
    public void updateCustomer(int ID, Customer c) {
        try (Connection con = DBUtil.connect()) {
            PreparedStatement stmt = con.prepareStatement(updateQuery);
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getPassword());
            stmt.setString(4, c.getPhone());
            stmt.setString(5, c.getDistrict());
            stmt.setString(6, c.getDOB());
            stmt.setString(7, c.getGender());
            stmt.setInt(8, c.getID());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to update customer", e);
        }
    }
}
