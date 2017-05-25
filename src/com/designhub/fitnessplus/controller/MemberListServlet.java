package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberBean;
import com.designhub.fitnessplus.dao.MemberDAO;

public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<MemberBean> listOfMember = new MemberDAO().list();
		
		if(listOfMember!=null)
		{
			request.setAttribute("listOfMember",listOfMember);
			request.getRequestDispatcher("memberList.jsp").forward(request, response);
		}
	
	}

}
