package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.CityBean;
import com.designhub.fitnessplus.dao.CityDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class CityUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String cityName = request.getParameter("txtCityName");
		String cityId = request.getParameter("cid");
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
			cityBean.setCityId(cityId);
			cityBean.setCityName(cityName);
			request.setAttribute("cityBean",cityBean);
			request.getRequestDispatcher("cityEdit.jsp").forward(request, response);
		} 
		else 
		{
			cityBean.setCityId(cityId);
			
			  if(new CityDAO().update(cityBean)) {
				  
				  System.out.println("Record Update");
				  response.sendRedirect("cityList");
				  
			  } 
			  else {
				  System.out.println("Record Not Updated");
			  
			  }

		}

	}
	

}
