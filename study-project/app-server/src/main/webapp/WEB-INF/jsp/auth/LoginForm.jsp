<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<h1>로그인</h1>
<form action='login' method='post'>
<div class="mb-3 row">
  <label for='f-email' class="col-sm-2 col-form-label">이메일</label>
  <div class="col-sm-10">
    <input id='f-email' type='email' name='email' class="form-control" value="${cookie.email.value}">
  </div>
</div>
<div class="mb-3 row">
  <label for='f-password' class="col-sm-2 col-form-label">암호</label>
  <div class="col-sm-6">
    <input id='f-password' type='password' name='password' class="form-control">
  </div>
</div>

<div class="mb-3 row">
  <label for='f-password' class="col-sm-2 col-form-label"></label>
  <div class="col-sm-6">
		<div class="form-check">
		  <input id="f-saveEmail" class="form-check-input"
		  type="checkbox" name="saveEmail" ${not empty cookie.email ? "checked" : ""}> <!-- 쿠키.이메일이 비어있지 않다면 checked를 이 자리에 두고 그렇지 않으면 빈 문자열 -->
		  <!-- 기본값(value) 지정 안 하면 saveEmail=on 이렇게 됨 디폴트 -->
		  <label class="form-check-label" for="flexCheckDefault">이메일 저장</label>
		</div>
	</div>
</div>

<button class="btn btn-primary btn-sm">로그인</button><br>
</form>










