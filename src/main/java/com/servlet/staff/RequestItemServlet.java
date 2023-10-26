package com.servlet.staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Item;
import com.model.ItemRequest;
import com.model.Staff;
import com.service.IItemRequestService;
import com.service.IItemService;
import com.service.IStaffService;
import com.service.impl.ItemRequestService;
import com.service.impl.ItemService;
import com.service.impl.StaffService;
import com.util.*;
import com.util.exceptions.ValidationError;


@WebServlet
public class RequestItemServlet extends HttpServlet {
    private final IItemService itemService = new ItemService();
    private final IItemRequestService requestService = new ItemRequestService();
    private final IStaffService staffService = new StaffService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("q");

        ArrayList<Item> items;
        if (Objects.isNull(search) || search.isEmpty()) {
            items = itemService.getAllItemList();
        } else {
            items = itemService.getAllItemListBySearch(search);
        }

        request.setAttribute("items", items);
        RequestDispatcher dispatcher = request.getRequestDispatcher(Views.REQUEST_ITEM);
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int staffId = SessionUtil.getStaffId(request);

        try {
            int itemId = Parse.Number(request.getParameter("itemId"), "Item ID");
            int qty = Parse.Number(request.getParameter("amount"), "Item amount");

            Item item = this.itemService.getItemById(itemId);
            Staff stf = this.staffService.getStaffById(staffId);

            ItemRequest iReq = new ItemRequest();

            iReq.setItem(item);
            iReq.setStaff(stf);
            iReq.setQty(qty);

            this.requestService.addItemRequest(iReq);

            Notify.add(request, Notify.Type.Error, "Request Added successfully");
        } catch (ValidationError e) {
            Notify.add(request, Notify.Type.Error, e.getMessage());
        }
        response.sendRedirect(URLS.urlFor(request, URLS.ITEM_REQUEST));
    }

}
