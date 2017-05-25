package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.TrainerScheduleBean;
import com.designhub.fitnessplus.dao.TrainerScheduleDAO;

public class TrainerScheduleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/*
		 * String trainerScheduleId = request.getParameter("id");
		 * 
		 * System.out.println(trainerScheduleId);
		 * 
		 * List<TrainerScheduleDetailsBean> listOfScheduleDetails = new
		 * TrainerScheduleDetailsDAO() .list(trainerScheduleId);
		 * 
		 * if (listOfScheduleDetails != null) {
		 * request.setAttribute("listOfScheduleDetails", listOfScheduleDetails);
		 * request.getRequestDispatcher("trainerScheduleDetailsList.jsp")
		 * .forward(request, response); }
		 */

		List<TrainerScheduleBean> listOfScheduleDetails = new TrainerScheduleDAO()
				.list();

		if (listOfScheduleDetails != null) {
			request.setAttribute("listOfScheduleDetails", listOfScheduleDetails);
			request.getRequestDispatcher("trainerScheduleList.jsp").forward(
					request, response);
		}

	}

}
