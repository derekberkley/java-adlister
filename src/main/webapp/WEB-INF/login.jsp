<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="h-25"></div>
    <div class="d-flex flex-column align-items-center">
        <h1>Please Log In</h1>
        <form class="w-25" action="/login" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block btn-lg btn-warning" value="Log In">
        </form>
        <p><small class="text-muted">Don't have an account? Register for one <a href="/register">here</a>.</small></p>
    </div>
    <div class="h-25"></div>
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>