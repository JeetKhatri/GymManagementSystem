<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@page import="com.designhub.fitnessplus.bean.AreaBean"%>
<%@page import="com.designhub.fitnessplus.dao.AreaDAO"%>
<%@page import="com.designhub.fitnessplus.bean.CityBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.dao.CityDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Admin Insert</title>
<link href="admin/bootstrap/css/registration.css" rel="stylesheet"
	type="text/css">

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



<script type='text/javascript'
	src='/GymManagementSystem/dwr/interface/AjaxDataDAO.js'></script>
<script type='text/javascript' src='/GymManagementSystem/dwr/engine.js'></script>
<script type='text/javascript' src='/GymManagementSystem/dwr/util.js'></script>

<script type="text/javascript">
	function getReply(cityId) {
		dwr.util.removeAllOptions("selAreaName");

		if (cityId == '') {
			var data = [ {
				areaName : '-- Select --',
				areaId : ''
			} ];
			dwr.util.addOptions("selAreaName", data, "areaId", "areaName");
		} else {
			AjaxDataDAO.getAllArea(cityId, function(data) {
				dwr.util.addOptions("selAreaName", data, "areaId", "areaName");
			});
		}
	}
</script>

<link rel="stylesheet"
	href="fitnessplus-Cascading Style Sheet/kendo.common-material.min.css" />
<link rel="stylesheet"
	href="fitnessplus-Cascading Style Sheet/kendo.material.min.css" />

<script src="fitnessplus - Javascript/jquery.min.js"></script>
<script src="fitnessplus - Javascript/kendo.all.min.js"></script>






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
			Admin <small>Insert</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="adminhomepage.jsp"><i
					class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Admin</li>
		</ol>

		

		<form action="AdminInsertServlet" method="post" name="adminForm"
			class="form-horizontal ">
			<table>
				<tr>
					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">First Name</label>
							<div class="col-sm-3">
								<input type="text" maxlength="15" value="${txtAdminFirstName}"
									class="form-control" placeholder="Your Name"
									name="txtAdminFirstName">${adminFirstName}
							</div>
						</div>
					</div>

					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Last Name</label>
							<div class="col-sm-3">
								<input type="text" maxlength="15" value="${txtAdminLastName}"
									class="form-control" placeholder="Your Name"
									name="txtAdminLastName">${adminLastName}
							</div>
						</div>
					</div>

					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Email</label>
							<div class="col-sm-3">
								<input type="text" maxlength="50" value="${txtAdminEmail}"
									class="form-control" placeholder="Your Email"
									name="txtAdminEmail" >${adminEmail}
							</div>
						</div>
					</div>

					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Passsword</label>
							<div class="col-sm-3">
								<input type="password" maxlength="15" value="${txtAdminPassword}"
									class="form-control" placeholder="Your Password"
									name="txtAdminPassword" >${adminPassword}
							</div>
						</div>
					</div>


					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Phone No</label>
							<div class="col-sm-3">
								<input type="text" maxlength="11" value="${txtAdminPhoneNo}"
									class="form-control" placeholder="Your Phone No"
									name="txtAdminPhoneNo" >${adminPhoneNo}
							</div>
						</div>
					</div>


					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Birth Date</label>
							<div class="col-sm-3">
								<input type="text" maxlength="25" value="${txtAdminDOB}"
									class="form-control" placeholder="Your Birth Date"
									name="txtAdminDOB" >${adminDOB}
							</div>
						</div>
					</div>
						<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Gender</label>
							<div class="col-sm-3">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="rdoAdminGender" id="rdoMale"
									value="male" checked="checked" value="${rdoAdminGender}">Male
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="rdoAdminGender" id="rdoFemale"
									value="female" value="${rdoAdminGender}"> Female ${adminGender}
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-5 control-label">Address</label>
						<div class="col-sm-3">
							<textarea rows="7" cols="37" maxlength="255" name="txtAdminAddress">${txtAdminAddress}</textarea>
							${adminAddress}
						</div>
					</div>



					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">City</label>
							<div class="col-sm-3">
								<select name="selCityName" id="selCityName"
									onChange="java:getReply(this.value)"
									style="padding: 5px; width: 245px;">
									<option value="0" selected="selected">Select City</option>
									<%
										CityDAO cityDAO = new CityDAO();
										List<CityBean> cityList = cityDAO.list();

										for (int i = 0; i < cityList.size(); i++) {

											String tmp = "unselected";
											String type = request.getParameter("selCityName");
											if (type == null)
												tmp = "unselected";
											else if (cityList.get(i).getCityId().equals(type))
												tmp = "selected";
									%>

									<option value=<%=cityList.get(i).getCityId()%> <%=tmp%>>
										<%=cityList.get(i).getCityName()%></option>
									<%
										}
									%>
								</select> ${msgCityName}
							</div>
						</div>
					</div>

					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Area </label>
							<div class="col-sm-3">
								<select name="selAreaName" id="selAreaName"
									style="padding: 5px; width: 245px;">

									<option value="">---Select Area---</option>

								</select> ${msgAreaName}
							</div>
						</div>
					</div>

				</tr>






				<%-- 
				<tr>
					<th align="left"><font size="5" color="blue">Admin
							Phone NO</font></th>
					<th><font size="5" color="red">:</font></th>
					<td><input type="text" value="${txtAdminPhoneNo}"
						placeholder="1234567890" name="txtAdminPhoneNo" size="26"
						style="height: 19px; float: left;" required pattern="[0-9\ ]+">

					</td>
				</tr>
				<tr>
					<th align="left"><font size="5" color="blue">Admin
							Gedner</font></th>
					<th><font size="5" color="red">:</font></th>
					<td>Male<input type="radio" name="rdoAdminGender" id="rdoMale"
						value="male" checked="checked" value="${rdoAdminGender}">
						Female<input type="radio" name="rdoAdminGender" id="rdoFemale"
						value="female" value="${rdoAdminGender}">
					</td>
				</tr>

				<tr>
					<th align="left"><font size="5" color="blue">Admin
							Birthday</font></th>
					<th><font size="5" color="red">:</font></th>
					<td><input id="datepicker" value="${txtAdminDOB}"
						placeholder="YYYY-MM-DD" name="txtAdminDOB" size="26" required>
					</td>
					<script>
						$(document).ready(function() {
							$("#datepicker").kendoDatePicker();

							$("#monthpicker").kendoDatePicker({
								start : "year",

								depth : "year",

								format : "MMMM yyyy"
							});
						});
					</script>
				</tr>


				<tr>
					<th>&nbsp;</th>
					<td>&nbsp;</td>
				</tr>

				<tr>
					<th align="left"><font size="5" color="blue">Admin
							Address</font></th>
					<th><font size="5" color="red">:</font></th>
					<td><textarea rows="5" cols="30" name="txtAdminAddress">${txtAdminAddress}</textarea>
						${adminAddress}</td>
				</tr>

				<tr>
					<th align="left"><font size="5" color="blue">City Name</font></th>
					<th><font size="5" color="red">:</font></th>
					<td><select name="selCityName" id="selCityName"
						onChange="java:getReply(this.value)">
							<option value="0" selected="selected">Select City</option>
							<%
								CityDAO cityDAO = new CityDAO();
								List<CityBean> cityList = cityDAO.list();

								for (int i = 0; i < cityList.size(); i++) {

									String tmp = "unselected";
									String type = request.getParameter("selCityName");
									if (type == null)
										tmp = "unselected";
									else if (cityList.get(i).getCityId().equals(type))
										tmp = "selected";
							%>

							<option value=<%=cityList.get(i).getCityId()%> <%=tmp%>>
								<%=cityList.get(i).getCityName()%></option>
							<%
								}
							%>
					</select> ${msgCityName}</td>
				</tr>

				<tr>
					<th align="left"><font size="5" color="blue">Area Name</font></th>
					<th><font size="5" color="red">:</font></th>
					<td><select name="selAreaName" id="selAreaName">

							<option value="">---Select Area---</option>

					</select> ${msgAreaName}</td>

				</tr>

				<tr>
					<td align="center"><br> <input type="reset" value="Reset"
						name="reset"
						style="background-color: red; color: white; width: 100px; height: 30px">
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="Submit" value="Ragister" name="submit"
						style="background-color: Green; color: white; width: 100px; height: 30px">
					</td>
				</tr>
 --%>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label class="col-sm-3 control-label"></label>
				<input type="reset" value="Reset" name="reset"
					class="btn  btn-danger">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="Submit" value="Ragister" name="submit"
					class="btn btn-success">

			</table>
		</form>
		<%
		} else {
			response.sendRedirect("userlogin.jsp");

		}
	%>
</body>
</html>











<%-- <%@page import="com.designhub.fitnessplus.bean.AreaBean"%>
<%@page import="com.designhub.fitnessplus.dao.AreaDAO"%>
<%@page import="com.designhub.fitnessplus.bean.CityBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.dao.CityDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Admin Insert</title>
<link href="admin/bootstrap/css/registration.css" rel="stylesheet"
	type="text/css">

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



<script type='text/javascript'
	src='/GymManagementSystem/dwr/interface/AjaxDataDAO.js'></script>
<script type='text/javascript' src='/GymManagementSystem/dwr/engine.js'></script>
<script type='text/javascript' src='/GymManagementSystem/dwr/util.js'></script>

<script type="text/javascript">
	function getReply(cityId) {
		dwr.util.removeAllOptions("selAreaName");

		if (cityId == '') {
			var data = [ {
				areaName : '-- Select --',
				areaId : ''
			} ];
			dwr.util.addOptions("selAreaName", data, "areaId", "areaName");
		} else {
			AjaxDataDAO.getAllArea(cityId, function(data) {
				dwr.util.addOptions("selAreaName", data, "areaId", "areaName");
			});
		}
	}
</script>

<link rel="stylesheet"
	href="fitnessplus-Cascading Style Sheet/kendo.common-material.min.css" />
<link rel="stylesheet"
	href="fitnessplus-Cascading Style Sheet/kendo.material.min.css" />

<script src="fitnessplus - Javascript/jquery.min.js"></script>
<script src="fitnessplus - Javascript/kendo.all.min.js"></script>






</head>
<body>
	<%@ include file="admin/adminHeader.html"%>
	<div class="content-wrapper" style="margin-top: -700px">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Admin <small>Insert</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="admin/adminhomepage.jsp"><i
					class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Admin</li>
		</ol>

		

		<form action="AdminInsertServlet" method="post" name="adminForm"
			class="form-horizontal ">
			<table>
				<tr>
					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">First Name</label>
							<div class="col-sm-3">
								<input type="text" value="${txtAdminFirstName}"
									class="form-control" placeholder="Your Name"
									name="txtAdminFirstName" pattern="[a-zA-Z\ ]+">
							</div>
						</div>
					</div>

					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Last Name</label>
							<div class="col-sm-3">
								<input type="text" value="${txtAdminLastName}"
									class="form-control" placeholder="Your Name"
									name="txtAdminLastName" pattern="[a-zA-Z\ ]+">
							</div>
						</div>
					</div>

					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Email</label>
							<div class="col-sm-3">
								<input type="email" value="${txtAdminEmail}"
									class="form-control" placeholder="Your Email"
									name="txtAdminEmail" >
							</div>
						</div>
					</div>

					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Passsword</label>
							<div class="col-sm-3">
								<input type="password" value="${txtAdminPassword}"
									class="form-control" placeholder="Your Password"
									name="txtAdminPassword" >
							</div>
						</div>
					</div>


					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Phone No</label>
							<div class="col-sm-3">
								<input type="text" value="${txtAdminPhoneNo}"
									class="form-control" placeholder="Your Phone No"
									name="txtAdminPhoneNo" >
							</div>
						</div>
					</div>


					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Birth Date</label>
							<div class="col-sm-3">
								<input type="text" value="${txtAdminDOB}"
									class="form-control" placeholder="Your Birth Date"
									name="txtAdminDOB" >
							</div>
						</div>
					</div>





					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Gender</label>
							<div class="col-sm-3">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="rdoAdminGender" id="rdoMale"
									value="male" checked="checked" value="${rdoAdminGender}">Male
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="rdoAdminGender" id="rdoFemale"
									value="female" value="${rdoAdminGender}">Female
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-5 control-label">Address</label>
						<div class="col-sm-3">
							<textarea rows="7" cols="37" name="txtAdminAddress">${txtAdminAddress}</textarea>
							${adminAddress}
						</div>
					</div>



					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">City</label>
							<div class="col-sm-3">
								<select name="selCityName" id="selCityName"
									onChange="java:getReply(this.value)"
									style="padding: 5px; width: 245px;">
									<option value="0" selected="selected">Select City</option>
									<%
										CityDAO cityDAO = new CityDAO();
										List<CityBean> cityList = cityDAO.list();

										for (int i = 0; i < cityList.size(); i++) {

											String tmp = "unselected";
											String type = request.getParameter("selCityName");
											if (type == null)
												tmp = "unselected";
											else if (cityList.get(i).getCityId().equals(type))
												tmp = "selected";
									%>

									<option value=<%=cityList.get(i).getCityId()%> <%=tmp%>>
										<%=cityList.get(i).getCityName()%></option>
									<%
										}
									%>
								</select> ${msgCityName}
							</div>
						</div>
					</div>

					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">Area </label>
							<div class="col-sm-3">
								<select name="selAreaName" id="selAreaName"
									style="padding: 5px; width: 245px;">

									<option value="">---Select Area---</option>

								</select> ${msgAreaName}
							</div>
						</div>
					</div>

				</tr>






				
				<tr>
					<th align="left"><font size="5" color="blue">Admin
							Phone NO</font></th>
					<th><font size="5" color="red">:</font></th>
					<td><input type="text" value="${txtAdminPhoneNo}"
						placeholder="1234567890" name="txtAdminPhoneNo" size="26"
						style="height: 19px; float: left;" required pattern="[0-9\ ]+">

					</td>
				</tr>
				<tr>
					<th align="left"><font size="5" color="blue">Admin
							Gedner</font></th>
					<th><font size="5" color="red">:</font></th>
					<td>Male<input type="radio" name="rdoAdminGender" id="rdoMale"
						value="male" checked="checked" value="${rdoAdminGender}">
						Female<input type="radio" name="rdoAdminGender" id="rdoFemale"
						value="female" value="${rdoAdminGender}">
					</td>
				</tr>

				<tr>
					<th align="left"><font size="5" color="blue">Admin
							Birthday</font></th>
					<th><font size="5" color="red">:</font></th>
					<td><input id="datepicker" value="${txtAdminDOB}"
						placeholder="YYYY-MM-DD" name="txtAdminDOB" size="26" required>
					</td>
					<script>
						$(document).ready(function() {
							$("#datepicker").kendoDatePicker();

							$("#monthpicker").kendoDatePicker({
								start : "year",

								depth : "year",

								format : "MMMM yyyy"
							});
						});
					</script>
				</tr>


				<tr>
					<th>&nbsp;</th>
					<td>&nbsp;</td>
				</tr>

				<tr>
					<th align="left"><font size="5" color="blue">Admin
							Address</font></th>
					<th><font size="5" color="red">:</font></th>
					<td><textarea rows="5" cols="30" name="txtAdminAddress">${txtAdminAddress}</textarea>
						${adminAddress}</td>
				</tr>

				<tr>
					<th align="left"><font size="5" color="blue">City Name</font></th>
					<th><font size="5" color="red">:</font></th>
					<td><select name="selCityName" id="selCityName"
						onChange="java:getReply(this.value)">
							<option value="0" selected="selected">Select City</option>
							<%
								CityDAO cityDAO = new CityDAO();
								List<CityBean> cityList = cityDAO.list();

								for (int i = 0; i < cityList.size(); i++) {

									String tmp = "unselected";
									String type = request.getParameter("selCityName");
									if (type == null)
										tmp = "unselected";
									else if (cityList.get(i).getCityId().equals(type))
										tmp = "selected";
							%>

							<option value=<%=cityList.get(i).getCityId()%> <%=tmp%>>
								<%=cityList.get(i).getCityName()%></option>
							<%
								}
							%>
					</select> ${msgCityName}</td>
				</tr>

				<tr>
					<th align="left"><font size="5" color="blue">Area Name</font></th>
					<th><font size="5" color="red">:</font></th>
					<td><select name="selAreaName" id="selAreaName">

							<option value="">---Select Area---</option>

					</select> ${msgAreaName}</td>

				</tr>

				<tr>
					<td align="center"><br> <input type="reset" value="Reset"
						name="reset"
						style="background-color: red; color: white; width: 100px; height: 30px">
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="Submit" value="Ragister" name="submit"
						style="background-color: Green; color: white; width: 100px; height: 30px">
					</td>
				</tr>

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label class="col-sm-3 control-label"></label>
				<input type="reset" value="Reset" name="reset"
					class="btn  btn-danger">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="Submit" value="Ragister" name="submit"
					class="btn btn-success">

			</table>
		</form>
</body>
</html> --%>