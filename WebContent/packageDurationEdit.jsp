<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="PackageDurationUpdateServlet" method="post" name="PackageDurationform">
<input type="hidden" name="id" value='${packageDuration.packageDurationId}${packageDurationId}' id="id">
<table>
	<tr>
	<th align="left"><font size="5" color="blue">Duration Time</font></th>
	<th><font size="5" color="red">:</font></th>
	<td><input type="text" placeholder="Duration Time(In Month)" maxlength="10" name="txtPackageDurationTime" value='${packageDuration.packageDurationTime}${txtPackageDurationTime}' size="26" style="height:19px;float: left;"> ${packageDurationTime}
</td>
</tr>
<tr>
	<td align="center"><br>
<!-- 		<input type ="reset" value="Reset" name="reset" style="background-color:red;color:white;width:100px;height:30px">	 -->
	</td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type ="Submit" value="Ragister" name="submit" style="background-color:Green;color:white;width:100px;height:30px">
	</td>
</tr>
</table>
</form>
</body>
</html>-