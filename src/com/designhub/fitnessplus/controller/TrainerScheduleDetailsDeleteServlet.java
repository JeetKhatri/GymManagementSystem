
package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.TrainerScheduleDetailsDAO;


public class TrainerScheduleDetailsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String trainerScheduleDetailsId = request.getParameter("trainerScheduleDetailsId");
	
		System.out.println("Hello->" + trainerScheduleDetailsId);
		
		int trainerId=new TrainerScheduleDetailsDAO().getTrainerId(trainerScheduleDetailsId);
		System.out.println("MEMBERID--->"+trainerId);
		
		if (new TrainerScheduleDetailsDAO().delete(trainerScheduleDetailsId)) {
			response.sendRedirect("TrainerScheduleDetailsListServlet?trainerId="+trainerId);
		} 
		else
		{
			response.sendRedirect("TrainerScheduleDetailsListServlet?trainerId="+trainerId);
		}
	}

}
