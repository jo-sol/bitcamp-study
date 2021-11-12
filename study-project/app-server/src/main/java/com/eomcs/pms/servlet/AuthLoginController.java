package com.eomcs.pms.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;

@WebServlet("/auth/login")
public class AuthLoginController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  MemberDao memberDao;

  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    try {
      Cookie cookie = null;
      // 쿠키 정보 확인하기
      if (request.getParameter("saveEmail") != null) {
        // 클라이언트에게 맡길 쿠키 준비
        cookie = new Cookie("email", email);

        // 유효 기간 설정 (밀리세컨드로 지정)
        // => 해당 기간까지만 클라이언트가 서버로 쿠키를 보내 주고 기간이 지나면 쿠키를 삭제해 버림
        // => 유효 기간을 설정하지 않으면 웹 브라우저가 실행되는 동안만 유지하라는 의미다.
        // 0이라고 적으면 지우라는 뜻, 음수는 저장하지 말라는 뜻
        cookie.setMaxAge(60 * 60 * 24 * 7); // 일주일 (초 * 분 * 시간 * 일)

        // 사용 범위 설정
        // => 해당 URL에 속한 자원을 요청할 때만 클라이언트가 서버에게 쿠키를 보내 줌
        // => 사용 범위를 지정하지 않으면 현재 서블릿 경로가 사용된다.
        //    예) http://localhost:8080/pms/auth/    <== login 서블릿과 같은 경로에 있는 자원을 요청할 때마다 무조건 보내라는 의미다.
        cookie.setPath(getServletContext().getContextPath() + "/auth"); // 원래는 "/pms/auth"지만 이름이 바뀔 수 있기 때문에 이렇게 설정

      } else {
        cookie = new Cookie("email", "");
        cookie.setMaxAge(0); // 유효 기간을 0으로 설정하면 웹 브라우저가 받는 즉시 무효한 쿠키가 된다.
      }
      response.addCookie(cookie);

      Member member = memberDao.findByEmailAndPassword(email, password);

      if (member != null) {
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", member);
        response.sendRedirect("../member/list");

      } else {
        response.setHeader("Refresh", "2;url=loginForm");

        request.setAttribute("pageTitle", "로그인오류!");
        request.setAttribute("contentUrl", "/auth/LoginFail.jsp");
        request.getRequestDispatcher("/template1.jsp").forward(request, response);

      }
    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







