<%@page import="com.designhub.fitnessplus.bean.PackageDurationBean"%>
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
	<center>
		
		<table border="1" align="center" width="50%">

				<%  
					ArrayList<PackageDurationBean> listOfPackageDuration = (ArrayList) request.getAttribute("listOfPackageDuration");
				
					if(listOfPackageDuration!=null)
					{
					%>
						<tr>

							<th>Package Duration Id</th>
							<th>Package Duration Time</th>
							<th>Action</th>	
						</tr>
						
						<%
							
							for(int i=0;i<listOfPackageDuration.size();i++)
							{
								PackageDurationBean packageDurationBean = listOfPackageDuration.get(i);
								
								%>
								
								<tr>
								
									<td align="center"><%= packageDurationBean.getPackageDurationId() %></td>
									<td align="center"><%= packageDurationBean.getPackageDurationTime() %></td>
									
									<td align="center">
										<a href="PackageDurationEditServlet?aid=<%= packageDurationBean.getPackageDurationId() %>">Change</a>
										<a href="PackageDurationDeleteServlet?aid=<%= packageDurationBean.getPackageDurationId() %>">Delete</a>		
									</td>
								
								</tr>
								
								<%
							}
						}
						
					
						else
						{
							%>
							
							<h1> No Record Found....!</h1>
							<%
						}
				
				%>
				
				

			</table>
		
		
	</center>

</body>
</html>