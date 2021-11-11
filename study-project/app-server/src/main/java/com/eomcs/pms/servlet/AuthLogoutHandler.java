package com.eomcs.pms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/logout")
public class AuthLogoutHandler extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException { // 입력 폼에 값이 넘어온다고 가정

    request.getSession().invalidate(); // 세션에 저장된 것을 무효화해라 (다 날아감)
    response.sendRedirect("loginForm");
  }
}







