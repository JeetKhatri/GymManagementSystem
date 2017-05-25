package com.designhub.fitnessplus.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.UserInquiryBean;
import com.designhub.fitnessplus.dao.UserInquiryDAO;



public class UserInquiryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<UserInquiryBean> listOfUserInquiry = new UserInquiryDAO().list();
		
		if(listOfUserInquiry!=null)
		{
			request.setAttribute("listOfUserInquiry", listOfUserInquiry);
			request.getRequestDispatcher("userInquiryList.jsp").forward(request, response);
		}
		else
		{
			System.out.println("No Record Found....");
		}
	}

}
