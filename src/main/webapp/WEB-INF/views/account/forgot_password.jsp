<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/Taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forgot password</title>
</head>
<body>

	<form:form action="${pageContext.request.contextPath}/forgot_password" method="POST" style="max-width: 420px; margin: 0 auto;">
		<div class="border border-secondary rounded p-3">
			<div>
				<p>We will be sending a reset password link to your email.</p>
			</div>
			<div>
				<p>${err }</p>
			</div>
			<div>
				<p>
					<input type="email" name="email" class="form-control" placeholder="Enter your e-mail" required autofocus />
					<span>${message}</span>
				</p>
				<p class="text-center">
					<input type="submit" value="Send" class="btn btn-primary" />
				</p>
			</div>
		</div>
	</form:form>
</body>
</html>