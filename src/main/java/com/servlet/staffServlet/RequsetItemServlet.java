package com.servlet.staffServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Item;
import com.model.ItemRequest;
import com.model.Staff;
import com.service.impl.ItemRequestService;
import com.service.impl.ItemService;
import com.service.impl.StaffService;


@WebServlet("/RequsetItemServlet")
public class RequsetItemServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int staffId = Integer.parseInt(request.getParameter("staffId"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		
		Item item = new ItemService().getItemById(itemId);
		Staff stf = new StaffService().getStaffById(staffId);
		
		ItemRequest iReq = new ItemRequest();
		
		iReq.setItem(item);
		iReq.setStaff(stf);
		iReq.setQty(qty);
		
		new ItemRequestService().addItemRequest(iReq);
	}

}
