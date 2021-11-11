<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 모든 내용이 template1의 ${contentUrl} 자리로 들어감 -->
   <style>
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
   
<h1>게시글 목록 (MVC + EL + JSTL + BootStrap)</h1>
<a href='form' class="btn btn-outline-success btn-sm">새 글</a><br>
<table class="table table-hover">
<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
</thead>
<tbody>

<c:forEach items="${boardList}" var="board">
<tr data-no="${board.no}">
    <td>${board.no}</td>
    <td><a href='detail?no=${board.no}'>${board.title}</a></td>
    <td>${board.writer.name}</td>
    <td>${board.registeredDate}</td>
    <td>${board.viewCount}</td>
</tr>
</c:forEach>

</tbody>
</table>

<script>
document.querySelectorAll("tbody a").forEach((aTag) => {
	aTag.target.onclick = () => false;
});

var trList = document.querySelectorAll("tbody tr");
trList.forEach(function(trTag) {
	trTag.onclick = (e) => {
		  window.location.href = e.currentTarget.querySelector("a").href; // 방법 2) 현재 페이지를 그 링크로 바꾸게 해라
	  };
	});
</script>

