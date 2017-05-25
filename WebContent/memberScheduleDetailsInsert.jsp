<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@page import="com.designhub.fitnessplus.bean.ActivityBean"%>
<%@page import="com.designhub.fitnessplus.dao.ActivityDAO"%>
<%@page import="com.designhub.fitnessplus.bean.MemberBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.dao.MemberDAO"%>
<%@page import="com.designhub.fitnessplus.bean.MemberScheduleBean"%>
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
		AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");

		if (adminBean != null && adminBean.getAdminId() != null) {
	%>
	<%
		MemberScheduleBean memberScheduleBean = new MemberScheduleBean();
			String memberId = request.getParameter("memberId");

			System.out.print("id on jsp: " + memberId);
	%>
	<form action="MemberScheduleDetailsInsertServlet" method="post"
		name="MemberScheduleDetailsInsertPage"
		id="MemberScheduleDetailsInsertPage">
		<input type="hidden" name="memberId" id="memberId"
			value="<%=memberId%>">
		<table>
			<tr>
				<td align="left"><font size="5" color="blue">Activity
						Name</font>
				</td>
				<td><select name="selActivityName" id="selActivityName">
						<option value="0" selected="selected">Select Activity</option>
						<%
							ActivityDAO activityDAO = new ActivityDAO();
								List<ActivityBean> activityList = activityDAO.list();

								for (int i = 0; i < activityList.size(); i++) {

									String tmp = "unselected";
									String type = request.getParameter("selActivityName");
									if (type == null)
										tmp = "unselected";
									else if (activityList.get(i).getActivityId().equals(type))
										tmp = "selected";
						%>

						<option value=<%=activityList.get(i).getActivityId()%> <%=tmp%>>
							<%=activityList.get(i).getActivityName()%></option>
						<%
							}
						%>
				</select> ${msgActivityName}</td>
			</tr>
			<tr>
				<td align="left"><font size="5" color="blue">Start time</font>
				</td>
				<td><input type="text" name="txtMemberStartTime"
					placeholder="Time" maxlength="10" value="${txtMemberStartTime}"
					size="26" style="height: 19px; float: left;">
					${memberStartTime}</td>
			</tr>
			<tr>
				<td align="left"><font size="5" color="blue">End Time</font>
				</td>
				<td><input type="text" name="txtMemberEndTime"
					placeholder="Time" maxlength="10" value="${txtMemberEndTime}"
					size="26" style="height: 19px; float: left;">
					${memberEndTime}</td>
			</tr>
			<tr>
				<td align="left"><font size="5" color="blue">Day</font>
				</td>
				<td><input type="text" name="txtMemberDay" placeholder="Time"
					maxlength="10" value="${txtMemberDay}" size="26"
					style="height: 19px; float: left;"> ${memberDay}</td>
			</tr>
			<tr>
				<td align="center"><br> <input type="reset" value="Reset"
					name="reset"
					style="background-color: red; color: white; width: 100px; height: 30px">
				</td>

				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>

				<td><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="Submit" value="Ragister" name="submit"
					style="background-color: Green; color: white; width: 100px; height: 30px">
				</td>
			</tr>
		</table>
	</form>
	<%
		} else {
			response.sendRedirect("userlogin.jsp");

		}
	%>
</body>
</html>