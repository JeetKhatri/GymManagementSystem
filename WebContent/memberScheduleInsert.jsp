<%@page import="com.designhub.fitnessplus.bean.ActivityBean"%>
<%@page import="com.designhub.fitnessplus.dao.ActivityDAO"%>
<%@page import="com.designhub.fitnessplus.bean.MemberBean"%>
<%@page import="com.designhub.fitnessplus.dao.MemberDAO"%>
<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.dao.AdminDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Member Schedule Insert</title>


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
<div class="content-wrapper" style="margin-top: -1000px">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		Member Schedule <small>Insert</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminhomepage.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">MemberSchedule</li>
	</ol>

	<br>
	<br>
	<br>
	<form action="MemberScheduleInsertServlet" method="post"
		name="MemberScheduleDetailsInsertPage" class="form-horizontal">
		<table>
			<tr>
				<div class="box-body">
					<div class="form-group">
						<label class="col-sm-5 control-label">Member Name</label>
						<div class="col-sm-5">
							<select name="selMemberName" id="selMemberName"
								style="padding: 5px; width: 245px;">
								<option value="0" selected="selected">Select Member
									Name</option>
								<%
									MemberDAO memberDAO = new MemberDAO();
											List<MemberBean> memberList = memberDAO.list();
											
											for(int i=0;i<memberList.size();i++)
											{

												String tmp="unselected";
												String type=request.getParameter("selMemberName");
												if(type==null)
													tmp="unselected";
												else if(memberList.get(i).getMemberId().equals(type))
													tmp="selected";
								%>

								<option value=<%=memberList.get(i).getMemberId()%> <%=tmp%>>
									<%=memberList.get(i).getMemberFirstName() + " "  + memberList.get(i).getMemberLastName()%></option>
								<%
									}
								%>
							</select> ${msgMemberName}
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-5 control-label">Activity Name</label>
						<div class="col-sm-5">
							<select name="selActivityName" id="selActivityName"
								style="padding: 5px; width: 245px;">
								<option value="0" selected="selected">Select Activity
									Name</option>
								<% 
					ActivityDAO activityDAO = new ActivityDAO();
					List<ActivityBean> activityList = activityDAO.list();
					
					for(int i=0;i<activityList.size();i++)
					{

						String tmp="unselected";
						String type=request.getParameter("selActivityName");
						if(type==null)
							tmp="unselected";
						else if(activityList.get(i).getActivityId().equals(type))
							tmp="selected";
				%>

				<option value=<%=activityList.get(i).getActivityId()%> <%=tmp %> > <%=activityList.get(i).getActivityName() %></option>
				<% 
					}
				%>
			</select>
			${msgActivityName}
						</div>
					</div>
				
				

					<div class="form-group">
						<label class="col-sm-5 control-label">Start Time</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" placeholder="Time"
								name="txtMemberStartTime" maxlength="10" value="${txtMemberStartTime}">
							${memberStartTime}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">End Time</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" placeholder="Time"
								name="txtMemberEndTime" maxlength="10" value="${txtMemberEndTime}">
							${memberEndTime}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Day</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Day" name="txtMemberDay" maxlength="10"
								value="${txtMemberDay}"> ${memberDay}
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
		</table>
	</form>
	</section>
</div>



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
<%
		} else {
			response.sendRedirect("userlogin.jsp");

		}
	%>
</body>
</html>



