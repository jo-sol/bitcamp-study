package com.eomcs.pms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/form")
public class MemberFormController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 출력을 담당할 뷰를 호출한다.
    request.getRequestDispatcher("/member/MemberForm.jsp").forward(request, response);
    // 메서드에서 메서드를 호출하는 게 아님
    // 메서드를 호출하면 리턴값이 나옴 (request.getRequestDispatcher("/member/MemberForm.jsp"))
    // 그 리턴값에 대해 forward를 하는 것
  }

}






