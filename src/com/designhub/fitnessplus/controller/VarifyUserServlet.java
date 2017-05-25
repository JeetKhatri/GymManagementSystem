package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberBean;
import com.designhub.fitnessplus.dao.LoginDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class VarifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("txtPassword");
		boolean isError = false;
		
		System.out.println(userEmail);
		
		if (ValidationUtils.isEmpty(userEmail)) {
			isError = true;
			request.setAttribute("message",
					"<font color=red>* Please Enter UserName</font>");
		}

		MemberBean memberBean = new LoginDAO().getForgotDetailMember(userEmail);

		if (memberBean == null || memberBean.getCityId() == "0") 
		{ 
			response.sendRedirect("userlogin.jsp");
			System.out.println("Helloooooo in Not Success");
			
		}
		else 
		{
			
			if (isError) {
				System.out.println("Helloooooo in Not Success");
				request.getRequestDispatcher("userlogin.jsp").forward(request,
						response);
			} else {
				System.out.println("Helloooooo in Success");
				request.setAttribute("memberBean", memberBean);
				request.getRequestDispatcher("checkSecurityAnswer.jsp")
						.forward(request, response);
			}
		}
	}

}
