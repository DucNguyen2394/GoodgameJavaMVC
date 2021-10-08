<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="sidebar" data-color="purple" data-background-color="black">

      <div class="logo"><a href="${pageContext.request.contextPath}" class="simple-text logo-normal">
          Mr.DucNguyen
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item active" onclick="checkActive(event)">
            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/home">
              <i class="material-icons">dashboard</i>
              <p>Dashboard</p>
            </a>
          </li>
          <li class="nav-item" onclick="checkActive(event)">
            <a class="nav-link" href="#">
              <i class="material-icons">person</i>
              <p>User Profile</p>
            </a>
          </li>
          <li class="nav-item " onclick="checkActive(event)">
            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/game/list?page=1&limit=10">
              <i class="material-icons">sports_esports</i>
              <p>Game manage</p>
            </a>
          </li>
          <li class="nav-item " onclick="checkActive(event)">
            <a class="nav-link" href="#">
              <i class="material-icons">bubble_chart</i>
              <p>Icons</p>
            </a>
          </li>
          <li class="nav-item " onclick="checkActive(event)">
            <a class="nav-link" href="#">
              <i class="material-icons">location_ons</i>
              <p>Maps</p>
            </a>
          </li>
          <li class="nav-item " onclick="checkActive(event)">
            <a class="nav-link" href="#">
              <i class="material-icons">notifications</i>
              <p>Notifications</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
<script>
	function checkActive(e) {
		console.log(e.target.textContent)
		let listNavItem = document.querySelectorAll('.nav-item')
		for(let i = 0 ; i < listNavItem.length; i++){
			
			console.log(listNavItem[i].childNodes[1].childNodes[3].textContent.trim())
			let node = 	listNavItem[i].childNodes[1].childNodes[3].textContent.trim()
			if(node === e.target.textContent){
				listNavItem[i].classList.add('active');
			}else{
				listNavItem[i].classList.remove('active');
			}
		}
	}
	
	
</script>