<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="My Cart"/>
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>

<div class="container">

    <h1 class="text-center">Your Cart</h1>

    <c:choose>
        <c:when test="${cart.isEmpty()}">
            <div class="h-75 d-flex flex-column justify-content-center align-items-center">
                <h2>Your cart is empty!</h2>
                <p>Go shopping!</p>
                <a href="ads">
                    <button class="btn btn-info btn-sm m-2">View All Products</button>
                </a>
            </div>
        </c:when>
        <c:otherwise>
            <c:forEach var="ad" items="${cart}">

                <div class="card m-3 mx-auto border-light">
                    <div class="row g-0">
                        <div class="col-md-4 product-img card"></div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h1 class="card-title">${ad.title}</h1>
                                <p class="card-text">${ad.description}</p>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. A
                                    asperiores at eius
                                    ipsam, porro quae. Delectus iste nam obcaecati sunt.</p>
                                <h4>$${ad.price}</h4>
                                <div class="row justify-content-end">
                                    <form action="/addToFavs" method="post">
                                        <button type="submit" class="btn btn-info btn-sm m-2" data-toggle="tooltip"
                                                data-placement="bottom"
                                                title="Add to Favorites"><i class="far fa-star"></i></button>
                                        <input type="hidden" name="ad" value="${ad.id}">
                                    </form>
                                    <form action="/removeFromCart" method="post">
                                        <button type="submit" class="btn btn-info btn-sm m-2" data-toggle="tooltip"
                                                data-placement="bottom"
                                                title="Remove From Cart">Remove
                                        </button>
                                        <input type="hidden" name="ad" value="${ad.id}">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </c:forEach>
            <form action="/ads" method="get">
                <button type="submit" class="btn btn-info btn-sm m-2" data-toggle="tooltip"
                        data-placement="bottom"
                        title="Keep Shopping">Keep Shopping
                </button>
            </form>
            <form action="/checkout" method="get">
                <button type="submit" class="btn btn-info btn-sm m-2" data-toggle="tooltip"
                        data-placement="bottom"
                        title="Checkout">Purchase
                </button>
            </form>
        </c:otherwise>
    </c:choose>

</div>

<jsp:include page="partials/footer.jsp"/>
</body>
</html>