package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.PackageBean;
import com.designhub.fitnessplus.dao.PackageDAO;

public class PackageEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String packageId = request.getParameter("packageId");
		System.out.println("-->Package I<---"+packageId);
		
		PackageBean packageBean = new PackageDAO().getByPK(packageId);
		
		
		if(packageBean!=null)
		{
			request.setAttribute("packageBean",packageBean);
			System.out.println(packageBean.getPackageId()+"---------"+packageBean.getPackageName());
			request.getRequestDispatcher("packageEdit.jsp").forward(request, response);
		}
	
	
	}

}
