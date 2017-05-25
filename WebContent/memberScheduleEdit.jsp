<%@page import="com.designhub.fitnessplus.bean.ActivityBean"%>
<%@page import="com.designhub.fitnessplus.dao.ActivityDAO"%>
<%@page import="com.designhub.fitnessplus.bean.MemberBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.dao.MemberDAO"%>
<%@page import="com.designhub.fitnessplus.bean.MemberScheduleDetailsBean"%>
<%@page import="com.designhub.fitnessplus.bean.MemberScheduleBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	MemberScheduleBean memberScheduleBean = (MemberScheduleBean) request.getAttribute("memberSchedule");
	String txtMemberId = request.getParameter("txtMemberId");
%>
<body>
	<%
		MemberScheduleDetailsBean memberScheduleDetailsBean = (MemberScheduleDetailsBean) request.getAttribute("memberScheduleDetailsBean");
		if (memberScheduleDetailsBean != null) {
	%>
	<form action="MemberScheduleDetailsUpdateServlet" method="post" name="MemberScheduleDetailsUpdatePage" id="MemberScheduleDetailsUpdatePage">
		<input type="hidden" name="id" id="id" value="<%=memberScheduleDetailsBean.getMemberScheduledetailsId() %>" >
		<table>
			<tr>
				
				<td align="left"><font size="5" color="blue">Member Name</font></td>
				<td>
						<select name="selMemberName" id="selMemberName">
				<option value="0">Select Member</option>
				
				<%  
					MemberScheduleDetailsBean memberScheduleDetails = (MemberScheduleDetailsBean)request.getAttribute("memberScheduleDetailsBean");					
					MemberDAO memberDAO = new MemberDAO();
					
					List<MemberBean> memberList = memberDAO.list();
					
					for(int i=0;i<memberList.size();i++){
						MemberBean member = memberList.get(i);
						
						
						if(member.getMemberId().equals(memberScheduleDetails.getMemberId()))
						{
						%>
							<option value="<%=member.getMemberId()%>" selected="selected"><%=member.getMemberFirstName() + " " + member.getMemberLastName() %></option>
						<%
						}		
						else
						{
				 			%>
					 			<option value="<%=member.getMemberId()%>"><%=member.getMemberFirstName() + " " + member.getMemberLastName()%></option>
							<%
						}
					} 
				%>

			</select>
				${msgMemberName}
				</td>
			</tr>
			
			
			<tr>
				<td align="left"><font size="5" color="blue">Activity Name</font></td>
				<td>
				<select name="selActivityName" id="selActivityName">
				<option value="0">Select city</option>
				
				<%  
					ActivityDAO activityDAO = new ActivityDAO();
					
					List<ActivityBean> activityList = activityDAO.list();
					
					for(int i=0;i<activityList.size();i++){
						ActivityBean activity = activityList.get(i);
						
						
						if(activity.getActivityId().equals(memberScheduleDetails.getActivityId()))
						{
						%>
							<option value="<%=activity.getActivityId()%>" selected="selected"><%=activity.getActivityName()%></option>
						<%
						}		
						else
						{
				 			%>
					 			<option value="<%=activity.getActivityId()%>"><%=activity.getActivityName()%></option>
							<%
						}
					} 
				%>

			</select>
				${msgActivityName}
				</td>
			</tr>
			<tr>
				<td align="left"><font size="5" color="blue">Start time</font></td>
				<td><input type="text"  name="txtMemberStartTime" placeholder="Time" maxlength="10" value="<%=memberScheduleDetailsBean.getMemberStartTime()%>" size="26" style="height: 19px; float: left;"> 
				${memberStartTime}
				</td>
			</tr> 
			<tr>
				<td align="left"><font size="5" color="blue">End Time</font></td>
				<td><input type="text"  name="txtMemberEndTime" placeholder="Time" maxlength="10" value="<%=memberScheduleDetailsBean.getMemberEndTime()%>" size="26" style="height: 19px; float: left;"> 
				${memberEndTime}
				</td>
			</tr> 
			<tr>
				<td align="left"><font size="5" color="blue">Day</font></td>
				<td><input type="text"  name="txtMemberDay" placeholder="Time" maxlength="10" value="<%=memberScheduleDetailsBean.getMemberDay()%>" size="26" style="height: 19px; float: left;"> 
				${memberDay}
				</td>
			</tr> 
			<tr>
				<td align="center">
					<br> 
					<input type="reset" value="Reset" name="reset" style="background-color: red; color: white; width: 100px; height: 30px">
				</td>

				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>

				<td>
					<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="Submit" value="Ragister" name="submit" style="background-color: Green; color: white; width: 100px; height: 30px">
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</form>

</body>
</html>