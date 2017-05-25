package com.designhub.fitnessplus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designhub.fitnessplus.bean.MemberProgressDetailsBean;
import com.designhub.fitnessplus.dao.MemberProgressDetailsDAO;
import com.designhub.fitnessplus.util.ValidationUtils;

@SuppressWarnings("serial")
public class MemberProgressDetailsInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String progressDate=dateformat.format(date);
		
		System.out.println(progressDate);
		
		String height= (request.getParameter("txtHeight"));
		String weight= (request.getParameter("txtWeight"));
		String bmi= (request.getParameter("txtBmi"));
		String biceps= (request.getParameter("txtBiceps"));
		String hips= (request.getParameter("txtHips"));
		String thigh= (request.getParameter("txtThigh"));
		String neck= (request.getParameter("txtNeck"));
		String forearms= (request.getParameter("txtForearms"));
		String chest= (request.getParameter("txtChest"));
		String calves= (request.getParameter("txtCalves"));
		String bodyfat= (request.getParameter("txtBodyfat"));
		String waist= (request.getParameter("txtWaist"));
		String memberId=(request.getParameter("memberId"));
		String month=(request.getParameter("selMonth"));
		String year=(request.getParameter("selYear"));
		boolean isError=false;
		MemberProgressDetailsBean progressbean=new MemberProgressDetailsBean();
		request.setAttribute("memberId", memberId);
		//System.out.println("memberId->>"+memberId);
		if(ValidationUtils.isEmpty(height))
		{
			request.setAttribute("height", "*");
			isError=true;
		}
		else
		{
			progressbean.setHeight(height);
			request.setAttribute("txtheight", height);
		}
		if(ValidationUtils.isEmpty(weight))
		{
			request.setAttribute("weight", "*");
			isError=true;
		}
		else
		{
			progressbean.setWeight(weight);
			request.setAttribute("txtweight", weight);
		}
		if(ValidationUtils.isEmpty(bmi))
		{
			request.setAttribute("bmi", "*");
			isError=true;
		}
		else
		{
			progressbean.setBmi(bmi);
			request.setAttribute("txtbmi", bmi);
		}
		if(ValidationUtils.isEmpty(biceps))
		{
			request.setAttribute("biceps", "*");
			isError=true;
		}
		else
		{
			progressbean.setBiceps(biceps);
			request.setAttribute("txtbiceps", biceps);
		}
		if(ValidationUtils.isEmpty(hips))
		{
			request.setAttribute("hips", "*");
			isError=true;
		}
		else
		{
			progressbean.setHips(hips);
			request.setAttribute("txthips", hips);
		}
		if(ValidationUtils.isEmpty(thigh))
		{
			request.setAttribute("thigh", "*");
			isError=true;
		}
		else
		{
			progressbean.setThigh(thigh);
			request.setAttribute("txtthigh", thigh);
		}
		if(ValidationUtils.isEmpty(neck))
		{
			request.setAttribute("neck", "*");
			isError=true;
		}
		else
		{
			progressbean.setNeck(neck);
			request.setAttribute("txtneck", neck);
		}
		if(ValidationUtils.isEmpty(forearms))
		{
			request.setAttribute("forearms","*");
			isError=true;
		}
		else
		{
			progressbean.setForearms(forearms);
			request.setAttribute("txtforearms", forearms);
			
		}
		if(ValidationUtils.isEmpty(chest))
		{
			request.setAttribute("chest","*");
			isError=true;
		}
		else
		{
			progressbean.setChest(chest);
			request.setAttribute("txtchest", chest);
		}
		if(ValidationUtils.isEmpty(calves))
		{
			request.setAttribute("calves","*");
			isError=true;
		}
		else
		{
			progressbean.setCalves(calves);
			request.setAttribute("txtcalves", calves);
		}
		if(ValidationUtils.isEmpty(bodyfat))
		{
			request.setAttribute("bodyfat", "*");
			isError=true;
		}
		else
		{
			progressbean.setBodyfat(bodyfat);
			request.setAttribute("txtbodyfat",bodyfat);
		}
		if(ValidationUtils.isEmpty(waist))
		{
			request.setAttribute("waist","*");
			isError=true;
		}
		else
		{
			progressbean.setWaist(waist);
			request.setAttribute("txtwaist", waist);
		}
		if(ValidationUtils.isEmpty(month))
		{
			request.setAttribute("month", "*");
			isError=true;
		}
		else {
			request.setAttribute("selMonth", month);
		}
		if(ValidationUtils.isEmpty(year))
		{
			request.setAttribute("year", "*");
			isError=true;
		}
		else {
			request.setAttribute("selYear", year);
		}
		if(isError){
			request.setAttribute("progressbean",progressbean);
			request.getRequestDispatcher("progressInsert.jsp?memberId="+memberId).forward(request, response);
		}
		else
		{	
			progressbean.setMemberId(memberId);
			progressbean.setDatetime(year+"-"+month);
			if(new MemberProgressDetailsDAO().insert(progressbean))
			{
				request.getRequestDispatcher("memberProgressDetailsListServlet?memberId"+memberId).include(request, response);
			}
			else{
			}
			/*{
			MemberProgressBean memberProgressBean=new MemberProgressBean();
			memberProgressBean.setMemberId(txtmemberId);
			String progressId="";
				if(new MemberProgressDAO().insert(memberProgressBean))
				{
					progressId=new MemberProgressDAO().getProgressIDByMemberId(txtmemberId);
				}
			progressbean.setProgressId(progressId);
			request.setAttribute("progressId", progressId);
			progressbean.setDatetime(year+"-"+month);
			if(new ProgressDAO().insert(progressbean))
			{
				PrintWriter out = response.getWriter();
				out.write("<font color=RED size=6><center>Progress Saved...</center></font>");
				request.getRequestDispatcher("progressDetailListServlet").include(request, response);
			}
		}*/
		}
	}
}
