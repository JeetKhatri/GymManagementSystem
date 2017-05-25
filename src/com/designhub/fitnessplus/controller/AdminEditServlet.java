package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.AdminBean;
import com.designhub.fitnessplus.dao.AdminDAO;

public class AdminEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String adminId = request.getParameter("id");
		
		AdminBean adminBean = new AdminDAO().getByPK(adminId);
		
		
		if(adminBean!=null)
		{
			request.setAttribute("adminBean",adminBean);
			request.getRequestDispatcher("adminEdit.jsp").forward(request, response);
		}
	
	
	}

}
