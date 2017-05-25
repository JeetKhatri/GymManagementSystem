package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.TrainerScheduleDetailsBean;
import com.designhub.fitnessplus.dao.TrainerScheduleDetailsDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class TrainerScheduleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String activityId = request.getParameter("selActivityName");
		String trainerStartTime = request.getParameter("txtTrainerStartTime");
		String trainerEndTime = request.getParameter("txtTrainerEndTime");
		String trainerDay = request.getParameter("txtTrainerDay");
		String trainerId = request.getParameter("selTrainerName");
		
		
		TrainerScheduleDetailsBean trainerScheduleDetailsBean = new TrainerScheduleDetailsBean();
		
		boolean isError = false;

	
		trainerScheduleDetailsBean.setTrainerId(trainerId);
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
		
		if (isError) 
		{
			System.out.println("error");
			request.setAttribute("trainerScheduleDetailsBean",trainerScheduleDetailsBean);
			request.getRequestDispatcher("trainerScheduleInsert.jsp").forward(request, response);
		} 
		else 
		{
			trainerScheduleDetailsBean.setTrainerId(trainerId);
			if(new TrainerScheduleDetailsDAO().insert(trainerScheduleDetailsBean)) {
				  
				  System.out.println("Record Inserted");
				  response.sendRedirect("TrainerScheduleListServlet");
				  
			  } 
			  else {
				  System.out.println("Record Not inserted");
			   
			  }
			
			
			
				/*System.out.println("success");
				TrainerScheduleBean trainerScheduleBean = new TrainerScheduleBean();
				trainerScheduleBean.setTrainerId(trainerId);
				String trainerScheduleDetailsId="";
				if(new TrainerScheduleDAO().insert(trainerScheduleBean))
				{
					trainerScheduleDetailsId = new TrainerScheduleDAO().getByPK(trainerId);
					System.out.println(trainerScheduleDetailsId);
				}
				
				trainerScheduleDetailsBean.setTrainerScheduledetailsId(trainerScheduleDetailsId);
				
				request.setAttribute("trainerScheduleDetailsId", trainerScheduleDetailsId);
				trainerScheduleDetailsBean.setTrainerScheduleId(trainerScheduleDetailsId);
				
				if(new TrainerScheduleDetailsDAO().insert(trainerScheduleDetailsBean)) {
				  
				  System.out.println("Record Inserted");
				  response.sendRedirect("TrainerScheduleDetailsListServlet");
				  
			  } 
			  else {
				  System.out.println("Record Not inserted");
			   
			  }*/

		}
		
	}

}
 