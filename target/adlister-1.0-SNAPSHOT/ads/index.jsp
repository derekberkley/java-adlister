
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Welcome to the Adlister!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome to the Adlister!</h1>


    <c:forEach var="any" items="${allAds}">
        <h4>${any.adTitle}</h4>
        <p>${any.adDescription}</p>
    </c:forEach>

    </div>

</body>
</html>
