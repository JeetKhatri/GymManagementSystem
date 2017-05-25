package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.GymDetailsBean;
import com.designhub.fitnessplus.dao.GymDetailsDAO;

public class GymDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GymDetailsBean> listofGymDetails = new GymDetailsDAO().list();
		if(listofGymDetails != null)
		{
			request.setAttribute("listofGymDetails",listofGymDetails);
			request.getRequestDispatcher("gymDetailsList.jsp").include(request, response);
		}else{
			System.out.println("No Record Found....");
		}
	}

}
