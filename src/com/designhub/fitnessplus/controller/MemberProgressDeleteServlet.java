
package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.MemberProgressDAO;
import com.designhub.fitnessplus.dao.MemberProgressDetailsDAO;

public class MemberProgressDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberProgressId = request.getParameter("progressId");
		System.out.println("In Delete ProgressId:- "+memberProgressId);
		if (new MemberProgressDetailsDAO().deleteByProgressId(memberProgressId)) {
		
			if( new MemberProgressDAO().delete(memberProgressId))
			{
				response.sendRedirect("memberProgressListServlet");
			}
			else
			{
				response.sendRedirect("memberProgressListServlet");
			}

		}
	}

}
