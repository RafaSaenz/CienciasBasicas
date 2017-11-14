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
                            <li><a href="Resources?action=view&mode=grid">Recursos</a></li>
                            <li><a href="Resources?action=add&mode=">Registrar</a></li>
                        </ul>
                    </div>
                </section>
                <section class="checkout-content">
                    <div class="container">
                        <div class="step-box fill">
                            <div class="title"><span>Registrar nuevo recurso</span> </div>
                        </div>
                        <div class="step-box">
                            <div class="title">Datos del recurso</div>
                            <div class="step2 step-content">
                                <div class="fill-address">
                                    <div class="row">
                                        <form action="Resources" method="post" id="addForm" enctype="multipart/form-data">
                                            <div class="col-sm-6">
                                                <div class="input-filde">   
                                                    <div class="input-box">
                                                        <label>Título:</label>
                                                        <input type="text" name="title" required maxlength="255" placeholder="Ingrese título del recurso">
                                                    </div>
                                                    <div class="input-box">
                                                        <label>Descripción:</label>
                                                        <textarea rows="5" cols="35" name="description" maxlength="255" required form="addForm" placeholder="Descripción detallada del recurso"></textarea>
                                                    </div>
                                                    <div class="input-box">
                                                        <label>Referencias</label>
                                                        <input type="text" maxlength="255" name="references">
                                                    </div>
                                                    <div class="input-box">
                                                        <label>Hipervínculos: </label>
                                                        <input type="text" maxlength="255" name="link">
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="input-filde">
                                                    <div class="input-box">
                                                        <label>Tipo de recurso: </label>
                                                        <select  required name="type">
                                                            <option style="display:none"></option>
                                                        <c:forEach var="type" items="${types}">
                                                            <option value="${type.id}">${type.description}</opt>
                                                            </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="input-box">
                                                    <label>Nivel: </label>
                                                    <select required name="level">
                                                        <option style="display:none"></option>
                                                        <option value="Básico">Básico</opt>
                                                        <option value="Intermedio">Intermedio</opt>
                                                        <option value="Avanzado">Avanzado</opt>
                                                    </select>
                                                </div>
                                                <div class="input-box">
                                                    <label>Área: </label>
                                                    <select required id="area" name="area">
                                                        <option style="display:none"></option>
                                                        <c:forEach var="area" items="${areas}">
                                                            <option value="${area.id}">${area.area}</opt>
                                                            </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="input-box">
                                                    <label>Tema: </label>
                                                    <select required id="topic" name="topic">

                                                    </select>
                                                </div>
                                                <div class="input-box">
                                                    <label>Subtema: </label>
                                                    <select required id="subtopic" name="subtopic">

                                                    </select>
                                                </div>
                                                <div class="input-box file">
                                                    <label>Archivo: </label>
                                                    <input id="file" required type="file" name="file" size="50"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="add-btn">
                                            <button class="btn" form="addForm" type="submit"><i class="fa fa-plus"></i>Cargar</button>                                    
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
    </body>
</html>