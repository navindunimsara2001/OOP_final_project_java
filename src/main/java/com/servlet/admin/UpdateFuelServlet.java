package com.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Fuel;
import com.service.impl.FuelService;
import com.util.Views;


@WebServlet
public class UpdateFuelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get fuel 1 details
				Fuel fuel1 = new FuelService().getFuelTypeByID(1);
				Fuel fuel2 = new FuelService().getFuelTypeByID(2);
				Fuel fuel3 = new FuelService().getFuelTypeByID(3);
				
				request.setAttribute("fuel1",fuel1);
				request.setAttribute("fuel2",fuel2);
				request.setAttribute("fuel3",fuel3);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(Views.UPDATE_FUEL_STOCK);
				dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID = Integer.parseInt(request.getParameter("ID"));
		double price = Double.parseDouble(request.getParameter("price"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		new FuelService().changeFuel(ID, price, amount);
		
		response.sendRedirect("./UpdateFuelServlet");
	}

}
