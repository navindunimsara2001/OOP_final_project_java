package com.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import com.model.Item;
import com.model.ItemRequest;
import com.model.Staff;
import com.service.IItemRequestService;
import com.util.DBUtil;

public class ItemRequestService implements IItemRequestService {
    private static final String ADD_QUERY = "INSERT INTO `item_request` (`item_id`, `staff_id`, `qty`) VALUES (? ,? , ?)";
    private static final String GET_QUERY = "SELECT * FROM `item_request` WHERE `id`=?";
    private static final String GET_ALL_QUERY = "SELECT * FROM `item_request`";
    private static final String GET_STAFF_QUERY = "SELECT * FROM `item_request` WHERE `staff_id`=?";
    private static final String UPDATE_QUERY = "UPDATE `item_request` SET `item_id`=? , `staff_id`=? , `qty`=? where id=?";
    private static final String DELETE_QUERY = "DELETE FROM `item_request` WHERE `id`=?";
    private static final String STATUS_QUERY = "UPDATE `item_request` SET `status` = ? WHERE `id`=?";


    /**
     * add Item request to database
     *
     * @param ir the id of Item Request
     */
    @Override
    public void addItemRequest(ItemRequest ir) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(ADD_QUERY)) {
            stmt.setInt(1, ir.getItem().getID());
            stmt.setInt(2, ir.getStaff().getID());
            stmt.setInt(3, ir.getQty());

            // execute sql statement
            stmt.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to add Item request", e);
        }
    }

    private ItemRequest loadRequest(ResultSet rs) throws SQLException {
        ItemRequest ir = new ItemRequest();
        ir.setID(rs.getInt("id"));

        Item itm = new ItemService().getItemById(rs.getInt("item_id"));
        ir.setItem(itm);

        Staff stf = new StaffService().getStaffById(rs.getInt("staff_id"));
        ir.setStaff(stf);

        String status = rs.getString("status");
        ir.setStatus(status);

        ir.setQty(rs.getInt("qty"));

        return ir;
    }

    /**
     * get Item request by using ID
     *
     * @param ID the id of the Item Request
     * @return object of
     */
    @Override
    public ItemRequest getItemRequestById(int ID) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_QUERY)) {
            stmt.setInt(1, ID);

            // execute sql statement
            ResultSet rs = stmt.executeQuery();

            ItemRequest ir;

            ir = this.loadRequest(rs);

            return ir;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get Item request by Id", e);
        }

        return null;
    }

    /**
     * get all ItemRequest objects
     *
     * @return list of ItemRequest objects
     */
    @Override
    public ArrayList<ItemRequest> getAllItemRequest() {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_ALL_QUERY)) {

            // execute sql statement
            ResultSet rs = stmt.executeQuery();

            ArrayList<ItemRequest> irList = new ArrayList<>();

            while (rs.next()) {
                irList.add(loadRequest(rs));
            }

            return irList;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get all Item request by Id", e);
        }

        return null;
    }

    /**
     * update Item request from database
     *
     * @param ID the id of Item Request
     * @param ir the requested item
     */
    @Override
    public void updateItemRequest(int ID, ItemRequest ir) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(UPDATE_QUERY)) {
            stmt.setInt(1, ir.getItem().getID());
            stmt.setInt(2, ir.getStaff().getID());
            stmt.setInt(3, ir.getQty());
            stmt.setInt(4, ID);

            // execute sql statement
            stmt.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to update Item request by Id", e);
        }
    }

    /**
     * delete Item Request from database
     *
     * @param ID the id of Item Request
     */
    @Override
    public void removeItemRequest(int ID) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(DELETE_QUERY)) {

            stmt.setInt(1, ID);

            // execute sql statement
            stmt.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to delete Item request by Id", e);
        }
    }

    /**
     * Gets the requests made by the given staff member
     *
     * @param ID the id of staff member
     * @return a list of staff members
     */
    public ArrayList<ItemRequest> getItemRequestByStaffId(int ID) {
        ArrayList<ItemRequest> itmList = new ArrayList<>();
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(GET_STAFF_QUERY)) {
            stmt.setInt(1, ID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                itmList.add(this.loadRequest(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get Item request by staff Id", e);
        }
        return itmList;
    }

    /**
     * Updates the status of a request
     *
     * @param ID     the id of request
     * @param status the status of request
     */
    @Override
    public void updateStatus(int ID, String status) {
        try (Connection con = DBUtil.connect(); PreparedStatement stmt = con.prepareStatement(STATUS_QUERY)) {
            stmt.setString(1, status);
            stmt.setInt(2, ID);

            stmt.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to update Item request by Id", e);
        }
    }


}
