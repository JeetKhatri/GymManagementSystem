package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.ProgressDAO;

public class ProgressDetailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = -2439073663607971768L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String progressDetailId=request.getParameter("progressDetailId");
		//System.out.println(id);
		if(new ProgressDAO().delete(progressDetailId))
		{
			PrintWriter out = response.getWriter();
			out.write("<font color=RED size=6><center>Progress Report Deleted.....</center></font>");
			request.getRequestDispatcher("progressDetailListServlet").include(request,response);
		}
		else{
			PrintWriter out = response.getWriter();
			out.write("<font color=RED size=6><center>Something Went Wrong.....</center></font>");
			request.getRequestDispatcher("progressDetailListServlet").include(request,response);
		}
	}

}
