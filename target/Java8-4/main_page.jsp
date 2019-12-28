<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Student Info Web Application</title>
</head>
<body style=" background: url(img.jpg) no-repeat;  width: 100%; height: 100%; margin: 0 auto; z-index: -1; position: absolute; ">
    <div style=" width: 900px; height: 480px; margin: 230px auto; background-color: white; opacity: 0.7; box-shadow: 0 0 5px 5px #5d76cb;">

        <table style="display: table; width: 860px; margin: 20px auto; font: normal normal 12px Verdana, Geneva, Arial, Helvetica, sans-serif;">

            <thead style="display: block; text-align: center;">
            <tr>
                <th style="width: 120px; "> ID </th>
                <th style="width: 370px; "> Фамилия Имя Отчество </th>
                <th style="width: 90px; "> № группы </th>
                <th style="width: 200px; "> Действие </th>
            </tr>
            </thead>

            <tbody style="display: block; height: 280px; width: 100%; overflow: auto; ">

            <c:forEach var="student" items="${studentsArray}">
                <tr>
                    <td style="width: 150px; ">${student.id}</td>
                    <td style="width: 400px; ">${student.name}</td>
                    <td style="width: 100px; ">${student.group_number}</td>
                    <td style="width: 210px; ">

                        <form method="get" action='<c:url value="/edit" />' style="display: inline;">
                            <input type="hidden" name="id" value="${student.id}">
                            <input type="submit" value="Редактировать">
                        </form> |
                        <form method="post" action='<c:url value="/delete" />' style="display: inline;">
                            <input type="hidden" name="id" value="${student.id}">
                            <input type="submit" value="Удалить">
                        </form>
                    </td>
                </tr>
            </c:forEach>


            </tbody>
        </table>

        <form method="get" action='<c:url value="/create" />' >

            <br><br>

            <input type="submit" value="Добавить" style="margin: 10px auto; margin-left: 400px; height: 29px; width: 100px;"/>
        </form>
    </div>




</body>