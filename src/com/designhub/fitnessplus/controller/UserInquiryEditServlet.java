package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.UserInquiryBean;
import com.designhub.fitnessplus.dao.UserInquiryDAO;

public class UserInquiryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String inquiryId = request.getParameter("uid");

		UserInquiryBean userInquiry = new UserInquiryDAO().getByPK(inquiryId);

		if (userInquiry != null) {
			request.setAttribute("userInquiry", userInquiry);
			request.getRequestDispatcher("userInquiryEdit.jsp").forward(request,
					response);
		}

	}

}

