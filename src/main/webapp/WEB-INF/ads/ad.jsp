<%--
  Created by IntelliJ IDEA.
  User: rodriquesperry
  Date: 12/10/21
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Single Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="h-25 d-flex mx-auto justify-content-center"><img src="https://bit.ly/3yi3PGs" alt="product details title image"></div>
<div class="card m-3 mx-auto border-light" style="max-width: 700px;">
    <div class="row g-0">
        <div class="col-md-4 product-img card"></div>
        <div class="col-md-8">
            <div class="card-body">
                <h1 class="card-title">${ad.title}</h1>
                <p class="card-text">${ad.description}</p>
                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. A asperiores at eius ipsam, porro quae. Delectus iste nam obcaecati sunt.</p>
                <h4>$${ad.price}</h4>
                <div class="row justify-content-end">
                    <button type="submit" class="btn btn-info btn-sm m-2" data-toggle="tooltip" data-placement="bottom" title="Add to Cart">Add to Cart <i class="fas fa-cart-plus"></i></button> <!--add functionality-->
                    <button type="submit" class="btn btn-info btn-sm m-2"  data-toggle="tooltip" data-placement="bottom" title="Add to Favorites">Add to Favorites <i class="far fa-star"></i></button> <!--add functionality-->
                </div>
                <p class="card-text"><small class="text-muted">Last updated 7 hours ago</small></p>
            </div>
        </div>
    </div>
</div>
<div class="h-25"><!--for aesthetics, delete later--></div>

<%--<h1>${ad.title}</h1>
    <h4>${ad.description}</h4>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. A asperiores at eius ipsam, porro quae. Delectus iste nam obcaecati sunt.</p>
    <p>$${ad.price}</p>--%>
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>