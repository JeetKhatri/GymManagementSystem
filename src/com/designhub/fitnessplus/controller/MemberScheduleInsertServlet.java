package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberScheduleDetailsBean;
import com.designhub.fitnessplus.dao.MemberScheduleDetailsDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class MemberScheduleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String activityId = request.getParameter("selActivityName");
		String memberStartTime = request.getParameter("txtMemberStartTime");
		String memberEndTime = request.getParameter("txtMemberEndTime");
		String memberDay = request.getParameter("txtMemberDay");
		String memberId = request.getParameter("selMemberName");
		
		
		MemberScheduleDetailsBean memberScheduleDetailsBean = new MemberScheduleDetailsBean();
		
		boolean isError = false;

	
		memberScheduleDetailsBean.setMemberId(memberId);
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
		
		if (isError) 
		{
			System.out.println("error");
			request.setAttribute("memberScheduleDetailsBean",memberScheduleDetailsBean);
			request.getRequestDispatcher("memberScheduleInsert.jsp").forward(request, response);
		} 
		else 
		{
			memberScheduleDetailsBean.setMemberId(memberId);
			if(new MemberScheduleDetailsDAO().insert(memberScheduleDetailsBean)) {
				  
				  System.out.println("Record Inserted");
				  response.sendRedirect("MemberScheduleListServlet");
				  
			  } 
			  else {
				  System.out.println("Record Not inserted");
			   
			  }
			
			
			
				/*System.out.println("success");
				MemberScheduleBean memberScheduleBean = new MemberScheduleBean();
				memberScheduleBean.setMemberId(memberId);
				String memberScheduleDetailsId="";
				if(new MemberScheduleDAO().insert(memberScheduleBean))
				{
					memberScheduleDetailsId = new MemberScheduleDAO().getByPK(memberId);
					System.out.println(memberScheduleDetailsId);
				}
				
				memberScheduleDetailsBean.setMemberScheduledetailsId(memberScheduleDetailsId);
				
				request.setAttribute("memberScheduleDetailsId", memberScheduleDetailsId);
				memberScheduleDetailsBean.setMemberScheduleId(memberScheduleDetailsId);
				
				if(new MemberScheduleDetailsDAO().insert(memberScheduleDetailsBean)) {
				  
				  System.out.println("Record Inserted");
				  response.sendRedirect("MemberScheduleDetailsListServlet");
				  
			  } 
			  else {
				  System.out.println("Record Not inserted");
			   
			  }*/

		}
		
	}

}
 