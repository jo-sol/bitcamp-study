<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <title>회원목록</title>
   <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.css">
   
   <script src="../node_modules/@popperjs/core/dist/umd/popper.js"></script> <!-- 의존하는 것 우선 -->
   <script src="../node_modules/bootstrap/dist/js/bootstrap.js"></script>
   
   <style>
    .container {
      xborder: 1px solid red; /* container에 속해 있는 건 테두리 좀 그려 봐 */ /* xborder는 테두리 없음 */
      width: 640px; /* 원하는 사이즈 크기 고정 */
    }
   </style>
</head>
<body>
<div class="container"> <!-- 화면 자동 고정(이름: container) -->
<h1>회원 목록 (MVC + EL + JSTL + BootStrap)</h1>
<a href='form' class="btn btn-outline-success btn-sm">새회원</a><br>
<table class="table table-hover">
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
<!-- 뭐를 반복할 거야? memberList -->
<c:forEach items="${memberList}" var="member"> <!-- "member"는 Member member : memberList의 member와 같음 -->
<tr> <!-- member는 JSTL 컨텍션에 저장되고, 그걸 하나씩 꺼내서 사용 -->
    <td>${member.no}</td> <!-- member.getNo() 값을 출력하는 익스프레션..? element(태그) -->
    <td><a href='detail?no=${member.no}'>${member.name}</a></td>
    <td>${member.email}</td>
    <td>${member.tel}</td>
    <td>${member.registeredDate}</td>
</tr>
</c:forEach>

</tbody>
</table>
</div><!-- .container -->
</body>
</html>

