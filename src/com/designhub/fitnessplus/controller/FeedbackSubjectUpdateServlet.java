package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.FeedbackSubjectBean;
import com.designhub.fitnessplus.dao.FeedbackSubjectDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

@SuppressWarnings("serial")
public class FeedbackSubjectUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String feedbackSubject=request.getParameter("feedbackSubject");
		System.out.println(feedbackSubject);
		FeedbackSubjectBean feedbackSubjectBean=new FeedbackSubjectBean();
		String feedbackSubjectId=request.getParameter("feedbackSubjectId");
		if(ValidationUtils.isEmpty(feedbackSubject))
		{
			feedbackSubjectBean.setFeedbackSubjectId(feedbackSubjectId);
			request.setAttribute("feedbackSubjectBean",feedbackSubjectBean );
			request.setAttribute("feedbacksubject","<font color=red>* Subject is Required</font>");
			request.getRequestDispatcher("feedbackSubjectEdit.jsp").forward(request, response);
		}
		else {
			feedbackSubjectBean.setFeedbackSubjectName(feedbackSubject);
			feedbackSubjectBean.setFeedbackSubjectId(feedbackSubjectId);
			if(new FeedbackSubjectDAO().update(feedbackSubjectBean))
			{
				PrintWriter out = response.getWriter();
				response.sendRedirect("feedbackSubjectListServlet");
			}
		}
		
	}

}
