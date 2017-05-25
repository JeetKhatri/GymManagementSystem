package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.SecurityQuestionsBean;
import com.designhub.fitnessplus.dao.SecurityQuestionsDAO;
import com.designhub.fitnessplus.util.ValidationUtils;


public class SecurityQuestionsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String question=request.getParameter("question");
		boolean isError=false;
		if(ValidationUtils.isEmpty(question))
		{
			isError=true;
			request.setAttribute("message","<font color=red>* Question is Required</font>");
		}
		if(isError)
		{
			request.setAttribute("question",question);
			request.getRequestDispatcher("securityQuestionsAdd.jsp").forward(request, response);
		}
		else
		{
			SecurityQuestionsBean questionsBean=new SecurityQuestionsBean();
			questionsBean.setQuestion(question);
			if(new SecurityQuestionsDAO().add(questionsBean))
			{
				System.out.println("Record inserted");
			}
			else
			{
				System.out.println("Record Not inserted");
				
			}
			request.getRequestDispatcher("SecurityQuestionsListServlet").forward(request, response);
		}
		
		
		
		
	}

}
