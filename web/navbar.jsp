<%-- 
    Document   : navbar
    Created on : 2/11/2017, 09:14:35 AM
    Author     : gerardo
--%>
<%@ page language="java" 
         import="business.User"
         import="javax.servlet.http.HttpSession"
         %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User currentUser = (User) session.getAttribute("currentSessionUser");

%>
<!--We modify the navbar according to an ADMIN, INSTRUCTOR or STUDENT-->
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
                <li class="sub-menu">
                    <a href="resources.jsp">Recursos</a>
                </li>
                <%                    if (currentUser.getRole().equals("3")) { //An Instructor is logged in
                %>
                <li class="sub-menu">
                    <a href="#">Dashboard</a>
                    <ul>
                        <li><a href="#">Recursos guardados</a></li>
                        <li><a href="#">Mis quizzes</a></li>
                        <li><a href="#">Mi progreso</a></li>
                    </ul>
                </li>
                <%
                    }
                    if (currentUser.getRole().equals("2")) { //An Instructor is logged in
                %>
                <li class="sub-menu">
                    <a href="#">Reportes</a>
                    <ul>
                        <li><a href="#">Por recurso</a></li>
                        <li><a href="#">Por alumno</li></a>
                        <li><a href="#">Por tema</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="#">Materiales</a>
                    <ul>
                        <li><a href="Resources?action=add&mode=">Agregar Recurso</a></li>
                        <li><a href="Instructors?id=L00000002">Ver instructor</li></a>
                        <li><a href="Resources?action=manage">Recursos</a></li>
                    </ul>
                </li>
                <%
                    }
                    if (currentUser.getRole().equals("1")) { //An admin is logged in
                %>
                <li class="sub-menu">
                    <a href="#">Administración</a>
                    <ul>
                        <li><a href="Resources?action=add&mode=">Agregar Recurso</a></li>
                        <li><a href="Resources?action=manage">Recursos</a></li>
                        <li><a href="newInstructor.jsp">Agregar Instructor</a></li>
                        <li><a href="newInstructor.jsp">Usuarios</a></li>
                    </ul>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>