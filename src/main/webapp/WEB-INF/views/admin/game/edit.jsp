<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/Taglib.jsp"%>
<c:url var="gameURL" value="http://localhost:8080/goodgame/admin/game/list" />
<c:url var="gameEditURL" value="http://localhost:8080/goodgame/admin/game/edit" />
<c:url var="gameAPI" value="http://localhost:8080/goodgame/api/game" />
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
									<label for="categoryCode" class="col-sm-3 control-label no-padding-right">Category:</label>
									<div class="col-sm-9">
										<%-- <form:select path="categoryCode" id="categoryCode" multiple="true">
											<form:option value="" label="-- Choose category --" />
										        <form:options value="${categories}"/>																			
										</form:select> --%>
										
										<form:select path="categoryCode" class="form-control" id="categoryCode"  name="categoryCode" multiple="multiple">
											<form:option value="" label="-- Choose category --" disabled="disabled"/>
											<c:forEach var="item" items="${categories}">
											    <option>${item.code}</option>>											
											</c:forEach>
										</form:select>
										
										<%-- <form:checkboxes path="categories" element="div" items="${categories}" itemValue="id" itemLabel="name"/> --%>
										
										<%-- <c:forEach items="${categories}" var="item">
								            <tr>
								                <td><form:checkbox path="categories" value="${item.code}" /></td>							                
								                <td><c:out value="${item.code}" /></td>
								            </tr>
								        </c:forEach> --%>
									</div>
								</div>
								<div class="form-group">
									<label for="platformCode" class="col-sm-3 control-label no-padding-right">Platform:</label>
									<div class="col-sm-9">
										<form:select path="platformCode" id="platformCode">
											<form:option value="" label="-- Choose platform --" disabled="disabled"/>
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
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Choose file upload</label>
									<div class="col-sm-9">
										<input type="file" class="col-xs-10 thumbnail" id="thumbnail" name="file"/>
									</div>
								</div>
								<div class="form-group">
									<label for="shortDescription" class="col-sm-3 control-label no-padding-right">ShortDescription:</label>
									<div class="col-sm-9">
										<form:textarea path="description" rows="2" cols="5" cssClass="form-control" id="shortDescription" />
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
	
		ClassicEditor
	    .create( document.querySelector( '#content' ) )
	    .catch( error => {
	        console.error( error );
	    } );	
	
		$('#formSubmit').on('submit', function (e) {
			e.preventDefault();
		    var data = {};
		    var formData = $('#formSubmit').serializeArray();
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
			var file_name = $('input[type="file"].thumbnail').val().replace(/\\/g, '/').replace(/.*\//, '')
			file_name_path = 'C:\\usr\\var\\thumbnail\\' + file_name;
			
			const select = document.getElementById('categoryCode');
			
			const categoryArr = [];
			for (let a = 0; a < select.options.length; a++)
				{
				if (select.options[a].value)
					categoryArr.push(select.options[a].value)
				}
			
			console.log(categoryArr)
			
			data = {...data, thumbnail: file_name_path,categoryArr}
			$.ajax({
	            url: '${gameAPI}',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = " ${gameEditURL}?id="+ result.id+ "&message=insert_success ";
	            },
	            error: function (error) {            	
	            	window.location.href = "${gameURL}?page=1&limit=10&message=error_system";
	            }
	        });
		}
		
		function updateGame(data) {
			var file_name = $('input[type="file"].thumbnail').val().replace(/\\/g, '/').replace(/.*\//, '')
			file_name_path = 'C:\\usr\\var\\thumbnail\\' + file_name;

			data = {...data, thumbnail: file_name_path}
			$.ajax({
	            url: '${gameAPI}',
	            type: 'PUT',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	console.log(result)
	            	window.location.href = "${gameEditURL}?id="+ result.id+ "&message=update_success ";
	            },
	            error: function (error) {
	            	window.location.href = "${gameURL}?id="+ result.id +"&message=error_system";
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
</body>
</html>
