<%@page import="com.designhub.fitnessplus.bean.PackageDurationBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.dao.PackageDurationDAO"%>
<%@page import="com.designhub.fitnessplus.bean.PackageDetailsBean"%>
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
		PackageDetailsBean packageDetails = (PackageDetailsBean) request.getAttribute("packageDetails");
		if (packageDetails != null) {
%>
<form method="post" action="PackageDetailsUpdateServlet">
<input type="hidden" name="packageDetailsId" value="${packageDetails.packageDetailsId}${packageDetailsId}">
<table>
		
		<tr>
			<th align="left"><font size="5" color="blue">Package Name</font></th>
			<th><font size="5" color="red">:</font></th>
			<td><input type="text" name="txtPackageName" id="txtPackageName" readonly="readonly" value='${packageDetails.packageName}${txtPackageName}' size="30">${packageName}</td>
		</tr>
		
		<tr>
				<th align="left"><font size="5" color="blue">Package Duration</font></th>
				<th><font size="5" color="red">:</font></th>
				<td><select name="selPackageDurationTime" id="selPackageDurationTime">
					<option value="0">Select Duration</option>
				
					<%  
					
				//	PackageDetailsBean packageDetails = (PackageDetailsBean)request.getAttribute("packageDetails");					
					PackageDurationDAO packageDurationDAO = new PackageDurationDAO();
					
					List<PackageDurationBean> packageDurationList = packageDurationDAO.list();
					
					for(int i=0;i<packageDurationList.size();i++){
						PackageDurationBean packageDuration = packageDurationList.get(i);
						
						
						if(packageDuration.getPackageDurationId().equals(packageDetails.getPackageDurationId()))
						{
						%>
							<option value="<%=packageDuration.getPackageDurationId()%>" selected="selected"><%=packageDuration.getPackageDurationTime()%></option>
						<%
						}		
						else
						{
				 			%>
					 			<option value="<%=packageDuration.getPackageDurationId()%>"><%=packageDuration.getPackageDurationTime()%></option>
							<%
						}
					} 
					
					
					
					%>

			</select>
				${msgPackageDurationTime}
			</td>
				
				
			</tr>
			
			<tr>
				<th align="left"><font size="5" color="blue">Package Rate</font></th>
				<th><font size="5" color="red">:</font></th>
				<td><input type="text"  name="txtPackageRate" placeholder="Rs." maxlength="5" value="${packageDetails.packageRate}" size="26" style="height: 19px; float: left;"> 
				${packageRate}</td>
			</tr> 
		<tr>
				<td align="center"><br> <input type="reset" value="Reset"
					name="reset"
					style="background-color: red; color: white; width: 100px; height: 30px">
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="Submit" value="Ragister" name="submit"
					style="background-color: Green; color: white; width: 100px; height: 30px">
				</td>
			</tr>		
</table>
</form>	
<%}else{System.out.println("Null value get");} %>
</body>
</html>