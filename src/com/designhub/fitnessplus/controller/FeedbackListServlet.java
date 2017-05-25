package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.FeedbackBean;
import com.designhub.fitnessplus.dao.FeedbackDAO;

public class FeedbackListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<FeedbackBean> feedbacklist =new FeedbackDAO().list();
		if (feedbacklist != null) {

			request.setAttribute("feedbacklist", feedbacklist);
			request.getRequestDispatcher("feedbackList.jsp").include(request,
					response);

		}

	}
}
