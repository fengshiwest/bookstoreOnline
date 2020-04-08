<%--
  Created by IntelliJ IDEA.
  User: 万宇
  Date: 2020/4/8
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>AddToCart</title>
</head>
<body>
<h3>添加书籍到购物车</h3>
<form action="addOrder" method="post">
    <input type="text" name="BookID" placeholder="BookID">
    <input type="text" name="BookNum" placeholder="BookNum">
    <div>
        <button type="submit">添加</button>
    </div>
</form>

</body>
</html>
