package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.AreaBean;
import com.designhub.fitnessplus.dao.AreaDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class AreaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String areaName = request.getParameter("txtAreaName");
		String areaId = request.getParameter("aid");
		String cityId = request.getParameter("selCityName");
		String areaPincode = request.getParameter("txtAreaPincode");
		
		AreaBean areaBean = new AreaBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(areaPincode)) {
			isError = true;
			request.setAttribute("areaPincode",
					"<font color=red>* Pincode is Required</font>");
		} 
		
		else {
			request.setAttribute("txtAreaPincode", areaPincode);
			areaBean.setAreaPincode(areaPincode);
		}
		
		if (ValidationUtils.isEmpty(areaName)) {
			isError = true;
			request.setAttribute("areaName",
					"<font color=red>*  is Required</font>");
		} 
		
		else {
			request.setAttribute("txtAreaName", areaName);
			areaBean.setAreaName(areaName);
		}

		if (cityId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgCityName",
					"<font color=red>* CITY is Required</font>");
		} 

		
		if (isError) 
		{
			areaBean.setCityId(cityId);
			areaBean.setAreaName(areaName);
			areaBean.setAreaId(areaId);
			
			request.setAttribute("areaBean",areaBean);
			request.getRequestDispatcher("areaEdit.jsp").forward(request, response);
		} 
		else 
		{
			
			areaBean.setAreaId(areaId);
			areaBean.setCityId(cityId);
			
			  if(new AreaDAO().update(areaBean)) {
				  
				  System.out.println("Record Update");
				  response.sendRedirect("AreaListServlet");
				  
			  } 
			  else {
				  System.out.println("Record Not Updated");
			  
			  }

		}

	}
	

}
