<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/Taglib.jsp"%>
<c:url var="gameURL" value="http://localhost:8080/goodgame/admin/game/list" />
<c:url var="editGameURL" value="http://localhost:8080/goodgame/admin/game/edit"></c:url>
<c:url var="gameAPI" value="http://localhost:8080/goodgame/api/game" />
<html>
<head>
<title>Edit games</title>
</head>
<body>
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
							
							<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
								<div class="form-group">
									<label for="categoryCode" class="col-sm-3 control-label no-padding-right">Category:</label>
									<div class="col-sm-9">
										<%-- <form:select path="categoryCode" id="categoryCode" multiple="true">
											<form:option value="" label="-- Choose category --" />
											<form:options items="${categories}"/>									
										</form:select> --%>
										<select class="form-control" id="categoryCode"  name="categoryCode" multiple>
											<option value="" label="-- Choose category --" />
										    <c:forEach var="item" items="${categories}">
										        <option value="${item.code}">${item.name}</option>
										    </c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="categoryCode" class="col-sm-3 control-label no-padding-right">Platform:</label>
									<div class="col-sm-9">
										<form:select path="platformCode" id="platformCode">
											<form:option value="" label="-- Choose platform --" />
											<form:options items="${platforms}"/>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Name's game</label>
									<div class="col-md-12">
										<form:input path="name" cssClass="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Title</label>
									<div class="col-md-12">
										<form:input path="title" cssClass="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Thumbnail</label>
									<div class="col-sm-9">
										<input type="file" class="col-xs-10" id="thumbnail" name="thumbnail" />
									</div>
								</div>
								<div class="form-group">
									<label for="shortDescription" class="col-sm-3 control-label no-padding-right">ShortDescription:</label>
									<div class="col-sm-9">
										<form:textarea path="description" rows="3" cols="10" cssClass="form-control" id="shortDescription" />
									</div>
								</div>
								<div class="form-group">
									<label for="content" class="col-sm-3 control-label no-padding-right">Content:</label>
									<div class="col-sm-9">
										<form:textarea path="content" rows="5" cols="10" cssClass="form-control" id="content" />
									</div>
								</div>
								<form:hidden path="id" id="gameId"/>
								<div class="clearfix form-actions">
									<div class="col-md-offset-3 col-md-9">
										<c:if test="${not empty model.id }">
											<button class="btn btn-info" type="submit" id="btnAddOrUpdateGame">
												<i class="ace-icon fa fa-check bigger-110"></i> Update game
											</button>
										</c:if>
										<c:if test="${empty model.id }">
											<button class="btn btn-info" type="submit" id="btnAddOrUpdateGame">
												<i class="ace-icon fa fa-check bigger-110"></i> Create game
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
		    console.log(formData)
		    $.each(formData, function (i, v) {
	            data["" + v.name + ""] = v.value;
	        });
		    var id = $('#gameId').val();
		    if (id == "") {
		    	addGame(data);
		    } else {
		    	updateGame(data);
		    }
		});
		
		function addGame(data) {
			$.ajax({
	            url: 'http://localhost:8080/goodgame/api/game',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = " ${editGameURL}?id="+ result.id+ "&message=create_success ";
	            	console.log("thanh cong");
	            },
	            error: function (error) {
	            	window.location.href = "${gameURL}?message=error_system";
	            	console.log("that bai");
	            }
	        });
		}
		
		function updateGame(data) {
			$.ajax({
	            url: 'http://localhost:8080/goodgame/api/game',
	            type: 'PUT',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = "${editGameURL}?id="+ result.id+ "&message=update_success ";
	            },
	            error: function (error) {
	            	window.location.href = "${gameURL}?id="+ result.id +"&message=error_system";
	            }
	        });
		}
	</script>
</body>
</html>
