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
    <link href="css/jquery.countdown.css" rel="stylesheet">
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
        <section class="breadcrumb ">
        	<div class="container">
            	<ul>
                	<li><a href="/CienciasBasicas/">Inicio</a></li>
                    <li><a href="Resources?action=view&mode=grid">Recursos</a></li>
                    <li><a href="Resources?action=add&mode=">Nuevo Recurso</a></li>
                </ul>
            </div>
        </section>
        <section class="thankYou-page">
        	<div class="container">
                <div class="section-title">
                    <h2>${message}</h2>
                <p>Para consultarlo click <a href="Resources?action=view&mode=detail&id=${resource}">AQUÍ</a></p>
                </div>
                <div class="thankYou-msg">
                	<p>${information}</p>
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
    <script type="text/javascript" src="js/jquery.countdown.js"></script>
    <script type="text/javascript" src="js/countdown-script.js"></script>
    <script type="text/javascript" src="js/coustem.js"></script>
</body>
</html>

