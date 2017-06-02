<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="menu">
    <c:choose>
        <c:when test="${!connecte}">
            <a href="<spring:url value="/identification"/>">Identification</a>
        </c:when>
        <c:when test="${userType}=='ADMIN'">
            <a href="<spring:url value="/hotel/lister"/>">Gestion hotels</a>
            <a href="<spring:url value="/chambre/lister"/>">Gestion chambres</a>
            <a href="<spring:url value="/client/lister"/>">Gestion clients</a>
            <a href="<spring:url value="/reservation/lister"/>">Gestion réservations</a>
            <a href="<spring:url value="/deconnexion"/>">Déconnexion</a>
        </c:when>
        <c:otherwise>
            <h4>Veuillez vous connecter</h4>
    </c:otherwise>
</c:choose>
</div>