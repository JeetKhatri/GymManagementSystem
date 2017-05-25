<%@page import="com.designhub.fitnessplus.bean.AreaBean"%>
<%@page import="com.designhub.fitnessplus.dao.AreaDAO"%>
<%@page import="com.designhub.fitnessplus.bean.GymDetailsBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.dao.GymDetailsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="GymImageInsertServlet" name="studentPage"
		id="studentPage" method="post" enctype="multipart/form-data">
		
		<table>


			<tr>
				<td align="left"><font size="5" color="blue">Gym Photo</font></td>
				<td><font size="5" color="red">:</font></td>
				<td colspan="2"><input type="file" name="photo"
					id="photo" value="${photo}" accept="image/*">${photo}</td>
			</tr>


			<tr>
				<th align="left"><font size="5" color="blue">GYM Name</font></th>
				<th><font size="5" color="red">:</font></th>
				<td>
					<select name="selGymName" id="selGymName">
					<option value="0" selected="selected">Select Gym</option>
					<% 
						GymDetailsDAO gymDetailsDAO = new GymDetailsDAO();
						List<GymDetailsBean> gymDetailsList = gymDetailsDAO.list();
						
						for(int i=0;i<gymDetailsList.size();i++)
						{
	
							String tmp="unselected";
							String type=request.getParameter("selGymName");
							if(type==null)
								tmp="unselected";
							else if(gymDetailsList.get(i).getGymDetailsId().equals(type))
								tmp="selected";
					%>	
	
					<option value=<%=gymDetailsList.get(i).getGymDetailsId()%> <%=tmp %> > <%=gymDetailsList.get(i).getAreaName() %></option>
					<% 
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

		</table>
	</form>
</body>
</html>