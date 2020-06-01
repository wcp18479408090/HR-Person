<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/27
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    if(confirm('权限不足，是否重新登陆？')){
        window.location.href="/login.jsp";
    }window.history.go(-1);
</script>
</body>
</html>

