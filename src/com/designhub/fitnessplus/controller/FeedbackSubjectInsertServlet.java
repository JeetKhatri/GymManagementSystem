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
public class FeedbackSubjectInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String feedbackSubject=request.getParameter("txtFeedbackSubject");
		if(ValidationUtils.isEmpty(feedbackSubject))
		{
			request.setAttribute("feedbacksubject","<font color=red>* Subject is Required</font>");
			request.getRequestDispatcher("feedbackSubjectInsert.jsp").forward(request, response);
		}
		else {
			FeedbackSubjectBean feedbackSubjectBean=new FeedbackSubjectBean();
			feedbackSubjectBean.setFeedbackSubjectName(feedbackSubject);
			if(new FeedbackSubjectDAO().insert(feedbackSubjectBean))
			{
				PrintWriter out = response.getWriter();
				out.write("<font color=RED size=6><center>FeedbackSubject is Added.....</center></font>");
				request.getRequestDispatcher("feedbackSubjectListServlet").include(request, response);
			}
		}
		
	}

}
