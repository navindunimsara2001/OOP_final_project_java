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
import com.util.Notify;
import com.util.Parse;
import com.util.URLS;
import com.util.Views;


@WebServlet
public class UpdateFuelServlet extends HttpServlet {
    private final FuelService fuelService = new FuelService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get fuel 1 details
        Fuel fuel1 = fuelService.getFuelTypeByID(1);
        Fuel fuel2 = fuelService.getFuelTypeByID(2);
        Fuel fuel3 = fuelService.getFuelTypeByID(3);

        request.setAttribute("fuel1", fuel1);
        request.setAttribute("fuel2", fuel2);
        request.setAttribute("fuel3", fuel3);

        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.UPDATE_FUEL_STOCK);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            int ID = Parse.Number(request.getParameter("ID"), "Fuel ID");
            double price = Parse.Float(request.getParameter("price"), "Fuel price");
            double amount = Parse.Float(request.getParameter("amount"), "Fuel amount");

            if (price <= 0) {
                throw new Parse.ValidationError("Invalid fuel price");
            }

            if (amount < 0) {
                throw new Parse.ValidationError("Invalid amount");
            }

            fuelService.changeFuel(ID, price, amount);

            Notify.add(request, Notify.Type.Success, "Updated Fuel Amount Successfully");
        } catch (Parse.ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }
        response.sendRedirect(URLS.urlFor(request, URLS.UPDATE_FUEL));


    }

}
