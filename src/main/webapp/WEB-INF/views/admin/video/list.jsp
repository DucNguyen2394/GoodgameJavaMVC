<%@include file="/common/Taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<div id="content-wrapper">
	<div class="container-fluid">
		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
			<li class="breadcrumb-item active">Tables</li>
		</ol>
		
		<c:if test="${not empty message }">
			<div class="alert alert-${alert}">
				<strong>${message}</strong>
			</div>							
		</c:if>
		
		<div class="card mb-3">
			<div class="card-header d-flex justify-content-between">
				<i class="fas fa-table mt-2">  Data Table Example</i>
				<div class="widget-box table-filter">
					<div class="table-btn-controls">
						<div class="pull-right tableTools-container">
							<div class="dt-buttons btn-overlap btn-group">
								<c:url var="createNewURL" value="/admin/game/edit"/>
									<a class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='add game' href='${createNewURL}'>
										<span>
											<i class="fa fa-plus-circle bigger-110 purple"> Create video</i>
										</span>
									</a>
								</div>
								<button id="btnDelete" type="button" onclick="warningBeforeDelete()"
									class="dt-button buttons-html5 btn btn-white btn-primary btn-bold btn-delete" data-toggle="tooltip" title='Delete video' disabled>
									<span>
										<i class="fas fa-trash-alt"></i>
									</span>
								</button>
							</div>
						</div>
					</div>
			</div>
			<form action="<c:url value='/admin/video/list'/>" id="formSubmit" method="GET">
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable">
							<thead>
								<tr>
									<th><input type="checkbox" id="checkAll"></th>
									<th>Name</th>
									<th>Title</th>
									<th>Description</th>
									<th>update video</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Title</th>
									<th>Description</th>
									<th>update video</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="item" items ="${model.listResult}">
									<tr>
										<td><input class="checkbox" onclick="toggleBtn()" type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
										<td>${item.name}</td>

										<td>
<%-- 											<c:url var="updateNewURL" value="/admin/game/edit">
												<c:param name="id" value="${item.id}"/>															
											</c:url> --%>																
											<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
												title="update game" href='${updateNewURL}'><i class="fas fa-pen-alt"> Update</i>
											</a>
										</td>
									</tr>
								</c:forEach>				
							</tbody>
						</table>
					</div>
				</div>
				<div class ="">
					<nav aria-label="Page navigation">
					     <ul class="pagination" id="pagination"></ul>
					</nav>
					<input type="hidden" id="page" name="page" />
					<input type="hidden" id="limit" name="limit" />
				</div>
			</form>		
			
			<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
		</div>
		<p class="small text-center text-muted my-5">
			<em>More table examples coming soon...</em>
		</p>
	</div>
</div>

<script>
	
	var currentPage = ${model.page};
	var totalPage = ${model.totalPage};
	
	 $(function () {
	    window.pagObj = $('#pagination').twbsPagination({
	        totalPages: totalPage,
	        visiblePages: 4,
	        startPage: currentPage,
	        onPageClick: function (event, page) {
	            if(currentPage != page){
	            	$("#limit").val(2);
	            	$("#page").val(page);
	            	$("#formSubmit").submit();
	            }
	        }
	    }).on('page', function (event, page) {
	        console.info(page + ' (from event listening)');
	    });
	}); 
</script>