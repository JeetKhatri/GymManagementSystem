package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberScheduleDetailsBean;
import com.designhub.fitnessplus.dao.MemberScheduleDetailsDAO;

public class MemberScheduleDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			
		  String memberId = request.getParameter("memberId");
		  
//		 / System.out.println("MSDL   MID--->"+memberId);
		  
		  List<MemberScheduleDetailsBean> listOfScheduleDetails = new
		  MemberScheduleDetailsDAO() .list(memberId);
		  
		  if (listOfScheduleDetails != null) 
		  {
			  request.setAttribute("listOfScheduleDetails", listOfScheduleDetails);
			  request.getRequestDispatcher("memberScheduleDetailsList.jsp")
		  .forward(request, response); 
		  }else{
			  System.out.println("NULL get...");
		  }
		 
	}

}
