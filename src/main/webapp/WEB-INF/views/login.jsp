<%@include file="/common/Taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<!-- Custom styles for this template-->
<link href="<c:url value='/template/admin/css/sb-admin.css'/>"
	rel="stylesheet" type="text/css">
<title>login</title>
</head>
<body class="bg-dark">
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Login</div>
			<div class="card-body">
			<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">
							Username or password incorrect!
					</div>
			</c:if>
				<form action="j_spring_security_check" method="post">
					<div class="form-group">
						<div class="form-label-group">
							<input type="text" id="inputEmail" class="form-control" placeholder="username" required="required" autofocus="autofocus" name="j_username"> 
								<label for="inputEmail">Username</label>
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="password" id="inputPassword" class="form-control"  placeholder="Password" required="required" name="j_password"> 
							<label for="inputPassword">Password</label>
						</div>
					</div>
					<div class="form-group">
						<div class="checkbox">
							<label> <input type="checkbox" value="remember-me">
								Remember Password
							</label>
						</div>
					</div>
					<a class="btn btn-primary btn-block" href="#">Login</a>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="register.html">Register an
						Account</a> <a class="d-block small" href="forgot-password.html">
						Forgot Password?</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>