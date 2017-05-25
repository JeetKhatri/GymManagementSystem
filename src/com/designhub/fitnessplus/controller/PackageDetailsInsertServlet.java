package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.PackageDetailsBean;
import com.designhub.fitnessplus.dao.PackageDetailsDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class PackageDetailsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String packageId = request.getParameter("selPackageName");
		String packageDurationId = request.getParameter("selPackageDurationTime");	
		String packageRate = request.getParameter("txtPackageRate");

		PackageDetailsBean packageDetailsBean = new PackageDetailsBean();
		boolean isError = false;

		if (packageId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgPackageName",
					"<font color=red>* PACKAGE NAME is Required</font>");
		} 
		if (packageDurationId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgPackageDurationTime",
					"<font color=red>* Duration is Required</font>");
		} 
		
		if (ValidationUtils.isEmpty(packageRate)) {
			isError = true;
			request.setAttribute("packageRate",
					"<font color=red>* package rate is Required</font>");
		} 
		
		else {
			request.setAttribute("txtPackageRate", packageRate);
			packageDetailsBean.setPackageRate(packageRate);
		}

		if (isError) 
		{
			System.out.println("Error");
			request.setAttribute("packageDetailsBean", packageDetailsBean);
			request.getRequestDispatcher("packageInsert.jsp").forward(request, response);
		} 
		else 
		{
				packageDetailsBean.setPackageId(packageId);
				  packageDetailsBean.setPackageDurationId(packageDurationId);
					
				  if(new PackageDetailsDAO().insert(packageDetailsBean)) 
				  {  
					  System.out.println("Record Inserted");
					  response.sendRedirect("PackageDetailsListServlet");  
				  }  else {
					  System.out.println("Record Not inserted");
				  }

		}

	}

}
