<%--
  Created by IntelliJ IDEA.
  User: 万宇
  Date: 2020/4/6
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<div>

    <h3>添加书籍</h3>
    <form action="addBook" method="post">
        <div>
            <%--ID, Name, Author, Language, Category, Cdrom, Commend, Content, Price, On_Sale_Time, Good_Price, Publish_name, Publish_address, Book_Num--%>
            <input type = "text" name = "ID" placeholder="ID">
            <input type = "text" name = "Name" placeholder="Name">
            <input type = "text" name = "Author" placeholder="Author">
            <input type = "text" name = "Language" placeholder="Language">
            <input type = "text" name = "Category" placeholder="Category">
            <input type = "text" name = "Cdrom" placeholder="Cdrom">
            <input type = "text" name = "Commend" placeholder="Commend">
            <input type = "text" name = "Content" placeholder="Content">
            <input type = "text" name = "Price" placeholder="Price">
            <input type = "text" name = "On_Sale_Time" placeholder="On_Sale_Time">
            <input type = "text" name = "Good_Price" placeholder="Good_Price">
            <input type = "text" name = "Publish_name" placeholder="Publish_name">
            <input type = "text" name = "Publish_address" placeholder="Publish_address">
            <input type = "text" name = "Book_Num" placeholder="Book_Num">
        </div>
        <div>
            <button type="submit">提交</button>
        </div>
    </form>
</div>

</body>
</html>
