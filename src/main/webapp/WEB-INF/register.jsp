<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register for Access!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h3 class="text-center m-5">Register for an account</h3>
        <form class="row g-3" action="/register" method="post">

            <div class="col-md-6 form-group">
                <label for="first_name">First name</label>
                <input id="first_name" name="first_name" class="form-control" type="text">
            </div>

            <div class="col-md-6 form-group">
                <label for="last_name">Last name:</label>
                <input id="last_name" name="last_name" class="form-control" type="text">
            </div>

            <div class="form-group col-md-6">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text">
            </div>

            <div class="form-group col-md-6">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>

            <div class="form-group col-md-12">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>

            <div class="form-group col-md-12">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>

            <div class="form-check mt-2">
                <select name="isVendor" class="custom-select">
                    <option selected>Select Account Type</option>
                    <option value="0">Customer</option>
                    <option value="1">Vendor</option>
                </select>
                <input type="submit" class="btn btn-md btn-outline-dark mt-4">
            </div>

        </form>
    </div>
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>

<%--HELLO--%>