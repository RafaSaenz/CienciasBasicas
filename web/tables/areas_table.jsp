<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ page language="java" 
         import="business.User"
         import="javax.servlet.http.HttpSession"
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="area-input" hidden style="padding: 15px 0px 0px 10px;">
    <label for="area-name">Nueva área: </label>
    <input id="area-name" type="text" maxlength="20">
    &nbsp;
    <label for="area-id">Clave:<span style="font-size: 9px;"> (no editable)</span></label>
    <input id="area-id" type="text" maxlength="2">
    <a id="save-area" href="#" class="close-icon"><i class="fa fa-save fa-2x"></i></a>
</div>
<div id="area-edit" hidden style="padding: 15px 0px 0px 10px;">
    <label for="topic">Editar área: </label>
    <input id="edit-area" type="text" maxlength="255">
    <a id="update-area" href="#" class="close-icon"><i class="fa fa-refresh fa-2x"></i></a>
</div>
<div class="cart-page">
    <div class="cart-table">
        <input class="form-control" id="myTopic" type="text" placeholder="Buscar..">
        <br>
        <table>
            <thead>
            <h3>Áreas&nbsp; &nbsp;<a id="add-area" href="#" class="close-icon"><span>Agregar:</span><i class="fa fa-plus"></i></a></h3>
            <tr>
                <th>ÁREA</th>
                <th>CLAVE</th>
                <th>ADMINISTRAR</th>
            </tr></thead>
            <tbody id="myTopicTbl">
                <c:forEach var="area" items="${areas}" >
                    <tr id="${area.id}">
                        <td>${area.area}</td>
                        <td>${area.id}</td>
                        <td>
                            <span class="small-text">Modificar:</span><a href="#" class="close-icon"><span class="small-text">Editar</span><i class="fa fa-pencil edit-a"></i></a>                            
                            &nbsp;
                            &nbsp;
                            <c:if test="${area.status eq 1}">
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Deshabilitar</span><i name="disable" class="fa fa-toggle-on enable-a"></i></a>
                                </c:if>
                                <c:if test="${area.status eq 0}">
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Habilitar</span><i name="enable" class="fa fa-toggle-off enable-a"></i></a>
                                </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>