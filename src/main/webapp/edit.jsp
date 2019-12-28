<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit Page</title>
</head>
<body style=" background: url(img.jpg) no-repeat;  width: 100%; height: 100%; margin: 0 auto; z-index: -1; position: absolute; ">
    <div style=" width: 360px; margin: 260px auto; background-color: white; opacity: 0.7; box-shadow: 0 0 5px 5px #5d76cb; padding: 35px; ">
        <h2 style="margin: 25px auto; text-align: center; ">Редактирование</h2>
        <form method="post">
            <input type="hidden" value="${student.id}" name="id" />
            <label>Имя:</label>
            <input name="name" value="${student.name}" autocomplete="off" />

            <br><br>

            <label>Номер группы: </label>
            <input name="group_number" value="${student.group_number}" type="number" />

            <br><br>

            <input type="submit" value="Изменить" style="margin: 10px auto"/>
        </form>
    </div>
</body>
</html>
