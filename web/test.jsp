<%--
  Created by IntelliJ IDEA.
  User: 万宇
  Date: 2020/3/30
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>OnlineBookStore</title>
</head>
<body>
<div>
    <h3>按id查询书籍</h3>
    <form action="TestServlet" method="post">
        <input type="text" name="FindByID" placeholder="FindByID">
        <div>
            <button type="submit">查询</button>
        </div>
    </form>

    <h3>查询结果</h3>
    <div>
        <c:if test="${book!=null }">
            <tr>
                <td>ID：${book.id}</td>
                <td>Name：${book.name}</td>
                <td>Author：${book.author}</td>
                <td>Language：${book.language}</td>
                <td>Category：${book.category}</td>
                <td>Cdrom：${book.cdrom}</td>
                <td>Commend：${book.commend}</td>
                <td>Content：${book.content}</td>
                <td>Price：${book.price}</td>
                <td>OnSaleTime：${book.onSaleTime}</td>
                <td>GoodPrice：${book.goodPrice}</td>
                <td>PublishName：${book.publishName}</td>
                <td>PublishAddress：${book.publishAddress}</td>
                <td>BookNum：${book.bookNum}</td>
            </tr>
        </c:if>
    </div>

    <h3>按作者查询书籍</h3>
    <form action="TestServlet" method="post">
        <input type="text" name="FindByAuthor" placeholder="FindByAuthor">
        <div>
            <button type="submit">查询</button>
        </div>
    </form>

    <h3>查询结果</h3>
    <div>
        <c:if test="${bookList!=null }">
            <c:forEach items="${bookList}" var="book">
                <tr>
                    <td>ID：${book.id}</td>
                    <td>Name：${book.name}</td>
                    <td>Author：${book.author}</td>
                    <td>Language：${book.language}</td>
                    <td>Category：${book.category}</td>
                    <td>Cdrom：${book.cdrom}</td>
                    <td>Commend：${book.commend}</td>
                    <td>Content：${book.content}</td>
                    <td>Price：${book.price}</td>
                    <td>OnSaleTime：${book.onSaleTime}</td>
                    <td>GoodPrice：${book.goodPrice}</td>
                    <td>PublishName：${book.publishName}</td>
                    <td>PublishAddress：${book.publishAddress}</td>
                    <td>BookNum：${book.bookNum}</td>
                </tr>
            </c:forEach>
        </c:if>

    </div>


    <h3>添加书籍</h3>
    <form action="TestServlet" method="post">
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
