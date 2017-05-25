package com.designhub.fitnessplus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberProgressDetailsBean;
import com.designhub.fitnessplus.dao.MemberProgressDetailsDAO;

@SuppressWarnings("serial")
public class MemberProgressDetailEditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String progressDetailId=request.getParameter("progressDetailId");
		MemberProgressDetailsBean progressBean=new MemberProgressDetailsDAO().getByPK(progressDetailId);
		
		if(progressBean!=null)
		{
			request.setAttribute("progressBean", progressBean);
			request.getRequestDispatcher("memberProgressDetailsEdit.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("progressDetailListServlet").forward(request, response);
		}
	}

}
