<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <title>회원목록</title>
   <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="../node_modules/sweetalert2/dist/sweetalert2.css">
    <link rel="stylesheet" href="../css/common.css">
    
   <script src="../node_modules/@popperjs/core/dist/umd/popper.js"></script> <!-- 의존하는 것 우선 -->
   <script src="../node_modules/bootstrap/dist/js/bootstrap.js"></script>
   <script src="../node_modules/sweetalert2/dist/sweetalert2.js"></script>
   
   <style>
    .container {
      xborder: 1px solid red; /* container에 속해 있는 건 테두리 좀 그려 봐 */ /* xborder는 테두리 없음 */
      width: 640px; /* 원하는 사이즈 크기 고정 */
    }
    tr a{
    text-decoration: none;
    color: black;
    }
    tr a:visited {
    color: black;
    }
    tr a:hover {
    cursor: pointer;
    }
   </style>
</head>
<body>
<div class="container"> <!-- 화면 자동 고정(이름: container) -->

<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../sidebar.jsp"></jsp:include>
<div id ="content">

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
<!-- member는 JSTL 컨텍션에 저장되고, 그걸 하나씩 꺼내서 사용 -->
<!-- <tr data-no="${member.no}"> 방법 3) -->
<tr>
    <td>${member.no}</td> <!-- member.getNo() 값을 출력하는 익스프레션..? element(태그) -->
    <td><a href='detail?no=${member.no}'>${member.name}</a></td>
   <%--  <td>${member.name}</td> --%>
    <td>${member.email}</td>
    <td>${member.tel}</td>
    <td>${member.registeredDate}</td>
</tr>
</c:forEach>

</tbody>
</table>
</div>
<jsp:include page="../footer.jsp"></jsp:include>

</div><!-- .container -->

<script>  /* 웹브라우저에서 실행하는 것이므로 헷갈리면 안 된다 */ 
// 태그에서 a를 찾아 반복문을 돌리고 눌러도 반응하지 않도록 false로 막음
// 만약 return을 적어야 한다면 사이드에 {} 적어 줘야 함
document.querySelectorAll("tbody a").forEach((aTag) => {
	aTag.target.onclick = () => false;
});

var trList = document.querySelectorAll("tbody tr"); /* trList > tbody tr을 모두 찾아라 */ // 리턴 객체는 HTMLCollection 타입 객체이다.
trList.forEach(function(trTag) {
	trTag.onclick = (e) => {
		  // console.log(e.currentTarget); // currentTarget >> Listener가 등록된 애를 알 수 있음 (tr tag)
		  // console.log(e.currentTarget.querySelector("a").href); // "a"를 가진 태그를 찾아서 그 링크를 알아내자
		  // e.currentTarget.querySelector("a").click(); // 방법 1) "a"를 찾으면 거기에 걸린 링크로 강제로 넘어가게 하자
		  window.location.href = e.currentTarget.querySelector("a").href; // 방법 2) 현재 페이지를 그 링크로 바꾸게 해라
		  // window.location.href = "detail?no=" + e.currentTarget.getAttribute("data-no"); // 방법 3) tr tag의 "data-no"값을 꺼내와라
		  // 방법 1~3은 보안에 가장 강력하며 검색 엔진에 걸리지 않는다.
	  };
	});
</script>

</body>
</html>

