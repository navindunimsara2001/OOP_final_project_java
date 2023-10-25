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
import com.util.NotifyUtil;
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

            int ID = Integer.parseInt(request.getParameter("ID"));
            double price = Double.parseDouble(request.getParameter("price"));
            double amount = Double.parseDouble(request.getParameter("amount"));

            fuelService.changeFuel(ID, price, amount);

            NotifyUtil.addNotify(request, NotifyUtil.Type.Success, "Updated Fuel Amount Successfully");
        } catch (Parse.ValidationError e) {
            NotifyUtil.addNotify(request, NotifyUtil.Type.Error, e.getMessage());
        }
        response.sendRedirect(URLS.urlFor(request, URLS.UPDATE_FUEL));


    }

}
