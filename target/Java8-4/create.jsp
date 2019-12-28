<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create new student</title>
</head>
<body style=" background: url(img.jpg) no-repeat;  width: 100%; height: 100%; margin: 0 auto; z-index: -1; position: absolute; ">
<div style=" width: 290px; margin: 170px auto; background-color: white; opacity: 0.7; box-shadow: 0 0 5px 5px #5d76cb; padding: 35px; ">
    <h2 style="text-align: center; margin: 25px auto;">Добавление</h2>

    <form method="post" action='<c:url value="/create" />' style="display: inline;">
        <label style="margin-left: 16px;">ID:</label>
        <input style="margin-left: 14px;" name="id" autocomplete="off" />
        <br><br>
        <label style="margin-left: 10px;">Имя:</label>
        <input style="margin-left: 8px;" name="name" autocomplete="off" />
        <br><br>
        <label>Группа:</label>
        <input name="group" autocomplete="off" type="number" />
        <br>
        <input type="submit" value="Добавить" style="margin: 20px auto" />

    </form>
</div>
</body>
</html>
