package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberScheduleDetailsBean;
import com.designhub.fitnessplus.dao.MemberScheduleDetailsDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class MemberScheduleDetailsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String activityId = request.getParameter("selActivityName");
		String memberStartTime = request.getParameter("txtMemberStartTime");
		String memberEndTime = request.getParameter("txtMemberEndTime");
		String memberDay = request.getParameter("txtMemberDay");
		String memberId = request.getParameter("memberId");
		String memberScheduleDetailsId = request.getParameter("id");
		MemberScheduleDetailsBean memberScheduleDetailsBean = new MemberScheduleDetailsBean();

		
		
		boolean isError = false;

		System.out.println("ID-----------" + memberScheduleDetailsId);
		
		if (ValidationUtils.isEmpty(memberStartTime)) {
			isError = true;
			request.setAttribute("memberStartTime",
					"<font color=red>* start time is Required</font>");
		} 
		
		else {
			request.setAttribute("txtMemberStartTime", memberStartTime);
			memberScheduleDetailsBean.setMemberStartTime(memberStartTime);
		}
		
		if (ValidationUtils.isEmpty(memberEndTime)) {
			isError = true;
			request.setAttribute("memberEndTime",
					"<font color=red>* End time is Required</font>");
		} 
		
		else {
			request.setAttribute("txtMemberEndTime", memberEndTime);
			memberScheduleDetailsBean.setMemberEndTime(memberEndTime);
		}
		
		if (ValidationUtils.isEmpty(memberDay)) {
			isError = true;
			request.setAttribute("memberDay",
					"<font color=red>* Day is Required</font>");
		} 
		
		else {
			request.setAttribute("txtMemberDay", memberDay);
			memberScheduleDetailsBean.setMemberDay(memberDay);
		}


		if (activityId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgActivityName",
					"<font color=red>* Activity is Required</font>");
		}else{
			memberScheduleDetailsBean.setActivityId(activityId);
		}

		if (memberId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgMemberName",
					"<font color=red>* Activity is Required</font>");
		}else{
			memberScheduleDetailsBean.setActivityId(activityId);
		}
		memberScheduleDetailsBean.setMemberScheduleId(memberScheduleDetailsId);
		memberScheduleDetailsBean.setMemberId(memberId);
		System.out.println("ID DETALS" + memberScheduleDetailsId);
		if (isError) 
		{
			memberScheduleDetailsBean.setMemberEndTime(memberEndTime);
			memberScheduleDetailsBean.setMemberDay(memberDay);
			memberScheduleDetailsBean.setMemberStartTime(memberStartTime);
			memberScheduleDetailsBean.setMemberScheduledetailsId(memberScheduleDetailsId);

			request.setAttribute("memberScheduleDetailsId", memberScheduleDetailsId);
			request.setAttribute("memberScheduleDetailsBean",memberScheduleDetailsBean);
			request.getRequestDispatcher("memberScheduleDetailsEdit.jsp").forward(request, response);
			
			System.out.println("error");
		} 
		else 
		{
				System.out.println("success");
				
				memberScheduleDetailsBean.setMemberScheduledetailsId(memberScheduleDetailsId);
				
				if(new MemberScheduleDetailsDAO().update(memberScheduleDetailsBean))
				{
					System.out.println("Inside");
					
				/*	if(new MemberScheduleDAO().update(memberScheduleDetailsBean))
					{*/
						System.out.println("Hello with mid " + memberId);
						request.setAttribute("id", memberId);
						request.getRequestDispatcher("MemberScheduleDetailsListServlet").forward(request, response);
					
					
				}else
					{
						response.sendRedirect("memberScheduleDetailsEdit.jsp");
					}	
				}
				
			
		}
		
	}
