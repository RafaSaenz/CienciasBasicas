<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="cart-page">
    <div class="cart-table">
        <table id="my-table">
            <thead><h3>Temas de: <span style="color: #001489;">${area.area}</span></h3></thead>
            <tr>
                <th>DESCRIPCIÓN</th>
                <th>CLAVE</th>
                <th>ESTATUS</th>
                <th>EDITAR</th>
                <th><a id="addNew" name="${area.id}" href="#" class="close-icon"><span>Agregar:</span><i class="fa fa-plus"></i></a></th>
            </tr>
            <c:forEach var="topic" items="${topics}" >
                <tr>
                    <td id="${topic.id}"><span class="small-text">Tema:</span>${topic.name}</td>
                    <td><span class="small-text">Identificador:</span>${topic.id}</td>
                    <td><span class="small-text">Estatus:</span><a href="#" class="close-icon"><span>Habilitado</span><i class="fa fa-toggle-on"></i></a></td>               
                    <td><span class="small-text">Modificar:</span><a href="#" class="close-icon"><span class="small-text">Modificar</span><i data-topic="${topic.id}" class="fa fa-pencil edit-row"></i></a></td>
                    <td><span class="small-text">Remover:</span><a href="#" class="close-icon"><span class="small-text">Remover</span><i data-topic="${topic.id}" class="fa fa-trash delete-row"></i></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>