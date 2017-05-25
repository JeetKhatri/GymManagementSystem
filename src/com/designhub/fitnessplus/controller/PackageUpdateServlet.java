package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.PackageBean;
import com.designhub.fitnessplus.dao.PackageDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class PackageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String packageName = request.getParameter("txtPackageName");
		String packageId = request.getParameter("packageId");
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
			packageBean.setPackageId(packageId);
			packageBean.setPackageName(packageName);
			request.setAttribute("packageBean",packageBean);
			request.getRequestDispatcher("packageEdit.jsp").forward(request, response);
		} 
		else 
		{
			packageBean.setPackageId(packageId);
			
			  if(new PackageDAO().update(packageBean)) {
				  
				  System.out.println("Record Update");
				  response.sendRedirect("packageListServlet");
				  
			  } 
			  else {
				  System.out.println("Record Not Updated");
			  
			  }

		}

	}
	

}
