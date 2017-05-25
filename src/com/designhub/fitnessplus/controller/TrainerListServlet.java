package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.TrainerBean;
import com.designhub.fitnessplus.dao.TrainerDAO;

public class TrainerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TrainerBean> listofTrainer = new TrainerDAO().list();
		if(listofTrainer != null)
		{
			request.setAttribute("listofTrainer",listofTrainer);
			request.getRequestDispatcher("trainerList.jsp").include(request, response);
		}else{
			System.out.println("No Record Found....");
		}
	}

}
