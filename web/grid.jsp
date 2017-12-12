<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="filter-row">
        <div class="view-type">
            <a name="grid-view" href="#" class="active"><i class="fa fa-th-large"></i></a>
            <a name="list-view" href="#" class=""><i class="fa fa-list"></i></a>
        </div>
        <div style="display:inline-block">
            <select id="area" name="area">
                <option style="display:none"></option>
                <c:forEach var="area" items="${areas}">
                    <option value="${area.id}">${area.area}</option>
                </c:forEach>
            </select>
        </div>
        &nbsp;
        <div style="display:inline-block">
            <select id="topic" name="topic" hidden>

            </select>
        </div>
        &nbsp;
        <div style="display:inline-block">
            <select id="subtopic" name="subtopic" hidden>

            </select>
        </div>
        &nbsp;
        <div style="display:inline-block">
            <input type="reset" id="res-filtering" hidden value="Restablecer">
        </div>
        <div class="search">
            <input type="text" placeholder="Search">
            <input type="submit" value="">
        </div>
    </div>
    <div id="display">
        <div class="row">
            <c:forEach var="resource" items="${resources}" >
                <div class="col-sm-6 col-md-3">
                    <div class="course-post">
                        <div class="img">
                            <img src="${pageContext.request.contextPath}/image/${resource.filePath}" alt="No Image Available" height="270px" width="270px">
                            <div class="price">${resource.level}</div>    
                            <div class="icon">
                                <a href="Resources?action=view&mode=detail&id=${resource.id}"><img src="images/book-icon.png" alt=""></a>
                            </div>
                        </div>
                        <div class="info">
                            <div class="name">${resource.title}</div>
                            <div class="expert"><span>Autor: </span>${resource.instructor.firstName} ${resource.instructor.lastName1}</div>
                        </div>
                        <div class="product-footer">
                            <div class="comment-box">	
                                <div class="box"><i class="fa fa-users"></i>0 Visitas</div>
                            </div>
                            <div class="rating">
                                <div class="fill" style="width:${resource.review}%;"></div>
                            </div>
                            <div class="view-btn">
                                <a href="Resources?action=view&mode=detail&id=${resource.id}" class="btn">Ver más</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="pagination">
        <ul>
            <li class="next"><a href="#"><i class="fa fa-angle-left"></i><span>Next</span></a></li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li class="prev"><a href="#"><span>prev</span> <i class="fa fa-angle-right"></i></a></li>
        </ul>
    </div>
</div>