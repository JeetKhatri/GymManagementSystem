<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.bean.FeedbackBean"%>
<%@page import="com.designhub.fitnessplus.bean.FeedbackSubjectBean"%>
<%@page import="com.designhub.fitnessplus.dao.FeedbackSubjectDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Feedback Update</title>


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
<%
		AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");
		
		if (adminBean != null && adminBean.getAdminId() != null) {
	%>
<%@ include file="admin/adminHeader.jsp"%>
<div class="content-wrapper" style="margin-top: -1000px">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		Feedback <small>Update</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminhomepage.jsp"><i
				class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Feedback</li>
	</ol>

	<br>
	<br>
	<br>

	<%
		FeedbackBean feedbackbean=(FeedbackBean)request.getAttribute("feedbackbean");
	%>

	<form action="feedbackUpdateServlet" method="post" name="feedbackForm"
		class="form-horizontal">
		<input type="hidden" name="feedbackId"
			value="${feedbackbean.getFeedbackId()}">
		<table>
			<tr>
				<div class="box-body">

					<div class="form-group">
						<label class="col-sm-5 control-label"> Name</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" placeholder="Name"
								name="txtName" maxlength="15" value="${feedbackbean.getName()}">
							${name}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Email</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" placeholder="Email-Id"
								name="txtEmail" maxlength="50"
								value="${feedbackbean.getEmail()}"> ${email}
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-5 control-label">Subject</label>
						<div class="col-sm-5">
							<select name="cmbSubject" id="selFeedbackSubjectName"
								style="padding: 5px; width: 245px;">


								<option value=0>Select the subject</option>
								<%
									java.util.List<FeedbackSubjectBean> feedbackSubjectList=new FeedbackSubjectDAO().list();
												if(feedbackSubjectList!=null)
												{
													FeedbackSubjectBean feedbackSubjectBean=new FeedbackSubjectBean();
													for(int i=0;i<feedbackSubjectList.size();i++)
													{					
														feedbackSubjectBean=feedbackSubjectList.get(i);
													if(feedbackbean.getFeedbackSubjectId().equals(feedbackSubjectBean.getFeedbackSubjectId())){
								%>
								<option value="<%=feedbackSubjectBean.getFeedbackSubjectId()%>"
									selected="selected"><%=feedbackSubjectBean.getFeedbackSubjectName()%>
									<%
										}
													else{
									%>
								
								<option value="<%=feedbackSubjectBean.getFeedbackSubjectId()%>"><%=feedbackSubjectBean.getFeedbackSubjectName()%>
									<%
										}
														}
													}
									%>
								
							</select>${feedbackSubject}

						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Content</label>
						<div class="col-sm-3">
							<textarea rows="7" cols="37" maxlength="255" name="txtaContent">${feedbackbean.getContent()}</textarea>
							${content}
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





<%-- 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	FeedbackBean feedbackbean=(FeedbackBean)request.getAttribute("feedbackbean");
%>
<body>

	<form action="feedbackUpdateServlet" method="post">
		<input type="hidden" name="feedbackId" value="${feedbackbean.getFeedbackId()}">
		<table>
		
			<tr>
				<td>Name</td>
				
				<td><input type="text" name="txtName" id="txtName"
					value="${feedbackbean.getName()}" placeholder="Enter name"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${name}</font>
				</td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="text" name="txtEmail" id="txtEmail"
					value="${feedbackbean.getEmail()}" placeholder="Enter Email-Id"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${email}</font>
				</td>
			</tr>

			<tr>
				<td>Subject</td>
				<td><select name="cmbSubject">
				<option value=0>Select the subject</option>
						<%
						java.util.List<FeedbackSubjectBean> feedbackSubjectList=new FeedbackSubjectDAO().list();
						if(feedbackSubjectList!=null)
						{
							FeedbackSubjectBean feedbackSubjectBean=new FeedbackSubjectBean();
							for(int i=0;i<feedbackSubjectList.size();i++)
							{					
								feedbackSubjectBean=feedbackSubjectList.get(i);
							if(feedbackbean.getFeedbackSubjectId().equals(feedbackSubjectBean.getFeedbackSubjectId())){
							
			
						%>
					 	<option value="<%=feedbackSubjectBean.getFeedbackSubjectId()%>" selected="selected"><%=feedbackSubjectBean.getFeedbackSubjectName()%> 
						<%
								}
						else{
						%>
						<option value="<%=feedbackSubjectBean.getFeedbackSubjectId()%>"><%=feedbackSubjectBean.getFeedbackSubjectName()%>
						<%	
						}
							}
						}%>
				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red size=6>${feedbackSubject}</font>
				</td>
			</tr>
			<tr>
				<td>Content</td>
				<td><textarea rows="8" cols="30" name="txtaContent">${feedbackbean.getContent()}</textarea>
					<font color=red size=6>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${content}</font>
				</td>
			</tr>

			<tr>
				<td><input type="submit" value="Update..">
				</td>
			</tr>
		</table>


	</form>

</body>
</html> --%>