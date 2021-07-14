<%@include file="/common/Taglib.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Register an Account</div>
			<div class="card-body">
				<form:form action ="register" id="formSubmit" method="POST" modelAttribute="form">
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-12">
								<div class="form-group">
									<form:input type="text" id="username" path="username" class="form-control" placeholder="Username" required="required"/> 
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<form:input type="text" id="fullname" path="fullname" class="form-control" placeholder="Fullname" required="required" />
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<div class="form-group">
									<form:input type="text" class="form-control" path="age" placeholder="Age" required="required"/> 
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<form:input type="text" class="form-control" path="address" placeholder="Address" required="required"/>									
								</div>
							</div>
						</div>
					</div>
					<%-- <div class="form-group">
						<div class="form-group">
							<form:input type="email" id="inputEmail" path="email" class="form-control" placeholder="Email address" required="required"/>
						</div>
					</div> --%>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-12">
								<div class="form-group">
									<form:input type="password" id="inputPassword" path="password" class="form-control" placeholder="Password" required="required"/>
								</div>
							</div>
							<!-- <div class="col-md-6">
								<div class="form-label-group">
									<input type="password" id="confirmPassword"
										class="form-control" placeholder="Confirm password"
										required="required"> <label for="confirmPassword">Confirm password</label>
								</div>
							</div> -->
						</div>
					</div>
					<button type="submit" class="btn btn-primary btn-block">Register</button>
				</form:form>
				<div class="text-center">
					<a class="d-block small mt-3" href="/login">Login Page</a> <a
						class="d-block small" href="#">Forgot Password?</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	
	<script type="text/javascript">
	
		$('#formSubmit').on('submit', function (e) {
			e.preventDefault();
		    var data = {};
		    var formData = $('#formSubmit').serializeArray();
		    console.log(formData)
		    $.each(formData, function (i, v) {
	            data["" + v.name + ""] = v.value;
	        });
		    
		    addUser(data)
		});
		
		function addUser(data) {
			$.ajax({
	            url: 'http://localhost:8080/goodgame/api/user',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = " http://localhost:8080/goodgame/login ";
	            	console.log("thanh cong");
	            },
	            error: function (error) {
	            	window.location.href = "http://localhost:8080/goodgame/account/register";
	            }
	        });
		}
		
	</script>
</body>
</html>