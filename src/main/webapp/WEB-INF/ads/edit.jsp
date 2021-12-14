<%--
  Created by IntelliJ IDEA.
  User: kevinorta
  Date: 12/14/21
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit your Ad</title>
</head>
<body>
<div>
  <form action="/edit" method="post">
    <div class="form-group">
      <label for="title">Title</label>
        <textarea id="title" name="title" class="form-control" type="text">${ad.title}</textarea>
    </div>
      <div class="form-group">
          <label for="description">Description</label>
          <textarea id="description" name="description" class="form-control" type="text">${ad.description}</textarea>
      </div>
<%--      <div class="form-group">--%>
<%--          <label for="category">Category</label>--%>
<%--          <textarea id="category" name="category" class="form-control" type="text">${ad.category}</textarea>--%>
<%--      </div>--%>
      <div class="form-group">
          <label for="price">Price</label>
          <textarea id="price" name="price" class="form-control" type="number">${ad.price}</textarea>
      </div>
      <input type="hidden" value="${id}" name="id">
      <input type="submit" class="btn btn-block btn-primary">
  </form>
</div>
</body>
</html>
