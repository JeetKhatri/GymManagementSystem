package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.PackageDurationBean;
import com.designhub.fitnessplus.dao.PackageDurationDAO;

public class PackageDurationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		List<PackageDurationBean> listOfPackageDuration = new PackageDurationDAO().list();
		
		if(listOfPackageDuration!=null)
		{
			request.setAttribute("listOfPackageDuration",listOfPackageDuration);
			request.getRequestDispatcher("packageDurationList.jsp").forward(request, response);
		}
		
	}

}
