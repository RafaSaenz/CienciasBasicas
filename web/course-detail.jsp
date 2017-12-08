<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
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
                            <li><a href="index.jsp">Inicio</a></li>
                            <li><a href="resources.jsp">Recursos</a></li>
                            <li><a href="/CienciasBasicas/Resources?action=view&mode=detail&id=${resource.id}">${resource.title}</a></li>
                    </ul>
                </div>
            </section>
            <section class="teacher-profile">
                <div class="container">
                    <div class="teacher-name">
                        <h3>${resource.title}</h3>
                        <span>${resource.area.area}</span>
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                            <div class="img">
                                    <c:if test="${file.type == 'video'}">
                                        <iframe width="640" height="360"
                                                src="${file.filepath}" allowfullscreen>
                                        </iframe>
                                    </c:if>
                                    <c:if test="${file.type == 'document'}">
                                        <object data="${pageContext.request.contextPath}/Document/${file.filepath}" type="application/pdf" width="740" height="520">
                                            <a href="${pageContext.request.contextPath}/Document/${file.filepath}">Download file.pdf</a>
                                        </object>
                                        <br>
                                        <a href="${pageContext.request.contextPath}/Document/${file.filepath}" target="_blank"><i class="fa fa-file-pdf-o"></i> Descargar archivo</a>
                                    </c:if>
                                    <c:if test="${file.type == 'image'}">
                                        <img src="${pageContext.request.contextPath}/image/${file.filepath}" alt="" height="520" width="740">
                                        <br>
                                        <a href="${pageContext.request.contextPath}/image/${file.filepath}" target="_blank"><i class="fa fa-file-image-o"></i> Descargar imagen</a>
                                    </c:if>
                            </div>
                            <div class="teacher-info">
                                <p>${resource.description}</p>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="profile-details">
                                <h4>Información:</h4>
                                <div class="details-slide">
                                    <span>Autor:</span>
                                    <p>${resource.instructor.firstName} ${resource.instructor.lastName1} ${resource.instructor.lastName2}</p>
                                </div>
                                <div class="details-slide">
                                    <span>Area:</span>
                                    <p>${resource.area.area}</p>
                                </div>
                                <div class="details-slide">
                                    <span>Tema:</span>
                                    <p>${resource.topic.name}</p>
                                </div>
                                <div class="details-slide">
                                    <span>Subtema:</span>
                                    <p>${resource.subtopic.name}</p>
                                </div>
                                <div class="details-slide">
                                    <span>Nivel:</span>
                                    <p>${resource.level}</p>
                                </div>
                                <div class="details-slide">
                                    <span>Referencias:</span>
                                    <p>${resource.references}</p>
                                </div>
                                <div class="details-slide">
                                    <span>Link:</span>
                                    <p><a href="${resource.link}">${resource.link}</a></p>
                                </div>
                                <div class="details-slide last">
                                    <span>Subido:</span>
                                    <p>${resource.addedDate}</p>
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

