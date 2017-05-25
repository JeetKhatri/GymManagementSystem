package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.TrainerBean;
import com.designhub.fitnessplus.dao.TrainerDAO;

public class TrainerEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String trainerId = request.getParameter("trainerId");

		TrainerBean trainerBean = new TrainerDAO().getByPK(trainerId);
		if (trainerBean != null) {
			request.setAttribute("trainerBean", trainerBean);
			request.getRequestDispatcher("trainerEdit.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("TrainerListServlet");
		}

	}

}
