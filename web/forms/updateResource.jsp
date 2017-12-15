<%-- 
    Document   : resourceForm
    Created on : 6/12/2017, 02:16:11 PM
    Author     : gerar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
    <div class="row">
        <form action="Resources" method="get" id="addForm">
            <div class="col-sm-6">
                <div class="input-filde">   
                    <div class="input-box">
                        <label>Título:</label>
                        <input type="text" name="title" value="${resource.title}" required maxlength="255" placeholder="Ingrese título del recurso">
                    </div>
                    <div class="input-box">
                        <label>Descripción:</label>
                        <textarea rows="5" cols="35" name="description"  maxlength="1000" required form="addForm" placeholder="Descripción detallada del recurso">${resource.description}</textarea>
                    </div>
                    <div class="input-box">
                        <label>Referencias</label>
                        <input type="text" maxlength="255" name="references" value="${resource.references}">
                    </div>
                    <div class="input-box">
                        <label>Hipervínculos: </label>
                        <input type="text" maxlength="255" value="${resource.link}" name="link">
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="input-filde">
                    <div class="input-box">
                        <label>Tipo de recurso: </label>
                        <select  required name="type">
                            <c:forEach var="type" items="${types}">
                                <c:choose>
                                    <c:when test="${type.id == resource.type.id}">
                                        <option selected value="${type.id}">${type.description}</opt>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${type.id}">${type.description}</opt>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-box">
                        <label>Nivel: </label>
                        <select required name="level">
                            <option value="Básico">Básico</opt>
                            <option value="Intermedio">Intermedio</opt>
                            <option value="Avanzado">Avanzado</opt>
                        </select>
                    </div>
                    <div class="input-box">
                        <label>Área: </label>
                        <select required id="area-slct" name="area">
                            <c:forEach var="area" items="${areas}">
                                <c:choose>
                                    <c:when test="${area.id == resource.area.id}">
                                        <option selected value="${area.id}">${area.area}</opt>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${area.id}">${area.area}</opt>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-box">
                        <label>Tema: </label>
                        <select required id="topic-slct" name="topic">
                            <c:forEach var="topic" items="${topics}">
                                <c:choose>
                                    <c:when test="${topic.id == resource.topic.id}">
                                        <option selected value="${topic.id}">${topic.name}</opt>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${topic.id}">${topic.name}</opt>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-box">
                        <label>Subtema: </label>
                        <select required id="subtopic-slct" name="subtopic">
                            <c:forEach var="subtopic" items="${subtopics}">
                                <c:choose>
                                    <c:when test="${subtopic.id == resource.subtopic.id}">
                                        <option selected value="${subtopic.id}">${subtopic.name}</opt>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${subtopic.id}">${subtopic.name}</opt>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
        </form>
    </div>            