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
                <section class="breadcrumb white-bg">
                    <div class="container">
                        <ul>
                            <li><a href="/CienciasBasicas/">Inicio</a></li>
                            <li><a href="Instructors?action=manage">Estudiantes</a></li>
                            <li><a href="Instructors?action=addStudent">Registrar</a></li>
                        </ul>
                    </div>
                </section>
                <section class="checkout-content">
                    <div class="container">
                        <div class="step-box fill">
                            <div class="title"><span>Agregar estudiante</span> </div>
                        </div>
                        <div class="step-box">
                            <div class="title">Datos del estudiante</div>
                            <div class="step2 step-content">
                                <div class="fill-address">
                                    <div class="row">
                                        <form action="Students" method="post" id="addForm" onsubmit="return checkFile();" enctype="multipart/form-data">
                                            <div class="col-sm-6">
                                                <div class="input-filde">
                                                    <div class="input-box">
                                                        <label>Matrícula </label>
                                                    <c:if test="${not empty user.id}">
                                                        <input type="text" name="id" required maxlength="10" placeholder="A00000000" value="${user.id}"
                                                           readonly="readonly">  
                                                    </c:if>
                                                    <c:if test="${empty user.id}">
                                                        <input type="text" name="id" required maxlength="10" placeholder="A00000000">
                                                    </c:if>
                                                    </div>    
                                                    <div class="input-box">
                                                        <label>Nombre:</label>
                                                        <input type="text" name="firstname" required maxlength="255" placeholder="Nombre(s)" value="${user.firstName}">
                                                    </div>
                                                    <div class="input-box">
                                                        <label>Apellido Paterno:</label>
                                                        <input type="text" name="lastname1" required maxlength="255" placeholder="Apellido Paterno" value="${user.lastName1}">
                                                    </div>
                                                    <div class="input-box">
                                                        <label>Apellido Materno:</label>
                                                        <input type="text" name="lastname2" required maxlength="255" placeholder="Apellido Materno" value="${user.lastName2}">
                                                    </div>
                                                    <div class="input-box">
                                                        <label>Email: </label>
                                                        <input type="email" maxlength="255" name="email" placeholder="Correo electrónico" value="${user.email}">
                                                    </div>
                                                    <div class="input-box">
                                                        <label>Password: </label>
                                                        <input type="password" name="password" required placeholder="Password" value="${user.password}">  
                                                        </div>
                                                    <div class="input-box select">
                                                        <label>Carrera: </label>
                                                    <select class="select" name = "major" value="${user.major}">
                                                        <option>ITIC</option>
                                                        <option>IIS</option>
                                                        <option>IBN</option>
                                                        <option>IMT</option>
                                                    </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="add-btn">
                                            <button class="btn" form="addForm" type="submit"><i class="fa fa-plus"></i>Registrar</button>                                    
                                        </div>
                                    </form>
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
        <style>
            select, textarea {width:100%; max-width:350px; border:solid 1px #d8d8d8; background:#fff; border-radius:5px; height:41px; line-height:29px; padding:5px 10px;}
            textarea { height: 130px;}
        </style>

        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/owl.carousel.js"></script>
        <script type="text/javascript" src="js/jquery.form-validator.min.js"></script>
        <script type="text/javascript" src="js/placeholder.js"></script>
        <script type="text/javascript" src="js/coustem.js"></script>
        <script type="text/javascript">
                                            $area = $('#area');
                                            $area.change(
                                                    function () {
                                                        $.ajax({
                                                            type: "GET",
                                                            url: "/CienciasBasicas/DataServlet?items=topics",
                                                            data: {area: $area.val()},
                                                            success: function (data) {
                                                                $("#topic").html(data),
                                                                        $("#topic").focus(),
                                                                        $("#topic").select()
                                                            }
                                                        });
                                                    }
                                            );
        </script>
        <script type="text/javascript">
            $topic = $('#topic');
            $topic.change(
                    function () {
                        $.ajax({
                            type: "GET",
                            url: "/CienciasBasicas/DataServlet?items=subtopics",
                            data: {topic: $topic.val()},
                            success: function (data) {
                                $("#subtopic").html(data),
                                        $("#subtopic").focus(),
                                        $("#subtopic").select()
                            }
                        });
                    }
            );
        </script>
        <script type="text/javascript">
            function checkFile() {
                var fileElement = document.getElementById("file");
                var fileExtension = "";
                if (fileElement.value.lastIndexOf(".") > 0) {
                    fileExtension = fileElement.value.substring(fileElement.value.lastIndexOf(".") + 1, fileElement.value.length);
                }
                if (fileExtension.toLowerCase() == "jpg" || fileExtension.toLowerCase() == "png") {
                    return true;
                } else {
                    alert("You must select a JPG or PNG file for upload");
                    return false;
                }
            }
        </script>
    </body>
</html>