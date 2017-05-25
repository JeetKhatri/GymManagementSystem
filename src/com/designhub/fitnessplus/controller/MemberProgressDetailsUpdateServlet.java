package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberProgressDetailsBean;
import com.designhub.fitnessplus.dao.ProgressDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

@SuppressWarnings("serial")
public class MemberProgressDetailsUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String memberId=request.getParameter("memberId");
		String height = (request.getParameter("txtHeight"));
		String weight = (request.getParameter("txtWeight"));
		String bmi = (request.getParameter("txtBmi"));
		String biceps = (request.getParameter("txtBiceps"));
		String hips = (request.getParameter("txtHips"));
		String thigh = (request.getParameter("txtThigh"));
		String neck = (request.getParameter("txtNeck"));
		String forearms = (request.getParameter("txtForearms"));
		String chest = (request.getParameter("txtChest"));
		String calves = (request.getParameter("txtCalves"));
		String bodyfat = (request.getParameter("txtBodyfat"));
		String waist = (request.getParameter("txtWaist"));
		String date=(request.getParameter("txtDate"));
		String progressDetailsId =(request.getParameter("progressDetailsId"));
		
		boolean isError = false;
		MemberProgressDetailsBean progressbean = new MemberProgressDetailsBean();
		if (ValidationUtils.isEmpty(height)) {
			request.setAttribute("height", "*");
			isError = true;
		} else {
			progressbean.setHeight(height);
			request.setAttribute("txtheight", height);
		}
		if (ValidationUtils.isEmpty(weight)) {
			request.setAttribute("weight", "*");
			isError = true;
		} else {
			progressbean.setWeight(weight);
			request.setAttribute("txtweight", weight);
		}
		if (ValidationUtils.isEmpty(bmi)) {
			request.setAttribute("bmi", "*");
			isError = true;
		} else {
			progressbean.setBmi(bmi);
			request.setAttribute("txtbmi", bmi);
		}
		if (ValidationUtils.isEmpty(biceps)) {
			request.setAttribute("biceps", "*");
			isError = true;
		} else {
			progressbean.setBiceps(biceps);
			request.setAttribute("txtbiceps", biceps);
		}
		if (ValidationUtils.isEmpty(hips)) {
			request.setAttribute("hips", "*");
			isError = true;
		} else {
			progressbean.setHips(hips);
			request.setAttribute("txthips", hips);
		}
		if (ValidationUtils.isEmpty(thigh)) {
			request.setAttribute("thigh", "*");
			isError = true;
		} else {
			progressbean.setThigh(thigh);
			request.setAttribute("txtthigh", thigh);
		}
		if (ValidationUtils.isEmpty(neck)) {
			request.setAttribute("neck", "*");
			isError = true;
		} else {
			progressbean.setNeck(neck);
			request.setAttribute("txtneck", neck);
		}
		if (ValidationUtils.isEmpty(forearms)) {
			request.setAttribute("forearms", "*");
			isError = true;
		} else {
			progressbean.setForearms(forearms);
			request.setAttribute("txtforearms", forearms);

		}
		if (ValidationUtils.isEmpty(chest)) {
			request.setAttribute("chest", "*");
			isError = true;
		} else {
			progressbean.setChest(chest);
			request.setAttribute("txtchest", chest);
		}
		if (ValidationUtils.isEmpty(calves)) {
			request.setAttribute("calves", "*");
			isError = true;
		} else {
			progressbean.setCalves(calves);
			request.setAttribute("txtcalves", calves);
		}
		if (ValidationUtils.isEmpty(bodyfat)) {
			request.setAttribute("bodyfat", "*");
			isError = true;
		} else {
			progressbean.setBodyfat(bodyfat);
			request.setAttribute("txtbodyfat", bodyfat);
		}
		if (ValidationUtils.isEmpty(waist)) {
			request.setAttribute("waist", "*");
			isError = true;
		} else {
			progressbean.setWaist(waist);
			request.setAttribute("txtwaist", waist);
		}
		if (isError) {
			progressbean.setProgressDetailId(progressDetailsId);
			progressbean.setDatetime(date);
			request.setAttribute("progressBean", progressbean);
			request.getRequestDispatcher("memberProgressDetailsEdit.jsp").forward(request,
					response);
		} else {
			
			
			progressbean.setProgressDetailId(progressDetailsId);
			// System.out.println(progressDetailsId);
			if (new ProgressDAO().update(progressbean)) {
				System.out.println("Update--Membee===="+memberId);
				request.getRequestDispatcher("memberProgressDetailsListServlet?memberId="+memberId).include(request, response);
			}
		}
	}

}
