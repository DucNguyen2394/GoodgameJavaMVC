<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/Taglib.jsp"%>
<c:url var="userAPI" value="http://localhost:8080/goodgame/api/user" />
<c:url var="userURL" value="http://localhost:8080/goodgame/admin/user/list" />
<c:url var="userEditURL" value="http://localhost:8080/goodgame/admin/user/edit" />

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
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a> </li>
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
							<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model" enctype="multipart/form-data">
								<div class="form-group">
									<div class="col-sm-6">
										<form:select path="userCode" class="form-control" id="userCode"  name="userCode" multiple="multiple">
											<form:option value="" label="-- Choose role --" disabled="disabled"/>
												<c:forEach var="item" items="${role}">
												<option>${item.code}</option>										
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label for="shortDescription" class="col-sm-3 control-label no-padding-right">Username</label>
									<div class="col-sm-6">
										<form:input path="username" type="text" cssClass="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label for="shortDescription" class="col-sm-3 control-label no-padding-right">Fullname</label>
									<div class="col-sm-6">
										<form:input path="fullname" type="text" cssClass="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label for="shortDescription" class="col-sm-3 control-label no-padding-right">Age</label>
									<div class="col-sm-6">
										<form:input path="age" type="text" cssClass="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label for="shortDescription" class="col-sm-3 control-label no-padding-right">Email</label>
									<div class="col-sm-6">
										<form:input path="email" type="text" cssClass="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label for="shortDescription" class="col-sm-3 control-label no-padding-right">Password</label>
									<div class="col-sm-6">
										<form:input path="password" type="password" cssClass="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label for="shortDescription" class="col-sm-3 control-label no-padding-right">Confirm Password</label>
									<div class="col-sm-6">
										<form:input path="confirmPassword" type="password" cssClass="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Choose file upload</label>
									<div class="col-sm-6">
										<form:input path="photo" type="file" cssClass="col-xs-10 thumbnail" id="thumbnail" name="file"/>
									</div>
								</div>
								<form:hidden path="id" id="userId"/>
								<div class="clearfix form-actions mt-5">
									<div class="col-md-offset-3 col-md-9">
										<c:if test="${not empty model.id }">
											<button class="btn btn-info" type="submit" id="btnAddOrUpdateGame">
												<i class="ace-icon fa fa-check bigger-110"></i> Update User
											</button>
										</c:if>
										<c:if test="${empty model.id }">
											<button class="btn btn-info" type="submit" id="btnAddOrUpdateGame">
												<i class="ace-icon fa fa-check bigger-110"></i> Create User
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
	    var id = $('#userId').val();
	    if (id == "") {
	    	addGame(data);
	    } else {
	    	updateGame(data);
	    }
	});
	
	function addGame(data) {
		var file_name = $('input[type="file"].thumbnail').val().replace(/\\/g, '/').replace(/.*\//, '')
		file_name_path = 'C:\\usr\\var\\thumbnail\\' + file_name;
		
		data = {...data, thumbnail: file_name_path}
		$.ajax({
            url: '${userAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = " ${userEditURL}?id="+ result.id+ "&message=insert_success ";
            },
            error: function (error) {
            	
            	window.location.href = "${userURL}?page=1&limit=10&message=error_system";
            }
        });
	}
	
	function updateGame(data) {
		var file_name = $('input[type="file"].thumbnail').val().replace(/\\/g, '/').replace(/.*\//, '')
		file_name_path = 'C:\\usr\\var\\thumbnail\\' + file_name;

		data = {...data, thumbnail: file_name_path}
		$.ajax({
            url: '${userAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	console.log(result)
            	window.location.href = "${userEditURL}?id="+ result.id+ "&message=update_success ";
            },
            error: function (error) {
            	window.location.href = "${userURL}?id="+ result.id +"&message=error_system";
            }
        });
	}
	
	$("#thumbnail").change(function (){
		var dataArray = {}
		var files = $(this)[0].files[0]
		if(files != undefined){
			var reader = new FileReader()
			reader.onload = function(e){
				  dataArray['base64'] = e.target.result
				  dataArray['name'] = files.name
			      upload(dataArray)
			    };
			reader.readAsDataURL(files)
		}
	})
	
	function upload(data){
		$.ajax({
			url: "http://localhost:8080/goodgame/api/upload",
			type: 'POST',
			data: JSON.stringify(data),
			contentType: 'application/json',
			dataType: 'json',
			enctype: 'multipart/form-data',
			success: function (result) {
				console.log("success")
			},
			error: function (error) {
            	console.log("error")
            }
		})
	}
	</script>
</body>
</html>