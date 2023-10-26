package com.servlet.staff;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.ItemRequest;
import com.service.impl.ItemRequestService;
import com.util.SessionUtil;
import com.util.Views;

@WebServlet
public class ShowRequestedItemsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ID = SessionUtil.getStaffId(request);

        ArrayList<ItemRequest> itmReqList = new ItemRequestService().getItemRequestByStaffId(ID);

        request.setAttribute("requestedItems", itmReqList);
        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.SHOW_REQUEST_ITEMS);
        dispatcher.forward(request, response);
    }
}
