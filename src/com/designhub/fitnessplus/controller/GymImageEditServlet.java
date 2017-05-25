package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.GymImageBean;
import com.designhub.fitnessplus.dao.GymImageDAO;

public class GymImageEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String gymImageId = request.getParameter("id");

		GymImageBean gymImageBean = new GymImageDAO().getByPK(gymImageId);

		if (gymImageBean != null) {
			request.setAttribute("gymImageBean", gymImageBean);
			request.getRequestDispatcher("gymImageEdit.jsp").forward(request,
					response);
		}

	}

}
