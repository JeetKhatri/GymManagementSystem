<%@page import="com.designhub.fitnessplus.bean.TrainerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>FitnessPLUS | Profile</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../admin/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="../admin/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="../admin/dist/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="../admin/plugins/iCheck/flat/blue.css">
<link rel="stylesheet" href="../admin/plugins/morris/morris.css">
<link rel="stylesheet"
	href="../admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet"
	href="../admin/plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="../admin/plugins/daterangepicker/daterangepicker-bs3.css">
<link rel="stylesheet"
	href="../admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
</head>
<body style="min-width: 100%; min-height: 100%; overflow: hidden; alignment-adjust: central;">
	<%
		TrainerBean trainerBean2 = (TrainerBean) session
				.getAttribute("trainerBean");

		if (trainerBean2 != null && trainerBean2.getTrainerId() != null) {
	%>
	<%@include file="trainerHeader.jsp"%>
	
	
	
	
		<div class="content-wrapper" style="margin-top: -1000px">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Trainer <small>Profile</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="trainerHomePage.jsp"><i class="fa fa-dashboard"></i>
					Home</a></li>
			<li class="active">Trainer Profile</li>
		</ol>
		<br>
		<br>

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
						<td style="padding: 10px;">Profile of <%=trainerBean.getTrainerFirstName() + " "
						+ trainerBean.getTrainerLastName()%></td>
					</tr>
				</table>
			</div>
		</div>
		<br />
		<table noborder
			style="margin-left: 10px; font: 14px lighter; font-family: Comic Sans MS">

			<tr>

				<td><label>First Name</label></td>
				<td><i><b> :: <label><%=trainerBean.getTrainerFirstName()%></label></b></i>
				</td>

			</tr>


			<tr>

				<td><label>Last Name</label></td>
				<td><i><b> :: <label><%=trainerBean.getTrainerLastName()%></label></b></i>
				</td>

			</tr>


			<tr>

				<td><label>Email-ID</label></td>
				<td><i><b> :: <label><%=trainerBean.getTrainerEmail()%></label></b></i>
				</td>

			</tr>



			<tr>

				<td><label>Gender</label></td>
				<td><i><b> :: <label><%=trainerBean.getTrainerGender()%></label></b></i>
				</td>

			</tr>

			<tr>

				<td><label>Phone-No</label></td>
				<td><i><b> :: <label><%=trainerBean.getTrainerPhoneNo()%></label></b></i>
				</td>

			</tr>


			<tr>

				<td><label>Date Of Birth</label></td>
				<td><i><b> :: <label><%=trainerBean.getTrainerDOB()%></label></b></i>
				</td>

			</tr>


			<tr>

				<td><label>Address</label></td>
				<td><i><b> :: <label><%=trainerBean.getTrainerAddress()%></label></b></i>
				</td>

			</tr>


			<tr>

				<td><label>City</label></td>
				<td><i><b> :: <label><%=trainerBean.getCityName()%></label></b></i>
				</td>

			</tr>

			<tr>

				<td><label>Area</label></td>
				<td><i><b> :: <label><%=trainerBean.getAreaName()%></label></b></i>
				</td>

			</tr>

			


		</table>
		</section>
	</div>


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
			response.sendRedirect("userlogin.jsp");

		}
	%>
</body>
</html>





