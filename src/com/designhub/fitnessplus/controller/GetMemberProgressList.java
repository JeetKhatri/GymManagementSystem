package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberProgressBean;
import com.designhub.fitnessplus.bean.MemberProgressDetailsBean;
import com.designhub.fitnessplus.dao.MemberProgressDAO;
import com.designhub.fitnessplus.dao.PersonalMemberDetailsDAO;


public class GetMemberProgressList extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId=request.getParameter("memberId");
		System.out.println("hhhhhhhhhhhhhhh" + memberId);
		
		List<MemberProgressDetailsBean> memberProgressDetailslist =new PersonalMemberDetailsDAO().progressList(memberId);
		if (memberProgressDetailslist!= null) {
			
			request.setAttribute("memberProgresslist", memberProgressDetailslist);
			request.getRequestDispatcher("member/memberProgressList.jsp").include(request,
					response);
	}
	}
	

}
