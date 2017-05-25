<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.designhub.fitnessplus.bean.FeedbackSubjectBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Feedback Subject List</title>


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
<%
				List<FeedbackSubjectBean> feedbackSubjectListCheck = (ArrayList) request.getAttribute("feedbackSubjectList");
				if (feedbackSubjectListCheck != null) {
%>

<div class="content-wrapper" style="margin-top: -1000px">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		Feedback Subject <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminhomepage.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Feedback Subject</li>
	</ol><br><br>
	<a href="feedbackSubjectInsert.jsp"><input type="button" value="ADD" name="ADD"
						class="btn btn-primary"></a><br>
	<center>

		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Feedback Subject List</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<table id="example1" class="table table-bordered table-striped">
				<%
				List<FeedbackSubjectBean> feedbackSubjectList = (ArrayList) request.getAttribute("feedbackSubjectList");
				if (feedbackSubjectList != null) {
%>
					<thead>
						<tr align="center">
						
								<td><b>Subject ID</b></td>
								<td><b>Subject name</b></td>
								<td><b>Action</b></td>
						</tr>
					</thead>
					<tbody>
					<%
								for (int i = 0; i < feedbackSubjectList.size(); i++) {
									FeedbackSubjectBean feedbackSubject = feedbackSubjectList
								.get(i);
							%>
							<tr align="center">
								<td><%= feedbackSubject.getFeedbackSubjectId() %></td>
								<td><%=feedbackSubject.getFeedbackSubjectName()%></td>
								<td>
									<a href="feedbackSubjectEditServlet?feedbackSubjectId=<%=feedbackSubject.getFeedbackSubjectId()%>">
									<i class="fa fa-edit"></i></a> 
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="feedbackSubjectDeleteServlet?feedbackSubjectId=<%=feedbackSubject.getFeedbackSubjectId()%>">
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
		Feedback Subject <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="admin/adminHeader.html"><i
				class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Feedback Subject</li>
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
<%
		} else {
			response.sendRedirect("userlogin.jsp");

		}
	%>
</body>
</html>








<%-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Feedback Subject List</title>


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

<%@ include file="admin/adminHeader.html"%>
<%
				List<FeedbackSubjectBean> feedbackSubjectListCheck = (ArrayList) request.getAttribute("feedbackSubjectList");
				if (feedbackSubjectListCheck != null) {
%>
<div class="content-wrapper" style="margin-top: -700px">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		Feedback Subject <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="admin/AdminHomePage.html"><i
				class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Feedback Subject</li>
	</ol>
	<br>
	<br>
	<br>
	<form action="" method="post" name="CitySelect"
		class="form-horizontal">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header" align="center">
						<h1 class="box-title" style="font-size: large;">City
							Table</h1>
						<!-- <div class="box-tools">
							<div class="input-group" style="width: 150px;">
								<input type="text" name="table_search"
									class="form-control input-sm pull-right" placeholder="Search">
								 <div class="input-group-btn">
									<button class="btn btn-sm btn-default">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div> -->
					</div>
					<!-- /.box-header -->
					<div class="box-body table-responsive no-padding">
						<table class="table table-hover">
							<%
								List<FeedbackSubjectBean> feedbackSubjectList = (ArrayList) request.getAttribute("feedbackSubjectList");
								if (feedbackSubjectList != null) {
							%>
							<tr align="center">
								<td><b>Feedback Subject ID</b></td>
								<td><b>Subject name</b></td>
								<td><b>Action</b></td>
							</tr>
							<%
								for (int i = 0; i < feedbackSubjectList.size(); i++) {
									FeedbackSubjectBean feedbackSubject = feedbackSubjectList
								.get(i);
							%>
							<tr align="center">
								<td><%= feedbackSubject.getFeedbackSubjectId() %></td>
								<td><%=feedbackSubject.getFeedbackSubjectName()%></td>
								<td>
									<a href="feedbackSubjectDeleteServlet?feedbackSubjectId=<%=feedbackSubject.getFeedbackSubjectId()%>">
									<i class="fa fa-edit"></i></a> 
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="feedbackSubjectEditServlet?feedbackSubjectId=<%=feedbackSubject.getFeedbackSubjectId()%>">
							    	<i class="glyphicon glyphicon-trash"></i></a>
							    </td>
							</tr>
							<%
								}}
							%>
						</table>
					</div>
					<!-- /.box-body -->
				</div>
			</div>
		</div>
	</form>
	</section>
</div>
<%
	}else{
%>
<div class="content-wrapper" style="margin-top: -700px">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		City <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="admin/adminHeader.html"><i
				class="fa fa-dashboard"></i> Home</a></li>
		<li><a href=""><i
				class="fa fa-map-marker"></i> Location</a></li>
		<li class="active">City</li>
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


<script src="admin/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script>
	$.widget.bridge('uibutton', $.ui.button);
</script>
<script src="admin/bootstrap/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="admin/plugins/morris/morris.min.js"></script>
<script src="admin/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
	src="admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="admin/plugins/knob/jquery.knob.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
<script src="admin/plugins/daterangepicker/daterangepicker.js"></script>
<script src="admin/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
	src="admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="admin/plugins/fastclick/fastclick.min.js"></script>
<script src="admin/dist/js/app.min.js"></script>
<script src="admin/dist/js/pages/dashboard.js"></script>
<script src="admin/dist/js/demo.js"></script>

</body>
</html>



 --%>

