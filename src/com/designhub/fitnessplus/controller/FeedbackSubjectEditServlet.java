package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.FeedbackSubjectBean;
import com.designhub.fitnessplus.dao.FeedbackSubjectDAO;



@SuppressWarnings("serial")
public class FeedbackSubjectEditServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String
		feedbackSubjectId=(request.getParameter("feedbackSubjectId"));
		FeedbackSubjectBean feedbackSubjectBean=new FeedbackSubjectDAO().getByPK(feedbackSubjectId);
		
		if(feedbackSubjectBean!=null)
		{
			request.setAttribute("feedbackSubjectBean", feedbackSubjectBean);
			request.getRequestDispatcher("feedbackSubjectEdit.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("feedbackSubjectListServlet").forward(request, response);
		}
	}

}
