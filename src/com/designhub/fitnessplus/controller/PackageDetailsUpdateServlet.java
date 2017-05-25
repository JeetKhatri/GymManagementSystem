package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.PackageDetailsBean;
import com.designhub.fitnessplus.dao.PackageDetailsDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class PackageDetailsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String packageDetailsId = request.getParameter("packageDetailsId");
		String packageName = request.getParameter("txtPackageName");
		String packageDurationId = request.getParameter("selPackageDurationTime");
		String packageRate = request.getParameter("txtPackageRate");
		
		PackageDetailsBean packageDetailsBean = new PackageDetailsBean();
		boolean isError = false;

		if (ValidationUtils.isEmpty(packageName)) {
			isError = true;
			request.setAttribute("packageName",
					"<font color=red>* Country is Required</font>");
		} 
		
		else {
			request.setAttribute("txtpackageName", packageName);
			packageDetailsBean.setPackageName(packageName);
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
		} else {
			request.setAttribute("txtPackageRate", packageRate);
			packageDetailsBean.setPackageRate(packageRate);
		}
		request.setAttribute("packageDetails", packageDetailsBean);
		packageDetailsBean.setPackageDurationId(packageDurationId);
		if (isError) 
		{
		//	System.out.println("error");	
			request.setAttribute("packageDetailsId", packageDetailsId);
			request.getRequestDispatcher("packageEdit.jsp").forward(request, response);
		} 
		else 
		{		
			packageDetailsBean.setPackageDetailsId(packageDetailsId);
			if(new PackageDetailsDAO().update(packageDetailsBean)) 
			{
				request.getRequestDispatcher("PackageDetailsListServlet").forward(request, response);
			}  else {
			  response.sendRedirect("packageEdit.jsp");
			  }

		}

	}

}
