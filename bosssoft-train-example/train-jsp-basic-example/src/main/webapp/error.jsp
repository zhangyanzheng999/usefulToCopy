<%--
  Created by IntelliJ IDEA.
  User: zyz1010561415
  Date: 2020/5/31
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%pageContext.setAttribute("APP_PATH", request.getContextPath());%>
<%--自定义标签--%>
<%@taglib uri="/userTag" prefix="userTag" %>
<!DOCTYPE html>
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap-theme.css"/>
<html lang="en">
<head>
    <title>错误界面</title>
</head>
<body>
<h1 style="color: #c9302c;margin-left: 650px;"  > 反正是出错了</h1>
</body>
</html>
