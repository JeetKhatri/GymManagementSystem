<%@page import="com.designhub.fitnessplus.bean.PackageBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Package List</title>
</head>
<body>
	<center>
		
		<table border="1" align="center" width="50%">

				<%  
					ArrayList<PackageBean> listOfPackage = (ArrayList) request.getAttribute("listOfPackage");;
				
					if(listOfPackage!=null)
					{
					%>
						<tr>

							<th>Package Id</th>
							<th>Package Name</th>
							<th>Action</th>	
						</tr>
						
						<%
						
							for(int i=0;i<listOfPackage.size();i++)
							{
								PackageBean packageBean = listOfPackage.get(i);
								
								%>
								
								<tr>
								
									<td align="center"><%= packageBean.getPackageId() %></td>
									<td align="center"><%= packageBean.getPackageName() %></td>
									<td align="center">
										<a href="packageEditServlet?packageId=<%= packageBean.getPackageId() %>">Change</a>
										<a href="packageDeleteServlet?packageId=<%= packageBean.getPackageId() %>">Delete</a>		
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