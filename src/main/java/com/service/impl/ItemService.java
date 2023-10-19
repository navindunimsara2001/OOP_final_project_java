package com.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import com.model.Item;
import com.service.IItemService;
import com.util.DBUtil;

public class ItemService implements IItemService {
	private final String GET_QUERY = "SELECT * FROM `item` WHERE `id`= ?";
	@Override
	public Item getItemById(int ID) {
		try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_QUERY)) {
			
			stmt.setInt(1, ID);
			
			ResultSet rs = stmt.executeQuery();
			
			Item itm = new Item();
			itm.setID(rs.getInt("id"));
			itm.setName(rs.getString("name"));
			
			return itm;
			
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Failed to get Item by Id", e);
		}
		return null;
	}
}
