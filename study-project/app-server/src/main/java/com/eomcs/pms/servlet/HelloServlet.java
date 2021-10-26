package com.eomcs.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/hi")
public class HelloServlet implements Servlet {

  // 객체를 최초로 만들 때 그때 딱 보내는 것
  @Override
  public void init(ServletConfig config) throws ServletException {

  }

  // 중간에 설정이 필요할 때 사용
  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  // 요청이 들어올 때
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("안녕!");
    out.println("Hello!");
  }

  // 관리자 입장에서 화면에 무언가를 나타내고 싶을 때
  @Override
  public String getServletInfo() {
    return null;
  }

  // 더 이상 쓰지 않을 때
  @Override
  public void destroy() {

  }

}
