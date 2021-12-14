<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Favorites</title>
    <jsp:include page="partials/head.jsp"/>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
<div class="container">
    <h1 class="text-center mt-3">Your Favorite Items</h1>
    <input type="hidden" name="id" value="${ad.id}">
    <p>${ad.title}</p>
    <p>${ad.description}</p>
    <p>$${ad.price}</p>
</div>
<div class="h-75"><!--space placeholder box for better transient experience--></div>
<jsp:include page="partials/footer.jsp"/>
</body>
</html>