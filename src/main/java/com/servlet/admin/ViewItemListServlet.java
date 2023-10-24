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

/**
 * Servlet implementation class ViewItemListServlet
 */
@WebServlet("/ViewItemListServlet")
public class ViewItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Item> itmList = new ItemService().getAllItemList();
		
		request.setAttribute("itmList", itmList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/viewItemList.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
