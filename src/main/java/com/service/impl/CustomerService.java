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
    private static final String ADD_QUERY = "insert into `customer` (`name`, `email`, `password`, `phone`, `district`,`dob`,`gender`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_QUERY = "select * from `customer` where id=?";
    private static final String GET_ALL_QUERY = "select * from `customer`";
    private static final String UPDATE_QUERY = "update `customer` set `name`=?, `email`=?, `password`=?, `phone`=?, `district`=?,`dob`=?,`gender`=? where id=?";
    private static final String DELETE_QUERY = "update `customer` set `name`=?, `email`=?, `password`=?, `phone`=?, `district`=?,`dob`=?,`gender`=? where id=?";

    /**
     * add customer to database
     *
     * @param cus the customer
     */
    @Override
    public void addCustomer(Customer cus) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(ADD_QUERY)) {
            stmt.setString(1, cus.getName());
            stmt.setString(2, cus.getEmail());
            stmt.setString(3, cus.getPassword());
            stmt.setString(4, cus.getPhone());
            stmt.setString(5, cus.getDistrict());
            stmt.setString(6, cus.getDOB());
            stmt.setString(7, cus.getGender());
            stmt.executeUpdate();
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
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_QUERY)) {
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

    /**
     * Loads the data from a single row into a Customer object
     *
     * @param result the ResultSet that contains the row
     * @return the customer object
     * @throws SQLException if any errors occur while reading the data.
     */
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
    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_ALL_QUERY)) {
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                customers.add(loadCustomer(result));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get customer", e);
        }

        return customers;
    }

    /**
     * update customer details
     *
     * @param ID the id of the customer
     * @param c  the new details of the customer.
     */
    @Override
    public void updateCustomer(int ID, Customer c) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(UPDATE_QUERY)) {
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getPassword());
            stmt.setString(4, c.getPhone());
            stmt.setString(5, c.getDistrict());
            stmt.setString(6, c.getDOB());
            stmt.setString(7, c.getGender());
            stmt.setInt(8, ID);

            stmt.executeUpdate();
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to update customer", e);
        }
    }
    
    @Override
    public void removeCustomer(int ID) {
    	try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(DELETE_QUERY)) {
    		
    		stmt.setInt(1, ID);
    		stmt.executeUpdate();
    		
    	} catch (SQLException e) {
    		logger.log(Level.SEVERE, "Failed to delete customer", e);
		}
    }
}
