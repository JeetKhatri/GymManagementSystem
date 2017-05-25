package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.LoginDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class CheckSecurityAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String securityAnswer = request.getParameter("securityAnswer");
		boolean isError = false;
		if (ValidationUtils.isEmpty(securityAnswer)) {
			isError = true;
			request.setAttribute("message", "Please Enter Answer");
		}
		if (isError) {

		} else {
			boolean flag = false;
			System.out.println(flag);
			System.out.println(memberId);
			System.out.println(securityAnswer);
			flag = new LoginDAO().checkSecurityAnswer(memberId,
					securityAnswer);
			System.out.println(flag);
			if (flag) {
				request.setAttribute("memberId", memberId);
				request.getRequestDispatcher("changePassword.jsp").forward(
						request, response);
			} else {
				// System.out.println("hello");
				response.sendRedirect("userlogin.jsp");
			}

		}

	}

}
