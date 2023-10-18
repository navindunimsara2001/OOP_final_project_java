package com.service.impl;

import com.model.Customer;
import com.model.Fuel;
import com.service.IFuelService;
import com.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;

public class FuelService implements IFuelService {
    private final static String GET_QUERY = "select * from `fuel` where id=?";
    private final static String GET_ALL_QUERY = "select * from `fuel`";
    private final static String UPDATE_FUEL = "update fuel set type=?, subtype=?, amount=?, price=? where id=?";

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
        }
        return null;
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
        f.setSubtype(result.getString("subtype"));
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
    public void updateFuel(int ID, Fuel fuel) {
        try (Connection con = DBUtil.connect();
             PreparedStatement stmt = con.prepareStatement(UPDATE_FUEL)) {
            stmt.setString(1, fuel.getType());
            stmt.setString(2, fuel.getSubtype());
            stmt.setFloat(3, fuel.getAmount());
            stmt.setDouble(4, fuel.getPrice());
            stmt.setInt(5, ID);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to update fuel", e);
        }
    }
}
