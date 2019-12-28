<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 15.12.2019
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Not found or exception</title>
</head>
<body style=" background: url(img.jpg) no-repeat;  width: 100%; height: 100%; margin: 0 auto; z-index: -1; position: absolute; ">
    <div style=" width: 260px; margin: 240px auto; background-color: white; opacity: 0.7; box-shadow: 0 0 5px 5px #5d76cb; padding: 35px; ">
        <h2 style="text-align: center">Страницы не существует, либо запрос содержит ошиибку</h2>
        <form method="get" action='<c:url value="/servlet" />' >
            <br>
            <input type="submit" value="Вернуться" style="margin: 20px auto; margin-left: 100px; height: 27px; " />
        </form>
    </div>
</body>
</html>
