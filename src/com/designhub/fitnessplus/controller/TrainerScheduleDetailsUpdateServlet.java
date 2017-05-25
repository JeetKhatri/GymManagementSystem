package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.TrainerScheduleDetailsBean;
import com.designhub.fitnessplus.dao.TrainerScheduleDetailsDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class TrainerScheduleDetailsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String activityId = request.getParameter("selActivityName");
		String trainerStartTime = request.getParameter("txtTrainerStartTime");
		String trainerEndTime = request.getParameter("txtTrainerEndTime");
		String trainerDay = request.getParameter("txtTrainerDay");
		String trainerId = request.getParameter("trainerId");
		String trainerScheduleDetailsId = request.getParameter("id");
		TrainerScheduleDetailsBean trainerScheduleDetailsBean = new TrainerScheduleDetailsBean();

		
		
		boolean isError = false;

		System.out.println("ID-----------" + trainerScheduleDetailsId);
		
		if (ValidationUtils.isEmpty(trainerStartTime)) {
			isError = true;
			request.setAttribute("trainerStartTime",
					"<font color=red>* start time is Required</font>");
		} 
		
		else {
			request.setAttribute("txtTrainerStartTime", trainerStartTime);
			trainerScheduleDetailsBean.setTrainerStartTime(trainerStartTime);
		}
		
		if (ValidationUtils.isEmpty(trainerEndTime)) {
			isError = true;
			request.setAttribute("trainerEndTime",
					"<font color=red>* End time is Required</font>");
		} 
		
		else {
			request.setAttribute("txtTrainerEndTime", trainerEndTime);
			trainerScheduleDetailsBean.setTrainerEndTime(trainerEndTime);
		}
		
		if (ValidationUtils.isEmpty(trainerDay)) {
			isError = true;
			request.setAttribute("trainerDay",
					"<font color=red>* Day is Required</font>");
		} 
		
		else {
			request.setAttribute("txtTrainerDay", trainerDay);
			trainerScheduleDetailsBean.setTrainerDay(trainerDay);
		}


		if (activityId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgActivityName",
					"<font color=red>* Activity is Required</font>");
		}else{
			trainerScheduleDetailsBean.setActivityId(activityId);
		}

		if (trainerId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgTrainerName",
					"<font color=red>* Activity is Required</font>");
		}else{
			trainerScheduleDetailsBean.setActivityId(activityId);
		}
		trainerScheduleDetailsBean.setTrainerScheduleId(trainerScheduleDetailsId);
		trainerScheduleDetailsBean.setTrainerId(trainerId);
		System.out.println("ID DETALS" + trainerScheduleDetailsId);
		if (isError) 
		{
			trainerScheduleDetailsBean.setTrainerEndTime(trainerEndTime);
			trainerScheduleDetailsBean.setTrainerDay(trainerDay);
			trainerScheduleDetailsBean.setTrainerStartTime(trainerStartTime);
			trainerScheduleDetailsBean.setTrainerScheduledetailsId(trainerScheduleDetailsId);

			request.setAttribute("trainerScheduleDetailsId", trainerScheduleDetailsId);
			request.setAttribute("trainerScheduleDetailsBean",trainerScheduleDetailsBean);
			request.getRequestDispatcher("trainerScheduleDetailsEdit.jsp").forward(request, response);
			
			System.out.println("error");
		} 
		else 
		{
				System.out.println("success");
				
				trainerScheduleDetailsBean.setTrainerScheduledetailsId(trainerScheduleDetailsId);
				
				if(new TrainerScheduleDetailsDAO().update(trainerScheduleDetailsBean))
				{
					System.out.println("Inside");
					
				/*	if(new TrainerScheduleDAO().update(trainerScheduleDetailsBean))
					{*/
						System.out.println("Hello with mid " + trainerId);
						request.setAttribute("id", trainerId);
						request.getRequestDispatcher("TrainerScheduleDetailsListServlet").forward(request, response);
					
					
				}else
					{
						response.sendRedirect("trainerScheduleDetailsEdit.jsp");
					}	
				}
				
			
		}
		
	}
