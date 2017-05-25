package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.TrainerBean;
import com.designhub.fitnessplus.dao.TrainerDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

public class TrainerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String trainerFirstName=request.getParameter("txtTrainerFirstName");
		String trainerLastName=request.getParameter("txtTrainerLastName");
		String trainerEmail=request.getParameter("txtTrainerEmail");
		String trainerGender=request.getParameter("rdbTrainerGender");
		String trainerDOB=request.getParameter("txtTrainerDOB");
		String trainerAddress=request.getParameter("txtareaTrainerAddress");
		String trainerPhoneNo=request.getParameter("txtTrainerPhoneNo");
		String trainerExperiance=request.getParameter("txtTrainerExperiance");
		String cityId = request.getParameter("selCityName");
		String areaId=request.getParameter("selAreaName");
		String trainerId=request.getParameter("trainerId");
		
		System.out.println("Trianer"   + trainerId);
		
		TrainerBean trainerBean=new TrainerBean();
		
		boolean isError=false;
		
		if(ValidationUtils.isEmpty(trainerFirstName))
		{
			request.setAttribute("trainerFirstName", "<font size=6 color=red>*</font>");
			isError=true;
		}
		else
		{
			request.setAttribute("txtTrainerFirstName", trainerFirstName);
			trainerBean.setTrainerFirstName(trainerFirstName);
		}
		if(ValidationUtils.isEmpty(trainerLastName))
		{
			request.setAttribute("trainerLastName", "<font size=6 color=red>*</font>");
			isError=true;
		}
		else
		{
			request.setAttribute("txtTrainerLastName", trainerLastName);
			trainerBean.setTrainerLastName(trainerLastName);
		}
		if(ValidationUtils.isEmpty(trainerEmail))
		{
			request.setAttribute("trainerEmail", "<font size=6 color=red>*</font>");
			isError=true;
		}
		else
		{
			request.setAttribute("txtTrainerEmail", trainerEmail);
			trainerBean.setTrainerEmail(trainerEmail);
		}
		
		if(ValidationUtils.isEmpty(trainerDOB))
		{
			request.setAttribute("trainerDOB", "<font size=6 color=red>*</font>");
			isError=true;
		}
		else
		{
			/*trainerDOB=trainerDOB.replaceAll("/", "-");
			String a[]=trainerDOB.split("-");
			trainerDOB=a[2]+"-"+a[0]+"-"+a[1];
			System.out.println(trainerDOB);
			*/request.setAttribute("txtTrainerDOB", trainerDOB);
			trainerBean.setTrainerDOB(trainerDOB);
		}
		if(ValidationUtils.isEmpty(trainerAddress))
		{
			request.setAttribute("trainerAddress", "<font size=6 color=red>*</font>");
			isError=true;
		}
		else
		{
			request.setAttribute("txtareaTrainerAddress", trainerAddress);
			trainerBean.setTrainerAddress(trainerAddress);
		}
		if(ValidationUtils.isEmpty(trainerPhoneNo))
		{
			request.setAttribute("trainerPhoneNo", "<font size=6 color=red>*</font>");
			isError=true;
		}
		else
		{
			request.setAttribute("txtTrainerPhoneNo", trainerPhoneNo);
			trainerBean.setTrainerPhoneNo(trainerPhoneNo);
		}
		
		if(ValidationUtils.isEmpty(trainerExperiance))
		{
			request.setAttribute("trainerExperiance", "<font size=6 color=red>*</font>");
			isError=true;
		}
		else
		{
			request.setAttribute("txtTrainerExperiance", trainerExperiance);
			trainerBean.setTrainerExperience(trainerExperiance);
		}
		
		if (cityId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgCityName",
					"<font size=6 color=red>*</font>");
		}
		if (areaId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgAreaName",
					"<font size=6 color=red>*</font>");
		}
		
		if(isError)
		{
			trainerBean.setAreaId(areaId);
			trainerBean.setCityId(cityId);
			trainerBean.setTrainerId(trainerId);
			request.setAttribute("trainerBean", trainerBean);
			request.getRequestDispatcher("trainerEdit.jsp").forward(request, response);
		}else{
			trainerBean.setTrainerIsActive("1");
			trainerBean.setAreaId(areaId);
			trainerBean.setCityId(cityId);
			trainerBean.setTrainerGender(trainerGender);
			trainerBean.setTrainerId(trainerId);
			System.out.println("Success");
			if(new TrainerDAO().update(trainerBean)) {
				request.getRequestDispatcher("TrainerListServlet").include(request, response);
			}else{
				//response.sendRedirect("adminInsert.jsp");
			}
		}
	}

}
