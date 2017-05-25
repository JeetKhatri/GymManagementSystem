package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.CityBean;
import com.designhub.fitnessplus.dao.CityDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class CityInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String cityName = request.getParameter("txtCityName");
		CityBean cityBean = new CityBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(cityName)) {
			isError = true;
			request.setAttribute("cityName",
					"<font color=red>* City is Required</font>");
		} 
		
		else {
			request.setAttribute("cityName", cityName);
			cityBean.setCityName(cityName);
		}

		if (isError) 
		{
			request.getRequestDispatcher("city.jsp").forward(request, response);
		} 
		else 
		{

			
			  if(new CityDAO().insert(cityBean)) {
				  
				  System.out.println("Record Inserted");
				  response.sendRedirect("cityList");
				  
			  } 
			  else {
				  System.out.println("Record Not inserted");
			  
			  }

		}

	}

}
