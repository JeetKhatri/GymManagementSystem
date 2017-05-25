<%@page import="com.designhub.fitnessplus.bean.PackageBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Country Edit Page</title>
</head>
<body>
	<%
		PackageBean packageBean = (PackageBean) request.getAttribute("packageBean");
		if (packageBean != null) {
	%>
	<form action="packageUpdateServlet" name="packageUpdate"
		id="packageUpdate" method="post">
		<input type="hidden" name="packageId" id="packageId"
			value="<%=packageBean.getPackageId()%>">
		<center>
			
			<table>
			<tr>
				<th align="left"><font size="5" color="blue">Package
						Name</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td><input type="text" 
					name="txtPackageName" size="26" value="<%=packageBean.getPackageName()%>"
					style="height: 19px; float: left;"> ${packageName}</td>
			</tr>
			<tr>
				<td align="center"><br> <input type="reset" value="Reset"
					name="reset"
					style="background-color: red; color: white; width: 100px; height: 30px">
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="Submit" value="Ragister" name="submit"
					style="background-color: Green; color: white; width: 100px; height: 30px">
				</td>
			</tr>
			<%
				}
			%>
		</table>
			
		</center>
	</form>

</body>
</html>