<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/Taglib.jsp"%>

<style>
	.gamesDetails {
    position: relative;
    padding-top: 100px;
}

@media only screen and (max-width: 991px) {
    .gamesDetails {
        padding: 50px 0
    }
}

.gamesDetails__content {
    border-bottom: 1px solid #eaeaea;
    padding-bottom: 30px
}

.gamesDetails__content-title {
    font-size: 50px;
    font-weight: 300;
    font-family: SofiaPro;
    text-align: center;
    text-transform: unset;
    padding-bottom: 20px;
    width: 80%;
    margin: 0 auto;
    line-height: 1.2;
    color: #fff
}

@media only screen and (max-width: 575px) {
    .gamesDetails__content-title {
        font-size: 30px;
        width: 100%
    }
}

.gamesDetails__content-subtitle {
    text-align: center;
    margin-bottom: 40px
}

.gamesDetails__content-subtitle .subtitle__author {
    font-size: 12px;
    text-transform: uppercase;
    color: #aaa;
    letter-spacing: .2em;
    font-weight: 400;
    position: relative
}

.gamesDetails__content-subtitle .subtitle__author a {
    font-size: 12px;
    text-transform: uppercase;
    color: #000;
    letter-spacing: .2em;
    font-weight: 500;
    padding-left: 5px
}

.gamesDetails__content-subtitle .subtitle__author a::after {
    content: "";
    display: inline-block;
    width: 32px;
    height: 1px;
    background-color: #cbcbcb;
    -moz-transform: rotate(315deg) translate(0, -5px);
    -webkit-transform: rotate(315deg) translate(0, -5px);
    -o-transform: rotate(315deg) translate(0, -5px);
    -ms-transform: rotate(315deg) translate(0, -5px);
    transform: rotate(315deg) translate(0, -5px);
    margin-left: 10px
}

.gamesDetails__content-subtitle .subtitle__author a:hover {
    color: #dc3545
}

.gamesDetails__content-subtitle .subtitle__comment {
    font-size: 12px;
    text-transform: uppercase;
    color: #aaa;
    letter-spacing: .2em;
    font-weight: 400
}

.gamesDetails__content-image {
    padding-bottom: 30px
}

.gamesDetails__content-text {
    margin-bottom: 20px
}

.gamesDetails__content-text p {
    font-size: 15px;
    color: #a8a8a8;
    font-weight: 400;
    line-height: 28px
}

.gamesDetails__content-tags .tags__title {
    font-size: 12px;
    font-weight: 600;
    color: #000;
    text-transform: uppercase;
    letter-spacing: .2em
}

.gamesDetails__content-tags .tags__item {
    font-size: 12px;
    font-weight: 400;
    color: #aaa;
    text-transform: uppercase;
    letter-spacing: .2em
}

.gamesDetails__content-tags .tags__item:hover {
    color: #dc3545
}

.gamesDetails__content-categories {
    display: flex;
    align-items: center;
    justify-content: flex-end
}

@media only screen and (max-width: 575px) {
    .gamesDetails__content-categories {
        justify-content: flex-start
    }
}

.gamesDetails__content-categories .categories__title {
    font-size: 12px;
    font-weight: 600;
    color: #000;
    text-transform: uppercase;
    letter-spacing: .2em
}

.gamesDetails__content-categories .categories__title a {
    font-size: 12px;
    font-weight: 400;
    color: #aaa;
    text-transform: uppercase;
    letter-spacing: .2em
}

.gamesDetails__button {
    padding-top: 30px
}

.gamesDetails__button a {
    font-size: 18px;
    font-weight: 700
}

.gamesDetails .games__item {
    margin-bottom: 0
}

.gamesDetails .games__item-info .info__text {
    margin-top: 0
}

.gamesDetails .games__item-image img {
    min-height: 300px
}

.gamesDetails .order_game a:hover{
    color: #dc3545;
    transition: all 0.4s ease;
}

h1{
	color:#fff !important;
}
</style>
	<%@include file="/WEB-INF/views/web/game/banner/bannerDetail.jsp"%>

	<div class="gamesDetails">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-xl-9">
            <div class="gamesDetails__content animate__animated animate__zoomIn wow" data-wow-delay="0.5s">
              <div class="gamesDetails__content-title">${game.name}</div>
              <div class="gamesDetails__content-image"><img src=""></div>
              <div class="gamesDetails__content-text">
                <p>
                  ${game.content }
                </p>
              </div>
              <div class="row">
                <div class="col-12 col-md-6">
                  <div class="gamesDetails__content-tags"><span class="tags__title">Platform: </span>
                  <a class="tags__item" href="#"> </a></div>
                </div>  
                           
	            <div class="col-12 col-md-6">
	                <div class="gamesDetails__content-categories"><span class="categories__title">category : 
	                <a href="#">${cateName}</a></span></div>
	            </div>
                
              </div>
            </div>
          <div class="order_game text-center py-3">
            <a href="" class="btn btn-dark">Order Now</a>
          </div>
          </div>
          <div class="col-lg-4 col-xl-3">
            <div class="games__sidebar animate__animated animate__fadeInRight wow" data-wow-delay="1s">
			
              <div class="games__sidebar-cate">
                <div class="cate__title">Categories</div>
                <div class="cate__content">
                 <c:forEach var = "item" items="${category.listResult}"> 
	                  <ul class="cate__content-list">
	                    <li class="list__item"><a class="list__item-link text-capitalize" href="#">${item.name}</a></li>
	                  </ul>
                  </c:forEach>
                </div>
              </div> 
          </div>
        </div>
      </div>
 		<%@include file="/WEB-INF/views/web/game/gameDetail/related.jsp" %>
 		
 		<h1>Game favorite</h1>
 		
 		<c:forEach var="item" items="${favoriteList}">
	 		<h1>${item.name}</h1>
	 		 		
 		</c:forEach>
 		
 		<h1>Game viewed</h1>
 		
 		<c:forEach var="item" items="${viewedList}">
	 		<h1>${item.name}</h1>
	 		 		
 		</c:forEach>
    </div>
 </div>
 
 
 