<%@page import="com.designhub.fitnessplus.bean.GymDetailsBean"%>
<%@page import="com.designhub.fitnessplus.bean.AreaBean"%>
<%@page import="com.designhub.fitnessplus.dao.AreaDAO"%>
<%@page import="com.designhub.fitnessplus.bean.CityBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.dao.CityDAO"%>
<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Gym Details Update</title>


<link rel="stylesheet"
	href="fitnessplus-Cascading Style Sheet/kendo.common-material.min.css" />
<link rel="stylesheet"
	href="fitnessplus-Cascading Style Sheet/kendo.material.min.css" />

<script src="fitnessplus - Javascript/jquery.min.js"></script>
<script src="fitnessplus - Javascript/kendo.all.min.js"></script>

<link rel="stylesheet" href="admin/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="admin/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="admin/dist/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="admin/plugins/iCheck/flat/blue.css">
<link rel="stylesheet" href="admin/plugins/morris/morris.css">
<link rel="stylesheet"
	href="admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet" href="admin/plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="admin/plugins/daterangepicker/daterangepicker-bs3.css">
<link rel="stylesheet"
	href="admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

</head>
<body>
<%
		AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");
		
		if (adminBean != null && adminBean.getAdminId() != null) {
	%>
<%@ include file="admin/adminHeader.jsp"%>
<div class="content-wrapper" style="margin-top: -1000px">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		Gym Details <small>Update</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminhomepage.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Gym Details</li>
	</ol>
	
<br><br><br>
	<form method="post" action="GymDetailsUpdateServlet" method="post" name="gymDetailsEdit"
		class="form-horizontal">
		<input type="hidden" name="gymId" value="${gymDetails.gymDetailsId}${gymId}">
		<table>
		
			<tr>
				<div class="box-body">			
					<div class="form-group">
						<label class="col-sm-5 control-label">City Name</label>
						<div class="col-sm-5">
						<select name="selCityName" id="selCityName" style="padding: 5px;width: 245px;">
							
							<option value="0">Select City Name</option>
				
							<% 
								GymDetailsBean gym = (GymDetailsBean)request.getAttribute("gymDetails");		
					
								CityDAO cityDAO = new CityDAO();
						
								List<CityBean> cityList = cityDAO.list();
						
								for(int i=0;i<cityList.size();i++)
								{
									CityBean city = cityList.get(i);
									System.out.print("City-> " + city.getCityId());
									System.out.print("\nAdmin-> " + gym.getCityId());
									if(city.getCityId().equals(gym.getCityId()))
									{
										%>
											<option value="<%=city.getCityId()%>" selected="selected"><%=city.getCityName()%></option>
										<%
									}		
									else
									{
										%>
											<option value="<%=city.getCityId()%>"><%=city.getCityName()%></option>
										<%
									}
								}
							%>	
						</select>
						${msgCityName}
																		
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-5 control-label">Area Name</label>
						<div class="col-sm-5">
						<select name="selAreaName" id="selAreaName" style="padding: 5px;width: 245px;">
							
							<option value="0">Select Area Name</option>
				
							<% 
					
								AreaDAO areaDAO = new AreaDAO();
								List<AreaBean> areaList = areaDAO.list();
						
								for(int i=0;i<areaList.size();i++)
								{
									AreaBean area = areaList.get(i);
							
									if(area.getAreaId().equals(gym.getAreaId()))
									{
										%>
											<option value="<%=area.getAreaId()%>" selected="selected"><%=area.getAreaName()%></option>
										<%
									}		
									else
									{
										%>
											<option value="<%=area.getAreaId()%>" ><%=area.getAreaName()%></option>
										<%
									}
								}
							%>	
						</select>
						${msgAreaName}
																		
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-5 control-label">Gym Address </label>
						<div class="col-sm-5">
							<textarea rows="7" cols="37" maxlength="11" name="txtGymAddress">${gymDetails.gymAddress}</textarea>${gymAddress}
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-5 control-label">Gym Phone no</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Phone NO..." name="txtGymPhoneNo" maxlength="15"
								value="${gymDetails.gymPhoneNo}"> ${gymPhoneNo}
						</div>
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="col-sm-3 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="Submit" value="Ragister" name="submit"
						class="btn btn-success">
			
			</tr>					
				
		
			
		</table>
	</form>	
	<%
		} else {
			response.sendRedirect("userlogin.jsp");

		}
	%>
</body>
</html>