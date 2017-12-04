<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="cart-page">
    <div class="cart-table">
        <input class="form-control" id="myInput" type="text" placeholder="Buscar..">
        <br>
        <table>
            <thead>
            <h3>Temas de: <span style="color: #001489;">${area.area}</span>&nbsp; &nbsp;<a id="addNew" name="${area.id}" href="#" class="close-icon"><span>Agregar:</span><i class="fa fa-plus"></i></a></h3>
            
            <tr>
                <th>DESCRIPCIÓN</th>
                <th>CLAVE</th>
                <th>ACCIONES</th>
            </tr></thead>
            <tbody id="myTable">
                <c:forEach var="topic" items="${topics}" >
                    <tr>
                        <td id="${topic.id}"><span class="small-text">Tema:</span>${topic.name}</td>
                        <td><span class="small-text">Identificador:</span>${topic.id}</td>
                        <c:if test="${topic.status eq 1}">
                            <td>
                                <span class="small-text">Modificar:</span><a href="#" class="close-icon"><span class="small-text">Editar</span><i data-topic="${topic.id}" class="fa fa-pencil edit-row modalBtn"></i></a>
                                &nbsp;
                                &nbsp;
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Deshabilitar</span><i data-area="${area.id}" data-items="topics_table" data-topic="${topic.id}" data-mode="disable" class="fa fa-toggle-on delete-row"></i></a>
                            </td>
                        </c:if>
                        <c:if test="${topic.status eq 0}">
                            <td>
                                <span class="small-text">Modificar:</span><a href="#" class="close-icon"><span class="small-text">Editar</span><i data-topic="${topic.id}" class="fa fa-pencil edit-row modalBtn"></i></a>
                                &nbsp;
                                &nbsp;
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Habilitar</span><i data-area="${area.id}" data-items="topics_table" data-topic="${topic.id}" data-mode="enable" class="fa fa-toggle-off delete-row"></i></a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Editar tema:</h4>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Actualizar</button>
            </div>
        </div>

    </div>
</div>