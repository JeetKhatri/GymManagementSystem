<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Login Form</title>

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
<script src="admin/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script src="admin/bootstrap/js/bootstrap.min.js"></script>
<script src="admin/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="admin/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="admin/plugins/fastclick/fastclick.min.js"></script>
<script src="admin/dist/js/app.min.js"></script>
<script src="admin/dist/js/demo.js"></script>
<link rel="stylesheet" href="LogIn/assets/css/styles.css" />

<!--[if lt IE 9]>
          <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<script type="text/javascript">
	function goLogIn() {
		var f = document.login;
		f.action = "LoginServlet";
		f.submit();
	}

	function goPassword() {
		var f = document.Pass;
		f.action = "VarifyUserServlet";
		f.submit();
	}
</script>
</head>

<body>


	<div id="formContainer">
		<form id="login" method="post" action="LoginServlet" name="login">
			<a href="#" id="flipToRecover" class="flipLink">Forgot?</a> <input
				type="text" name="txtEmail" id="loginEmail" placeholder="Email"
				required> <input type="password" name="txtPassword"
				id="loginPass" placeholder="Password"> 
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" name="butoon" value="LOGIN"
				onclick="goLogIn()"class="btn btn-primary" />
		</form>
		<form id="recover" method="post" action="VarifyUserServlet"
			name="Pass">
			<a href="#" id="flipToLogin" class="flipLink">Forgot?</a> <input
				type="text" name="txtPassword" id="recoverEmail" placeholder="Email" />
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" name="butoon" value="Recover"
				onclick="goPassword()"class="btn btn-primary" />
		</form>
	</div>


	<!-- JavaScript includes -->
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="LogIn/assets/js/script.js"></script>

</body>
</html>

