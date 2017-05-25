package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.TrainerScheduleDetailsBean;
import com.designhub.fitnessplus.dao.TrainerScheduleDetailsDAO;

public class TrainerScheduleDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			
		  String trainerId = request.getParameter("trainerId");
		  
//		 / System.out.println("MSDL   MID--->"+trainerId);
		  
		  List<TrainerScheduleDetailsBean> listOfScheduleDetails = new
		  TrainerScheduleDetailsDAO() .list(trainerId);
		  
		  if (listOfScheduleDetails != null) 
		  {
			  request.setAttribute("listOfScheduleDetails", listOfScheduleDetails);
			  request.getRequestDispatcher("trainerScheduleDetailsList.jsp")
		  .forward(request, response); 
		  }else{
			  System.out.println("NULL get...");
		  }
		 
	}

}
