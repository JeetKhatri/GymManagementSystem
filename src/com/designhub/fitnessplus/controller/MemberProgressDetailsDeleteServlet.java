package com.designhub.fitnessplus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.MemberProgressDetailsDAO;
import com.designhub.fitnessplus.dao.ProgressDAO;

public class MemberProgressDetailsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = -2439073663607971768L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String progressDetailId=request.getParameter("progressDetailId");

		
		int memberId=new MemberProgressDetailsDAO().getMemberId(progressDetailId);
		System.out.println("MEMBERID--->"+memberId);
		
		if(new ProgressDAO().delete(progressDetailId))
		{
			response.sendRedirect("memberProgressDetailsListServlet?memberId="+memberId);
		}
		else{
			response.sendRedirect("memberProgressDetailsListServlet?memberId="+memberId);
		}
	}

}
