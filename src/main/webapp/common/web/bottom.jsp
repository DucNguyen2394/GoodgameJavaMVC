<style>
	.bottom{
    height: 50px;
    background-color: #000;
}

.bottom .container{
    align-items: center;
}

.bottom .container .d-flex{
    display: flex;
    justify-content: space-between;
    align-items: center;
    line-height: 50px;
}

.bottom-right{
    display: flex;
    align-items: center;
}

.bottom-right a{
    padding-left: 12px;
    font-size: 16px;
}

.bottom-right a i{
	color : #333
}

@media (max-width: 1199px){
    .bottom .container{
        display: flex;
        justify-content: center;
    }
}
</style>


<div class="bottom">
            <div class="container">
                <div class="d-flex">
                    <div class="bottom-left d-flex animate__animated animate__fadeInLeft wow" data-wow-delay="0.5s">
                        <h4>Goodgame@gmail.com.vn</h4>
                    </div>
                    <div class="bottom-right d-flex animate__animated animate__fadeInRight wow" data-wow-delay="0.5s">
                        <a><i class="fab fa-facebook"></i></a>
                        <a><i class="fab fa-steam"></i></a>
                        <a><i class="fab fa-youtube"></i></a>
                        <a><i class="fab fa-twitter"></i></a>
                        <a><i class="fab fa-discord"></i></a>
                        <a><i class="fab fa-google-plus-g"></i></a>
                    </div>
                </div>
            </div>
        </div>