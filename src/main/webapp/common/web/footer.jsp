<style>
/* footer */
.footer{
    position: relative;
}

.footer a{
	text-decoration: none;
}

.footer-top{
    position: relative;
    background-color: #111111;
    color: #fff
    #e21b24;
}

.footer-top-about{
    margin-top: 30px;
    margin-bottom: 35px;
}

.footer-top-title{
    color: #fff;
    font-weight: 800;
    font-size: 30px;
    font-family: 'Titillium Web';
    line-height: 1.1;
}

.footer-top-title .title{
    color: #dc3545;
}

.footer-text{
    color: #fff;
}

.footer-menu{
    display: flex;
    margin-top: 20px;
    color: #fff;
}

.footer-menu .footer-menu-list{
    padding-bottom: 8px;
}

.footer-menu .footer-menu-list i{
    color: #dc3545;
    padding-right: 5px;
}

.footer-top-news{
    margin-top: 30px;
    margin-bottom: 35px;
}

.footer-img{
    display: flex;
}

.footer-img .footer-img-link{
    display: flex;
    padding-top: 20px;
}

.footer-img .footer-img-link i{
    color: #dc3545;
    padding-top: 5px;
}

.footer-img .footer-img-link .footer-text{
    display: flex;
    flex-direction: column;
}

.footer-img img{
    width: auto;
    height: 50px;
    padding-right: 10px;
}

.footer-top-contact{
    margin-top: 30px;
    margin-bottom: 35px;
}

.footer-contact{
    display: flex;
    flex-direction: column;
    padding-top: 5px;
}

.footer-contact i{
    padding-top: 15px;
    color: #dc3545;
}

.footer-contact i span.contact-title{
    color: #fff;
    padding-left: 5px;
}

/* slider */

.slide{
    text-align: center;
    color: #FFF;
}

.slide .item {
    position: relative;
    width: 100%;
}

.slide .item img{
    width: 100%;
}

.slide .inner{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
}

.slide .inner .inner-1{
    display: flex;
    justify-content: space-around;
}

.slide .inner .inner-1 li{
    padding-left: 10px;
    letter-spacing: 1.1px;
    font-weight: 600;
    text-transform: uppercase;
}

.slide .inner .inner-1 li i{
    color: #dc3545;
}

.slide .inner .title{
	color : #FFF !important;
    text-transform: uppercase;
    font-family: 'Titillium Web';
    font-weight: 800;
    font-size: 50px;
    padding-top: 30px;
}

.slide .inner .inner-2{
    padding-top: 80px;
    display: flex;
    justify-content: space-around;
}

.slide .inner .inner-2 li{
    text-transform: uppercase;
    letter-spacing: 1.1;
    border-bottom: 1px solid #FFF;
}

.slide .inner .inner-2 li a{
    font-size: 16px;
    font-weight: 600;
}

.slide .inner .inner-info{
    padding-top: 30px;
}

.slide .inner .inner-info .info{
	color : #FFF;
    font-weight: 400;
    font-size: 14px;
    letter-spacing: 1.1px;
}

.slide .inner .inner-info .info span{
    color: #dc3545;
    font-weight: 600;
}

@media only screen and (max-width: 991px){
    .slide .inner .title{
        font-size: 30px;
        padding-top: 20px;
    }
    .slide .inner .inner-2 li a{
        font-size: 12px;
    }
    .slide .inner .inner-2{
        padding-top: 20px;
    }
    .slide .inner .inner-1 li{
        font-size: 12px;
    }

    .slide .inner .inner-info{
        display: none;
    }
}
</style>

        <div class="footer">
            <div class="footer-top">
                <div class="container">
                    <div class="row mt-4">
                        <div class="col-lg-4 animate__animated animate__fadeInLeft wow" data-wow-delay="0.5s">
                            <div class="footer-top-about">
                                <div class="footer-top-title text-uppercase">about
                                    <span class="title"> us</span>
                                </div>
                                <div class="footer-text mt-4">
                                    Development began in 2021 and lasted for three and a half years. 
                                    we are people who are extremely dedicated to the profession.
                                </div>
                                <div class="footer-menu row d-flex mt-4">
                                    <ul class="footer-menu-ul col-6">
                                        <li class="footer-menu-list">
                                            <i class="fas fa-caret-right"></i>
                                            <a> Home</a>
                                        </li>
                                        <li class="footer-menu-list">
                                            <i class="fas fa-caret-right"></i>
                                            <a> Games</a>
                                        </li>
                                        <li class="footer-menu-list">
                                            <i class="fas fa-caret-right"></i>  
                                            <a> Team </a>
                                        </li>
                                        <li class="footer-menu-list">
                                            <i class="fas fa-caret-right"></i>
                                            <a> Esport</a>
                                        </li>
                                    </ul>
                                    <ul class="footer-menu-ul col-6">
                                        <li class="footer-menu-list">
                                            <i class="fas fa-caret-right"></i>
                                            <a> Blog </a>
                                        </li>
                                        <li class="footer-menu-list">
                                            <i class="fas fa-caret-right"></i>
                                            <a> About</a>
                                        </li>
                                        <li class="footer-menu-list">
                                            <i class="fas fa-caret-right"></i>
                                            <a> Community</a>
                                        </li>
                                        <li class="footer-menu-list">
                                            <i class="fas fa-caret-right"></i>
                                            <a> Contact</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 animate__animated animate__zoomIn wow" data-wow-delay="0.5s">
                            <div class="footer-top-news">
                                <div class="footer-top-title text-uppercase">lastest
                                    <span class="title"> news</span>
                                </div>                               
                                <div class="footer-img">
                                    <a class="footer-img-link" href="#">
                                        <img src="${pageContext.request.contextPath}/template/web/img/footer/footer-witcher.jpg"></img>

                                        <div class="footer-text"> This is the Witcher
                                            <i class="far fa-clock"> December 23,2021</i>                                             
                                        </div>
                                    </a>
                                </div>
                                <div class="footer-img">
                                    <a class="footer-img-link" href="#">
                                        <img src="${pageContext.request.contextPath}/template/web/img/footer/footer-valhalla.jpg"></img>
                                        <div class="footer-text"> This is Assasin Creed Valhalla
                                            <i class="far fa-clock"> December 23,2021</i>
                                        </div>
                                    </a>
                                </div>
                                <div class="footer-img">
                                    <a class="footer-img-link" href="#">
                                        <img src="${pageContext.request.contextPath}/template/web/img/footer/footer-reddead.jpg"></img>
                                        <div class="footer-text"> This is Red Dead Redemtion 
                                            <i class="far fa-clock"> December 23,2021</i>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 animate__animated animate__fadeInRight wow" data-wow-delay="0.5s">
                            <div class="footer-top-contact">
                                <div class="footer-top-title text-uppercase">contact
                                    <span class="title"> us</span>
                                </div>
                                <div class="footer-contact">
                                    <i class="fas fa-map-marker-check">
                                        <span class="contact-title">   King of HaDong</span>
                                    </i>
                                    <i class="fas fa-envelope">
                                        <span class="contact-title">   Goodgame@gmail.com</span>
                                    </i>
                                    <i class="fas fa-phone">
                                        <span class="contact-title">   +84 232.4808</span>
                                    </i>
                                    <i class="fas fa-id-card">
                                        <span class="contact-title">   017113166</span>
                                    </i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
