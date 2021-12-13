<%--
  Created by IntelliJ IDEA.
  User: rodriquesperry
  Date: 12/10/21
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">

    <h1>Update Your Information.</h1>

    <form action="/edit-profile" method="post">

        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text" value="${user.username}" required>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="email" class="form-control" type="text" value="${user.email}" required>
        </div>

        <button type="submit" name="editId" value="${user.id}" class="btn btn-block btn-primary">Update Information</button>
        <a href="/profile">Back to profile</a>
    </form>

</div>
</body>
</html>
