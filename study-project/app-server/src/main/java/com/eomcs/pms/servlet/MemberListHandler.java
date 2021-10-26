package com.eomcs.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;

@WebServlet("/member/list") // 이름 주기
public class MemberListHandler extends GenericServlet {
  private static final long serialVersionUID = 1L;

  MemberDao memberDao;

  // 객체 생성할 때 딱 한 번 호출
  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    // 내가 보내는 거 text 맞는데 html이야!
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    // 웹 브라우저로 보내야 하기 때문에 out 객체(웹 브라우저로 보내는 출력 객체임)
    out.println("<html>");
    out.println("<head>");
    out.println("   <title>회원목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>[회원 목록]</h1>"); // header 1 큰 제목
    out.println("<a href='form'>새회원</a><br>"); // 같은 멤버 밑에 form

    try {
      Collection<Member> memberList = memberDao.findAll();

      for (Member member : memberList) {
        out.printf("%d, <a href='detail?no=%1$d'>%s</a>, %s, %s, %s<br>", // <br> 브레이크: new line과 같은 의미 (\n)
            member.getNo(),  // 1$ : 첫 번째 애를 사용하겠다는 의미
            member.getName(), 
            member.getEmail(), 
            member.getTel(), 
            member.getRegisteredDate());
      }
    } catch (Exception e) {
      throw new ServletException(e); 
    }
    out.println("</body>");
    out.println("</html>");

  }

  // init에서 준비한 도구 중 반드시 해제 시켜야 하는 도구가 있으면 호출
  // 서버가 종료될 때 데이터베이스와 연결 끊기 위해 호출
  //  @Override
  //  public void destroy() {
  //    sqlSession.close();
  //  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

}







