package com.designhub.fitnessplus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.AdminBean;
import com.designhub.fitnessplus.dao.AdminDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class AdminInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String adminFirstName = request.getParameter("txtAdminFirstName");
		String adminLastName = request.getParameter("txtAdminLastName");
		String adminEmail = request.getParameter("txtAdminEmail");
		String adminPassword = request.getParameter("txtAdminPassword");
		String adminPhoneNo = request.getParameter("txtAdminPhoneNo");
		String adminGender = request.getParameter("rdoAdminGender");
		String adminDOB = request.getParameter("txtAdminDOB");
		String adminAddress = request.getParameter("txtAdminAddress");
		String adminCityId = request.getParameter("selCityName");
		String adminAreaId = request.getParameter("selAreaName");
		System.out.println(adminGender);
		
		AdminBean adminBean = new AdminBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(adminFirstName)) {
			isError = true;
			request.setAttribute("adminFirstName",
					"<font color=red>* First Name is Required</font>");
		} 
		
		else {
			request.setAttribute("txtAdminFirstName", adminFirstName);
			adminBean.setAdminFirstName(adminFirstName);;
		}
		
		
		if (ValidationUtils.isEmpty(adminLastName)) {
			isError = true;
			request.setAttribute("adminLastName",
					"<font color=red>* Last Name is Required</font>");
		} 
		
		else {
			request.setAttribute("txtAdminLastName", adminLastName);
			adminBean.setAdminLastName(adminLastName);;
		}
		
		if (ValidationUtils.isEmpty(adminEmail)) {
			isError = true;
			request.setAttribute("adminEmail",
					"<font color=red>* E-MAIL is Required</font>");
		} 
		else {
			System.out.println("Not EmPty");
			request.setAttribute("txtAdminEmail", adminEmail);
			if (!(ValidationUtils.isValidEmailAddress(adminEmail))) {
				isError = true;
				request.setAttribute("adminEmail",
						"<font color=red>* Invalid Email Format</font>");
			}
			else{
			request.setAttribute("txtAdminEmail", adminEmail);
			adminBean.setAdminEmail(adminEmail);
			}
		}
		
		if (ValidationUtils.isEmpty(adminPassword)) {
			isError = true;
			request.setAttribute("adminPassword",
					"<font color=red>* PASSWORD is Required</font>");
		} 
		
		else {
			request.setAttribute("txtAdminPassword", adminPassword);
			adminBean.setAdminPassword(adminPassword);;
		}
		
		if (ValidationUtils.isEmpty(adminPhoneNo)) {
			isError = true;
			request.setAttribute("adminPhoneNo",
					"<font color=red>* PHONE NO is Required</font>");
		} 
		
		else {
			request.setAttribute("txtAdminPhoneNo", adminPhoneNo);
			adminBean.setAdminPhoneNo(adminPhoneNo);;
		}
		
		if (ValidationUtils.isEmpty(adminGender)) {
			isError = true;
			request.setAttribute("adminGender",
					"<font color=red>* GENDER is Required</font>");
		} 
		
		else {
			request.setAttribute("rdoAdminGender", adminGender);
			adminBean.setAdminGender(adminGender);
		}

		if (ValidationUtils.isEmpty(adminDOB)) {
			isError = true;
			request.setAttribute("adminDOB",
					"<font color=red>* DOB is Required</font>");
		} 
		
		else {
			request.setAttribute("txtAdminDOB", adminDOB);
			adminBean.setAdminDOB(adminDOB);
		}
		
		if (ValidationUtils.isEmpty(adminAddress)) {
			isError = true;
			request.setAttribute("adminAddress",
					"<font color=red>* ADDRESS is Required</font>");
		} 
		
		else {
			request.setAttribute("txtAdminAddress", adminAddress);
			adminBean.setAdminAddress(adminAddress);
		}

		
		
		if (adminCityId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgCityName",
					"<font color=red>* CITY is Required</font>");
		} 

		if (adminAreaId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgAreaName",
					"<font color=red>* AREA is Required</font>");
		} 
		
		if (isError) 
		{			
			System.out.println("error");
			request.getRequestDispatcher("adminInsert.jsp").forward(request, response);
		} 
		else 
		{
				System.out.println("success");
				adminBean.setCityId(adminCityId);
				adminBean.setAreaId(adminAreaId);
				adminBean.setAdminIsActive("1");
				adminBean.setAdminGender(adminGender);
			  
				if(new AdminDAO().insert(adminBean)) {
				  
				  System.out.println("Record Inserted");
				  
				  SendEmail mail =new SendEmail();
			        String s = mail.SendEmail("REGISTRATION", adminEmail, "Reg successfully!!!");
				  
				  response.sendRedirect("AdminListServlet");
				  
			  } 
			  else {
				  System.out.println("Record Not inserted");
			  
			  }

		}

	}

}

