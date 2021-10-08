<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/Taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin - Dashboard</title>

	<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  	<!-- CSS Files -->
  	<link href="<c:url value='/template/dashboard/css/material-dashboard.css?v=2.1.0'/>" rel="stylesheet" type="text/css">
  	
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
	<!-- sweetalert -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css" />
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	 
	 <script src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/ckeditor.js"></script>
</head>
<body class="dark-edition">

		<div class="wrapper ">
			<%@ include file="/common/dashboard/menu.jsp"%>
			
			<div class="main-panel">
				<%@ include file="/common/dashboard/header.jsp"%>
				<div class="content">
			        <div class="container-fluid">		        
						<dec:body />			
			        </div>
				</div>
			<%@ include file="/common/dashboard/footer.jsp"%>
			</div>
				
		</div>
		
	  <!--   Core JS Files   -->
	  <script src="<c:url value='/template/dashboard/js/core/jquery.min.js'/>"></script>
	  <script src="<c:url value='/template/dashboard/js/core/popper.min.js'/>"></script>
	  <script src="<c:url value='/template/dashboard/js/core/bootstrap-material-design.min.js'/>"></script>
	  <script src="<c:url value='/template/dashboard/js/plugins/perfect-scrollbar.jquery.min.js'/>"></script>
	  <script src="https://unpkg.com/default-passive-events"></script>
	  <!-- Place this tag in your head or just before your close body tag. -->
	  <script defer src="https://buttons.github.io/buttons.js"></script>
	  <!--  Google Maps Plugin    -->
	  <!-- <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script> -->
	  <!-- Chartist JS -->
	  <%-- <script src="<c:url value='/template/dashboard/plugins/chartist.min.js'/>"></script> --%>
	  <!--  Notifications Plugin    -->
	  <script src="<c:url value='/template/dashboard/js/plugins/bootstrap-notify.js'/>"></script>
	  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
	  <script src="<c:url value='/template/dashboard/js/material-dashboard.js?v=2.1.0'/>"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
	<!--  Main JS -->
	<script src="<c:url value='/template/dashboard/js/main.js'/>"></script>
	<!-- pagging -->
	<script src="<c:url value='/template/dashboard/js/paging/jquery.twbsPagination.js'/>"></script>
</body>
</html>