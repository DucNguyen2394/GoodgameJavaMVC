<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/common/Taglib.jsp"%>

<style>

.category{
    margin: 60px 0 30px 0;
}

.category .btn-color{
    margin-bottom: 20px;
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 20px 0px 20px 0px;
    text-transform: uppercase;
}

.category .btn-color:hover{
    color: #fff !important;
}

.category .btn-color a{
    color: #dc3545;
    font-size: 14px;
    font-weight: bold;
}

.category .btn-color a:hover{
    color: #fff !important;
}

.category .category-list{
    margin-top: 50px;
}

.category .category-list .col-lg-6{
    margin-bottom: 40px;
}

.category .category-list .category-img{
    margin: 0px 0 10px 0;
    position: relative;
    box-shadow: 2px 2px 2px 2px #888;
    overflow: hidden;
}

.category .category-list .category-img .genre{
    position: absolute;
    bottom: 10px;
    right: 5px;
}

.category .category-list .category-img .genre i{
    color: #dc3545;
}

.category .category-list .category-img .genre a{
    color: #fff;
    font-size: 12px;
    padding-right: 5px;
    letter-spacing: 1.2;
    text-transform: uppercase;
}

.category .category-list .category-img img{
    width: 100%;
    cursor: pointer;
    object-fit: cover;
    transition: .5s;
}

.category .category-list .category-img:hover img{
    transform: scale(1.1);
    transition: .5s;
    opacity: .6
}

.category .category-list .list-title{
    font-family: 'Titillium Web';
    font-size: 24px;
    font-weight: 800;
    text-transform: uppercase;
    padding-bottom: 10px ;
}

.category .category-list .list-title a{
    color: #333 !important;
}

.category .category-list .list-title a:hover{
    color: #dc3545 !important;
}

.category .category-list .platform i{
    color: #dc3545;
}

.category .category-list .platform a{
    margin-left: 5px;
    color: #999;
    text-transform: uppercase;
}

.category .category-list .summary{
    color: #999;
    padding-top: 10px;
}

.page-item{
	display : none;
}

.page-item .page-link{
	z-index: 1;
    color: #333 !important;
    border-color: #dc3545;
    border-radius : 50%;
    font-size : 18px
}

.page-item.active .page-link{
	z-index: 1;
    color: #FFF;
    background-color: #dc3545;
    border-color: #dc3545;
    border-radius : 50%;
}
</style>

<%@include file="/WEB-INF/views/web/game/banner/bannerDetail.jsp"%>

<div class="category">
            <div class="container">
            	<form method="get" id="formSubmit" action="">
                <div class="category-top">
                    <div class="row">
                        <div class="col-md-2">
                            <a>
                                <div class="btn-color">
                                    all
                                </div>
                            </a>
                        </div>  
                        <c:forEach var = "item" items="${category.listResult}">
							<div class="col-md-2">
								<a onclick="load(${item.id})">
								 	<div class="btn-color">
										${item.name}
									</div>
								</a>							
							</div>
                        </c:forEach>                            
                    </div>
                </div>
                <div class="category-list">
                    <div class="row" id="content">
                   
	                    	<c:forEach var = "item" items ="${game}">
		                        <div class="col-lg-6 col-xl-3 animate__animated animate__zoomIn wow" data-wow-delay="0.5s">
		                            <div class="category-img">
		                                <a href="#"><img src="${item.thumbnail}"></img></a>
		                                <div class="genre">
		                                    <a href="#"> Action,Adventure</a>
		                                    <i class="fas fa-tags"></i>
		                                </div>
		                            </div>
		                            <div class="list-title">
		                                <a href="#">
		                                    ${item.name}
		                                </a>
		                            </div>
		                            <div class="platform">
		                                <i class="fas fa-tv"></i>
		                                <a href="#"> PC,PS5,Steam</a>
		                            </div>
		                            <div class="summary">
		                                <p>${item.title}</p>
		                            </div>
		                        </div>                   	
	                    	</c:forEach>
                                                               
                    </div>
                </div>
                <div class="text-center">
                	<nav aria-label="Page navigation">
						<ul class="pagination" id="pagination"></ul>
					</nav>
						<input type="hidden" id="page" name="page" />
						<input type="hidden" id="limit" name="limit" />
                </div>
                                
                </form>
            </div>
        </div>
        
<script>

	function load(categoryId){
		$.ajax({
			url: "${pageContext.request.contextPath}/game/list-by-category/"+categoryId,
			type: "GET",
			data:{
				cid : categoryId
			},
			success : function(response) {
				document.getElementById("content").innerHTML = response
			}
		})
	}
</script>