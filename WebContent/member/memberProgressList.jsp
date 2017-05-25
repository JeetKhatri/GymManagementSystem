<%@page import="com.designhub.fitnessplus.bean.MemberProgressDetailsBean"%>
<%@page import="com.designhub.fitnessplus.bean.MemberBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.dao.GetScheduleDAO"%>
<%@page
	import="com.designhub.fitnessplus.bean.MemberScheduleDetailsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member | Schedule</title>
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
<body
	style="min-width: 100%; min-height: 100%; overflow: hidden; alignment-adjust: central;">

	<%
		MemberBean memberBeanCheck = (MemberBean) session
				.getAttribute("memberBean");

		if (memberBeanCheck != null
				&& memberBeanCheck.getMemberId() != null) {
	%>
	<%@include file="memberHeaderTemp.jsp"%>

	<div class="content-wrapper" style="margin-top: -1000px">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Member <small>Progress</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="memberHomePageTemp.jsp"><i class="fa fa-dashboard"></i>
					Home</a></li>
			<li class="active">Member Schedule</li>
		</ol>
		<br>
		<br>

	<input type="hidden" name="memberId" value="<%= memberBean.getMemberId()%>">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Member Progress Details List</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<table id="example1" class="table table-bordered table-striped">
					<%
							ArrayList<MemberProgressDetailsBean> memberProgressDetailslist = (ArrayList) request.getAttribute("memberProgresslist");
							System.out.println("---->>>?   "+memberProgressDetailslist.size());
							if (memberProgressDetailslist != null) {
					%>
					<thead>
						<tr align="center">
						
								<td><b>Height</b></td>
								<td><b>Weight</b></td>
								<td><b>Biceps</b></td>
								<td><b>Chest</b></td>
								<td><b>Date & Time</b></td>
						</tr>
					</thead>
					<tbody>
					<%
					for (int i = 0; i < memberProgressDetailslist.size(); i++) {
							MemberProgressDetailsBean progressbean = memberProgressDetailslist.get(i);
					%>
						<tr align="center">
									
									<td><%=progressbean.getHeight()%></td>
									<td><%=progressbean.getWeight()%></td>
									<td><%=progressbean.getBiceps()%></td>
									<td><%=progressbean.getChest()%></td>
									<td><%=progressbean.getDatetime()%></td>
						</tr>
						<%} %>
					</tbody>
					<%} %>
				</table>
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->
		</center>
		</section>
	</div>
	






	<%-- <%
	
	MemberScheduleDetailsBean memberScheduleDetailsBean = new GetScheduleDAO().Memberlist(memberBean.getMemberId());
	if(memberScheduleDetailsBean!=null)
	{

		
		
		
		
		
	%>
	
	<div style="width: 100%; border-bottom: 2px solid black;">
			<table style="width: 100%; vertical-align: middle;">
				<tr>
					<td>
						<p
							style="margin-left: 10px; font: 20px lighter; font-family: verdana">Fitness
							plus</p>
					</td>
				</tr>
			</table>
			<br />
		</div>
		<div style="width: 100%;">
			<div
				style="width: 100%; background-color: rgb(224, 224, 224); padding: 1px 0px 5px 15px;">
				<table style="width: 100%;">
					<tr style="font-size: 20px; text-align: center">
						<td style="padding: 10px;">Profile of <%=memberBean.getMemberFirstName() + " "
						+ memberBean.getMemberLastName()%></td>
					</tr>
				</table>
			</div>
		</div>
		<br />
		<table noborder
			style="margin-left: 10px; font: 14px lighter; font-family: Comic Sans MS">

			<tr>

				<td><label>Start Time Name</label></td>
				<td><i><b> :: <label><%=memberBean.getMemberFirstName()%></label></b></i>
				</td>

			</tr>


			<tr>

				<td><label>Last Name</label></td>
				<td><i><b> :: <label><%=memberBean.getMemberLastName()%></label></b></i>
				</td>

			</tr>


			<tr>

				<td><label>Email-ID</label></td>
				<td><i><b> :: <label><%=memberBean.getMemberEmail()%></label></b></i>
				</td>

			</tr>



			<tr>

				<td><label>Gender</label></td>
				<td><i><b> :: <label><%=memberBean.getMemberGender()%></label></b></i>
				</td>

			</tr>

			<tr>

				<td><label>Phone-No</label></td>
				<td><i><b> :: <label><%=memberBean.getMemberPhoneNo()%></label></b></i>
				</td>

			</tr>


			<tr>

				<td><label>Date Of Birth</label></td>
				<td><i><b> :: <label><%=memberBean.getMemberDOB()%></label></b></i>
				</td>

			</tr>


			<tr>

				<td><label>Address</label></td>
				<td><i><b> :: <label><%=memberBean.getMemberAddress()%></label></b></i>
				</td>

			</tr>


			<tr>

				<td><label>City</label></td>
				<td><i><b> :: <label><%=memberBean.getCityName()%></label></b></i>
				</td>

			</tr>

			<tr>

				<td><label>Area</label></td>
				<td><i><b> :: <label><%=memberBean.getAreaName()%></label></b></i>
				</td>

			</tr>

			<tr>

				<td><label>Member Type</label></td>
				<td><i><b> :: <label><%=memberBean.getMemberTypeName()%></label></b></i>
				</td>

			</tr>



		</table>
		</section>
	</div>
	

	</section>
	</div>
 --%>
	<!-- jQuery 2.1.4 -->
	<script src="admin/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="admin/bootstrap/js/bootstrap.min.js"></script>
	<!-- DataTables -->
	<script src="admin/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="admin/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<!-- SlimScroll -->
	<script src="admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="admin/plugins/fastclick/fastclick.min.js"></script>
	<!-- AdminLTE App -->
	<script src="admin/dist/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="admin/dist/js/demo.js"></script>
	<script>
		$(function() {
			$("#example1").DataTable();
			$('#example2').DataTable({
				"paging" : true,
				"lengthChange" : false,
				"searching" : false,
				"ordering" : true,
				"info" : true,
				"autoWidth" : false
			});
		});
	</script>
	<%
		} else {
			response.sendRedirect("../userlogin.jsp");

		}
	%>
</body>
</html>





