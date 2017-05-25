<%@page import="com.designhub.fitnessplus.bean.ProgressBean"%>
<%@page import="com.designhub.fitnessplus.bean.MemberBean"%>
<%@page import="java.util.ArrayList"%>
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
<title>Admin | Member Progress Details Insert</title>


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

ProgressBean progressBean = (ProgressBean) request.getAttribute("progressbean");
String memberId=request.getParameter("memberId");
//System.out.println(txtmemberId);

//ProgressBean progressBean="WebContent/Feedback.jsp"(ProgressBean) request.getAttribute("progressbean");

%>
<body>
<%@ include file="admin/adminHeader.jsp"%>
<div class="content-wrapper" style="margin-top: -1000px">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		Member Progress Details <small>Insert</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminhomepage.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">MemberProgressDetails</li>
	</ol>

<br><br><br>
	<form action="memberProgressDetailsInsertServlet" method="post" name="memberProgressDetailsInsertServlet"
		class="form-horizontal">
		<table>
			<tr>
				<input type="hidden" name="memberId" id="memberId" value="<%= memberId %>">
					<div class="form-group">
						<label class="col-sm-5 control-label">Month</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Month-Day" name="selMonth" maxlength="5"
								value="${selMonth}"> ${month}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Year</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="2015" name="selYear" maxlength="4"
								value="${selYear}"> ${year}
						</div>
					</div>
					<input type="hidden" name="txtMemberId" value="1">
					<div class="form-group">
						<label class="col-sm-5 control-label">Height</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Enter Height" name="txtHeight" maxlength="4"
								value="${txtheight}"> ${height}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Weight</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Enter Weight" name="txtWeight" maxlength="4"
								value="${txtweight}"> ${weight}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">BMI</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Enter BMI" name="txtBmi" maxlength="4"
								value="${txtbmi}"> ${bmi}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Biceps</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Enter Biceps" name="txtBiceps" maxlength="4"
								value="${txtbiceps}"> ${biceps}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Hips</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Enter Hips" name="txtHips" maxlength="4"
								value="${txthips}"> ${hips}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Thigh</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Enter Thigh" name="txtThigh" maxlength="4"
								value="${txtthigh}"> ${thigh}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Neck</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Enter Neck" name="txtNeck" maxlength="4"
								value="${txtneck}"> ${neck}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Forearms</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Enter ForeArms" name="txtForearms" maxlength="4"
								value="${txtforearms}"> ${forearms}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Chest</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Enter Chest" name="txtChest" maxlength="4"
								value="${txtchest}"> ${chest}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Calves</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Enter Calves" name="txtCalves" maxlength="4"
								value="${txtcalves}"> ${calves}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Body Fat</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Enter BodyFat" name="txtBodyfat" maxlength="4"
								value="${txtbodyfat}"> ${bodyfat}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">Waist</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								placeholder="Enter Waist" name="txtWaist" maxlength="4"
								value="${txtwaist}"> ${waist}
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

</body>
</html>







<%-- 


<%@page import="com.designhub.fitnessplus.bean.ProgressBean"%>
<%@page import="com.designhub.fitnessplus.dao.MemberDAO"%>
<%@page import="com.designhub.fitnessplus.bean.MemberBean"%>
<%@page import="com.designhub.fitnessplus.bean.CityBean"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%

ProgressBean progressBean = (ProgressBean) request.getAttribute("progressbean");
String memberId=request.getParameter("memberId");
//System.out.println(txtmemberId);

//ProgressBean progressBean="WebContent/Feedback.jsp"(ProgressBean) request.getAttribute("progressbean");

%>
<body>
<center>

	<h1>Progress Details Insert Form</h1></center>
	<form action="memberProgressDetailsInsertServlet" method="post">
		<center><table>
		<tr>
				<td>
					<input type="hidden" name="memberId" id="memberId" value="<%= memberId %>">
				</td>
			</tr>
			<tr>
			<td>
			<input type="text" name="selMonth" value="${selMonth}" placeholder="Select Month"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${month}</font>
			</td>
			<td>
			<input type="text" name="selYear" value="${selYear}" placeholder="Select Year"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${year}</font>
			</td>
			</tr>
			<tr>
			<input type="hidden" name="txtMemberId" value="1">
				<td>Height</td>
				<td><input type="number" value="${txtheight}" name="txtHeight"
					placeholder="Enter Height" ><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${height}</font></td>
			</tr>

			<tr>
				<td>Weight</td>
				<td><input type="number" name="txtWeight"
					placeholder="Enter Weight" value="${txtweight}"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}</font></td>
			</tr>

			<tr>
				<td>BMI</td>
				<td><input type="number" name="txtBmi" placeholder="Enter BMI"  value="${txtbmi}"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${bmi}</font></td>
			</tr>

			<tr>
				<td>Biceps</td>
				<td><input type="number" name="txtBiceps"
					placeholder="Enter Biceps" value="${txtbiceps}"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${biceps}</font></td>
			</tr>

			<tr>
				<td>Hips</td>
				<td><input type="number" name="txtHips" placeholder="Enter Hips" value="${txthips}"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${hips}</font></td>
			</tr>

			<tr>
				<td>Thigh</td>
				<td><input type="number" name="txtThigh"
					placeholder="Enter Thigh" value="${txtthigh}"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${thigh}</font></td>
			</tr>

			<tr>
				<td>Neck</td>
				<td><input type="number" name="txtNeck" placeholder="Enter Neck" value="${txtneck}"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${neck}</font></td>
			</tr>

			<tr>
				<td>ForeArms</td>
				<td><input type="number" name="txtForearms"
					placeholder="Enter ForeArms" value="${txtforearms}"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${forearms}</font></td>
			</tr>

			<tr>
				<td>Chest</td>
				<td><input type="number" name="txtChest"
					placeholder="Enter Chest" value="${txtchest}"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${chest}</font></td>
			</tr>

			<tr>
				<td>Calves</td>
				<td><input type="number" name="txtCalves"
					placeholder="Enter Calves"  value="${txtcalves}"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${calves}</font></td>
			</tr>

			<tr>
				<td>BodyFat</td>
				<td><input type="number" name="txtBodyfat"
					placeholder="Enter BodyFat" value="${txtbodyfat}"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${bodyfat}</font></td>
			</tr>

			<tr>
				<td>Waist</td>
				<td><input type="number" name="txtWaist"
					placeholder="Enter Waist"  value="${txtwaist}"><font size=6
					color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${waist}</font></td>
			</tr>
			
			<tr>
				<td colspan="2">&nbsp</td>			
			</tr>
			
			<tr>
				<td colspan="2"><center>
						<input type="submit">
					</center>
				</td>
			</tr>

		</table></center>
	</form>

</body>

</html> --%>