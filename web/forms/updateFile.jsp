<%-- 
    Document   : fileForm
    Created on : 14/12/2017, 11:57:29 PM
    Author     : gerar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<div class="shipping-add">
    <div class="address-box">
        <div class="name">Imagen Representativa</div>
        <div class="address"><a href="${pageContext.request.contextPath}/image/${resource.filePath}" target="_blank"><i class="fa fa-download"></i> Descargar imagen</a></div>
        <div class="radio-row">
            <img src="${pageContext.request.contextPath}/image/${resource.filePath}" alt="No Image Available" height="150px" width="150px">
        </div>
        <div id="new-file" class="input-row">
            <input type="file">
        </div>
        <div class="link-row">
            <a href="#" id="edit-btn-i"><i class="fa fa-pencil"></i>Edit</a>
            <a href="#" class="pull-right"><i class="fa fa-trash"></i>Delete</a>
        </div>
    </div>
    <div class="address-box">
        <div class="name">Material Asociado</div>
        <c:if test="${file.type == 'document'}">
            <div class="address">
                <a href="${pageContext.request.contextPath}/Document/${file.filepath}" target="_blank"><i class="fa fa-file-pdf-o"></i> Descargar archivo</a>
            </div>
            <div class="radio-row">
                <img src="./images/pdf-icon.png" alt="No Image Available" height="150px" width="150px">
            </div>
        </c:if>
        <c:if test="${file.type == 'image'}">
            <div class="address">
                <a href="${pageContext.request.contextPath}/image/${file.filepath}" target="_blank"><i class="fa fa-file-image-o"></i> Descargar imagen</a>
            </div>
            <div class="radio-row">
                <img src="./images/jpg-icon.png" alt="No Image Available" height="150px" width="150px">
            </div>
        </c:if>
        <c:if test="${file.type == 'video'}">
            <div class="address">
                <a href="${file.filepath}" target="_blank"><i class="fa fa-youtube-play"></i> Visualizar video</a>
            </div>
            <div class="radio-row">
                <img src="./images/vid-icon.svg" alt="No Image Available" height="150px" width="150px">
            </div>
        </c:if>
        <div id="new-file" class="input-row">
            <input type="file">
        </div>
        <div class="link-row">
            <a href="#"><i class="fa fa-pencil"></i>Edit</a>
            <a href="#" class="pull-right"><i class="fa fa-trash"></i>Delete</a>
        </div>
    </div>
</div>

