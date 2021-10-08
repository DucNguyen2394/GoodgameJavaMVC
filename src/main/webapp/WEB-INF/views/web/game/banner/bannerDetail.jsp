<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
.banner{
  position: relative;
}

.banner img{
  width: 100%;
  z-index: 222;
}

.banner .bg-img{
	opacity : 0.2;
  background-color: #000000;
  background-size: cover;
  background-position: center center;
  position: absolute;
  width: 100%;
    height: 100%;
    top: 0;
    left: 0;
}


.banner-content{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
}

.banner__content-title{
  text-transform: uppercase;
  font-family: 'Titillium Web';
  font-weight: 600;
  font-size: 3.1875em;
  color: #dc3545;
  letter-spacing: 1.1px;
  
}

.banner__content-subtitle{
  text-transform: uppercase;
  font-family: 'Titillium Web';
  font-weight: 200;
  font-size: 2.2875em;
  color: #333;
  letter-spacing: 1.1px;
  color: #FFF
}

.banner__content-subtitle i {
  padding: 0 0.3125em 0 0.3125em;
}
</style>

<div class="banner">

	 <div class ="bg-img"></div>
     <img src="${pageContext.request.contextPath }/template/web/img/banner/banner-detail.jpg"/>	
        <div class="banner-content">
            <div class="banner__content-title">Games</div>
        <div class="banner__content-subtitle">GoodGame<i class="fal fa-angle-right"></i><span>Game Detail</span></div>
     </div>
</div>