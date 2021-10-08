<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/common/Taglib.jsp"%>
<c:url var="gameAPI" value="http://localhost:8080/goodgame/game/list?page=1&limit=10" />

<style>
/* Game */
.category{
    margin: 60px 0 30px 0;
}

.category .category-top .row .active{
    background : #dc3545;
	color: #fff !important;
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
    text-decoration: none !important;
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

.category .category-list .category-img .favor{
    position: absolute;
    bottom: 10px;
    left: 20px;
}

.category .category-list .category-img .favor i{
	color: #fff;
}

.category .category-list .category-img .favor i:hover{
	cursor: pointer;
	color: #dc3545;
	transition: .5s;
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
    color: #FFF !important;
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
								 	<div class="btn-color categoryActive" id="${item.id}" onclick="checkActive(${item.id})">
										${item.name}
									</div>
								</a>						
							</div>
                        </c:forEach>                            
                    </div>
                </div>
                <div class="category-list">
                    <div class="row" id="content">
	                    	<c:forEach var = "item" items ="${game.listResult}">
		                        <div class="col-lg-6 col-xl-3 animate__animated animate__zoomIn wow" data-wow-delay="0.5s">
		                            <div class="category-img" data-id="${item.id}">
		                                <a href="#"><img src="${pageContext.request.contextPath}/template/web/img/games/the-witcher-1-384x488.jpg"></img></a>
		                                <div class="genre">
		                                    <a href="#"> Action,Adventure</a>
		                                    <i class="fas fa-tags"></i>
		                                </div>
		                                <div class="favor btn-favor" data-id="${item.name}">
		                                    <i class="fas fa-star"></i>
		                                </div>
		                            </div>
		                            <div class="list-title" data-id="${item.id}">
		                                <a href="${pageContext.request.contextPath}/game/detail/${item.id}">
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
	
	var currentPage = ${game.page}
	var totalPage = ${game.totalPage}
	$(function () {
	    window.pagObj = $('#pagination').twbsPagination({
	        totalPages: totalPage,
	        visiblePages: 4,
	        startPage: currentPage,
	        onPageClick: function (event, page) {
	            if(currentPage != page){
	            	$("#limit").val(12);
	            	$("#page").val(page);
	            	$("#formSubmit").submit();
	            }
	        }
	    }).on('page', function (event, page) {
	        console.info(page + ' (from event listening)');
	    });
	});
	
	$(".btn-favor").click(function () {
		let name = $(this).attr("data-id")
		$.ajax({
			url:"http://localhost:8080/goodgame/game/add-to-favorite/" + name,

			success : function(response) {
				if(response){
					alert("Added favorite game successfully ")					
				}else{
					alert("Favorite game already exists ")	
				}
			}
		})
	})
	
	function load(categoryId){
		$.ajax({
			url: "${pageContext.request.contextPath}/game/list-by-category/"+categoryId,
			type: "POST",
			data:{
				cid : categoryId
			},
			success : function(response) {
				document.getElementById("content").innerHTML = response
			}
		})
	}
	
	function checkActive(id){	
		let elements = document.querySelectorAll('.categoryActive');
		for (let i = 0; i < elements.length ; i++) {
		  	if(id === +elements[i].id){
		  		elements[i].classList.add('active');	  		
		  	}else
		  		elements[i].classList.remove('active');
		}
	}
	
</script> 
