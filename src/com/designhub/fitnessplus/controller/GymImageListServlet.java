package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.GymImageBean;
import com.designhub.fitnessplus.dao.GymImageDAO;

public class GymImageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		List<GymImageBean> listOfGymImage = new GymImageDAO().list();
		
		if(listOfGymImage!=null)
		{
			request.setAttribute("listOfGymImage",listOfGymImage);
			request.getRequestDispatcher("gymImageList.jsp").forward(request, response);
		}
		
		
	}

}
