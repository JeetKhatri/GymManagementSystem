package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.PackageDetailsBean;
import com.designhub.fitnessplus.dao.PackageDetailsDAO;

public class PackageDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	List<PackageDetailsBean> listOfpackage = new PackageDetailsDAO().list();
		
		if(listOfpackage!=null)
		{
			request.setAttribute("listOfpackage",listOfpackage);
			request.getRequestDispatcher("packageDetailsList.jsp").forward(request, response);
		}
		
	}

}
