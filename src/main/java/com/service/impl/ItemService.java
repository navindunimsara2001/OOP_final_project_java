package com.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import com.model.Item;
import com.service.IItemService;
import com.util.DBUtil;

public class ItemService implements IItemService {
    private final static String GET_QUERY = "SELECT * FROM `item` WHERE `id`= ?";
    private final static String GET_ALL_QUERY = "SELECT * FROM `item`";
    private final static String SEARCH_QUERY = "SELECT * FROM `item` where `name` LIKE ?";
    private final static String UPDATE_QUERY = "UPDATE `item` SET `in_stock` = `in_stock`+ ? where `id` = ?";

    @Override
    public Item getItemById(int ID) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_QUERY)) {

            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return null;
            }

            return this.loadItem(rs);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get Item by Id", e);
        }
        return null;
    }

    public Item loadItem(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setID(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setInStock(rs.getInt("in_stock"));

        return item;
    }


    public ArrayList<Item> getAllItemListBySearch(String str) {
        ArrayList<Item> itmList = new ArrayList<>();
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(SEARCH_QUERY)) {

            stmt.setString(1, "%" + str + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                itmList.add(this.loadItem(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to search Items", e);
        }

        return itmList;
    }

    public ArrayList<Item> getAllItemList() {
        ArrayList<Item> itmList = new ArrayList<>();
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_ALL_QUERY)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                itmList.add(this.loadItem(rs));
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get all Items", e);
        }

        return itmList;
    }
    
    public void updateItemByID(int ID , int qty) {
    	 try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(UPDATE_QUERY)) {
    		 stmt.setInt(1,	qty);
    		 stmt.setInt(2, ID);
    		 
    		 stmt.executeUpdate();
    		 
    	 } catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
