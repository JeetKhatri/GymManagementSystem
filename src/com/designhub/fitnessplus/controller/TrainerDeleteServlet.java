package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.TrainerDAO;



public class TrainerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String trainerId = request.getParameter("trainerId");

		if (new TrainerDAO().delete(trainerId)) {
			PrintWriter out=response.getWriter();
			//response.setContentType("html/text");
			out.print("<center><font size=4 color=red>Trainer Deleted</font></center>");
			request.getRequestDispatcher("trainerListServlet").include(request, response);

		} else {
			request.getRequestDispatcher("trainerListServlet").include(request, response);
		}
	}

}
