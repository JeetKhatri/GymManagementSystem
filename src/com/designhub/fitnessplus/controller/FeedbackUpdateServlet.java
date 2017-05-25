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
public class FeedbackUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String feedbackName=request.getParameter("txtName");
		String feedbackEmail=request.getParameter("txtEmail");
		String feedbackContent=request.getParameter("txtaContent");
		String feedbackSubjectId=request.getParameter("cmbSubject");
		String feedbackId=request.getParameter("feedbackId");
		boolean isError=false;
		FeedbackBean feedbackbean=new FeedbackBean();
		if(ValidationUtils.isEmpty(feedbackName))
		{
			request.setAttribute("name", "<font color=red>* Name is Required</font>");
			isError=true;
		}
		else{
			request.setAttribute("txtName", feedbackName);
			feedbackbean.setName(feedbackName);
		}
		if(ValidationUtils.isEmpty(feedbackEmail))
		{
			request.setAttribute("email", "<font color=red>* Email is Required</font>");
			isError=true;
		}
		else{
			request.setAttribute("txtEmail", feedbackEmail);
			feedbackbean.setEmail(feedbackEmail);
		}
		if(ValidationUtils.isEmpty(feedbackContent))
		{
			request.setAttribute("content", "<font color=red>* Content is Required</font>");
			isError=true;
		}
		else{
			request.setAttribute("txtaContent", feedbackContent);
			feedbackbean.setContent(feedbackContent);
		}
		if(feedbackSubjectId.equals("0"))
		{
			request.setAttribute("feedbackSubject", "*");
			isError=true;
		}
		else{
			request.setAttribute("cmbSubject", feedbackSubjectId);
			feedbackbean.setFeedbackSubjectId(feedbackSubjectId);
		}
		if(isError){
			feedbackbean.setFeedbackId(feedbackId);
			feedbackbean.setFeedbackSubjectId(feedbackSubjectId);
			request.setAttribute("feedbackbean", feedbackbean);
			request.getRequestDispatcher("feedbackEdit.jsp").forward(request, response);
		}
		else
		{
			DateFormat df=new SimpleDateFormat("yyyy/mmm/dd hh:mm:ss");
			Date da=new Date();
			String date=df.format(da);
			feedbackbean.setDate(date);
			feedbackbean.setFeedbackSubjectId(feedbackSubjectId);
			feedbackbean.setFeedbackId(feedbackId);
			if(new FeedbackDAO().update(feedbackbean))
			{
				PrintWriter out = response.getWriter();
				request.getRequestDispatcher("feedbackListServlet").include(request, response);
			}
		}
	}

}
