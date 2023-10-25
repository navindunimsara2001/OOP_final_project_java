package com.servlet.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.ItemRequest;
import com.service.impl.ItemRequestService;
import com.util.NotifyUtil;
import com.util.Parse;
import com.util.URLS;
import com.util.Views;


@WebServlet
public class ManageItemRequest extends HttpServlet {

    private final ItemRequestService itemRequestService = new ItemRequestService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("ID");
        String status = request.getParameter("status");
        if (!Objects.isNull(id) && !Objects.isNull(status)) {
            try {
                int ID = Integer.parseInt(id);
                itemRequestService.updateStatus(ID, status);
                response.sendRedirect(URLS.urlFor(request, URLS.MANAGE_REQUEST));

                NotifyUtil.addNotify(request, NotifyUtil.Type.Success, "Request Updated Successfully");
            } catch (Parse.ValidationError e) {
                NotifyUtil.addNotify(request, NotifyUtil.Type.Error, e.getMessage());
            }

            return;
        }


        ArrayList<ItemRequest> irList = itemRequestService.getAllItemRequest();
        request.setAttribute("irList", irList);

        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.MANAGE_ITEM_REQUEST);
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
