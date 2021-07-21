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
		
		<!-- DataTables Example -->
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
											<i class="fa fa-plus-circle bigger-110 purple"> Create game</i>
										</span>
									</a>
								</div>
							</div>
						</div>
					</div>
			</div>
			
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>Name</th>
								<th>Title</th>
								<th>Description</th>
								<th>update game</th>
								<th>Delete game</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Name</th>
								<th>Title</th>
								<th>Description</th>
								<th>update game</th>
								<th>Delete game</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach var="item" items ="${model.listResult}">
								<tr>
									<td>${item.name}</td>
									<td>${item.title}</td>
									<td>${item.description}</td>
									<td>
										<c:url var="updateNewURL" value="/admin/game/edit">
											<c:param name="id" value="${item.id}"/>															
										</c:url>																
										<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
											title="update game" href='${updateNewURL}'><i class="fas fa-pen-alt"> Update</i>
										</a>
									</td>
									<td>
										<a class="btn btn-sm btn-primary btn-delete" data-toggle="tooltip"
											title="delete game" href='${updateNewURL}'><i class="fas fa-trash-alt"> Delete</i>
										</a>
									</td>
								</tr>
							</c:forEach>				
						</tbody>
					</table>
				</div>
			</div>
			<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
		</div>
		<p class="small text-center text-muted my-5">
			<em>More table examples coming soon...</em>
		</p>
	</div>
</div>

<script>
	function warningBeforeDelete(){
		
	}
</script>
