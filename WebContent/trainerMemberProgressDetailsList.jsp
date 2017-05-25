<%@page import="com.designhub.fitnessplus.bean.TrainerBean"%>
<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@page
	import="com.designhub.fitnessplus.bean.MemberProgressDetailsBean"%>
<%@page import="com.designhub.fitnessplus.dao.ProgressDAO"%>
<%@page import="com.designhub.fitnessplus.bean.ProgressBean"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
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
	<form action="">
		<table border="1" align="center" width="50%">
			<center>

				<%
					ArrayList<MemberProgressDetailsBean> memberProgressDetailslist = (ArrayList) request
								.getAttribute("memberProgressDetailslist");
						if (memberProgressDetailslist != null) {
				%>
				<tr>
					<th>Height</th>
					<th>Weight</th>
					<th>BMI</th>
					<th>Biceps</th>
					<th>Hips</th>
					<th>Thigh</th>
					<th>Neck</th>
					<th>ForeArms</th>
					<th>Chest</th>
					<th>Calves</th>
					<th>BodyFat</th>
					<th>Date & Time</th>
				</tr>
				<%
					for (int i = 0; i < memberProgressDetailslist.size(); i++) {
								MemberProgressDetailsBean progressbean = memberProgressDetailslist
										.get(i);
				%>
				<tr>
					<td><%=progressbean.getHeight()%></td>
					<td><%=progressbean.getWeight()%></td>
					<td><%=progressbean.getBmi()%></td>
					<td><%=progressbean.getBiceps()%></td>
					<td><%=progressbean.getHips()%></td>
					<td><%=progressbean.getThigh()%></td>
					<td><%=progressbean.getNeck()%></td>
					<td><%=progressbean.getForearms()%></td>
					<td><%=progressbean.getChest()%></td>
					<td><%=progressbean.getCalves()%></td>
					<td><%=progressbean.getBodyfat()%></td>
					<td><%=progressbean.getDatetime()%></td>
				</tr>
				<%
					}
						} else {
				%>
				<h3 style="color: RED">
					<center>No Records Found......</center>
				</h3>
				<%
					}
				%>
			</center>
		</table>


	</form>
	<%
		} else {
			response.sendRedirect("userlogin.jsp");

		}
	%>
</body>
</html>