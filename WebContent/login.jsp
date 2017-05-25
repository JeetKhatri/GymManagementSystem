<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Insert Page</title>
</head>
<body>
	<form action="LoginServlet" method="post" name="LoginPage" id="LoginPage">
		<center>
			<table>

				<tr>
					<td>E-Mail :</td>
					<td><input type="text" value="${txtEmail}" name="txtEmail" id="txtEmail">
						${email}</td>
				</tr>

				<tr>
					<td>Password :</td>
					<td><input type="password" value="${txtPassword}" name="txtPassword" id="txtPassword">${password}</td>
				</tr>
				

			<%-- 	<tr>
					<td>UserType :</td>
					<td><select name="userType">
							<option value=0>Select User</option>
							<option value="1">Admin</option>
							<option value="2">Trainer</option>
							<option value="3">Member</option>
					</select>${userType}</td>
				</tr> --%>

				<tr>
					<td><input type="reset" name="reset" id="reset" value="RESET">
						<input type="submit" name="submit" id="submit" value="LOGIN">

					</td>
				</tr>



			</table>
		</center>
	</form>

</body>
</html>