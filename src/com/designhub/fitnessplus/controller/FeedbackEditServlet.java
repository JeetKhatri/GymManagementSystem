package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.FeedbackBean;
import com.designhub.fitnessplus.dao.FeedbackDAO;


@SuppressWarnings("serial")
public class FeedbackEditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String feedbackId=(request.getParameter("feedbackId"));
		FeedbackBean feedbackBean=new FeedbackDAO().getByPK(feedbackId);
		
		if(feedbackBean!=null)
		{
			request.setAttribute("feedbackbean", feedbackBean);
			request.getRequestDispatcher("feedbackEdit.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("feedbackListServlet").forward(request, response);
		}
	}

}
