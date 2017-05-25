package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.GymDetailsBean;
import com.designhub.fitnessplus.dao.GymDetailsDAO;

public class GymDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gymId = request.getParameter("gymId");
		System.out.println("GYM ID" + gymId);
		GymDetailsBean gymDetails = new GymDetailsDAO().getByPK(gymId);
		if(gymDetails!=null)
		{
			request.setAttribute("gymDetails",gymDetails);
			request.getRequestDispatcher("gymDetailsEdit.jsp").forward(request, response);
		}	
	else{
		response.sendRedirect("GymDetailsListServlet");
	}
		
	}

}
