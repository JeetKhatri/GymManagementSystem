<%@page import="com.designhub.fitnessplus.bean.TrainerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>FitnessPLUS | Dashboard</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="../admin/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../admin/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="../admin/dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="../admin/plugins/iCheck/flat/blue.css">
    <link rel="stylesheet" href="../admin/plugins/morris/morris.css">
    <link rel="stylesheet" href="../admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="../admin/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="../admin/plugins/daterangepicker/daterangepicker-bs3.css">
    <link rel="stylesheet" href="../admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
  </head>
  <body class="hold-transition skin-blue sidebar-mini">
  <%
		TrainerBean trainerBean = (TrainerBean) session
				.getAttribute("trainerBean");
  
		if (trainerBean != null && trainerBean.getTrainerId() != null) {
		System.out.print("Hello" + trainerBean.getTrainerId());
	%>
    <div class="wrapper">

      <header class="main-header">
        <a href="trainerHomePage.jsp" class="logo">
			<span class="logo-mini"><b>F</b>+</span>
			<span class="logo-lg"><b>Fitness</b>PLUS</span>
        </a>
        <nav class="navbar navbar-static-top" role="navigation">
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"></a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">           
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <img src="user7-128x128.jpg" class="user-image" alt="User Image">
                  <span class="hidden-xs">  <%= trainerBean.getTrainerFirstName() %>   </span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                    <img src="user7-128x128.jpg" class="img-circle" alt="User Image">
                    <p>
                      <%= trainerBean.getTrainerFirstName() + " " +  trainerBean.getTrainerLastName() %>
                    </p>
                  </li>      
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="trainerProfile.jsp" class="btn btn-default btn-flat">Profile</a>
                    </div>
                   
                    <div class="pull-right">
                      <a href="../LogoutServlet" class="btn btn-default btn-flat">Sign out</a>
                    </div>
                  </li>
                </ul>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <aside class="main-sidebar">
        <section class="sidebar">
          <div class="user-panel">
            <div class="pull-left image">
              <img src="user7-128x128.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p> <%= trainerBean.getTrainerFirstName() %> </p>
              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="active treeview">
              <a href="trainerHomePage.jsp">
                <i class="fa fa-home"></i> <span>Home</span> 
              </a>
            </li>
            
            <li class="treeview">
              <a href="trainerProfile.jsp?trainerId=<%= trainerBean.getTrainerId()%>"><i class="fa fa-envelope-square"></i><span> Personal Information</span></a>
              </li>
              
              <li class="treeview">
              <a href="../GetScheduleTrainerListServlet"><i class="fa fa-comments-o"></i><span> Schedule</span></a>
              </li>
            
            <li>
              <a href="../TrainerMemberProgressListServlet">
              <i class="glyphicon glyphicon-th-list"></i> <span>View Progress List</span>
              </a>
            </li>
            
            <li>
              <a href="feedbackInsert.jsp">
              <i class="glyphicon glyphicon-th-list"></i> <span>Feedback</span>
              </a>
            </li>
            
          </ul>        </section>
      </aside>
	  
      <div class="content-wrapper">
        <section class="content-header">
          <h1>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</small>
          </h1>
          <ol class="breadcrumb">
            <li> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
          </ol>
        </section>
       </div>
     
	 <div> 
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
	</div>
	<%}else{
	response.sendRedirect("../userlogin.jsp");
	
} %>
  </body>
</html>
