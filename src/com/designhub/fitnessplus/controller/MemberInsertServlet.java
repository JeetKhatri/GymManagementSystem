package com.designhub.fitnessplus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberBean;
import com.designhub.fitnessplus.dao.MemberDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String memberFirstName = request.getParameter("txtMemberFirstName");
		String memberLastName = request.getParameter("txtMemberLastName");
		String memberEmail = request.getParameter("txtMemberEmail");
		String memberPassword = request.getParameter("txtMemberPassword");
		String memberPhoneNo = request.getParameter("txtMemberPhoneNo");
		String memberGender = request.getParameter("rdoMemberGender");
		String memberDOB = request.getParameter("txtMemberDOB");
		String memberAddress = request.getParameter("txtMemberAddress");
		String memberCityId = request.getParameter("selCityName");
		String memberAreaId = request.getParameter("selAreaName");
		String memberTypeId = request.getParameter("selMemberTypeName");
		String questionId=request.getParameter("selQuestion");
		String answer=request.getParameter("txtAnswer");
		
		
		MemberBean memberBean = new MemberBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(memberFirstName)) {
			isError = true;
			request.setAttribute("memberFirstName",
					"<font color=red>* First Name is Required</font>");
		} 
		
		else {
			request.setAttribute("txtMemberFirstName", memberFirstName);
			memberBean.setMemberFirstName(memberFirstName);;
		}
		
		if (ValidationUtils.isEmpty(answer)) {
			isError = true;
			request.setAttribute("msgAnswer",
					"<font color=red>* Answer is Required</font>");
		} 
		
		else {
			request.setAttribute("txtAnswer", answer);
			memberBean.setAnswer(answer);
		}
		
		if (ValidationUtils.isEmpty(memberLastName)) {
			isError = true;
			request.setAttribute("memberLastName",
					"<font color=red>* Last Name is Required</font>");
		} 
		
		else {
			request.setAttribute("txtMemberLastName", memberLastName);
			memberBean.setMemberLastName(memberLastName);;
		}
		
		if (ValidationUtils.isEmpty(memberEmail)) {
			isError = true;
			request.setAttribute("memberEmail",
					"<font color=red>* E-MAIL is Required</font>");
		} 
		
		else {
			System.out.println("Not EmPty");
			request.setAttribute("txtMemberEmail", memberEmail);
			if (!(ValidationUtils.isValidEmailAddress(memberEmail))) {
				isError = true;
				request.setAttribute("memberEmail",
						"<font color=red>* Invalid Email Format</font>");
			}
			else{
			request.setAttribute("txtMemberEmail", memberEmail);
			memberBean.setMemberEmail(memberEmail);
			}
		}
		
		if (ValidationUtils.isEmpty(memberPassword)) {
			isError = true;
			request.setAttribute("memberPassword",
					"<font color=red>* PASSWORD is Required</font>");
		} 
		
		else {
			request.setAttribute("txtMemberPassword", memberPassword);
			memberBean.setMemberPassword(memberPassword);
		}
		
		if (ValidationUtils.isEmpty(memberPhoneNo)) {
			isError = true;
			request.setAttribute("memberPhoneNo",
					"<font color=red>* PHONE NO is Required</font>");
		} 
		
		else {
			request.setAttribute("txtMemberPhoneNo", memberPhoneNo);
			memberBean.setMemberPhoneNo(memberPhoneNo);;
		}
		

		if (ValidationUtils.isEmpty(memberDOB)) {
			isError = true;
			request.setAttribute("memberDOB",
					"<font color=red>* DOB is Required</font>");
		} 
		
		else {
			
			/*memberDOB=memberDOB.replaceAll("/", "-");
			String a[]=memberDOB.split("-");
			memberDOB=a[2]+"-"+a[0]+"-"+a[1];
			System.out.println(memberDOB);*/
			
			
			request.setAttribute("txtMemberDOB", memberDOB);
			memberBean.setMemberDOB(memberDOB);
		}
		
		if (ValidationUtils.isEmpty(memberAddress)) {
			isError = true;
			request.setAttribute("memberAddress",
					"<font color=red>* ADDRESS is Required</font>");
		} 
		
		else {
			request.setAttribute("txtMemberAddress", memberAddress);
			memberBean.setMemberAddress(memberAddress);
		}

		
		
		if (memberCityId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgCityName",
					"<font color=red>* CITY is Required</font>");
		} 

		if (memberAreaId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgAreaName",
					"<font color=red>* AREA is Required</font>");
		} 
		
		if (memberTypeId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgMemberTypeName",
					"<font color=red>* MEMBER TYPE is Required</font>");
		} 
		

		if (questionId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgQuestion",
					"<font color=red>* Question Selection is Required</font>");
		} 
		
		
		if (isError) 
		{
			System.out.println("error");
			request.getRequestDispatcher("memberInsert.jsp").forward(request, response);
		} 
		else 
		{
				System.out.println("success");
				memberBean.setCityId(memberCityId);
				memberBean.setAreaId(memberAreaId);
				memberBean.setMemberTypeId(memberTypeId);
				memberBean.setQuestionId(questionId);
				memberBean.setMemberIsActive("1");
				
				memberBean.setMemberGender(memberGender);
			  
				
				
		
				if(new MemberDAO().insert(memberBean)) {
				  
				  System.out.println("Record Inserted");
				  response.sendRedirect("MemberListServlet");
				  
			  } 
			  else {
				  System.out.println("Record Not inserted");
			  
			  }

		}

	}

}

