package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.impl.ItemService;
import com.util.Notify;
import com.util.Parse;
import com.util.URLS;
import com.util.exceptions.ValidationError;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet
public class AddItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String name = Parse.Name(request.getParameter("itemName"));
            int qty = Parse.Number(request.getParameter("amount"), "Item amount");

            new ItemService().addItem(name, qty);
            Notify.add(request, Notify.Type.Success, "Added Item Successfully");
        } catch (ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }

        response.sendRedirect(URLS.urlFor(request, URLS.VIEW_ITEM_LIST));
    }

}
