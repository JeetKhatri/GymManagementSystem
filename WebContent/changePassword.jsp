<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet" href="LogIn/assets/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link href="LogIn/assets/css/signin2.css" rel="stylesheet">
<script src="LogIn/assets/js/ie-emulation-modes-warning.js"></script>
</head>

<body background="LogIn/assets/img/background-faded.jpg">

	<center>

		<h2>You Can Set New Password . . .</h2>
		<hr>
		<br>
		<form action="UpdatePasswordServlet" name="updatePassword"
			class="form-signin">

			<input type="password" name="password" id="password" value=""
				class="form-control"
				placeholder="Enter New Password [ Minimum 12 Character Required ]"
				required autofocus minlength=12>${msgPassword} <input
				type="password" name="confirmPassword" id="confirmPassword" value=""
				class="form-control" placeholder="Re-Enter Password " required
				autofocus minlength=12>${msgConfirmPassword} <input
				type="hidden" name="memberId"
				value="<%=request.getParameter("memberId")%>"> <br>

			<table align="left">
				<td><input type="submit" name="submit" value="MODIFY"
					class="btn btn-lg btn-primary btn-block">
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input type="reset" name="reset" value="RESET"
					class="btn btn-lg btn-primary btn-block">
				</td>

			</table>
		</form>

	</center>
</body>
</html>