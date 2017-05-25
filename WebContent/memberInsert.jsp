<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@page import="com.designhub.fitnessplus.bean.SecurityQuestionsBean"%>
<%@page import="com.designhub.fitnessplus.dao.SecurityQuestionsDAO"%>
<%@page import="com.designhub.fitnessplus.bean.PackageDurationBean"%>
<%@page import="com.designhub.fitnessplus.dao.PackageDurationDAO"%>
<%@page import="com.designhub.fitnessplus.bean.MemberTypeBean"%>
<%@page import="com.designhub.fitnessplus.dao.MemberTypeDAO"%>
<%@page import="com.designhub.fitnessplus.bean.PackageBean"%>
<%@page import="com.designhub.fitnessplus.dao.PackageDAO"%>
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
		AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");

		if (adminBean != null && adminBean.getAdminId() != null) {
	%>
	<%@ include file="admin/adminHeader.jsp"%>
	<div class="content-wrapper" style="margin-top: -1000px">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Member <small>Insert</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="adminhomepage.jsp"><i class="fa fa-dashboard"></i>
					Home</a>
			</li>
			<li class="active">Member</li>
		</ol>


		<form action="MemberInsertServlet" method="post" name="cityForm"
			class="form-horizontal">
			<table>
				<tr>
					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-5 control-label">First Name</label>
							<div class="col-sm-3">
								<input type="text" maxlength="15" value="${txtMemberFirstName}"
									class="form-control" placeholder="Your Name"
									name="txtMemberFirstName">${memberFirstName }
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-5 control-label">Last Name</label>
							<div class="col-sm-3">
								<input type="text" maxlength="15" value="${txtMemberLastName}"
									class="form-control" placeholder="Your Name"
									name="txtMemberLastName">${memberLastName }
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-5 control-label">Email</label>
							<div class="col-sm-3">
								<input type="email" maxlength="50" value="${txtMemberEmail}"
									class="form-control" placeholder="Your Email"
									name="txtMemberEmail">${memberEmail }
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-5 control-label">Passsword</label>
							<div class="col-sm-3">
								<input type="password" maxlength="15" value="${txtMemberPassword}"
									class="form-control" placeholder="Your Password"
									name="txtMemberPassword">${memberPassword }
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Phone No</label>
							<div class="col-sm-3">
								<input type="text" maxlength="11" value="${txtMemberPhoneNo}"
									class="form-control" placeholder="Your Phone No"
									name="txtMemberPhoneNo">${memberPhoneNo}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Birth Date</label>
							<div class="col-sm-3">
								<input type="text" value="${txtMemberDOB}" class="form-control"
									placeholder="YYYY-MM-DD" maxlength="10" name="txtMemberDOB">${memberDOB}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Gender</label>
							<div class="col-sm-3">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="rdoMemberGender" id="rdoMale"
									value="male" checked="checked" value="${rdoMemberGender}">Male
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="rdoMemberGender" id="rdoFemale"
									value="female" value="${rdoMemberGender}">Female
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-5 control-label">Address</label>
							<div class="col-sm-3">
								<textarea rows="5" cols="37" maxlength="255" name="txtMemberAddress">${txtMemberAddress}</textarea>
								${memberAddress}
							</div>
						</div>


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

						<div class="form-group">
							<label class="col-sm-5 control-label">Area </label>
							<div class="col-sm-3">
								<select name="selAreaName" id="selAreaName"
									style="padding: 5px; width: 245px;">

									<option value="">---Select Area---</option>

								</select> ${msgAreaName}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Member Type</label>
							<div class="col-sm-3">
								<select name="selMemberTypeName" id="selMemberTypeName"
									style="padding: 5px; width: 245px;">
									<option value="0" selected="selected">Select Member
										Type</option>
									<%
										MemberTypeDAO memberTypeDAO = new MemberTypeDAO();
											List<MemberTypeBean> memberTypeList = memberTypeDAO.list();

											for (int i = 0; i < memberTypeList.size(); i++) {

												String tmp = "unselected";
												String type = request.getParameter("selMemberTypeName");
												if (type == null)
													tmp = "unselected";
												else if (memberTypeList.get(i).getMemberTypeId()
														.equals(type))
													tmp = "selected";
									%>

									<option value=<%=memberTypeList.get(i).getMemberTypeId()%>
										<%=tmp%>>
										<%=memberTypeList.get(i).getMemberTypeName()%></option>
									<%
										}
									%>

								</select> ${msgMemberTypeName}
							</div>
						</div>



						<div class="form-group">
							<label class="col-sm-5 control-label">Security Question</label>
							<div class="col-sm-3">
								<select name="selQuestion" id="selQuestion"
									style="padding: 5px; width: 245px;">
									<option value="0" selected="selected">Select Question</option>
									<%
										SecurityQuestionsDAO securityQuestionsDAO = new SecurityQuestionsDAO();
											List<SecurityQuestionsBean> securityQuestionsList = securityQuestionsDAO
													.getSecurityQuestionsList();

											for (int i = 0; i < securityQuestionsList.size(); i++) {

												String tmp = "unselected";
												String type = request.getParameter("selQuestion");
												if (type == null)
													tmp = "unselected";
												else if (securityQuestionsList.get(i).getQuestionId()
														.equals(type))
													tmp = "selected";
									%>

									<option value=<%=securityQuestionsList.get(i).getQuestionId()%>
										<%=tmp%>>
										<%=securityQuestionsList.get(i).getQuestion()%></option>
									<%
										}
									%>
								</select> ${msgQuestion}
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Answer</label>
							<div class="col-sm-3">
								<input type="text" value="${txtAnswer}" maxlength="15" class="form-control"
									placeholder="Your Answer" name="txtAnswer">${msgAnswer}
							</div>
						</div>
					</div>
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
		<%
			} else {
				response.sendRedirect("userlogin.jsp");

			}
		%>
		
</body>
</html>
