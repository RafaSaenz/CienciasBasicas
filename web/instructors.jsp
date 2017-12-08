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
                    <li><a href="/CienciasBasicas/">Inicio</a></li>
                    <li><a href="/CienciasBasicas/Instructors?action=view&mode=grid">Instructores</a></li>
                </ul>
            </div>
        </section>
        <section class="courses-view">
        	<div class="container">
            	<div class="filter-row">
                    <div class="view-type">
                    	<a href="/CienciasBasicas/Instructors?action=view&mode=grid" class="active"><i class="fa fa-th-large"></i></a>
                        <a href="/CienciasBasicas/Instructors?action=view&mode=list"><i class="fa fa-list"></i></a>
                    </div>
                    <div class="search">
                    	<input type="text" placeholder="Search">
                        <input type="submit" value="">
                    </div>
                </div>  
        </section>   
        <section class="our-teacher">
        	<div class="container">
            	<div class="filter-row">
                </div><div class="row">
                <c:forEach var="user" items="${users}" >
                    
                        <div class="col-sm-6 col-md-3">
                            <div class="teacher-box">
                                <div class="img">
                                    <img src="${pageContext.request.contextPath}/image/${user.picPath}" alt="No Image Available" height="315px" width="270px"> 
                                    <ul class="sosiyal-mediya">
                                    <li><a href="${user.linkedin}"><i class="fa fa-linkedin"></i></a></li>
                                    </ul>
                                    </div>
                                    <div class="info">
                                        <div class="name"><a href="Instructors?action=view&mode=detail&id=${user.id}">${user.firstName} ${user.lastName1}</a></div>
                                        <div class="designation">Departamento de Ingeniería</div>
                                        <!-- <p>Breve descripción del profesor</p> -->
                                    </div>
                            </div>
                        </div>
                    
                </c:forEach></div>
                <div class="pagination">
                	<ul>
                    	<li class="prev"><a href="#"><i class="fa fa-angle-left"></i><span> prev</span> </a></li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li class="next"><a href="#"><span> Next</span><i class="fa fa-angle-right"></i></a></li>
                        </ul>
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

