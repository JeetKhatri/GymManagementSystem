package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.FeedbackDAO;

@SuppressWarnings("serial")
public class FeedbackDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String feedbackId = request.getParameter("feedbackId");

		if (new FeedbackDAO().delete(feedbackId)) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("feedbackList.jsp").include(request,
					response);
		} else {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("feedbackList.jsp").include(request,
					response);
		}
	}

}
