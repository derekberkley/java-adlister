<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <div class="container">
        <%--TODO: Add a message on your profile page that welcomes the currently logged in user--%>
        <h1>Welcome to your Profile Page!, ${name}</h1>
    </div>

</body>
</html>
