package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.designhub.fitnessplus.bean.AdminBean;
import com.designhub.fitnessplus.bean.MemberBean;
import com.designhub.fitnessplus.bean.TrainerBean;
import com.designhub.fitnessplus.dao.LoginDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		boolean isError = false;

		if (ValidationUtils.isEmpty(email)) {
			request.setAttribute("email", "<font size=6 color=red>*</font>");
			isError = true;
		} else {
			request.setAttribute("txtEmail", email);
		}
		if (ValidationUtils.isEmpty(password)) {
			request.setAttribute("password", "<font size=6 color=red>*</font>");
			isError = true;
		} else {
			request.setAttribute("txtPassword", password);
		}

		if (isError) {
			request.getRequestDispatcher("userlogin.jsp")
					.forward(request, response);
		} else {
			LoginDAO loginDAO = new LoginDAO();
			PrintWriter out = response.getWriter();
			if (loginDAO.adminLogin(email, password)) {
				AdminBean adminBean = new LoginDAO().adminLoginBean(email,
						password);

				HttpSession session = request.getSession();

				session.setAttribute("adminBean", adminBean);

				response.sendRedirect("adminhomepage.jsp");
			} else if (loginDAO.memberLogin(email, password)) {

				MemberBean memberBean = new LoginDAO().memberLoginBean(email, password);

				HttpSession session = request.getSession();

				session.setAttribute("memberBean", memberBean);

				
				response.sendRedirect("member/memberHomePage.jsp");
				
				out.print("<font size=6 color=red>Member Is Logged in....</font>");
			} else if (loginDAO.trainerLogin(email, password)) {
				TrainerBean trainerBean = new LoginDAO().trainerLoginBean(email, password);

				HttpSession session = request.getSession();

				session.setAttribute("trainerBean", trainerBean);

				response.sendRedirect("trainer/trainerHomePage.jsp");
				
			} else {

				response.sendRedirect("userlogin.jsp");
				
				out.print("<font size=6 color=red>You are Not Valid Person......to the DataBase......</font>");
			}
		}
	}

}








