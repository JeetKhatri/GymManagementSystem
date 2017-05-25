<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-gb" dir="ltr">
    
<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="With unique design and accent in details Maxx Fitness is perfect template. Design have beautiful typography and elegant structure. HTML Template is based on Warp7 Framework and made for all who wants a lightweight and modular website.">
        
        <title>Trainers</title>
        
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
    <body class="tm-isblog">
        <div class="ak-page">
            <!-- START Main menu -->
              <nav class="tm-navbar uk-navbar uk-navbar-attached">
                <div class="uk-container uk-container-center">
                    <!-- START Logo -->
                    <a class="tm-logo" href="../index.html">
                        <span class="color-1">Fitness </span><span class="color-2">PLUS</span>
                    </a>
                    <!-- END Logo -->
                    <ul class="uk-navbar-nav uk-hidden-small">
                    
                    <li class="treeview ">
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
                                            <li><a href="membershipPlan.jsp"><i class="fa fa-clock-o"></i><font color="#000000"> MemberShip &nbsp;&nbsp;&nbsp;&nbsp;Plan </font></a></li>
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
            <!-- END Main menu -->
            
            <!-- START Central block -->
            <div class="uk-container uk-container-center">
                <div class="tm-middle uk-grid" data-uk-grid-match="" data-uk-grid-margin="">
                    <div class="tm-main uk-width-medium-1-1">
                        <main class="tm-content uk-position-relative">
                            <!-- START breadcrumb block -->
                            <ul class="uk-breadcrumb">
                                <li><a href="../index.html">Home</a></li>
                                <li class="uk-active"><span>Trainers</span></li>
                            </ul>
                            <!-- END breadcrumb block -->
                            
                            <div id="system-message-container"></div>
                            
                            <div class="uk-grid">
                                <div class="uk-width-1-1">
                                    <div class="uk-panel uk-panel-header">
                                        <h1 class="tm-title">Trainers</h1>
                                    </div>
                                </div>
                            </div>
                            
                            
                            
                            <!-- START Article block -->
                            <div class="uk-grid" data-uk-grid-match="" data-uk-grid-margin="">
                                <div class="uk-width-medium-1-2">
                                    <article class="uk-article">
                                        <h2 class="uk-article-title">
                                            <a href="trainers/trainer_11.jsp" >Harsh Raval</a>
                                        </h2>
                                        <a class="uk-align-left" href="trainers/trainer_11.jsp" title=""><img src="images/demo/trainers/trainer-11.jpg" alt=""></a>
                                        <div>
                                            <p>Abs Trainer</p>
                                            <div class="jcomments-links">
                                                <a class="readmore-link" href="trainers/trainer_11.jsp" title="Harsh Raval">Read more ...</a>
                                            </div>
                                        </div>
                                    </article>
                                    <article class="uk-article">
                                        <h2 class="uk-article-title">
                                            <a href="trainers/trainer_89.jsp">Tyler Brown</a>
                                        </h2>
                                        <a class="uk-align-left" href="trainers/trainer_89.jsp" title=""><img src="images/demo/trainers/trainer-89.jpg" alt=""></a>
                                        <div>
                                            <p>Personal Trainer</p>
                                            <div class="jcomments-links">
                                                <a class="readmore-link" href="trainers/trainer_89.jsp" title="Tyler Brown">Read more ...</a>
                                            </div>
                                        </div>
                                    </article>
                                    <article class="uk-article">
                                        <h2 class="uk-article-title">
                                            <a href="trainers/trainer_55.jsp">Sonal Chauhan</a>
                                        </h2>
                                        <a class="uk-align-left" href="trainers/trainer_55.jsp" title=""><img src="images/demo/trainers/trainer-55.jpg" alt=""></a>
                                        <div>
                                            <p>Cardio Trainer</p>
                                            <div class="jcomments-links">
                                                <a class="readmore-link" href="trainers/trainer_55.jsp" title="Sonal Chauhan">Read more ...</a>
                                            </div>
                                        </div>
                                    </article>
                                    <article class="uk-article">
                                        <h2 class="uk-article-title">
                                            <a href="trainers/trainer_77.jsp" >Vijay Kapoor</a>
                                        </h2>
                                        <a class="uk-align-left" href="trainers/trainer_77.jsp" title=""><img src="images/demo/trainers/trainer-77.jpg" alt=""></a>
                                        <div>
                                            <p>Streching Trainer</p>
                                            <div class="jcomments-links">
                                                <a class="readmore-link" href="trainers/trainer_77.jsp" title="Vijay Kapoor">Read more ...</a>
                                            </div>
                                        </div>
                                    </article>
                                </div>
                                <div class="uk-width-medium-1-2" style="min-height: 1671px;">
                                    <article class="uk-article">
                                        <h2 class="uk-article-title">
                                            <a href="trainers/trainer_22.jsp" >Naomi Staver</a>
                                        </h2>
                                        <a class="uk-align-left" href="trainers/trainer_22.jsp" title=""><img src="images/demo/trainers/trainer-22.jpg" alt=""></a>
                                        <div>
                                            <p>Pilates Trainer</p>
                                            <div class="jcomments-links">
                                                <a class="readmore-link" href="trainers/trainer_22.jsp" title="Naomi Staver">Read more ...</a>
                                            </div>
                                        </div>
                                    </article>
                                    <article class="uk-article">
                                        <h2 class="uk-article-title">
                                            <a href="trainers/trainer_44.jsp">Vatsal Patel</a>
                                        </h2>
                                        <a class="uk-align-left" href="trainers/trainer_44.jsp" title=""><img src="images/demo/trainers/trainer-44.jpg" alt=""></a>
                                        <div>
                                            <p>Yoga Trainer</p>
                                            <div class="jcomments-links">
                                                <a class="readmore-link" href="trainers/trainer_44.jsp" title="Vatsal Patel">Read more ...</a>
                                            </div>
                                        </div>
                                    </article>
                                    <article class="uk-article">
                                        <h2 class="uk-article-title">
                                            <a href="trainers/trainer_33.jsp">Caitlin Harrison</a>
                                        </h2>
                                        <a class="uk-align-left" href="trainers/trainer_33.jsp" title=""><img src="images/demo/trainers/trainer-33.jpg" alt=""></a>
                                        <div>
                                            <p>Personal Trainer</p>
                                            <div class="jcomments-links">
                                                <a class="readmore-link" href="trainers/trainer_33.jsp" title="Caitlin Harrison">Read more ...</a>
                                            </div>
                                        </div>
                                    </article>
                                    <article class="uk-article">
                                        <h2 class="uk-article-title">
                                            <a href="trainers/trainer_66.jsp" >Nirav Shah</a>
                                        </h2>
                                        <a class="uk-align-left" href="trainers/trainer_66.jsp" title=""><img src="images/demo/trainers/trainer-66.jpg" alt=""></a>
                                        <div>
                                            <p>Pranayam Training</p>
                                            <div class="jcomments-links">
                                                <a class="readmore-link" href="trainers/trainer_66.jsp" title="Nirav Shah">Read more ...</a>
                                            </div>
                                        </div>
                                    </article>
                                </div>
                            </div>
                            <!-- END Article block -->
                        </main>
                    </div>
                </div>
            </div>
            <!-- END Central block -->
        <%@ include file="footer.jsp" %>     
                
        </div>
        
        
        
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
 
