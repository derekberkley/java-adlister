<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <h1>Welcome, ${sessionScope.user.firstName}!</h1>
    <div class="container">
        <div class="row">
            <div class="col-md-5 product-img card"></div>
            <div class="col-md-2 col-sm-0"></div>
            <div class="card ml-5 col">
                <div class="card-header">
                    <strong>User Information</strong>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Username:</strong> ${sessionScope.user.username}</li>
                    <li class="list-group-item"><strong>Email:</strong> ${sessionScope.user.email}</li>
                </ul>

                    <form action="/edit-profile" method="get">
                        <button class="btn btn-secondary mt-3 ml-3">Update Information</button>
                        <input type="hidden" name="edit-profile" value="${sessionScope.user.id}">
                    </form>

            </div>
        </div>
    </div>

    <div class="text-center mt-5">
        <a href="/ads" class="m-3 btn btn-info">View All Products</a>
    </div>

    <c:if test="${sessionScope.user.isVendor == 1}">
        <div class="container mt-3 text-center">
            <form action="/ads/create" method="get">
                <button class="btn btn-primary btn-lg mt-5 ml-3">Create Ad <i class="fas fa-plus"></i></button>
                <input type="hidden" name="create-ad" value="${sessionScope.user.id}">
            </form>
        </div>

        <div class="container">
            <h2 class="text-center mt-5">Here are all your ads</h2>
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
    </c:if>

    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>