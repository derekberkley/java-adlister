<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="My Cart"/>
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
<h1 class="text-center">Your Cart</h1>

<c:choose>
    <c:when test="${cart.isEmpty()}">
        <h2>Empty</h2>
    </c:when>
    <c:otherwise>
        <c:forEach var="ad" items="${cart}">
            <div class="card text-dark bg-light p-2 col-md-4">
                <img src="https://www.fillmurray.com/640/360" class="card-img-top img-fluid"
                     alt="Fill Murray Placeholder">
                <h3 class="card-title mx-auto mt-2">${ad.title}</h3>
                <p class="card-text mx-auto">${ad.description}</p>
                <form action="/ad" method="get" class="d-md-flex justify-content-md-end align-items-end">
                    <button class="btn btn-outline-dark btn-sm">Click for Details</button>
                    <input type="hidden" name="ad" value="${ad.id}">
                </form>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>


<jsp:include page="partials/footer.jsp"/>
</body>
</html>