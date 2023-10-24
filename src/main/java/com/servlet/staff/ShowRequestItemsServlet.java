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

@WebServlet("/ShowRequestItemsServlet")
public class ShowRequestItemsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID = SessionUtil.getStaffId(request);
		
		ArrayList<ItemRequest> itmReqList = new ItemRequestService().getItemRequestByStaffId(ID);
		request.setAttribute("itmReqList", itmReqList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/CreatedItemRequest.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
