package com.designhub.fitnessplus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.PackageDurationBean;
import com.designhub.fitnessplus.dao.PackageDurationDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class PackageDurationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String packageDurationTime = request.getParameter("txtPackageDurationTime");
		
		PackageDurationBean packageDurationBean = new PackageDurationBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(packageDurationTime)) {
			isError = true;
			request.setAttribute("packageDurationTime",
					"<font color=red>* time is Required</font>");
		} 
		
		else {
			request.setAttribute("txtPackageDurationTime", packageDurationTime);
			packageDurationBean.setPackageDurationTime(packageDurationTime);
		}

		
		if (isError) 
		{
			System.out.println("error");
			request.getRequestDispatcher("packageDurationInsert.jsp").forward(request, response);
		} 
		else 
		{
				System.out.println("success");
			  
				if(new PackageDurationDAO().insert(packageDurationBean)) {
				  
				  System.out.println("Record Inserted");
				  response.sendRedirect("PackageDurationListServlet");
			  } 
			  else {
				  System.out.println("Record Not inserted");
			  
			  }

		}

	}

}
