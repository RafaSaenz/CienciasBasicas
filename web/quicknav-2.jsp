<%-- 
    Document   : quicknav-2
    Created on : 2/11/2017, 09:24:51 AM
    Author     : gerar
--%>

<%@ page language="java" 
         import="business.User"
         import="javax.servlet.http.HttpSession"
%>
<%
    User currentUser = (User) session.getAttribute("currentSessionUser");
    if (currentUser == null) { //No user has logged in
%>
<div class="quck-nav style2" style="padding: 10px 40px 10px 40px;">
    <%
    } else { //A user has logged in
    %>
    <div class="quck-nav style2" >
        <%
            }
        %>
        <div class="contact-no"><a href="https://www.google.com.mx/maps/place/Instituto+Tecnol%C3%B3gico+de+Estudios+Superiores+de+Monterrey/@25.5173546,-103.3976534,15z/data=!4m5!3m4!1s0x0:0x8e349e24de90924d!8m2!3d25.5173546!4d-103.3976534"><i class="fa fa-map-marker"></i>Paseo del Tecnológico 751, Torreón Coah</a></div>
        <div class="contact-no"><a href="tel:018717296300"><i class="fa fa-phone"></i>01 871 729 6300</a></div>
        <div class="contact-no"><a href="http://www.itesm.mx/wps/wcm/connect/Campus/LAG/Laguna/"><i class="fa fa-globe"></i>lag.itesm.mx</a></div>

        <!--We modify the nav bar according to a logged in user-->
        <div class="quck-right">
            <!--Verify if a user has logged in or not-->
            <%
                if (currentUser == null) { //No user has logged in
            %>
            <div class="right-link"><a href="login-register.jsp"><i class="fa  fa-user"></i>Login / Register</a></div>
            <%
            } else { //A user has logged in
            %>
            <div class="right-link user-profileLink">
                <a href="javascript:void(0);"><i class="fa  fa-user"></i>
                    Bienvenido <%=currentUser.getFirstName() + " " + currentUser.getLastName1()%>
                </a>
                <ul class="accout-link">
                    <li><a href="account-settings.html">Mi cuenta</a></li>
                    <li><a href="my-courses.html">Mi Dashboard</a></li>
                    <li><a href="logout">Cerrar sesión</a></li>
                </ul>
            </div>
            <%
                }
            %>
        </div>
    </div>
