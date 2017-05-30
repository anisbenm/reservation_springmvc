<%-- 
    Document   : _TAMPLATE
    Created on : 29 mai 2017, 14:29:22
    Author     : Administrateur
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
        <contenue>
            <table border="2px">
                <thead><th>id</th><th>nom</th><th>adresse</th><th>action</th></thead>
                <c:forEach items="${hotels}" var="h">
                <tr> <td>${h.id}</td><td>${h.nom}</td><td>${h.adresse.localite}</td>
                    <td>
                        <a href="<spring:url value='/hotel/supprimer/${h.id}'/>">supprimer</a>
                        </td></tr>
            </c:forEach>
        </table>
    </contenue>

    <c:import url="../_PIED.jsp"></c:import>
</body>
</html>
