package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberProgressBean;
import com.designhub.fitnessplus.dao.MemberProgressDAO;


public class TrainerMemberProgressListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberProgressBean> memberProgresslist =new MemberProgressDAO().list();
		if (memberProgresslist!= null) {
			System.out.println("Hello");
			request.setAttribute("memberProgresslist", memberProgresslist);
			request.getRequestDispatcher("trainer/trainerMemberProgressList.jsp").include(request,
					response);
	}
	}
	

}
