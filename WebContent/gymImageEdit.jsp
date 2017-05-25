<%@page import="com.designhub.fitnessplus.bean.GymImageBean"%>
<%@page import="com.designhub.fitnessplus.bean.GymDetailsBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.dao.GymDetailsDAO"%>
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
		GymImageBean gymImageBean = (GymImageBean) request.getAttribute("gymImageBean");
		if (gymImageBean != null) {
	%>
	<form action="GymImageUpdateServlet" name="studentPage"
		id="studentPage" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" id="id"
			value="<%=gymImageBean.getGymImageId()%>">
		<table>


			<tr>
				<td align="left"><font size="5" color="blue">Gym Photo</font></td>
				<td><font size="5" color="red">:</font></td>
				<td colspan="2"><input type="file" name="photo"
					id="photo" value="<%=gymImageBean.getGymImagePath()%>" accept="image/*">${photo}</td>
			</tr>


			<tr>
			<td align="left"><font size="5" color="blue">Gym Name</font></td>
			<td><font size="5" color="red">:</font>
				</td>
			<td>
			<select name="selGymName" id="selGymName">
				<option value="0">Select Gym</option>
				
				<%  
					GymImageBean gymImage = (GymImageBean)request.getAttribute("GymImageBean");					
					GymDetailsDAO gymDetailsDAO = new GymDetailsDAO();
					
					List<GymDetailsBean> gymDetailsList = gymDetailsDAO.list();
					
					for(int i=0;i<gymDetailsList.size();i++){
						GymDetailsBean gymDetails = gymDetailsList.get(i);
						
						
						if(gymDetails.getGymDetailsId().equals(gymImage.getGymDetailsId()))
						{
						%>
							<option value="<%=gymDetails.getGymDetailsId()%>" selected="selected"><%=gymDetails.getAreaName()%></option>
						<%
						}		
						else
						{
				 			%>
					 			<option value="<%=gymDetails.getGymDetailsId()%>"><%=gymDetails.getAreaName()%></option>
							<%
						}
					} 
				%>

			</select>
				${msgGymName}
			</td>
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
</body>
</html>