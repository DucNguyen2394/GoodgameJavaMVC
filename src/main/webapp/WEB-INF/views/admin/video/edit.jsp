<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/Taglib.jsp"%>
<c:url var="videoURL" value="http://localhost:8080/goodgame/admin/video/list" />
<c:url var="videoEditURL" value="http://localhost:8080/goodgame/admin/video/edit" />
<c:url var="videoAPI" value="http://localhost:8080/goodgame/api/video" />
<c:url var="gameUpload" value="http://localhost:8080/goodgame/api/upload" />

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
									<label for="gameName" class="col-sm-3 control-label no-padding-right">Game:</label>
									<div class="col-sm-9">
										<form:select path="gameName" id="gameName">
											<form:option value="" label="-- Choose Game --" disabled="disabled"/>
											<form:options items="${games}"/>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Name's Video</label>
									<div class="col-sm-9">
										<form:input path="name" cssClass="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Episode</label>
									<div class="col-sm-9">
										<form:input path="episode" cssClass="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Choose file upload</label>
									<div class="col-sm-9">
										<input type="file" class="col-xs-10 thumbnail" id="thumbnail" name="file"/>
									</div>
								</div>
								<div class="form-group">
									<label for="content" class="col-sm-3 control-label no-padding-right">Link:</label>
									<div class="col-sm-9">									
										<form:input path="link" cssClass="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label for="shortDescription" class="col-sm-3 control-label no-padding-right">ShortDescription:</label>
									<div class="col-sm-9">
										<form:textarea path="" rows="2" cols="5" cssClass="form-control" id="shortDescription" />
									</div>
								</div>
								<form:hidden path="id" id="videoId"/>
								<div class="clearfix form-actions">
									<div class="col-md-offset-3 col-md-9">
										<c:if test="${not empty model.id }">
											<button class="btn btn-info" type="submit" id="btnAddOrUpdateVideo">
												<i class="ace-icon fa fa-check bigger-110"></i> Update video
											</button>
										</c:if>
										<c:if test="${empty model.id }">
											<button class="btn btn-info" type="submit" id="btnAddOrUpdateVideo">
												<i class="ace-icon fa fa-check bigger-110"></i> Create video
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
	    var id = $('#videoId').val();
	    if (id == "") {
	    	addVideo(data);
	    } else {
	    	updateVideo(data);
	    }
	});
	
	function addVideo(data) {
		var file_name = $('input[type="file"].thumbnail').val().replace(/\\/g, '/').replace(/.*\//, '')
		file_name_path = 'C:\\usr\\var\\thumbnail\\' + file_name;	
		
		data = {...data, thumbnail: file_name_path}
		$.ajax({
	        url: '${videoAPI}',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(data),
	        dataType: 'json',
	        success: function (result) {
	        	window.location.href = " ${videoEditURL}?id="+ result.id+ "&message=insert_success ";
	        },
	        error: function (error) {            	
	        	window.location.href = "${videoURL}?page=1&limit=10&message=error_system";
	        }
	    });
	}
	
	function updateVideo(data) {
		var file_name = $('input[type="file"].thumbnail').val().replace(/\\/g, '/').replace(/.*\//, '')
		file_name_path = 'C:\\usr\\var\\thumbnail\\' + file_name;
	
		data = {...data, thumbnail: file_name_path}
		$.ajax({
	        url: '${videoAPI}',
	        type: 'PUT',
	        contentType: 'application/json',
	        data: JSON.stringify(data),
	        dataType: 'json',
	        success: function (result) {
	        	console.log(result)
	        	window.location.href = "${videoEditURL}?id="+ result.id+ "&message=update_success ";
	        },
	        error: function (error) {
	        	window.location.href = "${videoURL}?id="+ result.id +"&message=error_system";
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
			url: "${gameUpload}",
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