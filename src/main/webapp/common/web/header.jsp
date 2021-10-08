<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/Taglib.jsp"%>
<%@ page import="com.goodgame.util.SecurityUtils" %>

<style>
	/* header */
.header {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 999;
  background: #000;
  transition: all 0.5s;
}

.header.absolute {
  position: absolute;
  left: auto;
  right: auto;
  width: 0;
}

.header-menu {
  display: flex;
  align-items: center;
  justify-content: space-between;
  transition: all 0.5s;
}

.header-menu-logo {
  height: 40px;
  visibility: visible;
  opacity: 1;
  width: auto;
  transition-duration: 0.5s;
}

.header-menu-logo-link {
  display: inline-block;
  height: 100%;
  width: auto;
}

.header-menu-logo-link img {
  height: 100%;
  width: auto;
}

.header-menu-button {
  position: relative;
  display: inline-block;
  line-height: 50px;
  background-color: transparent;
  border: 0;
  cursor: pointer;
  padding: 0;
  transition: 0.5s;
}

@media only screen and (min-width: 992px) {
  .header-menu-button {
    display: none;
  }
}

.header-menu-button i {
  width: 22px;
  height: 2px;
  border-radius: 1px;
  margin: 5px 0;
  transition: 0.4s;
}

.header-menu-button i:hover {
  color: #dc3545;
}

.header-menu-list {
  display: flex;
  align-items: center;
  flex-direction: row;
  flex-grow: 0;
  flex-basis: auto;
  width: auto;
  background-color: transparent;
}

@media only screen and (max-width: 991px) {
  .header-menu-list {
    margin: 0;
    padding: 0;
    display: block;
    position: fixed;
    top: 0;
    left: -300px;
    padding-bottom: 150px;
    width: 300px;
    height: 100%;
    background: #333;
    transition: 0.7s;
    z-index: 9999;
    overflow-x: hidden;
    overflow-y: auto;
  }
}

.header-menu-list.show {
  left: 0px;
}

.header-menu-list .list-item {
  position: relative;
  margin-left: 40px;
}

@media only screen and (max-width: 991px) {
  .header-menu-list .list-item {
    margin: 0;
    border-bottom: 1px solid #dc3545;
    padding-left: 20px;
  }
}

.header-menu-list .list-item.active a {
  color: #dc3545;
}

.header-menu-list .list-item .active1 {
  color: #dc3545;
}

.header-menu-list .list-item a {
  transition: all 0.4s ease;
  text-decoration: none;
}

.header-menu-list .list-item-logo {
  display: inline-block;
  height: 35px;
  width: auto;
  margin: 25px 22px 25px 35px;
}

@media only screen and (min-width: 992px) {
  .header-menu-list .list-item-logo {
    display: none;
  }
}

.header-menu-list .list-item-logo img {
  height: 100%;
  width: auto;
}

.header-menu-list .list-item-link {
  display: block;
  position: relative;
  font-size: 15px;
  line-height: 20px;
  font-weight: 600;
  text-transform: capitalize;
  color: #fff;
  cursor: pointer;
  padding: 24px 0;
}

@media only screen and (max-width: 991px) {
  .header-menu-list .list-item-link {
    margin: 0 22px 0 35px;
    line-height: 50px;
    padding: 0;
  }
}

.header-menu-list .list-item-link i {
  display: inline-block;
  margin-left: 5px;
  font-size: 12x;
  color: transparent;
  transition: 0.3s;
}

.header-menu-list .list-item:hover .list-item-link {
  color: #fff;
}

.header-menu-list::-webkit-scrollbar {
  width: 6px;
  background-color: #dc3545;
}

.header-menu-list::-webkit-scrollbar-thumb {
  background-color: #dc3545;
}

.header-menu-list::-webkit-scrollbar-track {
  background-color: #515a4e;
}

.header-menu-list .menu-search .icon-search i {
  color: #fff;
}

.header-menu-list .menu-search .icon-search i:hover {
  color: #dc3545;
}

.sticky {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 999;
  background-color: #000;
  box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
}

.sticky .header-menu-list .list-item-link {
  padding: 20px 0;
}

@media only screen and (max-width: 991px) {
  .sticky .header-menu-list .list-item-link {
    padding: 0;
  }
}

.hide {
  display: none;
}

.overlay-header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background: rgba(0, 0, 0, 0.8);
  z-index: 999;
  opacity: 0;
  visibility: hidden;
}

.overlay-header.active {
  opacity: 1;
  visibility: visible;
}

@media only screen and (max-width: 424px) {
  .overlay-header span {
    display: none;
  }
}

.overlay-header span i {
  position: absolute;
  right: 20px;
  top: 10px;
  width: 50px;
  height: 50px;
  line-height: 50px;
  font-size: 30px;
  color: #fff;
  cursor: pointer;
}

.overlay-header span i:hover {
  color: #dc3545;
}

.search__layout {
  position: fixed;
  top: 0;
  left: -100%;
  width: 100%;
  height: 100%;
  visibility: hidden;
  transition: all 0.4s ease;
  z-index: 99999;
  background: rgba(0, 0, 0.5, 0.8);
}

.search__layout.show {
  left: 0;
  visibility: visible;
}
.search__layout .search-close {
  height: 80px;
  display: flex;
  align-items: center;
  justify-content: flex-end;
  width: 100%;
  color: #fff;
}
.search__layout .search-close span {
  font-size: 25px;
  margin-right: 30px;
  transition: all 0.4s ease;
}

.search__layout .search-close span i:hover {
  color: #dc3545;
}

.search__layout .search-close span:hover {
  cursor: pointer;
  transform: rotateZ(360deg);
}

.search__layout .search-body {
  position: relative;
  height: 100px;
  width: 100%;
}
.search__layout .search-body form {
  position: absolute;
  top: 300px;
  width: 100%;
}
.search__layout p {
  text-align: center;
  font-size: 25px;
  margin-bottom: 30px;
  color: #fff;
}

.search__layout .search-input {
  margin: auto;
  position: relative;
  width: 40%;
}
.search__layout input {
  border: none;
  outline: none;
  background-color: transparent;
  border-bottom: 1px solid #dc3545;
  width: 100%;
  color: #fff;
  font-size: 20px;
}
.search__layout .search-input i {
  position: absolute;
  font-size: 25px;
  right: 0;
  bottom: 5px;
  transition: all 0.3s ease;
  color: #fff;
}

.search__layout i:hover {
  color: #dc3545;
  cursor: pointer;
}
</style>

<div class="overlay-header">
        <span class="close-overlay">
          <i class="fal fa-times"></i>
        </span>
      </div>
      <div class="header">
        <div class="container">
          <div class="header-menu">
            <div class="header-menu-logo">
              <a class="header-menu-logo-link" href="#">
                <img src="${pageContext.request.contextPath}/template/web/img/hunglogo.jpg"></img>
              </a>
            </div>
            <div class="accordion-menu">
              <div class="header-menu-button">
                <i class="fas fa-bars"></i>
              </div>
              <ul class="header-menu-list">
                <li class="list-item">
                  <a class="list-item-link active" href="${pageContext.request.contextPath}">Home</a>
                </li>
                <li class="list-item">
                  <a class="list-item-link" href="${pageContext.request.contextPath}/game/list?page=1&limit=12">
                    Games
                  </a>
                </li>
                <li class="list-item">
                  <a class="list-item-link" href="#">
                    Blog
                  </a>
                </li>
                <li class="list-item">
                  <a class="list-item-link" href="#">
                    About
                  </a>
                </li>
                <li class="list-item">
                  <a class="list-item-link" href="#">
                    Contact
                  </a>
                </li>
                
                <security:authorize access="isAnonymous()">
	                <li class="list-item">
	                  <a class="list-item-link" href="<c:url value='http://localhost:8080/goodgame/login'/>">Login</a>
	                </li>
                	<li><a class="list-item-link ml-5" href="<c:url value='/register' />">Register</a></li>
                </security:authorize>            
                
                <li class="list-item menu-search">
                  <a class="list-item-link icon-search" href="#">
                    <i class="fas fa-search"></i>
                  </a>
                </li>
                <security:authorize access="isAuthenticated()">
                <li><a class="list-item-link ml-5" href="<c:url value='/admin' />"> Admin </a></li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
					<li class="list-item-link ml-5 mr-5"> Welcome <%=SecurityUtils.getPrincipal().getUsername() %></li>
					<li><a class="list-item-link" href="<c:url value='/logout' />"> Logout </a></li>
				</security:authorize>
              </ul>
            </div>
          </div>
        </div>
        <div class="search__layout">
          <div class="search-body">
            <div class="search-close ">
              <span>
                <i class="fas fa-times"></i>
              </span>
            </div>
            <form action="${pageContext.request.contextPath}/game/list-by-keyword" method="GET">
              <p class="text-uppercase ">
                start typing and press Enter to search
              </p>
              <div class="search-input">
                <input type="text" name="keyword"/>
                <button>
	                <i class="fas fa-search mb-5"></i>
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>