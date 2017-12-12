<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ page language="java" 
         import="business.User"
         import="javax.servlet.http.HttpSession"
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User currentUser = (User) session.getAttribute("currentSessionUser");
%>

<div class="cart-page">
    <div class="cart-table">
        <input class="form-control" id="myTopic" type="text" placeholder="Buscar..">
        <br>
        <table>
            <thead>
            <h3>
                Instructores &nbsp; &nbsp; <a href="Instructors?action=add" class="close-icon"><span>Agregar:</span><i class="fa fa-plus"></i></a></h3>
            <tr>
                <th>NÓMINA</th>
                <th>NOMBRE</th>
                <th>EMAIL</th>
                <th>TEL</th>
                <th>LINKEDIN</th>
                <th>ADMINISTRAR</th>
            </tr></thead>
            <tbody id="myTopicTbl">
                <c:forEach var="user" items="${users}" >
                    <tr id="${user.id}">
                        <td>${user.id}</td>
                        <td>${user.firstName} ${user.lastName1} ${user.lastName2}</td>
                        <td>${user.email}</td>
                        <td>${user.tel}</td>
                        <td>${user.linkedin}</td>
                        <td>
                            <span class="small-text">Visualizar:</span>
                            <a href="Instructors?action=view&mode=detail&id=${user.id}" class="close-icon">
                                <span class="small-text">Visualizar:</span>
                                <i class="fa fa-eye"></i>
                            </a>
                            &nbsp;  
                            &nbsp;
                            <span class="small-text">Modificar:</span><a href="Instructors?action=add&mode=&i_id=${user.id}" class="close-icon"><span class="small-text">Editar</span><i class="fa fa-pencil"></i></a>                            
                            &nbsp;
                            &nbsp;
                            <c:if test="${user.status eq 1}">
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Deshabilitar</span><i name="disable" class="fa fa-toggle-on enable-btn4"></i></a>
                                </c:if>
                                <c:if test="${user.status eq 0}">
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Habilitar</span><i name="enable" class="fa fa-toggle-off enable-btn4"></i></a>
                                </c:if>   
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Administración de subtemas:</h4>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>