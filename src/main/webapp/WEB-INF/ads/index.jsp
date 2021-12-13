<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
<div>
    <!--put category drop down here where user can choose from list of categories and see items in that category-->
</div>
    <h1>Here Are all the ads!</h1>

    <form action="/ads" method="post" class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <form action="/ad" method="get">
                <button>Click for Details</button>
                <input type="hidden" name="ad" value="${ad.id}">
            </form>
        </div>
    </c:forEach>
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>