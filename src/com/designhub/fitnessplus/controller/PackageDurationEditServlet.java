package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.PackageDurationBean;
import com.designhub.fitnessplus.dao.PackageDurationDAO;

public class PackageDurationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String packageDurationId = request.getParameter("aid");
		
		PackageDurationBean packageDuration = new PackageDurationDAO().getByPK(packageDurationId);
		
		if(packageDuration!=null)
		{
			request.setAttribute("packageDuration",packageDuration);
			request.getRequestDispatcher("packageDurationEdit.jsp").forward(request, response);
		}
		
	}

}
