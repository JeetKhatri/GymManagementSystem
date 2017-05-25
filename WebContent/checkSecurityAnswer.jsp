<%@page import="com.designhub.fitnessplus.bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SecurityQuestion Verification</title>
<link rel="stylesheet" href="LogIn/assets/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link href="LogIn/assets/css/signin2.css" rel="stylesheet">
<script src="LogIn/assets/js/ie-emulation-modes-warning.js">
	
</script>
</head>
<body background="LogIn/assets/img/background-faded.jpg">
	<center>
		<%
			MemberBean memberBean = (MemberBean) request
					.getAttribute("memberBean");
				
			if(memberBean.getQuestion() != null)
			{
		%>

		<h2>Security Question Verification</h2>

		<hr>
		<form action="CheckSecurityAnswerServlet" name="checkSecurityQuestion"
			class="form-signin">



			<h3><%=memberBean.getQuestion()%></h3>


			<br> <input type="text" name="securityAnswer"
				class="form-control" placeholder="Enter Your Answer" required
				autofocus> <br>
			<table align="left">

				<input type="hidden" name="memberId"
					value="<%=memberBean.getMemberId()%>">
				<tr>
					<td><input type="submit" value=" Next Step" name="submit"
						class="btn btn-lg btn-primary btn-block">
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>

					<td><button class="btn btn-lg btn-primary ">
							<a href="forgotPassword.jsp">Previous</a>
						</button>
					</td>
				</tr>
			</table>
		</form>
		<%}else 
			{
				response.sendRedirect("userlogin.jsp");
			}%>
	</center>
</body>
</html>