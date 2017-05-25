package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.ProgressDAO;

@SuppressWarnings("serial")
public class ProgressDeleteServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("aid");
		//System.out.println(id);
		if(new ProgressDAO().delete(id))
		{
			PrintWriter out = response.getWriter();
			out.write("<font color=RED size=6><center>Feedback Deleted.....</center></font>");
			request.getRequestDispatcher("FeedbackList.jsp").include(request,response);
		}
		else{
			PrintWriter out = response.getWriter();
			out.write("<font color=RED size=6><center>Something Went Wrong.....</center></font>");
			request.getRequestDispatcher("feedbackSubjectListServlet").include(request,response);
		}
	}

}
