<%--
  Created by IntelliJ IDEA.
  User: 祈祷
  Date: 2020/4/3
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="LoginServlet" method="post">
    <h3>登录界面</h3>
    账号：<input name="user_account" type="text">
    密码：<input name="user_password" type="password">
    <input type="submit" value="提交按钮">
</form>
</body>
</html>
