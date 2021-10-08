<%@include file="/common/Taglib.jsp"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<div class="container">		
		<div class="row justify-content-center">
			<div class="col-md-12 col-lg-10">
				<div class="wrap d-md-flex">
					<div class="img" style="background-image: url(${pageContext.request.contextPath}/template/login/img/reddead.PNG);"></div>
					<div class="login-wrap p-4 p-md-5">
						<div class="d-flex">
							<div class="w-100">
								<h3 class="mb-4">Register</h3>
							</div>
							<div class="w-100">
								<p class="social-media d-flex justify-content-end">
									<a href="#" class="social-icon d-flex align-items-center justify-content-center">
										<span class="fa fa-facebook"></span>
									</a> 
									<a href="#" class="social-icon d-flex align-items-center justify-content-center">
										<span class="fa fa-twitter"></span>
									</a>
								</p>
							</div>
						</div>
						<c:if test="${param.incorrectAccount != null }">
							<div class="alert alert-danger">
								username or password incorrect
							</div>
						</c:if>
						<form:form action="" id="formSubmit" class="signin-form" method="POST" modelAttribute="user">
							<div class="form-group mb-3">
								<label class="label" for="name">Username</label> 
								<form:input path="username" type="text" class="form-control" placeholder="Username" />
								<span class="error">${error}</span>
							</div>
							<div class="form-group mb-3">
								<label class="label" for="name">Fullname</label> 
								<form:input path="fullname" type="text" class="form-control" placeholder="Fullname" />
								<span class="error">${error}</span>
							</div>
							<div class="form-group mb-3">
								<label class="label" for="name">Email</label> 
								<form:input path="email" type="email" class="form-control" placeholder="Email" />
							</div>
							<div class="form-group mb-3">
								<label class="label" for="name">Age</label> 
								<form:input path="age" type="text" class="form-control" placeholder="Age" />
							</div>
							<div class="form-group mb-3">
								<label class="label" for="password">Password</label> 
								<form:input path="password" type="password" class="form-control" placeholder="Password" />
							</div>
							<div class="form-group mb-3">
								<label class="label" for="password">Re-Password</label> 
								<form:input path="confirmPassword" type="password" class="form-control" placeholder="Re-Password"/>
							</div>
							<div class="form-group">
								<button type="submit" class="form-control btn btn-primary rounded submit px-3">Sign In</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>	
		 $('#formSubmit').on('submit', function (e) {
			e.preventDefault();
		    var data = {};
		    var formData = $('#formSubmit').serializeArray();
		    $.each(formData, function (i, v) {
	            data["" + v.name + ""] = v.value;
	            console.log( "name = " , v.name)
	        });
		    
		    addUser(data)
		});
		
		 function addUser(data) {
			console.log(data)
			$.ajax({
	            url: 'http://localhost:8080/goodgame/api/register',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	result.preventDefault()
	            	window.location.href = "http://localhost:8080/goodgame/login"; 
	            },
	            error: function (error) {
	            	const err = document.querySelector(".error")
	            	err.textContent = "invalid"
		            err.style.color = "red"	
	            }
	        });
		}    
		
	</script>
</body>
</html>