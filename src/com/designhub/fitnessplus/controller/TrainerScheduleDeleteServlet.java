
package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.TrainerScheduleDAO;
import com.designhub.fitnessplus.dao.TrainerScheduleDetailsDAO;

public class TrainerScheduleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String trainerScheduleId = request.getParameter("trainerScheduleId");
		System.out.println("id delete :- "+trainerScheduleId);
		if (new TrainerScheduleDetailsDAO().deleteByTrainerScheduleId(trainerScheduleId)) {
			
		} 
		else
		{
		}
		if( new TrainerScheduleDAO().delete(trainerScheduleId))
		{
			response.sendRedirect("TrainerScheduleListServlet");
		}
		else
		{
			response.sendRedirect("TrainerScheduleDetailsListServlet");
		}

	}

}
