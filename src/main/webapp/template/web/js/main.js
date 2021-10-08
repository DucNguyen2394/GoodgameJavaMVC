$(function () {
  //===== WOW JS =====//
  new WOW().init();

  //===== Scroll Sticky Menu =====//
  window.addEventListener("scroll", function () {
    var header = document.querySelector(".header");
    header.classList.toggle("sticky", window.scrollY > 0);
  });

  //===== Click Toggle Menu =====//
  let body = document.querySelector("body");
  let menuList = document.querySelector(".header-menu-list");
  let overlay = document.querySelector(".overlay-header");
  let button = document.querySelector(".header-menu-button");
  let closeButton = document.querySelector(".close-overlay");
  let header = document.querySelector(".header");
  let container = document.querySelector(".header .container");
  button.addEventListener("click", () => {
    body.classList.add("overflow-hidden");
    menuList.classList.add("show");
    overlay.classList.add("active");
    header.classList.add("absolute");
    container.classList.remove(".hide");
  });
  closeButton.addEventListener("click", () => {
    body.classList.remove("overflow-hidden");
    menuList.classList.remove("show");
    overlay.classList.remove("active");
    header.classList.remove("absolute");
  });
  overlay.addEventListener("click", () => {
    body.classList.remove("overflow-hidden");
    menuList.classList.remove("show");
    overlay.classList.remove("active");
    header.classList.remove("absolute");
  });

  // ===== Search layout ======//
  let menuSearch = document.querySelector(".menu-search");
  let searchClose = document.querySelector(".search-close");
  let searchLayout = document.querySelector(".search__layout");

  menuSearch.addEventListener("click", () => {
    searchLayout.classList.add("show");
  });
  searchClose.addEventListener("click", () => {
    searchLayout.classList.remove("show");
  });


  // ===== btn active ===== //
  // var active = document.getElementsById("myDiv");
  // var btns = active.getElementsByClassName("btn-color");
  // for (var i = 0; i < btns.length; i++) {
  //   btns[i].addEventListener("click", function () {
  //     var current = document.getElementsByClassName("btn-active");
  //     console.log("current")
  //     current[0].className = current[0].className.replace(" btn-active", "");
  //     this.className += " btn-active";
  //   });
  // }


});
