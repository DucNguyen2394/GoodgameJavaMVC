<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/common/Taglib.jsp"%>

<style>
.banner{
  position: relative;
}

.banner img{
  width: 100%;
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
}

.banner__content-subtitle i {
  padding: 0 0.3125em 0 0.3125em;
}

</style>

<div class="banner">
      <img src="${pageContext.request.contextPath }/template/web/img/banner/banner1.jpg"/>
        <div class="banner-content">
            <div class="banner__content-title">Games</div>
        <div class="banner__content-subtitle">GoodGame<i class="fal fa-angle-right"></i><span>All Game</span></div>
     </div>
</div>