<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
   <title>새회원</title>
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
<div class="container">
<h1>새회원 (MVC) </h1>
<form action='add'> <!--  서버의 요청은 무조건 JSP가 아니라 Servlet -->
<div class="mb-3 row">
  <label for='f-name' class="col-sm-2 col-form-label">이름</label>
  <div class="col-sm-6">
    <input id='f-name' type='text' name='name' class="form-control">
  </div>
</div>
<div class="mb-3 row">
  <label for='f-email' class="col-sm-2 col-form-label">이메일</label>
  <div class="col-sm-10">
    <input id='f-email' type='email' name='email' class="form-control">
  </div>
</div>
<div class="mb-3 row">
  <label for='f-password' class="col-sm-2 col-form-label">암호</label>
  <div class="col-sm-6">
    <input id='f-password' type='password' name='password' class="form-control">
  </div>
</div>
<div class="mb-3 row">
  <label for='f-photo' class="col-sm-2 col-form-label">사진</label>
  <div class="col-sm-10">
    <input id='f-photo' type='text' name='photo' class="form-control">
  </div>
</div>
<div class="mb-3 row">
  <label for='f-tel' class="col-sm-2 col-form-label">전화</label>
  <div class="col-sm-10">
    <input id='f-tel' type='tel' name='tel' class="form-control">
  </div>
</div>

<button class="btn btn-success btn-sm">등록</button><br>
</form>
</div><!-- .container -->
</body>
</html>