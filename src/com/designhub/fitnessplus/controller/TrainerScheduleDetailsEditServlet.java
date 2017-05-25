package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.TrainerScheduleDetailsBean;
import com.designhub.fitnessplus.dao.TrainerScheduleDetailsDAO;

public class TrainerScheduleDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String trainerScheduleDetailsId = request.getParameter("tid");

		TrainerScheduleDetailsBean trainerScheduleDetailsBean = new TrainerScheduleDetailsDAO()
				.getByPK(trainerScheduleDetailsId);

		if (trainerScheduleDetailsBean != null) {

			request.setAttribute("trainerScheduleDetailsBean",
					trainerScheduleDetailsBean);
			request.getRequestDispatcher("trainerScheduleDetailsEdit.jsp")
					.forward(request, response);
		}

	}

}
