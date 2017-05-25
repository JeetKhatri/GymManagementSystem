package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.SecurityQuestionsBean;
import com.designhub.fitnessplus.dao.SecurityQuestionsDAO;



public class SecurityQuestionsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			List<SecurityQuestionsBean> questionList=new ArrayList<SecurityQuestionsBean>();
			questionList=new SecurityQuestionsDAO().getSecurityQuestionsList();
			if(questionList!=null)
			{
				request.setAttribute("questionList",questionList);
			}
			request.getRequestDispatcher("securityQuestionsList.jsp").forward(request, response);
	}

}
