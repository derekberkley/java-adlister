<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.firstName}!</h1>
        <h2>Here are all your ads</h2>
        <p>Username: ${sessionScope.user.username}</p>
        <p>Email: ${sessionScope.user.email}</p>
        <form action="/edit-profile" method="get">
            <button>Update Information</button>
            <input type="hidden" name="edit-profile" value="${sessionScope.user.id}">
        </form>
    </div>
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>