<%--
  Created by IntelliJ IDEA.
  User: 万宇
  Date: 2020/3/30
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>BookStoreOnline</title>
</head>
<body>
<h3>按id查询书籍</h3>
<form action="queryBookByID" method="post">
    <input type="text" name="ID" placeholder="ID">
    <div>
        <button type="submit">查询</button>
    </div>
</form>

<h3>按作者查询书籍</h3>
<form action="queryBookByAuthor" method="post">
    <input type="text" name="Author" placeholder="Author">
    <div>
        <button type="submit">查询</button>
    </div>
</form>
</body>


</html>