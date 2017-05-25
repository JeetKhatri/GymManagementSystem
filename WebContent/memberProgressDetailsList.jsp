<%@page import="com.designhub.fitnessplus.bean.MemberProgressDetailsBean"%>
<%@page import="com.designhub.fitnessplus.bean.UserInquiryBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.bean.ActivityBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Member Progress Details List</title>


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
<%@ include file="admin/adminHeader.jsp"%>
<%
		ArrayList<MemberProgressDetailsBean> memberProgressDetailslistCheck = (ArrayList) request.getAttribute("memberProgressDetailslist");
		if (memberProgressDetailslistCheck != null) {
%>

<div class="content-wrapper" style="margin-top: -1000px">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		Member Progress Details <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminhomepage.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">MemberProgressDetails</li>
	</ol><br><br>
	<!-- <a href="userInquiry.jsp"><input type="button" value="ADD" name="ADD"
						class="btn btn-primary"></a><br> -->
	<center>

		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Member Progress Details List</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<table id="example1" class="table table-bordered table-striped">
					<%
							ArrayList<MemberProgressDetailsBean> memberProgressDetailslist = (ArrayList) request.getAttribute("memberProgressDetailslist");
							if (memberProgressDetailslist != null) {
					%>
					<thead>
						<tr align="center">
								
								<td><b>Height</b></td>
								<td><b>Weight</b></td>
								<td><b>Biceps</b></td>
								<td><b>Chest</b></td>
								<td><b>Date & Time</b></td>
								<td><b>Action</b></td>
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
									<td>
										<a href="memberProgressDetailEditServlet?progressDetailId=<%=progressbean.getProgressDetailId()%>">
										<i class="fa fa-edit" title="Update"></i></a> 
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="memberProgressDetailsDeleteServlet?progressDetailId=<%=progressbean.getProgressDetailId()%>">
										<i class="glyphicon glyphicon-trash" title="Delete"></i></a>																																		
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
		Member Progress Details <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="admin/adminHeader.html"><i
				class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">MemberProgressDetails</li>
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







<%-- <%@page import="com.designhub.fitnessplus.bean.MemberProgressDetailsBean"%>
<%@page import="com.designhub.fitnessplus.dao.ProgressDAO"%>
<%@page import="com.designhub.fitnessplus.bean.ProgressBean"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="">
		<table border="1" align="center" width="50%">
			<center>

				<%
					ArrayList<MemberProgressDetailsBean> memberProgressDetailslist = (ArrayList) request.getAttribute("memberProgressDetailslist");
					if (memberProgressDetailslist != null) {
				%>
				<tr>
					<th>Height</th>
					<th>Weight</th>
					<th>BMI</th>
					<th>Biceps</th>
					<th>Hips</th>
					<th>Thigh</th>
					<th>Neck</th>
					<th>ForeArms</th>
					<th>Chest</th>
					<th>Calves</th>
					<th>BodyFat</th>
					<th>Date & Time</th>
					<th>Action</th>
					<th></th>
				</tr>
				<%
					for (int i = 0; i < memberProgressDetailslist.size(); i++) {
							MemberProgressDetailsBean progressbean = memberProgressDetailslist.get(i);
				%>
				<tr>
					<td><%=progressbean.getHeight()%></td>
					<td><%=progressbean.getWeight()%></td>
					<td><%=progressbean.getBmi()%></td>
					<td><%=progressbean.getBiceps()%></td>
					<td><%=progressbean.getHips()%></td>
					<td><%=progressbean.getThigh()%></td>
					<td><%=progressbean.getNeck()%></td>
					<td><%=progressbean.getForearms()%></td>
					<td><%=progressbean.getChest()%></td>
					<td><%=progressbean.getCalves()%></td>
					<td><%=progressbean.getBodyfat()%></td>
					<td><%=progressbean.getDatetime()%></td>
					<td><a
						href="memberProgressDetailsDeleteServlet?progressDetailId=<%=progressbean.getProgressDetailId()%>">DELETE</a>
						<a
						href="memberProgressDetailEditServlet?progressDetailId=<%=progressbean.getProgressDetailId()%>">Update</a>
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
			</center>
		</table>


	</form>

</body>
</html> --%>