<%@include file="/common/Taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:url var="gameAPI" value="http://localhost:8080/goodgame/api/game" />
<c:url var="gameURL" value="http://localhost:8080/goodgame/admin/game/list" />
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
					<table class="table table-bordered" id="dataTable">
						<thead>
							<tr>
								<th><input type="checkbox" id="checkAll"></th>
								<th>Name</th>
								<th>Title</th>
								<th>Description</th>
								<th>update game</th>
								<th>Delete game</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th></th>
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
									<td><input class="checkbox" onclick="toggleBtn()" type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
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
										<button class="btn btn-sm btn-primary btn-delete" data-toggle="tooltip" onclick="warningBeforeDelete()" disabled
											title="delete game" ><i class="fas fa-trash-alt"> Delete</i>
										</button>
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

	function toggleBtn(){
		const checkBox = document.querySelector('.checkbox');
		const deleteBtn = document.querySelector('.btn-delete');
		  
		  if (checkBox.checked) {
			  deleteBtn.disabled = false;
			  console.log("ok");
		  } else {
			  deleteBtn.disabled = true;
		  }
	}
	
	 function warningBeforeDelete(){
		swal({
		    title: "Are you sure to delete this  of ?",
		    text: "Delete Confirmation?",
		    type: "warning",
		    showCancelButton: true,
		    confirmButtonColor: "#DD6B55",
		    confirmButtonText: "Delete",
		    closeOnConfirm: false
		  },
		  function() {
			  	const data = $('tbody input[type=checkbox]:checked').map(function (){
			  		return $(this).val()
			  	}).get();
		    $.ajax({
		        url: '${gameAPI}',
		        type: "DELETE",
		        contentType: 'application/json',
		        data: JSON.stringify(data),
		        success: function(result) {
		        	window.location.href = "${gameURL}?message=delete_success";
		        	console.log("dcm")
		        }
		      })
		      .done(function(result) {
		        swal("Deleted!", "Data successfully Deleted!", "success");
		        
		      })
		      .error(function(result) {
		        swal("Oops", "We couldn't connect to the server!", "error");
		      });
		  }
		);
	} 
</script>
