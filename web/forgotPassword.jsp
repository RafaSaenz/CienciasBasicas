<!DOCTYPE html>
<html lang="en">
<%@ page language="java" 
%>
<head>
    <!-- Meta information -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- Mobile Specific Metas -->

    <!-- Title -->
    <title>Academy</title>

    <!-- favicon icon -->
    <link rel="shortcut icon" href="images/Favicon.ico">

    <!-- CSS Stylesheet -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- bootstrap css -->
    <link href="css/owl.carousel.css" rel="stylesheet">
    <!-- carousel Slider -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- font awesome -->
    <link href="css/docs.css" rel="stylesheet">
    <!--  template structure css -->
    <link href="css/loader.css" rel="stylesheet"><!--  loader css -->
    <link href="css/jquery.selectbox.css" rel="stylesheet"><!-- select box -->

    <link href="https://fonts.googleapis.com/css?family=Arima+Madurai:100,200,300,400,500,700,800,900%7CPT+Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
        rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <div class="wapper">
        <jsp:include page="quicknav-2.jsp" flush="true"></jsp:include>
        </div>      
        <section class="login-view" >
            <div class="container" >
                <div class="row">
                    <div class="col-sm-6">
                        <form action="LoginServlet" method = "post">
                        <div class="section-title">
                            <h2>Recupera tu contraseña</h2>
                            <p>Ingresa el correo electronico usado al crear tu cuenta</p>
                        </div>
                        
                        <div class="input-box">
                                <input type="text" name="email" required placeholder="Email">
                        </div>
                        <div class="submit-slide">
                            <input type="submit" value="Recuperar" class="btn">
                        </div>
                        </form>
                    </div>
                    <div class="col-sm-6">
                    </div>
                </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp" flush="true"></jsp:include>
        <div class="top-arrow" id="goTop">
            <div class="arrow"><i class="fa fa-angle-up"></i></div>
        </div>
        <div class="search-blcok">
            <div class="close-icon">
                <i class="fa fa-close"></i>
            </div>
            <div class="input-box">
                <input type="text" placeholder="Enter Keyword">
                <div class="note">Input your search keywords and press Enter.</div>
            </div>
        </div>
    </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <style>
        select, textarea {width:100%; max-width:550px; border:solid 1px #d8d8d8; background:#fff; border-radius:5px; height:41px; line-height:29px; padding:5px 10px;}
        textarea { height: 150px;}
    </style>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/owl.carousel.js"></script>
    <script type="text/javascript" src="js/jquery.form-validator.min.js"></script>
    <script type="text/javascript" src="js/placeholder.js"></script>
    <script type="text/javascript" src="js/coustem.js"></script>
</body>

</html>
