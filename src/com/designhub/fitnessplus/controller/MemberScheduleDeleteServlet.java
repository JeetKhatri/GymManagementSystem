
package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.MemberScheduleDAO;
import com.designhub.fitnessplus.dao.MemberScheduleDetailsDAO;

public class MemberScheduleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberScheduleDetailsId = request.getParameter("memberScheduleId");
		System.out.println("id delete :- "+memberScheduleDetailsId);
		if (new MemberScheduleDetailsDAO().deleteByMemberScheduleId(memberScheduleDetailsId)) {
			System.out.println("memberScheduleDELETED/////////////////////");
		} 
		else
		{
			System.out.println("memberSchedule          NOT         DELETED/////////////////////");
		}
		if( new MemberScheduleDAO().delete(memberScheduleDetailsId))
		{
			response.sendRedirect("MemberScheduleListServlet");
		}
		else
		{
			response.sendRedirect("MemberScheduleDetailsListServlet");
		}

	}

}
