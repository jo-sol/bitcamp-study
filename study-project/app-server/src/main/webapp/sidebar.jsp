<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside>
<c:if test="${not empty sessionScope.loginUser}">
	<c:if test="${empty sessionScope.loginUser.photo}">
	<img src="https://via.placeholder.com/100">
	</c:if>
	<c:if test="${not empty sessionScope.loginUser.photo}">
  <img src="${contextPath}/upload/member/${sessionScope.loginUser.photo}_100x100.jpg">	
	</c:if>
	<br>
	${sessionScope.loginUser.name}<br>
</c:if>
</aside>