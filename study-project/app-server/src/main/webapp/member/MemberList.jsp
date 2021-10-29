<%@page import="java.util.Collection"%>
<%@page import="com.eomcs.pms.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
   <title>회원목록</title>
</head>
<body>
<h1>[회원 목록] (MVC)</h1>
<a href='form'>새회원</a><br>
<table border='1'>
<thead>
<tr>
<th>번호</th>
<th>이름</th>
<th>이메일</th>
<th>전화</th>
<th>등록일</th>
</tr>
</thead>
<tbody>
<!-- 사이에 넣고 싶을 때 -->
<% // 저장소에 있는 애를 꺼내겠다 타입은 Collection
Collection<Member> memberList = (Collection<Member>) request.getAttribute("memberList");

for (Member member : memberList) {
%>
<tr>
    <td><%=member.getNo()%></td> <!-- <%=member.getNo()%> 값을 출력하는 익스프레션..? element(태그) -->
    <td><a href='detail?no=<%=member.getNo()%>'><%=member.getName()%></a></td>
    <td><%=member.getEmail()%></td>
    <td><%=member.getTel()%></td>
    <td><%=member.getRegisteredDate()%></td>
</tr>
<%} %> <!-- tbody와 tr 사이에 중괄호 닫기 -->
</tbody>
</table>
</body>
</html>

