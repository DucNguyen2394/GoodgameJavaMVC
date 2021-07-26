<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/Taglib.jsp"%>
<%@ page import="com.goodgame.util.SecurityUtils" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/template/admin/js/paging/jquery.twbsPagination.js'/>"></script>
<title>Home</title>
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
		
		<li><a href="<c:url value='http://localhost:8080/goodgame/login' />">Login</a></li>
		<li><a href="<c:url value='/account/register' />">Register</a></li>
		</security:authorize>
		
		<security:authorize access="isAuthenticated()">
		<li>Welcome <%=SecurityUtils.getPrincipal().getUsername() %></li>
		<li><a href="<c:url value='/logout' />"> Logout </a></li>
		</security:authorize>
	</ul>
	
	<div class="container">
	    <nav aria-label="Page navigation">
	        <ul class="pagination" id="pagination"></ul>
	    </nav>
	</div>
	
	<script type="text/javascript">
	
	    $(function () {
	        window.pagObj = $('#pagination').twbsPagination({
	            totalPages: 10,
	            visiblePages: 4,
	            onPageClick: function (event, page) {
	                console.info(page + ' (from options)');
	            }
	        }).on('page', function (event, page) {
	            console.info(page + ' (from event listening)');
	        });
	    });
	</script>
</body>
</html>