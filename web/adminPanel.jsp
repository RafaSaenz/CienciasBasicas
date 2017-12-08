<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <style>
           .fa-save, .fa-refresh {
                color: #9ACD32;
            }
        </style>
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
                        <li><a href="#">Panel administrativo</a></li>
                        <li><a href="#">Administración de Recursos</a></li>
                    </ul>
                </div>
            </section>
            <section class="courses-view ">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="right-slide left">
                                <h3>Administrar</h3>
                                <ul class="catagorie-list">
                                    <li><a href="#" id="man-res">Recursos</a></li>
                                    <li><a href="#" id="man-area">Áreas</a></li>
                                    <li><a href="#" id="man-type">Tipos</a></li>
                                    <li><a href="#" id="man-level">Niveles</a></li>
                                </ul>
                                <h3>Temas y Subtemas</h3>
                                <ul class="catagorie-list">
                                <c:forEach var="area" items="${areas}" >
                                    <li><a href="#" id="${area.id}" class="area-link">${area.area}</a></li>
                                </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-9" style="border: #001489 solid thick">
                            <div id="cont2"></div>
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
        <script type="text/javascript" src="js/jquery.tabledit.js"></script>
        <script type="text/javascript" src="js/adminPanel.js"></script>
    </body>
</html>
