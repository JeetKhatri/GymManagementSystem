<%@page import="com.designhub.fitnessplus.bean.PackageBean"%>
<%@page import="com.designhub.fitnessplus.dao.PackageDAO"%>
<%@page import="com.designhub.fitnessplus.bean.PackageDurationBean"%>
<%@page import="java.util.List"%>
<%@page import="com.designhub.fitnessplus.dao.PackageDurationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="PackageDetailsInsertServlet" method="post"
		name="packageForm">
		<table>
			<tr>
				<th align="left"><font size="5" color="blue">Package Name</font></th>
				<th><font size="5" color="red">:</font></th>
				<td>
					<select name="selPackageName" id="selPackageName">
					<option value="0" selected="selected">Select Package</option>
					<% 
						PackageDAO packageDAO = new PackageDAO();
						List<PackageBean> packageList = packageDAO.list();
						
						for(int i=0;i<packageList.size();i++)
						{
	
							String tmp="unselected";
							String type=request.getParameter("selPackageName");
							if(type==null)
								tmp="unselected";
							else if(packageList.get(i).getPackageId().equals(type))
								tmp="selected";
					%>	
	
					<option value=<%= packageList.get(i).getPackageId() %> <%=tmp %> > <%= packageList.get(i).getPackageName()%></option>
					<% 
						}
					%>
					</select>
				${msgPackageName}
				</td>
			</tr>
	
			<tr>
				<th align="left"><font size="5" color="blue">Package
						Duration</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td><select name="selPackageDurationTime"
					id="selPackageDurationTime">
						<option value="0" selected="selected">Select Duration</option>
						<%
							PackageDurationDAO packageDurationDAO = new PackageDurationDAO();
							List<PackageDurationBean> packageDurationList = packageDurationDAO
									.list();

							for (int i = 0; i < packageDurationList.size(); i++) {

								String tmp = "unselected";
								String type = request.getParameter("selPackageDurationTime");
								if (type == null)
									tmp = "unselected";
								else if (packageDurationList.get(i).getPackageDurationId()
										.equals(type))
									tmp = "selected";
						%>

						<option
							value=<%=packageDurationList.get(i).getPackageDurationId()%>
							<%=tmp%>>
							<%=packageDurationList.get(i).getPackageDurationTime()%></option>
						<%
							}
						%>
				</select> ${msgPackageDurationTime}</td>
			</tr>

			<tr>
				<th align="left"><font size="5" color="blue">Package
						Rate</font>
				</th>
				<th><font size="5" color="red">:</font>
				</th>
				<td><input type="text" name="txtPackageRate" placeholder="Rs."
					maxlength="5" value="${txtPackageRate}" size="26"
					style="height: 19px; float: left;"> ${packageRate}</td>
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
</body>
</html>