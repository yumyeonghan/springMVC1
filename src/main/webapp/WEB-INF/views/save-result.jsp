<%@ page import="hello.servelt.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-07-07
  Time: 오후 3:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공

<%--원래는 <%=((Member)request.getAttribute("member")).getId()%> 로 해줘야 하지만 jsp 에서 ${} 을 지원해 주면서 다음과 같이 사용 가능--%>
<ul>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
