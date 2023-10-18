package com.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Appointment;
import com.service.IAppointmentService;
import com.util.DBUtil;

public class AppointmentService implements IAppointmentService {
	private final static String ADD_QUERY = "INSERT INTO `appointment`(`brand`,`model`,`year`,`type`,`date`,`customer_id`,`status`)";
	private final static String GET_QUERY = "SELECT * FROM `appointment` WHERE `id`= ?";
	private final static String GETALL_QUERY = "SELECT * FROM `appointment`";
	private final static String UPDATE_QUERY = "UPDATE `appointment` SET `brand`=? , `model`=? , `year`=? , `type`=? , `date`=? , `customer_id`=? , 'status'=?";
	private final static String DELETE_QUERY = "DELETE FROM `appointment` WHERE `id` = ?";
	
    /**
     * add appointment to the database
     *
     * @param app the object of Appointment
     */
    @Override
    public void addAppointment(Appointment app) {
    	try(Connection con = DBUtil.connect();
    		PreparedStatement stmt = con.prepareStatement(ADD_QUERY)
    		){
    		
    		stmt.setString(1,app.getBrand());
    		stmt.setString(2,app.getModel());
    		stmt.setString(3,app.getYear());
    		stmt.setString(4,app.getType());
    		stmt.setString(5,app.getDate());
    		stmt.setInt(6,app.getCus().getID());
    		stmt.setString(7,app.getStatus());
    		// execute 
    		stmt.executeUpdate();
    		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    // load value using method
    private Appointment loadAppoinment(ResultSet rs) throws SQLException {
    	Appointment app = new Appointment();
    	app.setID(rs.getInt("id"));
    	app.setBrand(rs.getString("brand"));
    	app.setModel(rs.getString("model"));
    	app.setYear(rs.getString("year"));
    	app.setType(rs.getString("date"));
    	app.setDate(rs.getString("date"));
    	
    	return app;
    }

    /**
     * get Appointment object using ID
     *
     * @param id the id of appointment
     * @return object of Appointment
     */
    @Override
    public Appointment getAppointmentById(int id) {
    	try(Connection con = DBUtil.connect();
        		PreparedStatement stmt = con.prepareStatement(GET_QUERY)
        	){
    		stmt.setInt(1, id);
  
    		ResultSet rs = stmt.executeQuery();
    		
    		return this.loadAppoinment(rs);
    		
    	} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
        
    }

    /**
     * get all Appointments
     *
     * @return
     */
    @Override
    public ArrayList<Appointment> getAppointments() {
    	try(Connection con = DBUtil.connect();
        		PreparedStatement stmt = con.prepareStatement(GET_QUERY)
        	){
    		
    		ArrayList<Appointment> appList = new ArrayList<>();
    		
    		ResultSet rs = stmt.executeQuery();
    		
    		while(rs.next()) {
    			
    		}
    		
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	
        return null;
    }

    /**
     * update appointment status
     *
     * @param ID  the id of appointment
     * @param app object of appointment
     */
    @Override
    public void updateAppointment(int ID, Appointment app) {

    }

    /**
     * delete Appointment from database
     *
     * @param ID the id of the Appointment
     */
    @Override
    public void removeAppointment(int ID) {

    }
}
