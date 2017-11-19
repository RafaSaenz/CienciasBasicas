<%-- 
    Document   : navbar
    Created on : 2/11/2017, 09:14:35 AM
    Author     : gerardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav id="nav-main">
    <div class="navbar navbar-inverse">
        <div class="navbar-header">
            <a href="/CienciasBasicas/" class="navbar-brand"><img src="images/logo.png" alt=""></a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active sub-menu">
                    <a href="index.jsp">Inicio </a>
                </li>
                <li class="mega-menu sub-menu">
                    <a href="Resources?action=view&mode=grid">Recursos</a>
                    <div class="menu-view">
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="menu-title">Física</div>
                                <ul>
                                    <li><a href="#">--</a></li>
                                </ul>
                            </div>
                            <div class="col-sm-4">
                                <div class="menu-title">Matemáticas</div>
                                <ul>
                                    <li><a href="#">--</a></li>
                                </ul>
                            </div>
                            <div class="col-sm-4">
                                <div class="menu-title">Programación</div>
                                <ul>
                                    <li><a href="#">--</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="sub-menu">
                    <a href="#">Dashboard</a>
                    <ul>
                        <li><a href="#">Recursos guardados</a></li>
                        <li><a href="#">Mis quizzes</a></li>
                        <li><a href="#">Mi progreso</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="#">Reportes</a>
                    <ul>
                        <li><a href="#">Por recurso</a></li>
                        <li><a href="#">Por alumno</li></a>
                        <li><a href="#">Por tema</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="#">Administrar</a>
                    <ul>
                        <li><a href="Resources?action=add&mode=">Agregar Recurso</a></li>
                        <li><a href="Instructors?id=L00000002">Ver instructor</li></a>
                        <li><a href="newInstructor.jsp">Agregar Instructor</a></li>
                        <li><a href="Resources?action=manage">Admin Panel</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>