<%@page import="com.designhub.fitnessplus.dao.GymImageDAO"%>
<%@page import="com.designhub.fitnessplus.bean.GymImageBean"%>
<%@page import="com.designhub.fitnessplus.dao.FeedbackDAO"%>
<%@page import="com.designhub.fitnessplus.bean.FeedbackBean"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Gym Image List</title>

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
<%@ include file="admin/adminHeader.html"%>
<%
					ArrayList<GymImageBean> gymImagelistCheck = (ArrayList) new GymImageDAO().list();
					if (gymImagelistCheck != null) {
%>

<div class="content-wrapper" style="margin-top: -700px">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		Gym List <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="admin/AdminHomePage.html"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li><a href="#"><i class="fa fa-dashboard"></i>
				Gallary</a></li>
		<li class="active">GymList</li>
	</ol><br><br>
	<center>

		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Gym Image List</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<table id="example1" class="table table-bordered table-striped">
				<%
					String filePath = getServletContext().getInitParameter("file-upload");
					ArrayList<GymImageBean> gymImagelist = (ArrayList) new GymImageDAO().list();
					if (gymImagelist != null) {
				%>
					<thead>
						<tr align="center">
								<td><b>Gym Image Id</b></td>
								<td><b>Gym Details Id</b></td>
								<td><b>Gym Image Path</b></td>
								<td><b>Action</b></td>
								
						</tr>
					</thead>
					<tbody>
					<%
					for (int i = 0; i < gymImagelist.size(); i++) {
							GymImageBean gymImageBean  = gymImagelist.get(i);
					%>
						<tr align="center">
								<td><%=gymImageBean.getGymImageId()%></td>
								<td><%=gymImageBean.getGymDetailsId()%></td>
								<td><img src="GymImagesUpload\<%=gymImageBean.getGymImagePath()%>" height="20px" width="20px"></td>
								<td align="center">
										<a href="GymImageDeleteServlet?id=<%=gymImageBean.getGymImageId()%>">
										<i class="fa fa-edit"></i></a> 
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="GymImageEditServlet?id=<%=gymImageBean.getGymImageId()%>">
							    		<i class="glyphicon glyphicon-trash"></i></a>
								</td>
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
	<%}else{
		%>
	<div class="content-wrapper" style="margin-top: -700px">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		Gym Image <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="admin/adminHeader.html"><i
				class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">GymImage</li>
	</ol>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h1 align="center" style="color: red;">No Record Found......</h1>
	</section>
</div>


<%
	}
%>
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

</body>
</html>



<%-- 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="">

			
			<table border="2" bordercolor="blue">


				<%
				String filePath = getServletContext().getInitParameter("file-upload");
					ArrayList<GymImageBean> gymImagelist = (ArrayList) new GymImageDAO().list();
					if (gymImagelist != null) {
				%>
				<tr>
				<th>Gym Image ID</th>
				<th>Gym Details ID</th>
				<th>Gym Image Path</th>
				<th>Action</th>
				</tr>
				<%
					for (int i = 0; i < gymImagelist.size(); i++) {
							GymImageBean gymImageBean  = gymImagelist.get(i);
				%>
				<tr>
					<td><%=gymImageBean.getGymImageId()%></td>
					<td><%=gymImageBean.getGymDetailsId()%></td>
					<td><img src="GymImagesUpload\<%=gymImageBean.getGymImagePath()%>" height="20px" width="20px"></td>
					<td><a
						href="GymImageDeleteServlet?id=<%=gymImageBean.getGymImageId()%>">DELETE</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="GymImageEditServlet?id=<%=gymImageBean.getGymImageId()%>">UPDATE</a>
					</td>
				</tr>
				<%
					}
					} else {
				%>
				<h3 style="color: RED">
					<center>No Records Found......</center>
				</h3>
				<%
					}
				%>
			</table>


		</form>
	</center>

</body>
</html> --%>