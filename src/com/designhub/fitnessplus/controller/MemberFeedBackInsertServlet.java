package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.FeedbackBean;
import com.designhub.fitnessplus.dao.FeedbackDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

@SuppressWarnings("serial")
public class MemberFeedBackInsertServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String feedbackDate=dateformat.format(date);
		
		System.out.println(feedbackDate);
		
		String feedbackName = request.getParameter("txtName");
		String feedbackEmail = request.getParameter("txtEmail");
		String feedbackContent = request.getParameter("txtAreaContent");
		String feedbackSubjectId = request
				.getParameter("selFeedbackSubjectName");
		
		System.out.println(feedbackSubjectId);
		boolean isError = false;
		FeedbackBean feedbackbean = new FeedbackBean();
		if (ValidationUtils.isEmpty(feedbackName)) {
			request.setAttribute("name", "<font color=red>* Name is Required</font>");
			isError = true;
		} else {
			request.setAttribute("txtName", feedbackName);
			feedbackbean.setName(feedbackName);
		}
		if (ValidationUtils.isEmpty(feedbackEmail)) {
			request.setAttribute("email", "<font color=red>* Email is Required</font>");
			isError = true;
		} else {
			request.setAttribute("txtEmail", feedbackEmail);
			feedbackbean.setEmail(feedbackEmail);
		}
		if (ValidationUtils.isEmpty(feedbackContent)) {
			request.setAttribute("content", "<font color=red>* content is Required</font>");
			isError = true;
		} else {
			request.setAttribute("txtaContent", feedbackContent);
			feedbackbean.setContent(feedbackContent);
		}
		if (feedbackSubjectId.equals("0")) {
			request.setAttribute("msgFeedbackSubjectName", "<font color=red>* Subject is Required</font>");
			isError = true;
		} else {
			request.setAttribute("cmbSubject", feedbackSubjectId);
			feedbackbean.setFeedbackSubjectId(feedbackSubjectId);
		}
		if (isError) {
			request.setAttribute("feedbackbean", feedbackbean);
			request.getRequestDispatcher("member/feedbackInsert.jsp").forward(request,
					response);
		} else {
			
			feedbackbean.setDate(feedbackDate);
			feedbackbean.setFeedbackSubjectId(feedbackSubjectId);

			if (new FeedbackDAO().insert(feedbackbean)) {
				PrintWriter out = response.getWriter();
				request.getRequestDispatcher("member/memberHomePage.jsp").include(
						request, response);
			}
		}

	}

}
