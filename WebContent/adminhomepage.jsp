<%@page import="java.sql.SQLException"%>
<%@page import="com.designhub.fitnessplus.util.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Home Page</title>


<link rel="stylesheet"
	href="fitnessplus-Cascading Style Sheet/kendo.common-material.min.css" />
<link rel="stylesheet"
	href="fitnessplus-Cascading Style Sheet/kendo.material.min.css" />

<script src="fitnessplus - Javascript/jquery.min.js"></script>
<script src="fitnessplus - Javascript/kendo.all.min.js"></script>

<link rel="stylesheet" href="admin/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="admin/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="admin/dist/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="admin/plugins/iCheck/flat/blue.css">
<link rel="stylesheet" href="admin/plugins/morris/morris.css">
<link rel="stylesheet"
	href="admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet" href="admin/plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="admin/plugins/daterangepicker/daterangepicker-bs3.css">
<link rel="stylesheet"
	href="admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

</head>
<body>

	<%
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		int cntUsers=0;
		int cntFeedback=0;
		int cntUserInquiry=0;
		int cntTrainer=0;
		int cntMemberSchedule=0;
		int cntTrainerSchedule=0;
		int cntClasses=0;
		
		AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");

		if (adminBean != null && adminBean.getAdminId() != null) {
	%>
	<%@ include file="admin/adminHeader.jsp"%>
	<div class="content-wrapper" style="margin-top: -1000px">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Dashboard <small>Control panel</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="adminhomepage.jsp"><i
					class="fa fa-dashboard"></i> Home</a>
			</li>
			<li class="active">Dashboard</li>
		</ol>

		<br>
		<br>
		<br>
		


		
		</section>
		<section class="content">
          <!-- Small boxes (Stat box) -->
          <div class="row">
            <div class="col-lg-3 col-xs-6">
              
              <div class="small-box bg-aqua">
                <div class="inner">
                  <h3><font face="Comic Sans MS" size="5" >No of <br>Trainer</font></h3>
                	 <p align="center">
                  	<%
        				conn = DBConnection.getConnection();
                  
                  	if(conn!=null)
                	  {
                		  String getTrainer = "Select * from trainer";
                	  	try {
          					pstmt = conn.prepareStatement(getTrainer);
          			
          					rs = pstmt.executeQuery();

          					while(rs.next()){
          						cntTrainer++;
          					}
          				
          				
          				 } catch (SQLException e) {
          					e.printStackTrace();
          				}
                 	 }
                  	
                  	%>
                  
                  <%=cntTrainer %>
                  
                  
                  </p>
                </div>
                <a href="TrainerListServlet" class="small-box-footer"> Manage Trainer <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-green">
                <div class="inner">
                 <h3><font face="Comic Sans MS" size="5" > No of <br>Members </font></h3>
                 <p align="center">
                  <%
        			conn = DBConnection.getConnection();
                  
                  if(conn!=null)
                  {
                	  String getUsers = "Select * from member";
                	  try {
          				pstmt = conn.prepareStatement(getUsers);
          			
          				rs = pstmt.executeQuery();

          				while(rs.next()){
          					cntUsers++;
          				}
          				
          				
          			 } catch (SQLException e) {
          				e.printStackTrace();
          			}
                  }
                  	
                  %>
                  
                  <%=cntUsers %>
                  
                  
                  </p>
                </div>
                <a href="MemberListServlet" class="small-box-footer"> Manage Member <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-yellow">
                <div class="inner">
                <h3><font face="Comic Sans MS" size="5" >Member Progresses</font></h3>
                  <p>view user report</p>
                </div>
                <a href="memberProgressListServlet" class="small-box-footer">  Progress <br>Reports <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-red">
                <div class="inner">
                  <h3><font face="Comic Sans MS" size="5" >No of <br>FeedBack</font></h3>
                  <p align="center">

				<%
        			conn = DBConnection.getConnection();
                  
                  if(conn!=null)
                  {
                	  String getFeedback = "Select * from feedback";
                	  try {
          				pstmt = conn.prepareStatement(getFeedback);
          			
          				rs = pstmt.executeQuery();

          				while(rs.next()){
          					cntFeedback++;
          				}
          				
          				
          			 } catch (SQLException e) {
          				e.printStackTrace();
          			}
                  }
                  	
                  %>
                  
                  <%=cntFeedback %>
 

				</p>
                </div>
                <a href="feedbackListServlet" class="small-box-footer">Manage FeedBack <i class="fa fa-arrow-circle-right"></i></a>
              </div>
           </div>
           </div>
           
           <div class="row">
           	<div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-red">
                <div class="inner">
                <h3><font face="Comic Sans MS" size="5"> Member Schedule </font></h3>
                  <p align="center">
                  <%
        			conn = DBConnection.getConnection();
                  
                  if(conn!=null)
                  {
                	  String getMemberSchedule = "Select * from memberSchedule";
                	  try {
          				pstmt = conn.prepareStatement(getMemberSchedule);
          			
          				rs = pstmt.executeQuery();

          				while(rs.next()){
          					cntMemberSchedule++;
          				}
          				
          				
          			 } catch (SQLException e) {
          				e.printStackTrace();
          			}
                  }
                  	
                  %>
                  
                  <%=cntUsers %>
                  
                  
                  </p>
                </div>
                <a href="MemberScheduleListServlet" class="small-box-footer"> View Members Schedule<i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div>

           	<div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-yellow">
                <div class="inner">
                <h3><font face="Comic Sans MS" size="5"> Trainer Schedule </font></h3>
                  <p align="center">
                  <%
        			conn = DBConnection.getConnection();
                  
                  if(conn!=null)
                  {
                	  String getTrainerSchedule = "Select * from trainerSchedule";
                	  try {
          				pstmt = conn.prepareStatement(getTrainerSchedule);
          			
          				rs = pstmt.executeQuery();

          				while(rs.next()){
          					cntTrainerSchedule++;
          				}
          				
          				
          			 } catch (SQLException e) {
          				e.printStackTrace();
          			}
                  }
                  	
                  %>
                  
                  <%=cntTrainerSchedule %>
                  
                  
                  </p>
                </div>
                <a href="TrainerScheduleListServlet" class="small-box-footer"> View Trainers Schedule<i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div>


			           	<div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-green">
                <div class="inner">
                <h3><font face="Comic Sans MS" size="5"> Total Classes </font></h3>
                  <p align="center">
                  <%
        			conn = DBConnection.getConnection();
                  
                  if(conn!=null)
                  {
                	  String getClasses= "Select * from activity";
                	  try {
          				pstmt = conn.prepareStatement(getClasses);
          			
          				rs = pstmt.executeQuery();

          				while(rs.next()){
          					cntClasses++;
          				}
          				
          				
          			 } catch (SQLException e) {
          				e.printStackTrace();
          			}
                  }
                  	
                  %>
                  
                  <%=cntClasses %>
                  
                  
                  </p>
                </div>
                <a href="ActivityListServlet" class="small-box-footer"> Manage Classes<i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div>
            
            
			<div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-aqua">
                <div class="inner">
                <h3><font face="Comic Sans MS" size="5"> Inquiry </font></h3>
                  <p align="center">
                  <%
        			conn = DBConnection.getConnection();
                  
                  if(conn!=null)
                  {
                	  String getUserInquiry = "Select * from userInquiry";
                	  try {
          				pstmt = conn.prepareStatement(getUserInquiry);
          			
          				rs = pstmt.executeQuery();

          				while(rs.next()){
          					cntUserInquiry++;
          				}
          				
          				
          			 } catch (SQLException e) {
          				e.printStackTrace();
          			}
                  }
                  	
                  %>
                  
                  <%=cntUserInquiry %>
                  
                  
                  </p>
                </div>
                <a href="UserInquiryListServlet" class="small-box-footer"> View User Inquiries<i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div>
            
            
          
           
           </section>
	</div>


	<script src="admin/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<script>

		$.widget.bridge('uibutton', $.ui.button);
	script>
	<script src="admin/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="admin/plugins/morris/morris.min.js"></script>
	<script src="admin/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script src="admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script src="admin/plugins/knob/jquery.knob.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
	<script src="admin/plugins/daterangepicker/daterangepicker.js"></script>
	<script src="admin/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script src="admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="admin/plugins/fastclick/fastclick.min.js"></script>
	<script src="admin/dist/js/app.min.js"></script>
	<script src="admin/dist/js/pages/dashboard.js"></script>
	<script src="admin/dist/js/demo.js"></script>
	<%
		} else {
			response.sendRedirect("userlogin.jsp");

		}
	%>
</body>
</html>

