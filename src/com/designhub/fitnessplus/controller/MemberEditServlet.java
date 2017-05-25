package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberBean;
import com.designhub.fitnessplus.dao.MemberDAO;

public class MemberEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String memberId = request.getParameter("id");
		
		MemberBean memberBean = new MemberDAO().getByPK(memberId);
		
		
		if(memberBean!=null)
		{
			request.setAttribute("memberBean",memberBean);
			request.getRequestDispatcher("memberEdit.jsp").forward(request, response);
		}
	
	
	}

}
