<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/common/Taglib.jsp"%>

<style>
	
	.highlight{
      height: auto;
      margin: 40px auto;
      overflow: hidden;
	}
	
	.highlight .highlight-header .highlight-title{
		color: #fff;
		text-transform: uppercase;
   		font-weight: 800;
   		font-size: 28px;
    	font-family: 'Titillium Web';
    	text-align: center;
	}
	
	.highlight-prev{
		position: absolute;
	    top: 32%;
	    font-size: 90px;
	    font-weight: bold;
	    cursor: pointer;
	    z-index: 1;
	    left: .5%;
	    color: #dc3545;
	   
	}
	
	.highlight-next{
        left: 97.5%;	  
        text-align: right;
		position: absolute;
	    top: 32%;
	    font-size: 90px;
	    font-weight: bold;
	    cursor: pointer;
	    z-index: 1;
	    color: #dc3545
    }
    
    .highlight-body{
      display: flex;
      justify-content: left;
      overflow-x: auto;
      position: relative;
      
    }
    
    .highlight-flex{
    	display: flex;
    }
    
    .highlight-body::-webkit-scrollbar{
      visibility: hidden;
    }
    
    .highlight-item{
	  width: 25%;
      text-align: center;
      padding-top: 40px;
      font-weight: bold;
      margin: 10px 0px;
      color: white;
      transition: 0.5s;
    }
    
    .highlight-item .category-img img{
    	width: 100%;
    	box-shadow: 1px 1px 1px 1px #888;
    }
    
    .highlight-item .list-title{
    	padding-top : 20px;
    	font-size: 20px;
    }
</style>

<div class="highlight container">
	<div class ="highlight-container">
		<div class="highlight-header mb-5">
			<div class="highlight-title">Featured game</div>
		</div>	   	
			<div class ="highlight-body row">
				<span class="highlight-prev">&#139;</span>
		    	<span class="highlight-next">&#155;</span> 
		    	<div class="highlight-flex">
					<c:forEach var="item" items="${game.listResult}">
					  <div class ="highlight-item col-xl-3">
					  			                
			              <div class="category-img">
			                   <a href="#"><img src="template/web/img/games/the-witcher-1-384x488.jpg"></img></a>
			              </div>
			              <div class="list-title">
			              	<a href="#"> ${item.name} </a>
			              </div>
					  </div>						      
					</c:forEach>		    	
		    	</div>  	
			</div>
	</div>
</div>

<script>
	var prev = document.querySelector('.highlight-prev')
	var next = document.querySelector('.highlight-next')
	var item = document.querySelectorAll('.highlight-item')
	var l = 0
	
	console.log(item)
	
	next.onclick = () => {
		l++;
		for(var i of item){
	        if(l == 0 ) {i.style.left = "0px";}
	        if(l == 1 ) {i.style.left = "-740px";}
	        if(l == 2 ) {i.style.left = "-1480px";}
	        if(l == 3 ) {i.style.left = "-2220px";}
	        if(l == 4 ) {i.style.left = "-2360px";}
	        if(l > 4 ) {l = 4;}

	      }
	}
	
	prev.onclick = () => {
		l--;
		for(var i of item){
			if(l == 0 ) {i.style.left = "0px";}
	        if(l == 1 ) {i.style.left = "-740px";}
	        if(l == 2 ) {i.style.left = "-1480px";}
	        if(l == 3 ) {i.style.left = "-2220px";}
	        if(l < 0 ) {l = 0;}
	      }
	}
	
</script>