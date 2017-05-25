package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.UserInquiryDAO;


public class UserInquiryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String inquiryId = request.getParameter("uid");
	
		if (new UserInquiryDAO().delete(inquiryId)) {
			response.sendRedirect("UserInquiryListServlet");
		} else {
			response.sendRedirect("UserInquiryListServlet");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

}
