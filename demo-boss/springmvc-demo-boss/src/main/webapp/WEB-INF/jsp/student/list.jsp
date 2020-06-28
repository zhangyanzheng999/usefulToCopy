<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zyz1010561415
  Date: 2020/6/5
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%pageContext.setAttribute("APP_PATH", request.getContextPath());%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${APP_PATH}/css/student.css"/>
</head>
<body>
<a href="${pageContext.request.contextPath}/student/preSave">学生添加</a>
<table class="table">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td><a href="${pageContext.request.contextPath}/student/preSave?id=${student.id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath}/student/delete/?id=${student.id}">删除</a></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
