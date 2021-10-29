package com.eomcs.pms.servlet;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;

@WebServlet("/member/detail") // 웹에서 자동 실행이 불가능하고, 내가 직접 명령어를(이름) 입력해 줘야 함
public class MemberDetailController extends GenericServlet {
  private static final long serialVersionUID = 1L; // 이건 억압시키든 이렇게 하든 상관없음

  MemberDao memberDao;

  // 객체 생성할 때 딱 한 번 호출
  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException { // 오직 ServletException, IOException만 던진다!!


    try {
      int no = Integer.parseInt(request.getParameter("no")); // int값이 안 넘어올 수 있으니까 try 안에 넣기
      Member member = memberDao.findByNo(no);


      if (member == null) {
        throw new Exception("해당 번호의 회원이 없습니다.");
      }

      request.setAttribute("member", member);
      request.getRequestDispatcher("/member/MemberDetail.jsp").forward(request, response);


    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







