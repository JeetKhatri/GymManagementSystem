<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@page import="com.designhub.fitnessplus.bean.ActivityBean"%>
<%@page import="com.designhub.fitnessplus.dao.ActivityDAO"%>
<%@page import="com.designhub.fitnessplus.bean.TrainerBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.dao.TrainerDAO"%>
<%@page
	import="com.designhub.fitnessplus.bean.TrainerScheduleDetailsBean"%>
<%@page import="com.designhub.fitnessplus.bean.TrainerScheduleBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	TrainerScheduleBean trainerScheduleBean = (TrainerScheduleBean) request
			.getAttribute("trainerSchedule");
	String txtTrainerId = request.getParameter("txtTrainerId");
%>
<body>
	<%
		AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");

		if (adminBean != null && adminBean.getAdminId() != null) {
	%>
	<%
		TrainerScheduleDetailsBean trainerScheduleDetailsBean = (TrainerScheduleDetailsBean) request
					.getAttribute("trainerScheduleDetailsBean");
			if (trainerScheduleDetailsBean != null) {
	%>
	<form action="TrainerScheduleDetailsUpdateServlet" method="post"
		name="TrainerScheduleDetailsUpdatePage"
		id="TrainerScheduleDetailsUpdatePage">
		<input type="hidden" name="id" id="id"
			value="<%=trainerScheduleDetailsBean
							.getTrainerScheduledetailsId()%>">
		<table>
			<tr>

				<td align="left"><font size="5" color="blue">Trainer
						Name</font>
				</td>
				<td><select name="selTrainerName" id="selTrainerName">
						<option value="0">Select Trainer</option>

						<%
							TrainerScheduleDetailsBean trainerScheduleDetails = (TrainerScheduleDetailsBean) request
											.getAttribute("trainerScheduleDetailsBean");
									TrainerDAO trainerDAO = new TrainerDAO();

									List<TrainerBean> trainerList = trainerDAO.list();

									for (int i = 0; i < trainerList.size(); i++) {
										TrainerBean trainer = trainerList.get(i);

										if (trainer.getTrainerId().equals(
												trainerScheduleDetails.getTrainerId())) {
						%>
						<option value="<%=trainer.getTrainerId()%>" selected="selected"><%=trainer.getTrainerFirstName() + " "
									+ trainer.getTrainerLastName()%></option>
						<%
							} else {
						%>
						<option value="<%=trainer.getTrainerId()%>"><%=trainer.getTrainerFirstName() + " "
									+ trainer.getTrainerLastName()%></option>
						<%
							}
									}
						%>

				</select> ${msgTrainerName}</td>
			</tr>


			<tr>
				<td align="left"><font size="5" color="blue">Activity
						Name</font>
				</td>
				<td><select name="selActivityName" id="selActivityName">
						<option value="0">Select city</option>

						<%
							ActivityDAO activityDAO = new ActivityDAO();

									List<ActivityBean> activityList = activityDAO.list();

									for (int i = 0; i < activityList.size(); i++) {
										ActivityBean activity = activityList.get(i);

										if (activity.getActivityId().equals(
												trainerScheduleDetails.getActivityId())) {
						%>
						<option value="<%=activity.getActivityId()%>" selected="selected"><%=activity.getActivityName()%></option>
						<%
							} else {
						%>
						<option value="<%=activity.getActivityId()%>"><%=activity.getActivityName()%></option>
						<%
							}
									}
						%>

				</select> ${msgActivityName}</td>
			</tr>
			<tr>
				<td align="left"><font size="5" color="blue">Start time</font>
				</td>
				<td><input type="text" name="txtTrainerStartTime"
					placeholder="Time" maxlength="10"
					value="<%=trainerScheduleDetailsBean.getTrainerStartTime()%>"
					size="26" style="height: 19px; float: left;">
					${trainerStartTime}</td>
			</tr>
			<tr>
				<td align="left"><font size="5" color="blue">End Time</font>
				</td>
				<td><input type="text" name="txtTrainerEndTime"
					placeholder="Time" maxlength="10"
					value="<%=trainerScheduleDetailsBean.getTrainerEndTime()%>"
					size="26" style="height: 19px; float: left;">
					${trainerEndTime}</td>
			</tr>
			<tr>
				<td align="left"><font size="5" color="blue">Day</font>
				</td>
				<td><input type="text" name="txtTrainerDay" placeholder="Time"
					maxlength="10"
					value="<%=trainerScheduleDetailsBean.getTrainerDay()%>" size="26"
					style="height: 19px; float: left;"> ${trainerDay}</td>
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
			<%
				}
			%>
		</table>
	</form>
	<%
		} else {
			response.sendRedirect("userlogin.jsp");

		}
	%>
</body>
</html>