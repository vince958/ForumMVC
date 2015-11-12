<%-- 
    Document   : _menu
    Created on : 28 oct. 2015, 14:15:08
    Author     : ETY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="menu"><br><br>
    <a href="<spring:url value="/" />">Accueil</a><br>
    <a href="lister_films">Films</a><br>
    <a href="">Series</a><br>
    <div class="menuLogin">
        <c:choose>
            <c:when test="${isLogged!=true}">
                <spring:url value="/connexion" var="connexionUrl"/>
                <form:form method="POST" action="${connexionUrl}" modelAttribute="util">
                    Login: <form:input path="login"/><form:errors path="login"/><br> 
                    Mdp: &nbsp;&nbsp;<form:password path="mdp" /><form:errors path="mdp"/><br><br>
                    <input class="loginButton" type="submit" value="Connexion"/>
                </form:form><br>
                <spring:url value="/inscription" var="inscriptionUrl"/>
                <a class="loginButton" href="${inscriptionUrl}">Inscription</a>
            </c:when>
            <c:otherwise>
                Bonjour ${userLogin} !<br><br>
                <spring:url value="/deconnexion" var="deconnexionUrl"/>
                <a class="loginButton" href="${deconnexionUrl}">Deconnexion</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
