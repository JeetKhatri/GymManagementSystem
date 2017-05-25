package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.ActivityBean;
import com.designhub.fitnessplus.dao.ActivityDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class ActivityUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String activityName = request.getParameter("txtActivityName");
		String activityId = request.getParameter("id");
	//	System.out.println("id  ================"+activityId+" "+activityName);
		boolean isError=false;
		ActivityBean activitybean = new ActivityBean();
		
		if(ValidationUtils.isEmpty(activityName))
		{
			request.setAttribute("activityName", "<font color=red>* Name is Required</font>");
			isError=true;
		}else{
			request.setAttribute("txtActivityName", activityName);
			if(activityName == null)
				activityName="";
			activitybean.setActivityName(activityName);
		}
		
		if(isError)
		{
	//		System.out.println("error");
			request.setAttribute("activityId",activityId);
			request.getRequestDispatcher("activityEdit.jsp").forward(request, response);
		}else{
	//		System.out.println("success");			
			activitybean.setActivityId(activityId);
			
			if(new ActivityDAO().update(activitybean))
			{
				response.sendRedirect("ActivityListServlet");
			}
			else
			{
				response.sendRedirect("activityEdit.jsp");
			}
		}
	}

}
