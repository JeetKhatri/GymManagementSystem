<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.designhub.fitnessplus.util.DBConnection"%>
<%@page import="com.designhub.fitnessplus.bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>FitnessPLUS | Member Home</title>
    <link rel="stylesheet" href="../admin/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="et" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../admin/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="../admin/dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="../admin/plugins/iCheck/flat/blue.css">
    <link rel="stylesheet" href="../admin/plugins/morris/morris.css">
    <link rel="stylesheet" href="../admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="../admin/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="../admin/plugins/daterangepicker/daterangepicker-bs3.css">
    <link rel="stylesheet" href="../admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <style type="text/css">
    
    .table {
	width: 75%;
	max-width: 100%;
	margin-bottom: 20px;
	margin-left: 370;
}
    </style>
  </head>
  <body class="hold-transition skin-blue sidebar-mini">
  
  <%
	  Connection conn = null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	
	int cntUsers=0;
	int cntFeedback=0;
	int cntUserInquiry=0;
	int cntTrainer=0;
		MemberBean memberBean = (MemberBean) session.getAttribute("memberBean");
  
		if (memberBean != null && memberBean.getMemberId() != null) {
		System.out.print("Hello" + memberBean.getMemberId());
	%>
    <div class="wrapper">
		
      <header class="main-header">
        <a href="memberHomePage.jsp" class="logo">
          <span class="logo-mini"><b>F</b>+</span>
          <span class="logo-lg"><b>Fitness</b>PLUS</span>
        </a>
        <nav class="navbar navbar-static-top" role="navigation">
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            
          </a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- User Account: style can be found in dropdown.less -->
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <img src="avatar5.png" class="user-image" alt="User Image">
                  <span class="hidden-xs">   <%= memberBean.getMemberFirstName() %>   </span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                    <img src="avatar5.png" class="img-circle" alt="User Image">
                    <p>
                      <%= memberBean.getMemberFirstName() + " " +memberBean.getMemberLastName()  %> 
                    </p>
                  </li>
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="memberProfile.jsp?memberId=<%= memberBean.getMemberId()%>" class="btn btn-default btn-flat">Profile</a>
                    </div>
                   
                    <div class="pull-right">
                      <a href="../LogoutServlet" class="btn btn-default btn-flat">Sign out</a>
                    </div>
                  </li>
                </ul>
              </li>
              <!-- Control Sidebar Toggle Button -->
              <li>
               <!-- <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>-->
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="avatar5.png" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p><%= memberBean.getMemberFirstName() %></p>
              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="active treeview">
              <a href="memberHomePage.jsp">
                <i class="fa fa-home"></i> <span>Home</span> 
              </a>
            </li>
            
            <li class="treeview">
              <a href="memberProfile.jsp?memberId=<%= memberBean.getMemberId()%>"><i class="fa fa-envelope-square"></i><span> Personal Information</span></a>
              </li>
              
              <li class="treeview">
              <a href="../GetScheduleListServlet"><i class="fa fa-comments-o"></i><span> Schedule</span></a>
              </li>
            
            <li>
              <a href="../GetMemberProgressList?memberId=<%= memberBean.getMemberId()%>">
              <i class="glyphicon glyphicon-th-list"></i> <span>Progress Report</span>
              </a>
            </li>
            
            <li>
              <a href="feedbackInsert.jsp">
              <i class="glyphicon glyphicon-th-list"></i> <span>Feedback</span>
              </a>
            </li>
            
          </ul>
        </section>
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
          
            Home
            <small>Control panel</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="memberHomePage.jsp"><i class="fa fa-home"></i> Home</a></li>
            
          </ol>
        </section>
		<br><br>
        <!-- Main content -->
        <section class="content">
          <!-- Small boxes (Stat box) -->
          <div class="row">
            <div class="col-lg-3 col-xs-6" align="center">
              
              <div class="small-box bg-yellow">
                <div class="inner">
                  <h3><font face="Comic Sans MS" size="5" >Number of <br> Trainer</font></h3>
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
                <div class="icon">
                  <i class="ion ion-bag"></i>
                </div>
                <a href="" class="small-box-footer"> <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
			
			<div class="col-lg-3 col-xs-6" align="center">
              <div class="small-box bg-aqua">
                <div class="inner">
                  <h3><font face="Comic Sans MS" size="5" >Number of <br> Members</font></h3>
                	 <p align="center">
                  	<%
        				conn = DBConnection.getConnection();
                  
                  	if(conn!=null)
                	  {
                		  String getMember = "Select * from member";
                	  	try {
          					pstmt = conn.prepareStatement(getMember);
          			
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
                <div class="icon">
                  <i class="ion ion-bag"></i>
                </div>
                <a href="" class="small-box-footer">  <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->

            </div>
           </section>
           </div>
           </div>
           <form name="sliderForm" style="margin-top: -750px; margin-left: 225px;">
           <br><br>
                      <%@ include file="memberHeaderSlider.jsp" %>
             </form>
             
    <script src="../admin/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <script>
      $.widget.bridge('uibutton', $.ui.button);
    </script>
    <script src="../admin/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="../admin/plugins/morris/morris.min.js"></script>
    <script src="../admin/plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="../admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="../admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script src="../admin/plugins/knob/jquery.knob.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
    <script src="../admin/plugins/daterangepicker/daterangepicker.js"></script>
    <script src="../admin/plugins/datepicker/bootstrap-datepicker.js"></script>
    <script src="../admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <script src="../admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="../admin/plugins/fastclick/fastclick.min.js"></script>
    <script src="../admin/dist/js/app.min.js"></script>
    <script src="../admin/dist/js/pages/dashboard.js"></script>
    <script src="../admin/dist/js/demo.js"></script>
    <%}else{
	response.sendRedirect("../userlogin.jsp");
	
} %>
  </body>
</html>
