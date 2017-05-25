<%@page import="com.designhub.fitnessplus.bean.PackageDetailsBean"%>
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
		<input type="hidden" name="pId" id="pId">
		<input type="hidden" name="pName" id="pName">
		<table border="1" align="center" width="50%">

				<%  
					ArrayList<PackageDetailsBean> listOfPackage = (ArrayList) request.getAttribute("listOfpackage");
				
					if(listOfPackage!=null)
					{
					%>
						<tr>

							<th>Package Id</th>
							<th>Package Details Id</th>
							<th>Package Name</th>
							<th>Package Duration</th>
							<th>Package Rate</th>
							<th>Action</th>	
						</tr>
						
						<%
						
							for(int i=0;i<listOfPackage.size();i++)
							{
								PackageDetailsBean packageBean = listOfPackage.get(i);
								%>
								
								<tr>
								
									<td align="center"><%= packageBean.getPackageId() %></td>
									<td align="center"><%= packageBean.getPackageDetailsId() %></td>
									<td align="center"><%= packageBean.getPackageName() %></td>
									<td align="center"><%= packageBean.getPackageDurationTime() %></td>
									<td align="center"><%= packageBean.getPackageRate() %></td>
									<td align="center">
										<a href="PackageDetailsEditServlet?packageDetailsId=<%= packageBean.getPackageDetailsId() %>">Change</a>
										<a href="PackageDetailsDeleteServlet?packageDetailsId=<%= packageBean.getPackageDetailsId() %>">Delete</a>	
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