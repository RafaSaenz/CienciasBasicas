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
                            <li><a href="/CienciasBasicas/Resources?action=view&mode=list">Recursos</a></li>
                        </ul>
                    </div>
                </section>
                <section class="courses-view list-view">
                    <div class="container">
                        <div class="filter-row">
                            <div class="view-type">
                                <a href="/CienciasBasicas/Resources?action=view&mode=grid"><i class="fa fa-th-large"></i></a>
                                <a href="/CienciasBasicas/Resources?action=view&mode=list" class="active"><i class="fa fa-list"></i></a>
                            </div>
                            <div class="search">
                                <input type="text" placeholder="Search">
                                <input type="submit" value="">
                            </div>
                        </div>
                        <c:forEach var="resource" items="${resources}" >
                            <div class="course-post">
                                <div class="img">
                                    <img src="${pageContext.request.contextPath}/image/${resource.filePath}" alt="">
                                    <div class="icon">
                                        <a href="Resources?action=view&mode=detail&id=${resource.id}"><img src="images/book-icon.png" alt=""></a>
                                    </div>
                                    <div class="price">${resource.level}</div>
                                </div>
                                <div class="info">
                                    <div class="name">${resource.title}</div>
                                    <div class="expert"><span>Autor: </span>${resource.instructor.firstName} ${resource.instructor.lastName1} ${resource.instructor.lastName2}</div>
                                    <div class="product-footer">
                                        <div class="comment-box">	
                                            <div class="box"><i class="fa fa-users"></i>0 Enrolled</div>
                                        </div>
                                        <div class="rating">
                                            <div class="fill" style="width:${resource.review}%"></div>
                                        </div>
                                            <p><b>${resource.area.area}</b></p>
                                        <div class="view-btn2">
                                            <a href="Resources?action=view&mode=detail&id=${resource.id}" class="btn">Ver más</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach></div>
                    <div class="pagination">
                        <ul>
                            <li class="next"><a href="#"><i class="fa fa-angle-left"></i><span>Next</span></a></li>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li class="prev"><a href="#"><span>prev</span> <i class="fa fa-angle-right"></i></a></li>
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

