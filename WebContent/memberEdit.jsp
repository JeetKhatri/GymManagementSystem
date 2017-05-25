<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@page import="com.designhub.fitnessplus.bean.MemberTypeBean"%>
<%@page import="com.designhub.fitnessplus.dao.MemberTypeDAO"%>
<%@page import="com.designhub.fitnessplus.bean.PackageBean"%>
<%@page import="com.designhub.fitnessplus.dao.PackageDAO"%>
<%@page import="com.designhub.fitnessplus.bean.MemberBean"%>
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
<title>Admin | Member Insert</title>
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
			Member <small>Insert</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="admin/adminhomepage.jsp"><i
					class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Member</li>
		</ol>
		<%
			MemberBean memberBean = (MemberBean) request
						.getAttribute("memberBean");
				if (memberBean != null) {
		%>
		<form action="MemberUpdateServlet" method="post" name="memberForm"
			class="form-horizontal ">
			<input type="hidden" name="id" id="id"
			value="<%=memberBean.getMemberId()%>">
			<table>
				<tr>
					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">First Name</label>
							<div class="col-sm-3">
								<input type="text" maxlength="15" value="${memberBean.memberFirstName}"
									placeholder="Your Name" name="txtMemberFirstName"
									class="form-control"> ${memberFirstName}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Last Name</label>
							<div class="col-sm-3">
								<input type="text" maxlength="15" value="${memberBean.memberLastName}"
									placeholder="Your Name" name="txtMemberLastName"
									class="form-control"> ${memberLastName}
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-5 control-label">Email-Id</label>
							<div class="col-sm-3">
								<input type="text" maxlength="50" value="${memberBean.memberEmail}"
									placeholder="Your Name" name="txtMemberEmail"
									class="form-control"> ${memberEmail}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Phone No.</label>
							<div class="col-sm-3">
								<input type="text" maxlength="11" value="${memberBean.memberPhoneNo}"
									placeholder="Your Name" name="txtMemberPhoneNo"
									class="form-control"> ${memberPhoneNo}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Gender</label>
							<div class="col-sm-3">
								Male<input type="radio" name="rdoMemberGender" id="rdoMale"
									value="male" checked="checked" value="${rdoMemberGender}">
								Female<input type="radio" name="rdoMemberGender" id="rdoFemale"
									value="female" value="${rdoMemberGender}">
								${memberGender}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">BirthDay</label>
							<div class="col-sm-3">
								<input type="text" value="${memberBean.memberDOB}"
									placeholder="YYYY/MM/DD" maxlength="15" name="txtMemberDOB"
									class="form-control"> ${memberDOB}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Address</label>
							<div class="col-sm-3">
								<textarea rows="5" cols="30" maxlength="255" name="txtMemberAddress"
									class="form-control">${memberBean.memberAddress}</textarea>
								${memberAddress}
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
										MemberBean member = (MemberBean) request
														.getAttribute("memberBean");

												CityDAO cityDAO = new CityDAO();

												List<CityBean> cityList = cityDAO.list();

												for (int i = 0; i < cityList.size(); i++) {
													CityBean city = cityList.get(i);
													System.out.print("City-> " + city.getCityId());
													System.out.print("\nMember-> " + member.getCityId());
													if (city.getCityId().equals(member.getCityId())) {
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

													if (area.getAreaId().equals(member.getAreaId())) {
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
							<label class="col-sm-5 control-label">Member Type Name</label>
							<div class="col-sm-5">
								<select name="selMemberTypeName" id="selMemberTypeName"
									class="form-control" style="padding: 5px; width: 245px;">
									<option value="0" selected="selected">Select Member
										Type</option>
									<%
										MemberTypeDAO memberTypeDAO = new MemberTypeDAO();
												List<MemberTypeBean> memberTypeList = memberTypeDAO.list();

												for (int i = 0; i < memberTypeList.size(); i++) {
													MemberTypeBean memberType = memberTypeList.get(i);

													if (memberType.getMemberTypeId().equals(
															member.getMemberTypeId())) {
									%>
									<option value="<%=memberType.getMemberTypeId()%>"
										selected="selected"><%=memberType.getMemberTypeName()%></option>
									<%
										} else {
									%>
									<option value="<%=memberType.getMemberTypeId()%>"><%=memberType.getMemberTypeName()%></option>
									<%
										}
												}
									%>
								</select> ${msgMemberTypeName}
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

<%-- <body>
	<%
		AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");

		if (adminBean != null && adminBean.getAdminId() != null) {
	%>
	<%
		MemberBean memberBean = (MemberBean) request
					.getAttribute("memberBean");
			if (memberBean != null) {
	%>
	<form action="MemberUpdateServlet" method="post"
		name="updateMemberDetails" id="updateMemberDetails">
		<input type="hidden" name="id" id="id"
			value="<%=memberBean.getMemberId()%>">
		<table>
			<tr>
				<th align="left"><font size="5" color="blue">Member
						First Name</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td><input type="text" value="${memberBean.memberFirstName}"
					placeholder="Your Name" name="txtMemberFirstName" size="26"
					style="height: 19px; float: left;"> ${memberFirstName}</td>
			</tr>
			<tr>
				<th align="left"><font size="5" color="blue">Member Last
						Name</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td><input type="text" value="${memberBean.memberLastName}"
					placeholder="Surname" name="txtMemberLastName" size="26"
					style="height: 19px; float: left;"> ${memberLastName}</td>
			</tr>
			<tr>
				<th align="left"><font size="5" color="blue">Member
						Email</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td><input type="text" value="${memberBean.memberEmail}"
					placeholder="abc@gmail.com" name="txtMemberEmail" size="26"
					style="height: 19px; float: left;"> ${memberEmail}</td>
			</tr>
			<tr>
				<th align="left"><font size="5" color="blue">Member
						Password</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td><input type="password" value="${memberBean.memberPassword}"
					placeholder="******" name="txtMemberPassword" size="26"
					style="height: 19px; float: left;"> ${memberPassword}</td>
			</tr>
			<tr>
				<th align="left"><font size="5" color="blue">Member
						Phone NO</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td><input type="text" value="${memberBean.memberPhoneNo}"
					placeholder="1234567890" name="txtMemberPhoneNo" size="26"
					style="height: 19px; float: left;"> ${memberPhoneNo}</td>
			</tr>
			<tr>
				<th align="left"><font size="5" color="blue">Member
						Gedner</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td>Male<input type="radio" name="rdoMemberGender" id="rdoMale"
					value="male" checked="checked" value="${rdoMemberGender}">
					Female<input type="radio" name="rdoMemberGender" id="rdoFemale"
					value="female" value="${rdoMemberGender}"> ${memberGender}
				</td>
			</tr>

			<tr>
				<th align="left"><font size="5" color="blue">Member
						Birthday</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td><input type="text" value="${memberBean.memberDOB}"
					placeholder="YYYY-MM-DD" name="txtMemberDOB" size="26"
					style="height: 19px; float: left;"> ${memberDOB}</td>
			</tr>

			<tr>
				<th align="left"><font size="5" color="blue">Member
						Address</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td><textarea rows="5" cols="30" name="txtMemberAddress">${memberBean.memberAddress}</textarea>
					${memberAddress}</td>
			</tr>

			<tr>
				<th align="left"><font size="5" color="blue">City Name</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td><select name="selCityName" id="selCityName">
						<option value="0" selected="selected">Select City</option>
						<%
							MemberBean member = (MemberBean) request
											.getAttribute("memberBean");

									CityDAO cityDAO = new CityDAO();

									List<CityBean> cityList = cityDAO.list();

									for (int i = 0; i < cityList.size(); i++) {
										CityBean city = cityList.get(i);
										System.out.print("City-> " + city.getCityId());
										System.out.print("\nMember-> " + member.getCityId());
										if (city.getCityId().equals(member.getCityId())) {
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
				</select> ${msgCityName}</td>
			</tr>

			<tr>
				<th align="left"><font size="5" color="blue">Area Name</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td><select name="selAreaName" id="selAreaName">
						<option value="0" selected="selected">Select Area</option>
						<%
							AreaDAO areaDAO = new AreaDAO();
									List<AreaBean> areaList = areaDAO.list();

									for (int i = 0; i < areaList.size(); i++) {
										AreaBean area = areaList.get(i);

										if (area.getAreaId().equals(member.getAreaId())) {
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
				</select> ${msgAreaName}</td>
			</tr>

			<tr>
				<th align="left"><font size="5" color="blue">Member Type
						Name</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td><select name="selMemberTypeName" id="selMemberTypeName">
						<option value="0" selected="selected">Select Member Type</option>
						<%
							MemberTypeDAO memberTypeDAO = new MemberTypeDAO();
									List<MemberTypeBean> memberTypeList = memberTypeDAO.list();

									for (int i = 0; i < memberTypeList.size(); i++) {
										MemberTypeBean memberType = memberTypeList.get(i);

										if (memberType.getMemberTypeId().equals(
												member.getMemberTypeId())) {
						%>
						<option value="<%=memberType.getMemberTypeId()%>"
							selected="selected"><%=memberType.getMemberTypeName()%></option>
						<%
							} else {
						%>
						<option value="<%=memberType.getMemberTypeId()%>"><%=memberType.getMemberTypeName()%></option>
						<%
							}
									}
						%>
				</select> ${msgMemberTypeName}</td>
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
</html> --%>