
package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.MemberScheduleDetailsDAO;


public class MemberScheduleDetailsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberScheduleDetailsId = request.getParameter("memberScheduleDetailsId");
	
		System.out.println("Hello->" + memberScheduleDetailsId);
		
		int memberId=new MemberScheduleDetailsDAO().getMemberId(memberScheduleDetailsId);
		System.out.println("MEMBERID--->"+memberId);
		
		if (new MemberScheduleDetailsDAO().delete(memberScheduleDetailsId)) {
			response.sendRedirect("MemberScheduleDetailsListServlet?memberId="+memberId);
		} 
		else
		{
			response.sendRedirect("MemberScheduleDetailsListServlet?memberId="+memberId);
		}
	}

}
