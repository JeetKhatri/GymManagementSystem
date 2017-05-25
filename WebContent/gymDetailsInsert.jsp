<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@page import="com.designhub.fitnessplus.bean.CityBean"%>
<%@page import="com.designhub.fitnessplus.dao.CityDAO"%>
<%@page import="com.designhub.fitnessplus.bean.AreaBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.dao.AreaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Gym Details Insert</title>


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
			Area <small>Insert</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="adminhomepage.jsp"><i class="fa fa-dashboard"></i>
					Home</a>
			</li>
			<li class="active">Area</li>
		</ol>

		<br>
		<br>
		<br>
		<form method="post" action="GymDetailsInsertServlet" method="post"
			name="gymDetailForm" class="form-horizontal">

			<table>
				<tr>

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

					<div class="form-group">
						<label class="col-sm-5 control-label">Gym Address</label>
						<div class="col-sm-3">
							<textarea rows="7" cols="37" maxlength="255" name="txtGymAddress">${txtGymAddress}</textarea>
							${gymAddress}
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-5 control-label">Gym Phone no</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Enter Mobile No." name="txtGymPhoneNo"
								maxlength="11" value="${txtGymPhoneNo}"> ${gymPhoneNo}

						</div>
					</div>
					<br>
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
		</section>
		</div>

		<%
			} else {
				response.sendRedirect("userlogin.jsp");

			}
		%>
		
</body>
</html>