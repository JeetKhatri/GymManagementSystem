<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@page import="com.designhub.fitnessplus.bean.PackageBean"%>
<%@page import="com.designhub.fitnessplus.dao.PackageDAO"%>
<%@page import="com.designhub.fitnessplus.bean.TrainerBean"%>
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
<title>Admin | Trainer Insert</title>
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
		AdminBean adminBean1 = (AdminBean) session
				.getAttribute("adminBean");

		if (adminBean1 != null && adminBean1.getAdminId() != null) {
	%>
	<%@ include file="admin/adminHeader.jsp"%>
	<div class="content-wrapper" style="margin-top: -1000px">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Trainer <small>Insert</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="admin/adminhomepage.jsp"><i
					class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Trainer</li>
		</ol>
		<%
			TrainerBean trainerBean = (TrainerBean) request
						.getAttribute("trainerBean");
				if (trainerBean != null) {
		%>
		<form action="TrainerUpdateServlet" method="post" name="trainerForm"
			class="form-horizontal ">
			<input type="hidden" name="trainerId" id="trainerId"
			value="<%=trainerBean.getTrainerId()%>">
			<table>
				<tr>
					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">First Name</label>
							<div class="col-sm-3">
								<input type="text" value="${trainerBean.trainerFirstName}"
									placeholder="Your Name" name="txtTrainerFirstName"
									class="form-control"> ${trainerFirstName}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Last Name</label>
							<div class="col-sm-3">
								<input type="text" value="${trainerBean.trainerLastName}"
									placeholder="Your Name" name="txtTrainerLastName"
									class="form-control"> ${trainerLastName}
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-5 control-label">Email-Id</label>
							<div class="col-sm-3">
								<input type="text" value="${trainerBean.trainerEmail}"
									placeholder="Your Name" name="txtTrainerEmail"
									class="form-control"> ${trainerEmail}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Phone No.</label>
							<div class="col-sm-3">
								<input type="text" value="${trainerBean.trainerPhoneNo}"
									placeholder="Your Name" name="txtTrainerPhoneNo"
									class="form-control"> ${trainerPhoneNo}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Gender</label>
							<div class="col-sm-3">
								Male<input type="radio" name="rdbTrainerGender" id="rdoMale"
									value="male" checked="checked" value="${rdoTrainerGender}">
								Female<input type="radio" name=rdbTrainerGender id="rdoFemale"
									value="female" value="${rdoTrainerGender}">
								${trainerGender}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">BirthDay</label>
							<div class="col-sm-3">
								<input type="text" value="${trainerBean.trainerDOB}"
									placeholder="01/01/1999" name="txtTrainerDOB"
									class="form-control"> ${trainerDOB}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Address</label>
							<div class="col-sm-3">
								<textarea rows="5" cols="30" name="txtareaTrainerAddress"
									class="form-control">${trainerBean.trainerAddress}</textarea>
								${trainerAddress}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">City Name</label>
							<div class="col-sm-5">
								<select name="selCityName" id="selCityName" class="form-control"
									style="padding: 5px; width: 245px;">
									<option value="0" selected="selected" class="form-control">Select
										City</option>
									<%
										TrainerBean trainer = (TrainerBean) request
														.getAttribute("trainerBean");

												CityDAO cityDAO = new CityDAO();

												List<CityBean> cityList = cityDAO.list();

												for (int i = 0; i < cityList.size(); i++) {
													CityBean city = cityList.get(i);
													System.out.print("City-> " + city.getCityId());
													System.out.print("\nTrainer-> " + trainer.getCityId());
													if (city.getCityId().equals(trainer.getCityId())) {
									%>
									<option value="<%=city.getCityId()%>" selected="selected"><%=city.getCityName()%></option>
									<%
										} else {
									%>
									<option value="<%=city.getCityId()%>"><%=city.getCityName()%></option>
									<%
										}
												}
									%>
								</select> ${msgCityName}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Area Name</label>
							<div class="col-sm-5">
								<select name="selAreaName" id="selAreaName" class="form-control"
									style="padding: 5px; width: 245px;">
									<option value="0" selected="selected">Select Area</option>
									<%
										AreaDAO areaDAO = new AreaDAO();
												List<AreaBean> areaList = areaDAO.list();

												for (int i = 0; i < areaList.size(); i++) {
													AreaBean area = areaList.get(i);

													if (area.getAreaId().equals(trainer.getAreaId())) {
									%>
									<option value="<%=area.getAreaId()%>" selected="selected"><%=area.getAreaName()%></option>
									<%
										} else {
									%>
									<option value="<%=area.getAreaId()%>"><%=area.getAreaName()%></option>
									<%
										}
												}
									%>
								</select> ${msgAreaName}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Trainer's
						Experiance in Year</label>
							<div class="col-sm-3">
								<input type="text" value="<%=trainerBean.getTrainerExperience()%>"
									placeholder="Your Name" name="txtTrainerExperiance"
									class="form-control"> ${trainerExperiance}
							</div>
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
				<%
					}
				%>
			</table>
		</form>
		<%
			} else {
				response.sendRedirect("userlogin.jsp");

			}
		%>
		
</body>
</html>

