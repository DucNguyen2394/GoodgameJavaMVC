<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/Taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<!-- Custom fonts for this template-->
<link
	href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link
	href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.css'/>" rel="stylesheet" type="text/css">

<!-- Custom styles for this template-->
<link href="<c:url value='/template/admin/css/sb-admin.css'/>" rel="stylesheet" type="text/css">
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
</head>
<body id="page-top">

	<%@ include file="/common/admin/header.jsp"%>
	
	<div id="wrapper">
		<%@ include file="/common/admin/menu.jsp"%>
		<dec:body />
	</div>
		
	<%@ include file="/common/admin/footer.jsp"%>

	<!-- Bootstrap core JavaScript-->
	<script src="<c:url value='/template/admin/vendor/jquery/jquery.js'/>"></script>
	<script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

	<!-- Page level plugin JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/chart.js/Chart.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/vendor/datatables/jquery.dataTables.js'/>"></script>
	<script
		src="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.js'/>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/template/admin/js/sb-admin.min.js'/>"></script>

	<!-- Demo scripts for this page-->
	<script
		src="<c:url value='/template/admin/js/demo/datatables-demo.js'/>"></script>
	<script
		src="<c:url value='/template/admin/js/demo/chart-area-demo.js'/>"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
</body>
</html>