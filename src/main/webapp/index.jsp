<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
<script>$("#farmer-vid")[1].play()</script>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<video class="w-100" autoplay loop muted id="farmer-vid" src="pexels-rodnae-productions-8540430.mp4"></video>


<div style="background-color: #DD4A48; text-align: center">
    <h1>Here Are all the ads!</h1>
</div>
<div class="container">
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-4">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <p>$${ad.price}</p>
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