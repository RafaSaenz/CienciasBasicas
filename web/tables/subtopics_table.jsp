<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ page language="java" 
         import="business.User"
         import="javax.servlet.http.HttpSession"
         %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User currentUser = (User) session.getAttribute("currentSessionUser");
%>
<div id="subtopic-input" hidden style="padding: 15px 0px 0px 10px;">
    <label for="topic">Nuevo subtema: </label>
    <input id="subtopic" type="text" maxlength="255">
    <a id="save-subtopic" href="#" class="close-icon"><i class="fa fa-save fa-2x"></i></a>
</div>
<div id="subtopic-edit" hidden style="padding: 15px 0px 0px 10px;">
    <label for="topic">Editar subtema: </label>
    <input id="edit-subtopic" type="text" maxlength="255">
    <a id="update-subtopic" href="#" class="close-icon"><i class="fa fa-refresh fa-2x"></i></a>
</div>
<div class="cart-page">
    <div class="cart-table">
        <input class="form-control" id="mySubtopic" type="text" placeholder="Buscar..">
        <br>
        <table>
            <thead>
            <h3>Subtemas de: <span style="color: #001489;">${topic.name}</span>&nbsp; &nbsp;<a id="add-subtopic" name="${topic.id}" href="#" class="close-icon"><span>Agregar:</span><i class="fa fa-plus"></i></a></h3>
            <tr>
                <th>DESCRIPCIÓN</th>
                <th>CLAVE</th>
                <th>ADMINISTRAR</th>
            </tr></thead>
            <tbody id="mySubtopicTbl">
                <c:forEach var="topic" items="${subtopics}" >
                    <tr id="${topic.id}">
                        <td>${topic.name}</td>
                        <td>${topic.id}</td>
                        <td>
                            <span class="small-text">Modificar:</span><a href="#" class="close-icon"><span class="small-text">Editar</span><i class="fa fa-pencil edit-s"></i></a>
                            <%
                                if (currentUser.getRole().equals("1")) { //An Instructor is logged in
                            %>
                            &nbsp;
                            &nbsp;
                            <c:if test="${topic.status eq 1}">
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Deshabilitar</span><i name="disable" class="fa fa-toggle-on enable-s"></i></a>
                                </c:if>
                                <c:if test="${topic.status eq 0}">
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Habilitar</span><i name="enable" class="fa fa-toggle-off enable-s"></i></a>
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