<%@ page import="com.codeup.adlister.models.Ad" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
List<Ad> emptyCart = new ArrayList<>();
request.getSession().setAttribute("cart", emptyCart);
%>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Checkout" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container d-flex flex-column justify-content-center align-items-center h-75">
    <h1>You have successfully submitted your order!</h1>
    <h3>Thanks for shopping with your friendly online farmer's market,</h3>
    <h1>Fresh Feed!</h1>
    <hr>
    <a href="ads">
        <button class="btn btn-info btn-sm m-2">View All Products</button>
    </a>
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>