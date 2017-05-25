package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberTypeBean;
import com.designhub.fitnessplus.dao.MemberTypeDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class MemberTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String memberTypeName = request.getParameter("txtMemberTypeName");
		System.out.println(memberTypeName);
		String memberTypeId = request.getParameter("mid");
		MemberTypeBean memberTypeBean = new MemberTypeBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(memberTypeName)) {
			isError = true;
			request.setAttribute("memberTypeName",
					"<font color=red>* MemberType Name is Required</font>");
		} 
		
		else {
			request.setAttribute("memberTypeName", memberTypeName);
			memberTypeBean.setMemberTypeName(memberTypeName);
		}

		if (isError) 
		{
			memberTypeBean.setMemberTypeId(memberTypeId);
			memberTypeBean.setMemberTypeName(memberTypeName);
			request.setAttribute("memberTypeBean",memberTypeBean);
			request.getRequestDispatcher("memberTypeEdit.jsp").forward(request, response);
		} 
		else 
		{
			memberTypeBean.setMemberTypeId(memberTypeId);
			
			  if(new MemberTypeDAO().update(memberTypeBean)) {
				  
				  System.out.println("Record Update");
				  response.sendRedirect("memberTypeList");
				  
			  } 
			  else {
				  System.out.println("Record Not Updated");
			  
			  }

		}

	}
	

}
