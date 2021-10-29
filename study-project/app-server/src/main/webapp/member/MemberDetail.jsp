<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
   <title>회원상세</title>
   <style>
     label {
       margin-right: 5px;
       text-align: right;
       display: inline-block;
       width: 60px;
       }
   </style>
</head>
<body>
<h1>회원 상세 (MVC + EL2)</h1>
<form action='update'>
		<label for='f-no'>번호</label>
		<input id='f-no' type='text' name='no' value='${member.no}' readonly><br>
		<!-- member.getNo()를 프로퍼티명인 member.no로 해도 됨 ($안에서는 OGNL표기법으로 getter메서드 지정 사용 가능) -->
		<!-- 정확하게 페이지에서 찾게 하려면 pageScope. 등 표시해야 하는데, request에 담았으면 그냥 해도 됨  -->
		
		<label for='f-name'>이름</label>
		<input id='f-name' type='text' name='name' value='${member.name}'><br>
		
		<label for='f-email'>이메일</label>
		<input id='f-email' type='email' name='email' value='${member.email}'><br>
		
		<label for='f-password'>암호</label>
		<input id='f-password' type='password' name='password'><br>
		
		<label for='f-photo'>사진</label>
		<input id='f-photo' type='text' name='photo' value='${member.photo}'><br>
		
		<label for='f-tel'>전화</label>
		<input id='f-tel' type='tel' name='tel' value='${member.tel}'><br>
		
		<label for='f-registeredDate'>등록일</label>
		<span id='f-registeredDate'>${member.registeredDate}</sapn><br>
<button>변경</button>
 <a href='delete?no=${member.no}'>[삭제]</a> <a href='list'>[목록]</a><br>
</form>
</body>
</html>

