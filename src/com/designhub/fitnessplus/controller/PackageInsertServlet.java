package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.PackageBean;
import com.designhub.fitnessplus.dao.PackageDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class PackageInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String packageName = request.getParameter("txtPackageName");
		PackageBean packageBean = new PackageBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(packageName)) {
			isError = true;
			request.setAttribute("packageName",
					"<font color=red>* Country is Required</font>");
		} 
		
		else {
			request.setAttribute("packageName", packageName);
			packageBean.setPackageName(packageName);
		}

		if (isError) 
		{
			request.getRequestDispatcher("packageInsert.jsp").forward(request, response);
		} 
		else 
		{

			
			  if(new PackageDAO().insert(packageBean)) {
				  
				  System.out.println("Record Inserted");
				  response.sendRedirect("packageListServlet");
				  
			  } 
			  else {
				  System.out.println("Record Not inserted");
			  
			  }

		}

	}

}
