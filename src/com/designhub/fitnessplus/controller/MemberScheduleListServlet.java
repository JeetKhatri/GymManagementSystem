package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberScheduleBean;
import com.designhub.fitnessplus.dao.MemberScheduleDAO;

public class MemberScheduleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/*
		 * String memberScheduleId = request.getParameter("id");
		 * 
		 * System.out.println(memberScheduleId);
		 * 
		 * List<MemberScheduleDetailsBean> listOfScheduleDetails = new
		 * MemberScheduleDetailsDAO() .list(memberScheduleId);
		 * 
		 * if (listOfScheduleDetails != null) {
		 * request.setAttribute("listOfScheduleDetails", listOfScheduleDetails);
		 * request.getRequestDispatcher("memberScheduleDetailsList.jsp")
		 * .forward(request, response); }
		 */

		List<MemberScheduleBean> listOfScheduleDetails = new MemberScheduleDAO()
				.list();

		if (listOfScheduleDetails != null) {
			request.setAttribute("listOfScheduleDetails", listOfScheduleDetails);
			request.getRequestDispatcher("memberScheduleList.jsp").forward(
					request, response);
		}

	}

}
