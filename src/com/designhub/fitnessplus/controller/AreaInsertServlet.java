package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.AreaBean;
import com.designhub.fitnessplus.dao.AreaDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class AreaInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String areaName = request.getParameter("txtAreaName");
		String cityId = request.getParameter("selCityName");
		String areaPincode = request.getParameter("txtAreaPincode");
		System.out.println(cityId);
		
		AreaBean areaBean = new AreaBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(areaName)) {
			isError = true;
			request.setAttribute("areaName",
					"<font color=red>* Area is Required</font>");
		} 
		
		else {
			request.setAttribute("txtAreaName", areaName);
			areaBean.setAreaName(areaName);
		}
		
		if (ValidationUtils.isEmpty(areaPincode)) {
			isError = true;
			request.setAttribute("areaPincode",
					"<font color=red>* Pincode is Required</font>");
		} 
		
		else {
			request.setAttribute("txtAreaPincode", areaPincode);
			areaBean.setAreaPincode(areaPincode);
		}


		if (cityId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgCityName",
					"<font color=red>* CITY is Required</font>");
		} 

		
		if (isError) 
		{
			System.out.println("error");
			request.getRequestDispatcher("areaInsert.jsp").forward(request, response);
		} 
		else 
		{
				System.out.println("success");
				areaBean.setCityId(cityId);
			  
				if(new AreaDAO().insert(areaBean)) {
				  
				  System.out.println("Record Inserted");
				  response.sendRedirect("AreaListServlet");
				  
			  } 
			  else {
				  System.out.println("Record Not inserted");
			  
			  }

		}

	}

}
