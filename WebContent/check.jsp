<!DOCTYPE html>
<%@page import="com.designhub.fitnessplus.bean.AdminBean"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>FitnessPLUS | Dashboard</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
    <link rel="stylesheet" href="plugins/morris/morris.css">
    <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker-bs3.css">
    <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

  </head>
  <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
      <aside class="main-sidebar">
        <section class="sidebar">
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class=" treeview">
              <a href="adminhomepage.jsp">
                <i class="fa fa-dashboard"></i> <span>Dashboard</span> 
              </a>          
            </li>
            <li class="treeview">
              <a href="MemberListServlet">
              <i class="fa fa-user"></i>
                <span>Member Management</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="memberInsert.jsp"><i class="fa fa-gg"></i> Member Ragistration </a></li>
                <li><a href="MemberListServlet"><i class="fa fa-gg"></i> Member List </a></li>
                <li><a href="memberTypeList"><i class="fa fa-gg"></i> Member Type </a></li>
                <li><a href="memberProgressListServlet"><i class="fa fa-gg"></i> Member Progress </a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="TrainerListServlet">
              <i class="fa fa-black-tie"></i>
                <span>Trainer Management</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="trainerInsert.jsp"><i class="fa fa-gg"></i> Trainer Ragistration </a></li>
                <li><a href="TrainerListServlet"><i class="fa fa-gg"></i> Trainer List </a></li>               
              </ul>
            </li>
            
            <li class="treeview">
              <a href="AdminListServlet">
              <i class="fa fa-user-secret"></i>
                <span>Admin Management</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="adminInsert.jsp"><i class="fa fa-gg"></i> Admin Ragistration </a></li>
                <li><a href="AdminListServlet"><i class="fa fa-gg"></i> Admin List </a></li>
                <li><a href="SecurityQuestionsListServlet"><i class="fa fa-gg"></i> Sequrity Questions </a></li>               
              </ul>
            </li>           
            <li class="treeview">
              <a href="ActivityListServlet">
                <i class="fa fa-picture-o"></i>
                <span>Classes</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
             <ul class="treeview-menu">
                <li><a href="activityInsert.jsp"><i class="fa fa-gg"></i> Add Classes</a></li>
                <li><a href="ActivityListServlet"><i class="fa fa-gg"></i> Show Classes</a></li>                
              </ul>
            </li>
            <li class="treeview">
              <a href="">
                <i class="fa fa-table"></i> <span>Schedule</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="MemberScheduleListServlet"><i class="fa fa-gg"></i> Member Schedule</a></li>
                <li><a href="TrainerScheduleListServlet"><i class="fa fa-gg"></i> Trainer Schedule</a></li>
              </ul>
            </li>
            
            <li class="treeview">
              <a href="#">
                <i class="fa fa-map-marker"></i> <span>Location</span>
                <i class="fa fa-angle-left pull-right"></i>           
			  </a>
              <ul class="treeview-menu">
                <li><a href="cityList"><i class="fa fa-gg"></i> City List</a></li>
                <li><a href="AreaListServlet"><i class="fa fa-gg"></i> Area List</a></li>
              </ul>
            </li>
            
             <li class="treeview">
              <a href="">
                <i class="fa fa-envelope-square"></i> <span>Feedback</span>
                <i class="fa fa-angle-left pull-right"></i>           
			  </a>
              <ul class="treeview-menu">
                <li><a href="feedbackListServlet"><i class="fa fa-gg"></i><span> Feedback</span></a></li>
                <li><a href="feedbackSubjectListServlet"><i class="fa fa-gg"></i> Feedback Subject</a></li>
              </ul>
            </li>
            <li class="treeview">
              
              </li>
              
              <li class="treeview">
				<a href="UserInquiryListServlet"><i class="fa fa-comments-o"></i><span> Inquiry</span></a>
              </li>
            
            <li>
              <a href="GymDetailsListServlet">
              <i class="glyphicon glyphicon-th-list"></i> <span>GYM Details</span>
              </a>
            </li>           
          </ul>
        </section>
      </aside>
      </div>
     
	<div>
		<script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>    
		<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
		<script>
			$.widget.bridge('uibutton', $.ui.button);
		</script>
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<script src="bootstrap/js/raphael-min.js"></script>
		<script src="plugins/morris/morris.min.js"></script>
		<script src="plugins/sparkline/jquery.sparkline.min.js"></script>    
		<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
		<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
		<script src="plugins/knob/jquery.knob.js"></script>
		<script src="bootstrap/js/moment.min.js"></script>
		<script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
		<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
		<script src="plugins/fastclick/fastclick.min.js"></script>
		<script src="dist/js/app.min.js"></script>
		<script src="dist/js/pages/dashboard.js"></script>
		<script src="dist/js/demo.js"></script>
	</div>
	 
  </body>
</html>
