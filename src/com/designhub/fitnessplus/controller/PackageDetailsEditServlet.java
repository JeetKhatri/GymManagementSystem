package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.PackageDetailsBean;
import com.designhub.fitnessplus.dao.PackageDetailsDAO;

public class PackageDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			

		String packageDetailsId = request.getParameter("packageDetailsId");
		PackageDetailsBean packageDetails = new PackageDetailsDAO().getByPK(packageDetailsId);
		if(packageDetails!=null)
		{
			request.setAttribute("packageDetails",packageDetails);
			request.getRequestDispatcher("packageDetailsEdit.jsp").forward(request, response);
		}	
		else{
			response.sendRedirect("PackageDetailsListServlet");
		}
		
	}

}
