package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.FeedbackSubjectBean;
import com.designhub.fitnessplus.dao.FeedbackSubjectDAO;

@SuppressWarnings("serial")
public class FeedbackSubjectListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.util.List<FeedbackSubjectBean> feedbackSubjectList=new FeedbackSubjectDAO().list();
		if(feedbackSubjectList!=null)
		{
			request.setAttribute("feedbackSubjectList", feedbackSubjectList);
			request.getRequestDispatcher("feedbackSubjectList.jsp").forward(request, response);
		}
	}

}
