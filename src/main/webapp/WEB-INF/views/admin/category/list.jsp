<%@include file="/common/Taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:url var="categoryAPI" value="http://localhost:8080/goodgame/api/category" />
<c:url var="categoryURL" value="http://localhost:8080/goodgame/admin/category/list" />
<c:url var="trashURL" value="/admin/category/trash?page=1&limit=10"/>

<div id="content-wrapper">
	<div class="container-fluid ">
		<!-- Breadcrumbs-->
		<div class="d-flex justify-content-between">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
				<li class="breadcrumb-item active">Tables</li>						
			</ol>	
			<a class="mt-2 mr-4" data-toggle="tooltip" title='add game' href='${trashURL}'>
				<span>
					<i class="fas fa-trash bigger-110 purple"> Recycle bin</i>
				</span>
			</a>			
		</div>
		
		<c:if test="${not empty message }">
			<div class="alert alert-${alert}">
				<strong>${message}</strong>
			</div>	
			<c:remove var="message" scope="session"/>
		</c:if>
		
		<div class="card mb-3">
			<div class="card-header d-flex justify-content-between">
				<i class="fas fa-table mt-2"> Category list</i>
				<div class="widget-box table-filter">
					<div class="table-btn-controls">
						<div class="pull-right tableTools-container">
							<div class="dt-buttons btn-overlap btn-group">
								<c:url var="createCategoryURL" value="/admin/category/edit"/>
									<a class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='add game' href='${createCategoryURL}'>
										<span>
											<i class="fa fa-plus-circle bigger-110 purple"> Create Category</i>
										</span>
									</a>
								</div>
								<button id="btnDelete" type="button" onclick="warningBeforeDelete()"
									class="dt-button buttons-html5 btn btn-white btn-primary btn-bold btn-delete" data-toggle="tooltip" title='Delete category' disabled>
									<span>
										<i class="fas fa-trash-alt"></i>
									</span>
								</button>
							</div>
						</div>
					</div>
			</div>
			<form action="<c:url value='/admin/category/list'/>" id="formSubmit" method="get">
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable">
							<thead>
								<tr>
									<th><input type="checkbox" id="checkAll" class="selectAll"></th>
									<th>Id</th>
									<th>Name</th>
									<th>Code</th>
									<th>update category</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th></th>
									<th>Id</th>
									<th>Name</th>
									<th>Code</th>
									<th>update category</th>
								</tr>
							</tfoot>
							<tbody>
							<c:if test="${not empty model.listResult}">
								<c:forEach var="item" items ="${model.listResult}">
									<tr>
										<td><input class="checkbox" onclick="toggleBtn()" type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
										<td>${item.id}</td>
										<td>${item.name}</td>
										<td>${item.code}</td>
										<td>
											<c:url var="updateCategoryURL" value="/admin/category/edit">
												<c:param name="id" value="${item.id}"/>															
											</c:url>																
											<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
												title="update game" href='${updateCategoryURL}'><i class="fas fa-pen-alt"> Update</i>
											</a>
										</td>
									</tr>
								</c:forEach>	
							</c:if>	
							<c:if test="${empty model.listResult}">
								<tr>
									<td colspan="5" class="text-center">
										<div class=""><strong>You don't have any category yet!</strong></div>
										<a href="${pageContext.request.contextPath}/admin/category/edit">Create category</a>
									</td>									
								</tr>									
							</c:if>
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
	            	$("#limit").val(10);
	            	$("#page").val(page);
	            	$("#formSubmit").submit();
	            }
	        }
	    }).on('page', function (event, page) {
	        console.info(page + ' (from event listening)');
	    });
	});
		
	function toggleBtn(){		  
		const allCheckBox = document.querySelectorAll('.checkbox');
		console.log(allCheckBox)
		const deleteBtn = document.querySelector('.btn-delete');
		deleteBtn.disabled = true;
		allCheckBox.forEach(checkBox => {
			if (checkBox.checked) {
				deleteBtn.disabled = false;
			}
		})
	}
	
	$('.selectAll').click(function() {
	    $(this.form.elements).filter(':checkbox').prop('checked', this.checked);
	    toggleBtn();
	})
	
	 function warningBeforeDelete(){
		swal({
		    title: "Are you sure to delete this  of ?",
		    text: "Delete Confirmation?",
		    type: "warning",
		    showCancelButton: true,
		    confirmButtonColor: "#DC3545",
		    confirmButtonText: "Delete",
		    closeOnConfirm: false
		  },
		  function() {
			  	const data = $('tbody input[type=checkbox]:checked').map(function (){
			  		return $(this).val()
			  	}).get();
		    $.ajax({
		        url: '${categoryAPI}',
		        type: "DELETE",
		        contentType: 'application/json',
		        data: JSON.stringify(data),
		        success: function(result) {
		        	window.location.href = "${categoryURL}?page=1&limit=10&message=delete_success";

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
