<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="cart-page">
    <div class="cart-table">
        <input class="form-control" id="myInput" type="text" placeholder="Buscar..">
        <br>
        <table>
            <thead>
            <h3>Todos los Recursos</h3>
            <tr>
                <th>TÍTULO</th>
                <th>AUTOR</th>
                <th>ÁREA</th>
                <th>TEMA</th>
                <th>SUBTEMA</th>
                <th>EDITAR</th>
                <th><a id="addNew" name="${area.id}" href="#" class="close-icon"><span>Agregar:</span><i class="fa fa-plus"></i></a></th>
            </tr></thead>
            <tbody id="myTable">
                <c:forEach var="resource" items="${resources}" >
                    <tr>
                        <td id="${resource.id}"><span class="small-text">Título:</span>${resource.title}</td>
                        <td><span class="small-text">Autor:</span>${resource.instructor.firstName} ${resource.instructor.lastName1}</td>
                        <td><span class="small-text">Área:</span>${resource.area.area}</td>
                        <td><span class="small-text">Área:</span>${resource.topic.name}</td>
                        <td><span class="small-text">Área:</span>${resource.subtopic.name}</td>
                        <td><span class="small-text">Modificar:</span><a href="Resources?action=add&mode=&r_id=${resource.id}" class="close-icon"><span class="small-text">Modificar</span><i data-topic="${resource.id}" class="fa fa-pencil edit-row"></i></a></td>
                        <td><span class="small-text">Remover:</span><a href="#" class="close-icon"><span class="small-text">Remover</span><i data-items="resources" data-topic="${resource.id}" class="fa fa-trash delete-row"></i></a></td>
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
                <button type="button" class="btn btn-default" data-dismiss="modal">Guardar</button>
            </div>
        </div>

    </div>
</div>