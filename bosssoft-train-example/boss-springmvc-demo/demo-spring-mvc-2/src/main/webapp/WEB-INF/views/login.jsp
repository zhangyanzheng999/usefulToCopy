<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%pageContext.setAttribute("APP_PATH", request.getContextPath());%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>登录</title>
</head>
<body>
<form action="${APP_PATH}/login">
    <table>
        <caption>用于登录</caption>
        <td>
        <th scope="row">登录</th>
        </td>
        <c:if test="${err!=null}">
            <tr>
                <td><label style="color: red">错误消息:</label></td>
                <td>
                    <label style="color: red;text-align: center">${err}</label>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <td>
            <input type="submit" value="登录">
        </td>
    </table>
</form>
</body>
</html>
