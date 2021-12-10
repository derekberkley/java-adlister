<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Logged Out" />
    </jsp:include>
</head>
<body>
<div class="d-flex flex-column">
    <h1>You have been logged out. :)</h1>
    <p>We hope to see you again soon!</p>
</div>
<div class="d-flex">
    <div id="home">
        <a class="btn btn-primary m-5" href="/FreshFeed">Go to The Fresh Feed</a>
    </div>
    <div id="login">
        <a class="btn btn-info m-5" href="/login">Go to Login</a>
    </div>
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>