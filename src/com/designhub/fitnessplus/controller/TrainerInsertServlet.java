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

public class TrainerInsertServlet extends HttpServlet {
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
		String trainerAddress=request.getParameter("txtTrainerAddress");
		String trainerPhoneNo=request.getParameter("txtTrainerPhoneNo");
		String trainerPassword=request.getParameter("txtTrainerPassword");
		String trainerExperiance=request.getParameter("txtTrainerExperiance");
		String cityId = request.getParameter("selCityName");
		String areaId=request.getParameter("selAreaName");
		String questionId=request.getParameter("selQuestion");
		String answer=request.getParameter("txtAnswer");
		
	
		
		TrainerBean trainerBean=new TrainerBean();
		
		boolean isError=false;
		
		if(ValidationUtils.isEmpty(trainerFirstName))
		{
			request.setAttribute("trainerFirstName", "<font color=red>First Name is Required</font>");
			isError=true;
		}
		else
		{
			request.setAttribute("txtTrainerFirstName", trainerFirstName);
			trainerBean.setTrainerFirstName(trainerFirstName);
		}
		if(ValidationUtils.isEmpty(trainerLastName))
		{
			request.setAttribute("trainerLastName", "<font color=red>Last Name is Required</font>");
			isError=true;
		}
		else
		{
			request.setAttribute("txtTrainerLastName", trainerLastName);
			trainerBean.setTrainerLastName(trainerLastName);
		}
		if(ValidationUtils.isEmpty(trainerEmail))
		{
			request.setAttribute("trainerEmail", "<font color=red>E-Mail is Required</font>");
			isError=true;
		}
		else
		{
			System.out.println("Not EmPty");
			request.setAttribute("txtTrainerEmail", trainerEmail);
			if (!(ValidationUtils.isValidEmailAddress(trainerEmail))) {
				isError = true;
				request.setAttribute("trainerEmail",
						"<font color=red>* Invalid Email Format</font>");
			}
			else{
			request.setAttribute("txtTrainerEmail", trainerEmail);
			trainerBean.setTrainerEmail(trainerEmail);
			}
		}
		if(ValidationUtils.isEmpty(trainerGender))
		{
			request.setAttribute("trainerGender", "<font color=red>Gender is Required</font>");
			isError=true;
		}
		else
		{
			request.setAttribute("txtTrainerGender", trainerGender);
			trainerBean.setTrainerGender(trainerGender);
		}
		if(ValidationUtils.isEmpty(trainerDOB))
		{
			request.setAttribute("trainerDOB", "<font color=red>Date of Birth is Required</font>");
			isError=true;
		}
		else
		{
			/*trainerDOB=trainerDOB.replaceAll("/", "-");
			String a[]=trainerDOB.split("-");
			trainerDOB=a[2]+"-"+a[0]+"-"+a[1];
			*/
			System.out.println(trainerDOB);
			request.setAttribute("txtTrainerDOB", trainerDOB);
			trainerBean.setTrainerDOB(trainerDOB);
		}
		if(ValidationUtils.isEmpty(trainerAddress))
		{
			request.setAttribute("trainerAddress", "<font color=red>Addreess is Required</font>");
			isError=true;
		}
		else
		{
			request.setAttribute("txtTrainerAddress", trainerAddress);
			trainerBean.setTrainerAddress(trainerAddress);
		}
		if(ValidationUtils.isEmpty(trainerPhoneNo))
		{
			request.setAttribute("trainerPhoneNo", "<font color=red>Phone No is required</font>");
			isError=true;
		}
		else
		{
			request.setAttribute("txtTrainerPhoneNo", trainerPhoneNo);
			trainerBean.setTrainerPhoneNo(trainerPhoneNo);
		}
		if(ValidationUtils.isEmpty(trainerPassword))
		{
			request.setAttribute("trainerPassword", "<font color=red>Phone No is Required</font>");
			isError=true;
		}
		else
		{
			request.setAttribute("txtTrainerPassword", trainerPassword);
			trainerBean.setTrainerPassWord(trainerPassword);
		}
		if(ValidationUtils.isEmpty(trainerExperiance))
		{
			request.setAttribute("trainerExperiance", "<font color=red>Experience is required</font>");
			isError=true;
		}
		else
		{
			request.setAttribute("txtTrainerExperiance", trainerExperiance);
			trainerBean.setTrainerExperience(trainerExperiance);
		}
		if (ValidationUtils.isEmpty(answer)) {
			isError = true;
			request.setAttribute("msgAnswer",
					" <font color=red>Answer is Required</font>");
		} 
		
		else {
			request.setAttribute("txtAnswer", answer);
			trainerBean.setAnswer(answer);
		}

		if (cityId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgCityName",
					"<font color=red>City is Required</font>");
		}
		if (areaId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgAreaName",
					"<font color=red>Area is Required</font>");
		}
		if (questionId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgQuestion",
					"<font color=red> Question Selection is Required</font>");
		} 
		if(isError)
		{
			request.getRequestDispatcher("trainerInsert.jsp").forward(request, response);
		}else{
			trainerBean.setTrainerIsActive("1");
			trainerBean.setAreaId(areaId);
			trainerBean.setCityId(cityId);
			trainerBean.setQuestionId(questionId);
			if(new TrainerDAO().insert(trainerBean)) {
				request.getRequestDispatcher("TrainerListServlet").include(request, response);
			}else{
				response.sendRedirect("trainerInsert.jsp");
			}
		}
	}

}
