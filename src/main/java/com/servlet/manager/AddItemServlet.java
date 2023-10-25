package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.impl.ItemService;
import com.util.NotifyUtil;
import com.util.Parse;
import com.util.URLS;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String name = Parse.Name("name");
            int qty = Parse.Number("qty", "Item amount");

            new ItemService().addItem(name, qty);
            NotifyUtil.addNotify(request, NotifyUtil.Type.Success, "Added Item Successfully");
        } catch (Parse.ValidationError e) {
            NotifyUtil.addNotify(request, NotifyUtil.Type.Error, e.getMessage());
        }

        response.sendRedirect(URLS.urlFor(request, URLS.VIEW_ITEM_LIST));
    }

}
