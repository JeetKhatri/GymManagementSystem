package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.designhub.fitnessplus.bean.TrainerBean;
import com.designhub.fitnessplus.bean.TrainerScheduleDetailsBean;
import com.designhub.fitnessplus.dao.GetScheduleDAO;
import com.designhub.fitnessplus.dao.TrainerScheduleDetailsDAO;

public class GetScheduleTrainerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		TrainerBean trainerBean = (TrainerBean) session.getAttribute("trainerBean");	
		
		
		  String trainerId = trainerBean.getTrainerId();
		  
		  
		  List<TrainerScheduleDetailsBean> listOfScheduleDetails = new
				  GetScheduleDAO() .trainerList(trainerId);
		  
		  if (listOfScheduleDetails != null) 
		  {
			  System.out.println("Hllllllllllll");
			  request.setAttribute("listOfScheduleDetails", listOfScheduleDetails);
			  request.getRequestDispatcher("trainer/trainerSchedule.jsp")
		  .forward(request, response); 
		  }else{
			  System.out.println("NULL get...");
		  }
		 
	}

}
