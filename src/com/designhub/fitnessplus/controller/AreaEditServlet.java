package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.AreaBean;
import com.designhub.fitnessplus.dao.AreaDAO;

public class AreaEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String areaId = request.getParameter("aid");
		
		AreaBean areaBean = new AreaDAO().getByPK(areaId);
		
		System.out.println(" Hi " +areaId);
		
		if(areaBean!=null)
		{
			request.setAttribute("areaBean",areaBean);
			request.getRequestDispatcher("areaEdit.jsp").forward(request, response);
		}
	
	
	}

}
