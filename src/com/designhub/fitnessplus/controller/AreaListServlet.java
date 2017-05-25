package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.AreaBean;
import com.designhub.fitnessplus.dao.AreaDAO;

public class AreaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		List<AreaBean> listOfArea = new AreaDAO().list();
		
		if(listOfArea!=null)
		{
			request.setAttribute("listOfArea",listOfArea);
			request.getRequestDispatcher("areaList.jsp").forward(request, response);
		}
		
		
	}

}
