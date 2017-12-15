<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ page language="java" 
         import="business.User"
         import="javax.servlet.http.HttpSession"
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User currentUser = (User) session.getAttribute("currentSessionUser");
%>
<div id="type-input" hidden style="padding: 15px 0px 0px 10px;">
    <label for="topic">Nuevo tipo de recurso: </label>
    <input id="type" type="text" maxlength="255">
    <a id="save-type" href="#" class="close-icon"><i class="fa fa-save fa-2x"></i></a>
</div>
<div id="type-edit" hidden style="padding: 15px 0px 0px 10px;">
    <label for="topic">Editar tipo de recurso: </label>
    <input id="edit-type" type="text" maxlength="255">
    <a id="update-type" href="#" class="close-icon"><i class="fa fa-refresh fa-2x"></i></a>
</div>
<div class="cart-page">
    <div class="cart-table">
        <input class="form-control" id="myTopic" type="text" placeholder="Buscar..">
        <br>
        <table>
            <thead>
            <h3>Tipos de recursos: <a id="add-type" href="#" class="close-icon"><span>Agregar:</span><i class="fa fa-plus"></i></a></h3>
            <tr>
                <th>DESCRIPCIÓN</th>
                <th>ADMINISTRAR</th>
            </tr></thead>
            <tbody id="myTopicTbl">
                <c:forEach var="type" items="${types}" >
                    <tr id="${type.id}">
                        <td>${type.description}</td>
                        <td>
                            <span class="small-text">Modificar:</span><a href="#" class="close-icon"><span class="small-text">Editar</span><i class="fa fa-pencil edit-rt"></i></a>                            
                            <%  
                                if (true)/*(currentUser.getRole().equals("1"))*/ { //An Instructor is logged in
                            %>
                            &nbsp;
                            &nbsp;
                            <c:if test="${type.status eq 1}">
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Deshabilitar</span><i name="disable" class="fa fa-toggle-on enable-rt"></i></a>
                                </c:if>
                                <c:if test="${type.status eq 0}">
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Habilitar</span><i name="enable" class="fa fa-toggle-off enable-rt"></i></a>
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