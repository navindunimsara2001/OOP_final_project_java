package com.service.impl;

import com.model.Fuel;
import com.service.IFuelService;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

public class FuelService implements IFuelService {
    private final static String GET_QUERY = "select * from `fuel` where id=?";
    private final static String GET_ALL_QUERY = "select * from `fuel`";
    private final static String UPDATE_FUEL_AMOUNT = "update fuel set `amount`= `amount`-? where id=?";
    private final static String UPDATE_FUEL = "update fuel set `price`= ? ,`amount`=`amount`+ ? where id=?";

    /**
     * Gets the fuel type with the given id.
     *
     * @param ID the id of fuel(type)
     * @return fuel object
     */
    @Override
    public Fuel getFuelTypeByID(int ID) {
        try (Connection con = DBUtil.connect()) {
            PreparedStatement stmt = con.prepareStatement(GET_QUERY);
            stmt.setInt(1, ID);

            ResultSet result = stmt.executeQuery();

            if (!result.next()) {
                return null;
            }

            return this.loadFuel(result);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get fuel", e);
            return null;
        }
    }

    /**
     * Gets a list of all fuel types in the database
     *
     * @return fuel list
     */
    @Override
    public ArrayList<Fuel> getFuelTypes() {
        ArrayList<Fuel> fuels = new ArrayList<>();
        try (Connection con = DBUtil.connect()) {
            PreparedStatement stmt = con.prepareStatement(GET_ALL_QUERY);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                fuels.add(this.loadFuel(result));
            }


        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get fuel", e);
        }
        return fuels;
    }

    /**
     * Loads the data from a single row into a Fuel object
     *
     * @param result the ResultSet that contains the row
     * @return the Fuel object
     * @throws SQLException if any errors occur while reading the data.
     */
    private Fuel loadFuel(ResultSet result) throws SQLException {
        Fuel f = new Fuel();
        f.setID(result.getInt("id"));
        f.setType(result.getString("type"));
        f.setAmount(result.getFloat("amount"));
        f.setPrice(result.getDouble("price"));
        return f;
    }

    /**
     * Updates the data of the fuel type with the given id.
     *
     * @param ID   id of fuel type
     * @param fuel the new data of the fuel object
     */
    @Override
    public void updateFuelAmount(int ID , double amount) {
        try (Connection con = DBUtil.connect();
             PreparedStatement stmt = con.prepareStatement(UPDATE_FUEL_AMOUNT)) {
            stmt.setDouble(1,amount);
            stmt.setInt(2, ID);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to update fuel", e);
        }
    }
    
    /**
     * 
     * @param ID the id of fuel type
     * @param price new price
     * @param  amount the new amount
     */
    @Override
	public void changeFuel(int ID , double price , double amount) {
    	try (Connection con = DBUtil.connect();
                PreparedStatement stmt = con.prepareStatement(UPDATE_FUEL)) {
    		stmt.setDouble(1, price);
    		stmt.setDouble(2, amount);
    		stmt.setDouble(3, ID);
    		
    		stmt.executeUpdate();
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
