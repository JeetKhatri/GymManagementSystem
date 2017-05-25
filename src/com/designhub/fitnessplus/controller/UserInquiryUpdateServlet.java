package com.designhub.fitnessplus.controller;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.UserInquiryBean;
import com.designhub.fitnessplus.dao.UserInquiryDAO;
import com.designhub.fitnessplus.util.ValidationUtils;



public class UserInquiryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
		String inquiryId = request.getParameter("uid");
		String firstName = request.getParameter("txtFirstName");
		String lastName = request.getParameter("txtLastName");
		String email = request.getParameter("txtEmail");
		String phoneNo = request.getParameter("txtPhoneNo");
		String inquiryMassage = request.getParameter("txtMassage");
		String isAttendedBy = request.getParameter("selAdminName");
		String inquiryDate = dateFormat.format(date);
		
		boolean isError = false;
		UserInquiryBean userInquiryBean = new UserInquiryBean();

		if (ValidationUtils.isEmpty(firstName)) {
			request.setAttribute("firstName","<font color=red> * FIRST NAME is Required</font>");
			isError = true;
		} 
		else {
				
				request.setAttribute("txtFirstName", firstName);
	
				userInquiryBean.setFirstName(firstName);
		}
		
		if ((ValidationUtils.isEmpty(lastName))) {
				request.setAttribute("lastName","<font color=red> * LAST NAME is Required</font>");
				isError = true;
		} 
		else {
			request.setAttribute("txtLastName", lastName);

			userInquiryBean.setLastName(lastName);
			//userInquiryBean.setLastName(lastName);
				
		}
		
		if ((ValidationUtils.isEmpty(email))) {
				request.setAttribute("email","<font color=red> * Email-Id is Required</font>");
				isError = true;
		} 
		else {
			request.setAttribute("txtEmail", email);
	

				userInquiryBean.setEmail(email);
		}
		
		if (ValidationUtils.isEmpty(phoneNo)) {
				request.setAttribute("phoneNo", "<font color=red> * MOBILE NO is Required</font>");
				isError = true;
		} 
		else {
			request.setAttribute("txtPhoneNo", phoneNo);
			userInquiryBean.setPhoneNo(phoneNo);
		}
		
		if (ValidationUtils.isEmpty(inquiryMassage)) {
				request.setAttribute("inquiryMassage", "<font color=red> * INQUIRY MASSAGE is Required</font>");
				isError = true;
		} 
		else {
			request.setAttribute("txtMassage", inquiryMassage);
				userInquiryBean.setInquiryMassage(inquiryMassage);
		}


		if (isError) 
		{
			userInquiryBean.setPhoneNo(phoneNo);
			userInquiryBean.setIsAttendedBy(isAttendedBy);
			userInquiryBean.setInquiryId(inquiryId);
			request.setAttribute("userInquiry", userInquiryBean);
			request.getRequestDispatcher("userInquiryEdit.jsp").forward(request,
					response);
		}

		else {

			userInquiryBean.setInquiryDate(inquiryDate);
			userInquiryBean.setIsAttendedBy(isAttendedBy);
			userInquiryBean.setInquiryId(inquiryId);
			
			if(new UserInquiryDAO().update(userInquiryBean))
			{
				response.sendRedirect("UserInquiryListServlet");
			}
			else
			{
				response.sendRedirect("userInquiryEdit.jsp");
			}
			

		}

	}

}
