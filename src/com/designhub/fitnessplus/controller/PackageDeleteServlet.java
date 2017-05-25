package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.dao.PackageDAO;
import com.designhub.fitnessplus.dao.PackageDetailsDAO;


public class PackageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String packageId = request.getParameter("packageId");
		System.out.println(";;;;;;;;;;;;;;;;;;;"+packageId);
		if (new PackageDetailsDAO().deleteByPackageId(packageId)) {
			if(new PackageDAO().delete(packageId))
			{
				System.out.println("Both Deleted.......");
				response.sendRedirect("packageListSevlet");
			}
		} else {
			System.out.println("Not Deleted...");
			response.sendRedirect("packageListServlet");

		}

	}

}
