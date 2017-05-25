package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberProgressDetailsBean;
import com.designhub.fitnessplus.dao.MemberProgressDetailsDAO;


public class MemberProgressDetailsListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId=request.getParameter("memberId");
		System.out.println("MemberID------->"+memberId);
		List<MemberProgressDetailsBean> memberProgressDetailslist =new MemberProgressDetailsDAO().list(memberId);
		if (memberProgressDetailslist!= null) {
			System.out.println("IF");
			request.setAttribute("memberProgressDetailslist", memberProgressDetailslist);
			request.getRequestDispatcher("memberProgressDetailsList.jsp").include(request,
					response);
	}
	}
	

}
