<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ page language="java" 
         import="business.User"
         import="javax.servlet.http.HttpSession"
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User currentUser = (User) session.getAttribute("currentSessionUser");
%>
<div id="topic-input" hidden style="padding: 15px 0px 0px 10px;">
    <label for="topic">Nuevo tema: </label>
    <input id="topic" type="text" maxlength="255">
    <a id="save-topic" href="#" class="close-icon"><i class="fa fa-save fa-2x"></i></a>
</div>
<div id="topic-edit" hidden style="padding: 15px 0px 0px 10px;">
    <label for="topic">Editar tema: </label>
    <input id="edit-topic" type="text" maxlength="255">
    <a id="update-topic" href="#" class="close-icon"><i class="fa fa-refresh fa-2x"></i></a>
</div>
<div class="cart-page">
    <div class="cart-table">
        <input class="form-control" id="myTopic" type="text" placeholder="Buscar..">
        <br>
        <table>
            <thead>
            <h3>Temas de: <span style="color: #001489;">${area.area}</span>&nbsp; &nbsp;<a id="add-topic" name="${area.id}" href="#" class="close-icon"><span>Agregar:</span><i class="fa fa-plus"></i></a></h3>
            <tr>
                <th>DESCRIPCIÓN</th>
                <th>CLAVE</th>
                <th>ADMINISTRAR</th>
            </tr></thead>
            <tbody id="myTopicTbl">
                <c:forEach var="topic" items="${topics}" >
                    <tr id="${topic.id}">
                        <td>${topic.name}</td>
                        <td>${topic.id}</td>
                        <td>
                            <span class="small-text">Subtemas:</span>
                            <a href="#" class="close-icon">
                                <span class="small-text">Ver Subtemas</span>
                                <i class="fa fa-bars modalBtn"></i>
                            </a>
                            &nbsp;  
                            &nbsp;
                            <span class="small-text">Modificar:</span><a href="#" class="close-icon"><span class="small-text">Editar</span><i class="fa fa-pencil edit-t"></i></a>                            
                            <%  
                                if (currentUser.getRole().equals("1")) { //An Instructor is logged in
                            %>
                            &nbsp;
                            &nbsp;
                            <c:if test="${topic.status eq 1}">
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Deshabilitar</span><i name="disable" class="fa fa-toggle-on enable-t"></i></a>
                                </c:if>
                                <c:if test="${topic.status eq 0}">
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Habilitar</span><i name="enable" class="fa fa-toggle-off enable-t"></i></a>
                                </c:if>
                            <%  
                                } //An Instructor is logged in
                            %>
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