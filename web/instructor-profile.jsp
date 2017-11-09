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
            <jsp:include page="quicknav-2.jsp" flush="true"></jsp:include>
            <header id="header">
                <div class="container">
                    <jsp:include page="navbar.jsp" flush="true"></jsp:include>
                </div>
            </header>
            <section class="breadcrumb">
                <div class="container">
                    <ul>
                        <li><a href="index.html">Home</a></li>
                        <li><a href="instructors.html">Our Teacher</a></li>
                        <li><a href="instructor-profile.html">instructor Profile</a></li>
                    </ul>
                </div>
            </section>
            <section class="teacher-profile">
                <div class="container">
                    <div class="teacher-name">
                        <h3>${instructor.firstName} ${instructor.lastName1} ${instructor.lastName2}</h3>
                        <span>Profesor de planta</span>
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <div class="img"><img src="images/team-member/member-img4.jpg" alt=""></div>
                            <div class="teacher-info">
                                <p>Breve CV del profesor</p>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="profile-details">
                                <h4>Detalles del profesor</h4>
                                <div class="details-slide">
                                    <span>Departamento:</span>
                                    <p>Ingeniería</p>
                                </div>
                                <div class="details-slide">
                                    <span>Teléfono:</span>
                                    <p>123 4564 1234</p>
                                </div>
                                <div class="details-slide">
                                    <span>Correo electrónico:</span>
                                    <p><a href="MailTo:${instructor.email}">${instructor.email}</a></p>
                                </div>
                                <div class="details-slide last">
                                    <span>Me gusta:</span>
                                    <p><i class="fa fa-heart-o"></i> 5 Like</p>
                                </div>
                            </div>
                        </div>
                    </div>
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
        <script type="text/javascript" src="js/placeholder.js"></script>
        <script type="text/javascript" src="js/coustem.js"></script>
    </body>
</html>

