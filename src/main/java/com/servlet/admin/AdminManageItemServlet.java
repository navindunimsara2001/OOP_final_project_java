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
import com.util.URLS;
import com.util.Views;

/**
 * Servlet implementation class ViewItemListServlet
 */
@WebServlet
public class AdminManageItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Item> itmList = new ItemService().getAllItemList();

        request.setAttribute("itmList", itmList);

        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.VIEW_ITEM_LIST);
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = Integer.parseInt(request.getParameter("itmID"));
        int qty = Integer.parseInt(request.getParameter("qty"));
        System.out.println(ID + "," + qty);
        new ItemService().updateItemByID(ID, qty);

        response.sendRedirect(URLS.urlFor(request, URLS.VIEW_ITEM_LIST));
    }
}