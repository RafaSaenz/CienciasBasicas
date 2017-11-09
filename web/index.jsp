<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Meta information -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"><!-- Mobile Specific Metas -->
    
    <!-- Title -->
    <title>Academy</title>
    
    <!-- favicon icon -->
    <link rel="shortcut icon" href="images/Favicon.ico">
    
    <!-- CSS Stylesheet -->
    <link href="css/bootstrap.css" rel="stylesheet"><!-- bootstrap css -->
    <link href="css/owl.carousel.css" rel="stylesheet"><!-- carousel Slider -->
    <link href="css/font-awesome.css" rel="stylesheet"><!-- font awesome -->
    <link href="css/loader.css" rel="stylesheet"><!--  loader css -->
    <link href="css/docs.css" rel="stylesheet"><!--  template structure css -->
    <link href="https://fonts.googleapis.com/css?family=Arima+Madurai:100,200,300,400,500,700,800,900%7CPT+Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

</head>
    
<body>
    <div class="wapper">
    	<div id="loader-wrapper">
            <div id="loader"></div>
            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>
        </div>
        <jsp:include page="quicknav-2.jsp" flush="true"></jsp:include>
        <header id="header">
            <div class="container">
                <jsp:include page="navbar.jsp" flush="true"></jsp:include>
            </div>
        </header>
        <section class="banner">
        	<div class="banner-img"><img src="images/banner/banner-img1.jpg" alt=""></div>
            <div class="banner-text">
            	<div class="container">
                	<h1>Aprendizaje Híbrido, aprende web.</h1>
                    <p>¡Ánimo y adelante!  </p>
                    <div class="search-box">
                        <form action="platform">
                            <input type="hidden" name="action" value="search">
                            <input type="text" placeholder="Buscar ahora">
                            <input type="submit" value="">
                        </form>
                    </div>
                </div>
            </div>
        </section>
        
        <section class="student-feedback">
        	<div class="container">
            	<div class="section-title">
                	<h2>Testimonios de estudiantes</h2>
                </div>
                <div class="feedback-slider">
                	<div class="item">
                    	<div class="student-img"><img src="images/user-img/student-img1.png" alt=""></div>
                        <div class="student-name">John Doe</div>
                        <div class="student-designation">ITIC</div>
                        <p><i class="fa fa-quote-left"></i> Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic. <i class="fa fa-quote-right"></i> </p>
                    </div>
                    <div class="item">
                    	<div class="student-img"><img src="images/user-img/student-img1.png" alt=""></div>
                        <div class="student-name">Hardik Davaria</div>
                        <div class="student-designation">software engineer</div>
                        <p><i class="fa fa-quote-left"></i> Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic. <i class="fa fa-quote-right"></i> </p>
                    </div>
                </div>
            </div>
        </section>
        <section class="our-team">
        	<div class="section-title">
            	<h2>Colaboradores</h2>
            </div>
            <div class="member-slider">	
            	<div class="item">
                	<div class="member-info">
                    	<div class="img"><img src="images/team-member/member-img1.png" alt=""></div>
                        <p>Que linda es España!!</p>
                        <div class="member-name">-José Manuel Pardo<span>Física</span></div>
                    </div>
                </div>
                <div class="item">
                	<div class="member-info">
                    	<div class="img"><img src="images/team-member/member-img2.png" alt=""></div>
                        <p>?Lorem Ipsum is simply dummy text of the printing and typesetting industry it has survived not only five centuries, but also the leap into electronic typesetting, unchanged...</p>
                        <p>It was popularised in the 1960s with the release of recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                        <div class="member-name">-Dhruv Patel<span>Geek-in-charge, Coder extraordinaire</span></div>
                    </div>
                </div>
                <div class="item">
                	<div class="member-info">
                    	<div class="img"><img src="images/team-member/member-img3.png" alt=""></div>
                        <p>?Lorem Ipsum is simply dummy text of the printing and typesetting industry it has survived not only five centuries, but also the leap into electronic typesetting, unchanged...</p>
                        <p>It was popularised in the 1960s with the release of recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                        <div class="member-name">-Ravi Chauhan<span>A.K.A Freshie </span></div>
                    </div>
                </div>
                <div class="item">
                	<div class="member-info">
                    	<div class="img"><img src="images/team-member/member-img1.png" alt=""></div>
                        <p>?Lorem Ipsum is simply dummy text of the printing and typesetting industry it has survived not only five centuries, but also the leap into electronic typesetting, unchanged...</p>
                        <p>It was popularised in the 1960s with the release of recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                        <div class="member-name">-Hardik Chauhan<span>Strategizer</span></div>
                    </div>
                </div>
                <div class="item">
                	<div class="member-info">
                    	<div class="img"><img src="images/team-member/member-img2.png" alt=""></div>
                        <p>?Lorem Ipsum is simply dummy text of the printing and typesetting industry it has survived not only five centuries, but also the leap into electronic typesetting, unchanged...</p>
                        <p>It was popularised in the 1960s with the release of recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                        <div class="member-name">-Dhruv Patel<span>Geek-in-charge, Coder extraordinaire</span></div>
                    </div>
                </div>
                <div class="item">
                	<div class="member-info">
                    	<div class="img"><img src="images/team-member/member-img3.png" alt=""></div>
                        <p>?Lorem Ipsum is simply dummy text of the printing and typesetting industry it has survived not only five centuries, but also the leap into electronic typesetting, unchanged...</p>
                        <p>It was popularised in the 1960s with the release of recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                        <div class="member-name">-Ravi Chauhan<span>A.K.A Freshie </span></div>
                    </div>
                </div>
            </div>
        </section>
        <section class="start-learning">
        	<div class="container">
            	<p>¡Me siento preparado!</p>
                <a href="#" class="btn">Quiz</a>
            </div>
        </section>
        
        <jsp:include page="footer.jsp" flush="true"></jsp:include>
    </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/owl.carousel.js"></script>
    <script type="text/javascript" src="js/jquery.form-validator.min.js"></script>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript" src="js/map-styleMain.js"></script>
    <script type="text/javascript" src="js/placeholder.js"></script>
    <script type="text/javascript" src="js/coustem.js"></script>
</body>
</html>

