<%-- 
    Document   : resourceForm
    Created on : 6/12/2017, 02:16:11 PM
    Author     : gerar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="checkout-content">
    <div class="container">
        <div class="step-box fill">
            <div class="title"><span>Registrar nuevo recurso</span> </div>
        </div>
        <div class="step-box">
            <div class="title">Datos del recurso</div>
            <div class="step2 step-content">
                <div class="fill-address">
                    <div class="row">
                        <form action="Resources" method="post" id="addForm" onsubmit="return checkFile();" enctype="multipart/form-data">
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
                                            <option style="display:none"></option>
                                            <c:forEach var="type" items="${types}">
                                                <option value="${type.id}">${type.description}</opt>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="input-box">
                                        <label>Nivel: </label>
                                        <select required name="level">
                                            <option style="display:none"></option>
                                            <option value="Básico">Básico</opt>
                                            <option value="Intermedio">Intermedio</opt>
                                            <option value="Avanzado">Avanzado</opt>
                                        </select>
                                    </div>
                                    <div class="input-box">
                                        <label>Área: </label>
                                        <select required id="area" name="area">
                                            <option style="display:none"></option>
                                            <c:forEach var="area" items="${areas}">
                                                <option value="${area.id}">${area.area}</opt>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="input-box">
                                        <label>Tema: </label>
                                        <select required id="topic" name="topic">

                                        </select>
                                    </div>
                                    <div class="input-box">
                                        <label>Subtema: </label>
                                        <select required id="subtopic" name="subtopic">

                                        </select>
                                    </div>
                                    <div class="input-box file">
                                        <label>Imagen: </label>
                                        <input id="file" required type="file" name="file" size="50"/>
                                    </div>

                                </div>
                            </div>
                            <div class="add-btn">
                                <button class="btn" form="addForm" type="submit"><i class="fa fa-save"></i>Guardar</button>                                    
                            </div>
                        </form>
                    </div>            
                </div>
            </div>
        </div>
    </div>
</section>