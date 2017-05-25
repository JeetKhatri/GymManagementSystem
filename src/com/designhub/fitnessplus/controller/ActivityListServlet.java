package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.ActivityBean;
import com.designhub.fitnessplus.dao.ActivityDAO;

public class ActivityListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ActivityBean> listofActivity = new ActivityDAO().list();
		if(listofActivity != null)
		{
			request.setAttribute("listofActivity",listofActivity);
			request.getRequestDispatcher("activityList.jsp").forward
			(request, response);
		}else{
			System.out.println("No Record Found....");
		}
	}

}
