package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberTypeBean;
import com.designhub.fitnessplus.dao.MemberTypeDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class MemberTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String memberTypeName = request.getParameter("txtMemberTypeName");
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
			request.getRequestDispatcher("memberType.jsp").forward(request, response);
		} 
		else 
		{

			
			  if(new MemberTypeDAO().insert(memberTypeBean)) {
				  
				  System.out.println("Record inserted");
				  response.sendRedirect("memberTypeList");
				  
			  } 
			  else {
				  System.out.println("Record Not inserted");
			  
			  }

		}

	}

}
