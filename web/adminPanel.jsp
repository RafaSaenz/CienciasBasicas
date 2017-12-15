<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" 
         import="business.User"
         import="javax.servlet.http.HttpSession"
         %>
<%
    User currentUser = (User) session.getAttribute("currentSessionUser");

%>
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
                <section class="courses-view ">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="right-slide left">
                                    <h3>Recursos</h3>
                                    <ul class="catagorie-list">
                                        <li><a href="#" id="man-res">Recursos</a></li>
                                        <%                    if (currentUser.getRole().equals("1")) { //An admin is logged in
                                        %>
                                    <li><a href="#" id="man-types">Tipos</a></li>
                                    <li><a href="#" id="man-area">Áreas</a></li>
                                        <%
                                            }
                                        %>
                                    <li><a href="#" id="man-tas">Temas/Subtemas</a>
                                        <ul id="top_sub">
                                        </ul>
                                    </li>
                                </ul>
                                <%                    if (currentUser.getRole().equals("1")) { //An admin is logged in
                                %>
                                <h3>Usuarios</h3>
                                <ul class="catagorie-list">
                                    <li><a href="#" id="man-ins">Instructores</a></li>
                                    <li><a href="#" id="man-stu">Estudiantes</a></li>
                                </ul>
                                <% }
                                %>
                            </div>
                        </div>
                        <div class="col-md-9" style="border: #001489 solid thick">
                            <div id="cont2"></div>
                        </div>
                        <div class="modal fade" id="adminModal" role="dialog">
                            <div class="modal-dialog modal-lg">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">x</h4>
                                    </div>
                                    <div class="modal-body">

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">x</button>
                                    </div>
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
            .fa-save, .fa-refresh { color: #9ACD32;}
            select, textarea {width:100%; max-width:399px; border:solid 1px #d8d8d8; background:#fff; border-radius:5px; height:41px; line-height:29px; padding:5px 10px;}
            textarea { height: 117px;}
            .input-box {padding-left: 10px;}
            .input-box label {position: relative; line-height:35px; font-size:14px; padding:0px; display:block; font-weight:bold; margin:0px; padding-bottom:7px; color:#333333; }
            .input-box input {width:100%; max-width:399px; border:solid 1px #d8d8d8; background:#fff; border-radius:5px; height:41px; line-height:29px; padding:5px 10px; }
            .shipping-add {display:inline-block; width:100%; }
            .address-box {margin:10px; border:solid 1px #d8d8d8; border-radius:5px; padding:10px 0 0 0; width:412px; float:left;}
            .address-box .name {display:block; border-bottom:solid 1px #d8d8d8; text-align:center; line-height:30px; font-size:18px; color:#333333; font-weight:500; margin-bottom:7px; padding-bottom: 4px; }
            .address-box .address {min-height:10px; line-height:24px; font-size:14px; color:#666666; text-align:center; display:block; }
            .address-box .radio-row {display:block; padding:10px; text-align:center;}
            .address-box .input-row {display:block; padding:10px; text-align:center; border-top: solid 1px #d8d8d8;}
            .address-box .link-row { background:#f2f0f0; border-radius:0 0 5px 5px; padding:0 15px 0 10px; overflow:hidden;}
            .address-box .link-row a {line-height:40px; font-size:16px; color:#666666; font-weight:normal; float:left}
            .address-box .link-row a .fa {padding:0 3px 0 0;}
        </style>
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
