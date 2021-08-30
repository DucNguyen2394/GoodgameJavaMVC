<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/Taglib.jsp"%>
<c:url var="categoryURL" value="/admin/category/list"/>
<c:url var="categoryAPI" value="/api/category" />
<c:url var="categoryEditURL" value="/admin/category/edit" />

<div class="container-fluid mt-2">
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="/">Home</a> </li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content" style="height: 1000px">
					<div class="row">
						<div class="col-12">
						
							<c:if test="${not empty message }">
								<div class="alert alert-${alert}">
								 	<strong>${message}</strong>
								</div>							
							</c:if>
							<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Category name</label>
									<div class="col-md-12">
										<form:input path="name" class="col-xs-10 col-sm-5" />
										<div>${error}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Category Code</label>
									<div class="col-md-12">
										<form:input path="code" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<form:hidden path="id" id="categoryId"/>
								<div class="clearfix form-actions">
									<div class="col-md-offset-3 col-md-9">
										<c:if test="${not empty model.id }">
											<button class="btn btn-info" type="submit" id="btnAddOrUpdateGame">
												<i class="ace-icon fa fa-check bigger-110"></i> Update category
											</button>
										</c:if>
										<c:if test="${empty model.id }">
											<button class="btn btn-info" type="submit" id="btnAddOrUpdateGame">
												<i class="ace-icon fa fa-check bigger-110"></i> Create category
											</button>	
										</c:if>
										&nbsp; &nbsp; &nbsp;
										<button class="btn" type="reset">
											<i class="ace-icon fa fa-undo bigger-110"></i> Cancel
										</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>		
	
		$('#formSubmit').on('submit', function (e) {
			e.preventDefault();
		    var data = {};
		    var formData = $('#formSubmit').serializeArray();
		    $.each(formData, function (i, v) {
	            data["" + v.name + ""] = v.value;
	        });
		    var id = $('#categoryId').val();
		    if (id == "") {
		    	addCategory(data);
		    } else {
		    	updateCategory(data);
		    }
		});
		
		function addCategory(data) {
			$.ajax({
	            url: 'http://localhost:8080/goodgame/api/category',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = " ${categoryEditURL}?id="+ result.id+ "&message=insert_success ";
	            },
	            error: function (error) {            	
	            	window.location.href = "${categoryURL}?page=1&limit=10&message=error_system";
	            }
	        });
		}
		
		function updateCategory(data) {
			$.ajax({
	            url: 'http://localhost:8080/goodgame/api/category',
	            type: 'PUT',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = "${categoryEditURL}?id="+ result.id+ "&message=update_success ";
	            },
	            error: function (error) {
	            	window.location.href = "${categoryURL}?id="+ result.id +"&message=error_system";
	            }
	        });
		}
		
	</script>