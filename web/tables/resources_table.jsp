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
                Recursos &nbsp; &nbsp; <a href="Resources?action=add&mode=" class="close-icon"><span>Agregar:</span><i class="fa fa-plus"></i></a></h3>
            <tr>
                <th>TÍTULO</th>
                <%  
                    if (currentUser.getRole().equals("1")) { //An Instructor is logged in
                %>
                <th>AUTOR</th>
                <%
                    }
                %>
                <th>ÁREA</th>
                <th>TEMA</th>
                <th>SUBTEMA</th>
                <th>ACCIONES</th>
            </tr></thead>
            <tbody id="myTopicTbl">
                <c:forEach var="resource" items="${resources}" >
                    <tr id="${resource.id}">
                        <td><span class="small-text">Título:</span>${resource.title}</td>
                        <%  
                            if (currentUser.getRole().equals("1")) { //An Instructor is logged in
                        %>
                        <td><span class="small-text">Autor:</span>${resource.instructor.firstName} ${resource.instructor.lastName1}</td>
                        <%
                            }
                        %>
                        <td><span class="small-text">Área:</span>${resource.area.area}</td>
                        <td><span class="small-text">Tema:</span>${resource.topic.name}</td>
                        <td><span class="small-text">Subtema:</span>${resource.subtopic.name}</td>
                        <td>
                            <span class="small-text">Visualizar:</span>
                            <a href="Resources?action=view&mode=detail&id=${resource.id}" class="close-icon">
                                <span class="small-text">Visualizar:</span>
                                <i class="fa fa-eye"></i>
                            </a>
                            <c:if test="${resource.instructor.id == currentSessionUser.id}">
                            &nbsp;  
                            &nbsp;
                            <span class="small-text">Modificar:</span><a href="Resources?action=add&mode=&r_id=${resource.id}" class="close-icon"><span class="small-text">Editar</span><i class="fa fa-pencil"></i></a>                            
                            
                            &nbsp;
                            &nbsp;
                            <c:if test="${resource.status eq 1}">
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Deshabilitar</span><i name="disable" class="fa fa-toggle-on enable-btn3"></i></a>
                                </c:if>
                                <c:if test="${resource.status eq 0}">
                                <span class="small-text">Estatus:</span><a href="#" class="close-icon"><span class="small-text">Habilitar</span><i name="enable" class="fa fa-toggle-off enable-btn3"></i></a>
                                </c:if>   
                                </c:if>
                        </td>
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