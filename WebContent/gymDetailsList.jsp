<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@page import="com.designhub.fitnessplus.bean.GymDetailsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Gym Details List</title>


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
					ArrayList<GymDetailsBean> listofGymDetailsCheck = (ArrayList) request.getAttribute("listofGymDetails");;
					if(listofGymDetailsCheck!=null)
					{
%>

<div class="content-wrapper" style="margin-top: -1000px">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		Gym Details <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminhomepage.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">GymDetails</li>
	</ol><br><br>
	<a href="gymDetailsInsert.jsp"><input type="button" value="ADD" name="ADD"
						class="btn btn-primary"></a><br>
	<center>

		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Gym Details List</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<input type="hidden" name="gymId" id="gymId">
				<table id="example1" class="table table-bordered table-striped">
				<%  
					ArrayList<GymDetailsBean> listofGymDetails = (ArrayList) request.getAttribute("listofGymDetails");;
					if(listofGymDetails!=null){
				%>
					<thead>
						<tr align="center">
								<td><b>Gym Id</b></td>
								<td><b>Gym Address</b></td>
								<td><b>City Name</b></td>
								<td><b>Area Name</b></td>
								<td><b>Gym phone No</b></td>
								<td><b>Action</b></td>
						</tr>
					</thead>
					<tbody>
					<%
							for(int i=0;i<listofGymDetails.size();i++)
							{
								GymDetailsBean gymDetailsBean = listofGymDetails.get(i);
					%>
						<tr align="center">
						
									<td align="center"><%= gymDetailsBean.getGymDetailsId() %></td>
									<td align="center"><%= gymDetailsBean.getGymAddress() %></td>
									<td align="center"><%= gymDetailsBean.getCityName() %></td>
									<td align="center"><%= gymDetailsBean.getAreaName() %></td>
									<td align="center"><%= gymDetailsBean.getGymPhoneNo() %></td>
									<td align="center">
										<a href="GymDetailsEditServlet?gymId=<%= gymDetailsBean.getGymDetailsId() %>">
										<i class="fa fa-edit"></i></a> 
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="GymDetailsDeleteServlet?gymId=<%= gymDetailsBean.getGymDetailsId() %>">
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
		Gym Details <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="admin/adminHeader.html"><i
				class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">GymDetails</li>
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
<title>Insert title here</title>
</head>
<%@page import="com.designhub.fitnessplus.bean.GymDetailsBean"%>
<%@page import="java.util.ArrayList"%>
<body>
	<center>
		<input type="hidden" name="gymId" id="gymId">
		<table border="1" align="center" width="50%">

				<%  
					ArrayList<GymDetailsBean> listofGymDetails = (ArrayList) request.getAttribute("listofGymDetails");;
				
					if(listofGymDetails!=null)
					{
					%>
						<tr>

							<th>Gym Id</th>
							<th>Gym Address</th>
							<th>City Name</th>
							<th>Area Name</th>
							<th>Gym phone No</th>
							<th>Action</th>	

						</tr>
						
						<%
						
							for(int i=0;i<listofGymDetails.size();i++)
							{
								GymDetailsBean gymDetailsBean = listofGymDetails.get(i);
								
								%>
								
								<tr>
								
									<td align="center"><%= gymDetailsBean.getGymDetailsId() %></td>
									<td align="center"><%= gymDetailsBean.getGymAddress() %></td>
									<td align="center"><%= gymDetailsBean.getCityName() %></td>
									<td align="center"><%= gymDetailsBean.getAreaName() %></td>
									<td align="center"><%= gymDetailsBean.getGymPhoneNo() %></td>
									
									<td align="center">
										<a href="GymDetailsEditServlet?gymId=<%= gymDetailsBean.getGymDetailsId() %>">Change</a>
										<a href="GymDetailsDeleteServlet?gymId=<%= gymDetailsBean.getGymDetailsId() %>">Delete</a>		
									</td>
								
								</tr>
								
								<%
							}
						}
						
					
						else
						{
							%>
							<h1> No Record Found....!</h1>
							<%
						}
				%>
			</table>		
	</center>

</body>
</html> --%>