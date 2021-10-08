<ul class="sidebar navbar-nav">
	<li class="nav-item"><a class="nav-link" href="index.html"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
	</a></li>
	<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
		href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
		aria-haspopup="true" aria-expanded="false"> <i
			class="fas fa-fw fa-folder"></i> <span>Pages</span>
	</a>
		<div class="dropdown-menu" aria-labelledby="pagesDropdown">
			<h6 class="dropdown-header">Login Screens:</h6>
			<a class="dropdown-item" href="${pageContext.request.contextPath}/">Home</a> 
			<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/game/list?page=1&limit=10">Game</a> 
			<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/user/list?page=1&limit=10">User</a>
			<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/category/list?page=1&limit=10">Category</a>
			<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/video/list?page=1&limit=2">Video</a> 
			<a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
			<div class="dropdown-divider"></div>
			<h6 class="dropdown-header">Other Pages:</h6>
			<a class="dropdown-item" href="404.html">404 Page</a> 
			<a class="dropdown-item" href="blank.html">Blank Page</a>
		</div>
	</li>
	<li class="nav-item"><a class="nav-link" href="charts.html"> 
		<i class="fas fa-fw fa-chart-area"></i> <span>Charts</span></a></li>
	<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath }/admin/game/list?page=1&limit=10">
			<i class="fas fa-fw fa-table"></i> <span>Tables</span>
	</a></li>
</ul>