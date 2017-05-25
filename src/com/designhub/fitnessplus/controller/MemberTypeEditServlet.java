package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberTypeBean;
import com.designhub.fitnessplus.dao.MemberTypeDAO;

public class MemberTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String memberTypeId = request.getParameter("mid");
		
		MemberTypeBean memberTypeBean = new MemberTypeDAO().getByPK(memberTypeId);
		
		
		if(memberTypeBean!=null)
		{
			request.setAttribute("memberTypeBean",memberTypeBean);
			request.getRequestDispatcher("memberTypeEdit.jsp").forward(request, response);
		}
	
	
	}

}
