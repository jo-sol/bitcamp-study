package com.eomcs.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;

@WebServlet("/member/update")
public class MemberUpdateHandler extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  MemberDao memberDao;

  // 객체 생성할 때 딱 한 번 호출
  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {





    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Member member = memberDao.findByNo(no);

      if (member == null) {
        throw new Exception("해당 번호의 회원이 없습니다.<br>");
      } else {

        member.setName(request.getParameter("name"));
        member.setEmail(request.getParameter("email"));
        member.setPassword(request.getParameter("password"));
        member.setPhoto(request.getParameter("photo"));
        member.setTel(request.getParameter("tel"));

        memberDao.update(member);
        sqlSession.commit();

        // 리다이렉트(redirect) --> 응답 상관없이 바로 넘어가게 하고 싶으면 리다이렉트(로그인 후)
        // 서버에 응답을 받는 즉시 지정한 URL로 요청하도록 웹브라우저에게 명령한다.
        // 이때 서버는 응답할 때 내용을 보내지 않는다.
        // 어? 그럼 위에서 출력한 내용은 어떻게 되나요?
        // => 위의 코드에서 출력한 내용은 현재 버퍼에 보관되어 있다.
        // => 아직 웹브라우저에게 보낸 상태가 아니다.
        // => 따라서 위 코드에서 출력한 모든 내용, 즉 버퍼에 들어 있는 콘텐트는 모두 버려진다.
        // => 그래서 클라이언트로 내용을 보내지 않는 것이다.
        // => 오직 다시 요청해야 하는 URL 정보만 보낸다.
        response.sendRedirect("list"); // 여기는 무조건 URL만 지정한다

      }
    } catch (Exception e) {
      // 변경 오류가 발생했을 때만 출력하게 한다.
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<html>");
      out.println("<head>");
      out.println("  <title>회원변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>회원변경결과</h1>");
      out.println("회원 변경 오류!");
      out.println("<a href='list'>[목록]</a><br>"); // 다시 리스트로 가게 하기
      out.println("</body>");
      out.println("</html>");
      e.printStackTrace(); // 왜 에러가 떴는지 서버창에 띄워주기
    }

    // 리프래시(refresh) --> 중간에 출력값이 떠야 한다면 리프래시
    // 서버가 보낸 콘텐트를 출력한 후에
    // 1초가 경과하면 지정한 URL을 요청하도록
    // 웹브라우저에게 명령한다.

  }
}







