<%--
  Created by IntelliJ IDEA.
  User: zyz1010561415
  Date: 2020/6/5
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%pageContext.setAttribute("APP_PATH", request.getContextPath());%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${APP_PATH}/student/save">
    <table>
        <td>
        <th>添加学生</th>
        </td>
        <tr>
            <td>
                姓名
            </td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>
                年龄
            </td>
            <td><input type="text" name="age"></td>
        </tr>
        <td>
            <input type="submit" value="提交">
        </td>
    </table>
</form>
</body>
</html>
