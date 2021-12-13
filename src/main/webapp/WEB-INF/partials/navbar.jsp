<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("user", request.getSession().getAttribute("user"));
%>
<nav class="navbar navbar-light">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="w-100 navbar-header d-flex justify-content-between align-items-center">
            <a class="navbar-brand" href="/FreshFeed"><img class="logo" src="/est2021.png" alt="logo"></a>
            <form class="form-inline" action="/ads" method="post">
                <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light btn-lg" type="submit"><i class="fas fa-search"></i></button>
            </form>
        <ul class="nav d-flex">
            <li class="m-2"><a class="icon" href="/cart"><i class="fas fa-cart-plus fa-2x" data-toggle="tooltip" data-placement="bottom" title="Cart"></i></a></li>
            <li class="m-2"><a class="icon" href="/fav"><i class="far fa-star fa-2x" data-toggle="tooltip" data-placement="bottom" title="Favorites"></i></a></li>
            <c:if test="${user == null}">
                <li class="m-2"><a class="icon" href="/login"><i class="fas fa-sign-in-alt fa-2x" data-toggle="tooltip" data-placement="bottom" title="Login"></i></a></li>
            </c:if>
            <c:if test="${user != null}">
                <li class="m-2"><a class="icon" href="/profile">Profile</a></li>
                <li class="m-2"><a class="icon" href="/logout"><i class="fas fa-sign-out-alt fa-2x" data-toggle="tooltip" data-placement="bottom" title="Logout"></i></a></li>
            </c:if>

        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>