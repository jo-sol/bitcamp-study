package com.eomcs.pms.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;

@WebServlet("/auth/login")
public class AuthLoginHandler extends HttpServlet {
  private static final long serialVersionUID = 1L;

  MemberDao memberDao;

  @Override
  public void init() throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException { // 입력 폼에 값이 넘어온다고 가정

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    try {
      Member member = memberDao.findByEmailAndPassword(email, password);

      if (member != null) {
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", member);
        // 세션에 로그인 정보를 (loginUser라는 이름으로 member를) 저장한다.
        response.sendRedirect("../member/list");
        // 로그인 성공하면 멤버 리스트로 가

      } else {
        // 오류가 나면 2초 뒤에 로그인 폼으로 가게 해 버려
        response.setHeader("Refresh", "2;url=loginForm");

        // 로그인 오류 시 가게 될 페이지
        request.setAttribute("pageTitle", "로그인 오류!");
        request.setAttribute("contentUrl", "/auth/LoginFail.jsp");
        request.getRequestDispatcher("/template1.jsp").forward(request, response);

      }
    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







