<%-- 
    Document   : _template
    Created on : 28 oct. 2015, 14:14:39
    Author     : ETY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:import url="../template/_javascripts.jsp"/>
        <c:import url="../template/_stylesheets.jsp"/>
    </head>
    <body>
        <c:import url="../template/_titre.jsp"/>
        <c:import url="../template/_menu.jsp"/>
        <div class="contenu">
            <spring:url value="/inscription" var="inscritptionUrl"/>
            <form:form action="${inscriptionUrl}" modelAttribute="util" method="POST">
                Login: <form:input path="login"/><form:errors path="login"/><br> 
                Mdp: &nbsp;&nbsp;<form:password path="mdp" /><form:errors path="mdp"/><br><br>
                Type: <form:radiobuttons path="type" items="${typeList}"/>
                <input type="submit" value="Valider"/>
            </form:form>
        </div>
        <c:import url="../template/_pied.jsp"/>
    </body>
</html>
