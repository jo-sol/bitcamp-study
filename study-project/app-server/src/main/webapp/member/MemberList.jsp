<%@page import="java.util.Collection"%>
<%@page import="com.eomcs.pms.domain.Member"%>
<%@page import="com.eomcs.pms.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
   <title>회원목록</title>
</head>
<body>
<h1>[회원 목록]</h1>
<a href='MemberForm.jsp'>새회원</a><br>
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
<% // <== scriptlet (자바 코드 조각을 두는 태그)
Collection<Member> memberList = memberDao.findAll();

for (Member member : memberList) {
%>
<tr>
    <td><%=member.getNo()%></td> <!-- <%=member.getNo()%> 값을 출력하는 익스프레션..? element(태그) -->
    <td><a href='MemberDetail.jsp?no=<%=member.getNo()%>'><%=member.getName()%></a></td>
    <td><%=member.getEmail()%></td>
    <td><%=member.getTel()%></td>
    <td><%=member.getRegisteredDate()%></td>
</tr>
<%} %> <!-- tbody와 tr 사이에 중괄호 닫기 -->
</tbody>
</table>
</body>
</html>
<!-- 하위는 JSP 엔진에게 알려 주는 명령어 -->
<%! // <== declaration element(tag) 선언 태그
// 자바 서블릿 클래스를 만들 때 그 클래스에 들어갈 변수와 메서드를 이 태그 안에 작성한다.
    MemberDao memberDao;

    public void jspInit() {
      ServletConfig config = getServletConfig();
      ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
      memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
    }
%>

