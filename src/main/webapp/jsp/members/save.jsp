<%@ page import="hello.servelt.domain.member.Member" %>
<%@ page import="hello.servelt.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-07-07
  Time: 오후 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //jsp 도 결국엔 servlet 으로 바뀌어서 실행되기 때문에 request, response 을 그냥 사용할 수 있다.(out 도 가능)
    MemberRepository memberRepository=MemberRepository.getInstance();
    String username=request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age")); //getParameter 으로 가져온 값은 항상 string 이므로 int 로 변환

    Member member =new Member(username, age);
    memberRepository.save(member);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
