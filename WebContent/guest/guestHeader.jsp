<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
         
        <title>FitnessPLUS </title>
        
        <!-- Favicon and Apple icon -->
        <link href="favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon">
        <link href="apple_touch_icon.png" rel="apple-touch-icon-precomposed">
        
        <link href="css/bootstrap.css" rel="stylesheet"><!-- Bootstrap Styles -->
        <link href="css/theme.css" rel="stylesheet"><!-- Main Template Styles -->
        <link href="css/schedule.css" rel="stylesheet"><!-- Schedule CSS -->
        
           <link rel="stylesheet" href="../admin/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    	<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    	<link rel="stylesheet" href="../admin/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    	<link rel="stylesheet" href="../admin/dist/css/skins/_all-skins.min.css">
    <!-- iCheck -->
    	<link rel="stylesheet" href="../admin/plugins/iCheck/flat/blue.css">
    <!-- Morris chart -->
    	<link rel="stylesheet" href="../admin/plugins/morris/morris.css">
    <!-- jvectormap -->
    	<link rel="stylesheet" href="../admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <!-- Date Picker -->
    	<link rel="stylesheet" href="../admin/plugins/datepicker/datepicker3.css">
    <!-- Daterange picker -->
  		<link rel="stylesheet" href="../admin/plugins/daterangepicker/daterangepicker-bs3.css">
    <!-- bootstrap wysihtml5 - text editor -->
  	  	<link rel="stylesheet" href="../admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">	

        
        
    </head>
    <body class="tm-isblog tm-page-classes">
        <div class="ak-page">
            <!-- START Main menu -->
            <nav class="tm-navbar uk-navbar uk-navbar-attached">
                <div class="uk-container uk-container-center">
                    <!-- START Logo -->
                    <a class="tm-logo" href=".//index.html">
                        <span class="color-1">Fitness </span><span class="color-2">PLUS</span>
                    </a>
                    <!-- END Logo -->
                    <ul class="uk-navbar-nav uk-hidden-small">
                    
                    <li class="treeview uk-active">
              			<a href="../index.html"><span> HOME <i class="fa fa-home"></i></span></a>
             			 </li>
      
                          <li class="uk-parent" data-uk-dropdown="{}" aria-haspopup="true" aria-expanded="false">
                            <a href=""><span> The GYM <i class="fa fa-get-pocket"></i></span></a>
                            <div class="uk-dropdown uk-dropdown-navbar uk-dropdown-width-1">
                                <div class="uk-grid uk-dropdown-grid">
                                    <div class="uk-width-1-1">
                                        <ul class="uk-nav uk-nav-navbar">    
                                            <li><a href="Equipment.jsp"><i class="fa fa-home"></i><font color="#000000">  Equipment </font></a></li>
                                            <li><a href="aboutUs.jsp"><i class="fa fa-info-circle"></i><font color="#000000">  About us </font></a></li>
                                            <li><a href="membershipPlan.jsp"><i class="fa fa-clock-o"></i><font color="#000000"> MemberShip &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Plan </font></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li><a href="schedule.jsp">Schedule</a></li>
                        <li class="uk-parent" data-uk-dropdown="{}" aria-haspopup="true" aria-expanded="false">
                            <a href="classes.html">Classes <i class="fa fa-get-pocket"></i></a>
                            <div class="uk-dropdown uk-dropdown-navbar ">
                               <div class="uk-grid uk-dropdown-grid">
                                  <div class="uk-width-1-1">
                                     <ul class="uk-nav uk-nav-navbar">
                                         <li><a href="classes/yoga.jsp"><font color="#000000"> Yoga </font></a></li>
                                         <li><a href="classes/pranayam.jsp"><font color="#000000"> pranayam </font></a></li>
                                		<li><a href="classes/abs.jsp"><font color="#000000"> abs </font></a></li>
                                        <li><a href="classes/cardaio.jsp"><font color="#000000"> cardaio </font></a></li>
                                        <li><a href="classes/pilates.jsp"><font color="#000000">Pilates</font></a></li>
                                        <li><a href="classes/stretching.jsp"><font color="#000000">stretching</font></a></li>
                                         </ul>
                                    </div>
                                </div>
                            </div>
                        </li>
                       
                        <li><a href="trainer.jsp">Trainers</a></li>
                        <li><a href="gallery.html">Gallery</a></li>
                    	 <li class="treeview uk-active">
                        	<a href="../userlogin.jsp">
                    		<i class="fa fa-sign-in"></i> Login
                 			</a>
                 		</li>
                    </ul>
                    <a href="#offcanvas" class="uk-navbar-toggle uk-visible-small" data-uk-offcanvas=""></a>
                </div>
            </nav>
        </div>
        <div>
        </div>
        
        
        	<!--ADMIN START-->
        
        <!-- jQuery 2.1.4 -->
    <script src="../admin/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
      $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Bootstrap 3.3.5 -->
    <script src="../admin/bootstrap/js/bootstrap.min.js"></script>
    <!-- Morris.js charts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="../admin/plugins/morris/morris.min.js"></script>
    <!-- Sparkline -->
    <script src="../admin/plugins/sparkline/jquery.sparkline.min.js"></script>
    <!-- jvectormap -->
    <script src="../admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="../admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <!-- jQuery Knob Chart -->
    <script src="../admin/plugins/knob/jquery.knob.js"></script>
    <!-- daterangepicker -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
    <script src="../admin/plugins/daterangepicker/daterangepicker.js"></script>
    <!-- datepicker -->
    <script src="../admin/plugins/datepicker/bootstrap-datepicker.js"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="../admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <!-- Slimscroll -->
    <script src="../admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <!-- FastClick -->
    <script src="../admin/plugins/fastclick/fastclick.min.js"></script>
    <!-- AdminLTE App -->
    <script src="../admin/dist/js/app.min.js"></script>
    <!--  dashboard demo (This is only for demo purposes) -->
    <script src="../admin/dist/js/pages/dashboard.js"></script>
    <!--  demo purposes -->
    <script src="../admin/dist/js/demo.js"></script>
    
    <!--ADMIN   END-->
 
        
        <script src="js/jquery.min.js" type="text/javascript"></script><!-- jQuery v1.11.2 -->
        <script src="js/bootstrap.min.js" type="text/javascript"></script><!-- Bootstrap.js Custom version for HTML! -->
        
        <!-- UIkit Version 2.19.0 -->
        <script src="js/uikit/js/uikit.js" type="text/javascript"></script>
        <script src="js/uikit/js/components/slideshow.js" type="text/javascript"></script>
        <script src="js/uikit/js/components/slideshow-fx.js" type="text/javascript"></script>
        <script src="js/uikit/js/core/cover.js" type="text/javascript"></script>
        <script src="js/uikit/js/core/modal.js" type="text/javascript"></script>
        <script src="js/uikit/js/components/lightbox.js" type="text/javascript"></script>
        
        <!-- Animated circular progress bars -->
        <script src="js/circle-progress.js" type="text/javascript"></script>
        
        <!-- START Schedule block -->
        <script src="js/jquery.mousewheel.js" type="text/javascript"></script><!-- Uses for Schedule -->
        <script src="js/jquery.jscrollpane.min.js" type="text/javascript"></script><!-- Uses for Schedule -->
        <!-- END Schedule block -->
        
        <!-- Template scripts -->
        <script src="js/script.js" type="text/javascript"></script>
        
    </body>


</html>