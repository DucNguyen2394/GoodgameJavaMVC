<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/Taglib.jsp"%>
<%@ page import="com.goodgame.util.SecurityUtils" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello website</h1>
	<ul>
		<li><a href="<c:url value='/' />">trang chu</a></li>
		<li>about</li>
		<li>contact</li>
		<li>service</li>
		<li>contact</li>
		
		<security:authorize access = "isAnonymous()">
		
		<li>Login</li>
		<li><a href="<c:url value='/account/register' />">Register</a></li>
		</security:authorize>
		
		<security:authorize access="isAuthenticated()">
		<li>Welcome <%=SecurityUtils.getPrincipal().getUsername() %></li>
		<li><a href="<c:url value='/logout' />"> Logout </a></li>
		</security:authorize>
	</ul>
</body>
</html>