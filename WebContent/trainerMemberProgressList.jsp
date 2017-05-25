<%@page import="com.designhub.fitnessplus.bean.TrainerBean"%>
<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@page import="com.designhub.fitnessplus.bean.MemberProgressBean"%>
<%@page import="com.designhub.fitnessplus.bean.MemberScheduleBean"%>
<%@page
	import="com.designhub.fitnessplus.bean.MemberScheduleDetailsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		TrainerBean trainerBean = (TrainerBean) session
				.getAttribute("trainerBean");

		if (trainerBean != null && trainerBean.getTrainerId() != null) {
	%>
	<center>

		<table border="1" align="center" width="50%">

			<%
				ArrayList<MemberProgressBean> memberProgresslist = (ArrayList) request
							.getAttribute("memberProgresslist");
					;

					if (memberProgresslist != null) {
			%>
			<tr>

				<th>Member Name</th>
				<th>Schedule Id</th>
				<th>Action</th>
			</tr>

			<%
				for (int i = 0; i < memberProgresslist.size(); i++) {
							MemberProgressBean memberProgressBean = memberProgresslist
									.get(i);
			%>

			<tr>
				<td align="center"><%=memberProgressBean.getMemberFirstName() + " "
								+ memberProgressBean.getMemberLastName()%></td>
				<td align="center"><%=memberProgressBean.getMemberId()%></td>
				<td align="center"><a
					href="TrainerMemberProgressDetailsServlet?memberId=<%=memberProgressBean.getMemberId()%>">Show_Details</a>
				</td>

			</tr>

			<%
				}
					}

					else {
			%>

			<h1>No Record Found....!</h1>
			<%
				}
			%>



		</table>


	</center>
	<%
		} else {
			response.sendRedirect("userlogin.jsp");

		}
	%>
</body>
</html>