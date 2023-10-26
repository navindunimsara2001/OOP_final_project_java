package com.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Item;
import com.service.impl.ItemService;
import com.util.*;
import com.util.exceptions.ValidationError;

/**
 * Servlet implementation class ViewItemListServlet
 */
@WebServlet
public class AdminManageItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ItemService itemService = new ItemService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Item> itmList = itemService.getAllItemList();

        request.setAttribute("itmList", itmList);

        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.VIEW_ITEM_LIST);
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int ID = Parse.Number(request.getParameter("itmID"), "Item ID");
            int qty = Parse.Number(request.getParameter("qty"), "Item Amount");

            itemService.updateItemByID(ID, qty);

            Notify.add(request, Notify.Type.Success, "Item Amount Updated Successfully");
        } catch (ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }
        response.sendRedirect(URLS.urlFor(request, URLS.VIEW_ITEM_LIST));
    }
}
