<%--
  Created by IntelliJ IDEA.
  User: 祈祷
  Date: 2020/4/3
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
<form action="RegisterServlet" method="post">
    <h3>注册界面</h3>
    账号：<input name="user_account" type="text"><br>
    密码：<input name="user_password" type="password"><br>
    <input type="submit" value="提交按钮">
</form>
</body>
</html>
