package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.GymDetailsBean;
import com.designhub.fitnessplus.dao.GymDetailsDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class GymDetailsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String gymAddress = request.getParameter("txtGymAddress");
		String gymPhoneNo = request.getParameter("txtGymPhoneNo");
		String gymCityId = request.getParameter("selCityName");
		String gymAreaId = request.getParameter("selAreaName");

		GymDetailsBean gymDetailsBean = new GymDetailsBean();

		boolean isError = false;

		if(ValidationUtils.isEmpty(gymAddress))
		{
			request.setAttribute("gymAddress", "<<font color=red>* Address is Required</font>");
			isError=true;
		}else{
			request.setAttribute("txtGymAddress", gymAddress);
			if(gymAddress == null)
				gymAddress="";
			gymDetailsBean.setGymAddress(gymAddress);
		}
		if(ValidationUtils.isEmpty(gymPhoneNo))
		{
			request.setAttribute("gymPhoneNo", "<font color=red>* Mobile no. is Required</font>");
			isError=true;
		}else{
			request.setAttribute("txtGymPhoneNo", gymPhoneNo);
			if(gymPhoneNo == null)
				gymPhoneNo="";
			gymDetailsBean.setGymPhoneNo(gymPhoneNo);
		}

		if (gymCityId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgCityName",
					"<font color=red>* CITY is Required</font>");
		} 

		if (gymAreaId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgAreaName",
					"<font color=red>* AREA is Required</font>");
		} 

		
		if (isError) 
		{
			request.getRequestDispatcher("gymDetailsInsert.jsp").forward(request, response);
		} 
		else 
		{
			gymDetailsBean.setAreaId(gymAreaId);
			gymDetailsBean.setCityId(gymCityId);
			
//			System.out.println("success");
			if(new GymDetailsDAO().insert(gymDetailsBean)) {
				response.sendRedirect("GymDetailsListServlet");
			}else{
				response.sendRedirect("gymDetailsInsert.jsp");
			}
		}
	}
}
