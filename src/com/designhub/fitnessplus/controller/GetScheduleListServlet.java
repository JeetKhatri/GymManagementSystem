package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.designhub.fitnessplus.bean.MemberBean;
import com.designhub.fitnessplus.bean.MemberScheduleDetailsBean;
import com.designhub.fitnessplus.dao.GetScheduleDAO;
import com.designhub.fitnessplus.dao.MemberScheduleDetailsDAO;

public class GetScheduleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		MemberBean memberBean = (MemberBean) session.getAttribute("memberBean");	
		
		
		  String memberId = memberBean.getMemberId();
		  
		  
		  List<MemberScheduleDetailsBean> listOfScheduleDetails = new
				  GetScheduleDAO() .memberList(memberId);
		  
		  if (listOfScheduleDetails != null) 
		  {
			  request.setAttribute("listOfScheduleDetails", listOfScheduleDetails);
			  request.getRequestDispatcher("member/memberSchedule.jsp")
		  .forward(request, response); 
		  }else{
			  System.out.println("NULL get...");
		  }
		 
	}

}
