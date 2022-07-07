<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-07-07
  Time: 오후 3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- 상대경로 사용, [현재 URL 이 속한 계층 경로 + /save] -->
<%--action 이 절대 경로면(/save) 처음부터 /로 해서 다 들어가지만 지금은 상대경로(save)로 하면 현재 경로상에서 save 를 호출함 보통은 절대경로 사용--%>
<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>

</body>
</html>
