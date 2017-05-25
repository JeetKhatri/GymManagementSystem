package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.SecurityQuestionsBean;
import com.designhub.fitnessplus.dao.SecurityQuestionsDAO;
import com.designhub.fitnessplus.util.ValidationUtils;


public class SecurityQuestionsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int questionId=Integer.parseInt(request.getParameter("securityQuestionId"));
		String question=request.getParameter("securityQuestion");
		SecurityQuestionsBean questionsBean=new SecurityQuestionsBean();
		boolean isError=false;
		if(ValidationUtils.isEmpty(question))
		{
			isError=true;
			request.setAttribute("message","<font color=red>* Question is Required</font>");
		}
		if(isError)
		{
			questionsBean.setQuestionId(questionId);
			questionsBean.setQuestion(question);
			request.setAttribute("questionBean",questionsBean);
			request.getRequestDispatcher("securityQuestionsEdit.jsp").forward(request, response);
		}
		else
		{
			questionsBean.setQuestionId(questionId);
			questionsBean.setQuestion(question);
			
			if(new SecurityQuestionsDAO().update(questionsBean))
			{
				System.out.println("Record Updated");
			}
			else
			{
				System.out.println("Record Not Not Updated");
				
			}
			request.getRequestDispatcher("SecurityQuestionsListServlet").forward(request, response);
		}
	
	}

}
