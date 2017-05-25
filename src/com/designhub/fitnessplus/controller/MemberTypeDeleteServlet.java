package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.MemberTypeDAO;

public class MemberTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String memberTypeId = request.getParameter("mid");

		if (new MemberTypeDAO().delete(memberTypeId)) {
			response.sendRedirect("memberTypeList");

		} else {
			response.sendRedirect("memberTypeList");

		}

	}

}
