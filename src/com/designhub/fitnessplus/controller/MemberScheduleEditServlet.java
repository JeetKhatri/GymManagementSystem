package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberScheduleDetailsBean;
import com.designhub.fitnessplus.dao.MemberScheduleDetailsDAO;

public class MemberScheduleEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String memberScheduleDetailsId = request.getParameter("tid");
		
		MemberScheduleDetailsBean memberScheduleDetailsBean = new MemberScheduleDetailsDAO().getByPK(memberScheduleDetailsId);
		
		if(memberScheduleDetailsBean!=null)
		{
		
			request.setAttribute("memberScheduleDetailsBean", memberScheduleDetailsBean);
			request.getRequestDispatcher("memberScheduleEdit.jsp").forward(request, response);
		}
		
		
	}
		
		
}

