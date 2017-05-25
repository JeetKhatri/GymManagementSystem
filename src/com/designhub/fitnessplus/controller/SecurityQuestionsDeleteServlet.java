package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.SecurityQuestionsDAO;


public class SecurityQuestionsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int securityQuestionId=Integer.parseInt(request.getParameter("securityQuestionId"));
		if(new SecurityQuestionsDAO().delete(securityQuestionId))
		{
			response.sendRedirect("SecurityQuestionsListServlet");
		}
	}

}
