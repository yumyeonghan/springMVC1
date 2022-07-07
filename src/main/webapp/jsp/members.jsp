<%@ page import="hello.servelt.domain.member.MemberRepository" %>
<%@ page import="hello.servelt.domain.member.Member" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-07-07
  Time: 오후 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository=MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    for (Member member : members) {
        out.write(" <tr>");
        out.write(" <td>" + member.getId() + "</td>");
        out.write(" <td>" + member.getUsername() + "</td>");
        out.write(" <td>" + member.getAge() + "</td>");
        out.write(" </tr>");
    }
%>
</body>
</html>
