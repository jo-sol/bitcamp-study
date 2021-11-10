package com.eomcs.pms.servlet;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.ibatis.session.SqlSession;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/member/update")
public class MemberUpdateController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  MemberDao memberDao;

  // 객체 생성할 때 딱 한 번 호출
  @Override
  public void init() throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
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
      } 

      member.setName(request.getParameter("name"));
      member.setEmail(request.getParameter("email"));
      member.setPassword(request.getParameter("password"));
      member.setTel(request.getParameter("tel"));

      Part photoPart = request.getPart("photo");
      if (photoPart.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        photoPart.write(getServletContext().getRealPath("/upload/member") + "/" + filename);
        // 상속받은 서블릿 중에서 getServletContext를 리턴받는 애가 있음
        // 걔를 통해서 getRealPath(업로드 경로)를 알아내서 저장
        member.setPhoto(filename); // 실제 저장한 파일명을 데이터 베이스에 저장하도록
      }

      memberDao.update(member);
      sqlSession.commit();

      response.sendRedirect("list"); // 여기는 무조건 URL만 지정한다

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }

    // 리다이렉트(redirect) --> 응답 상관없이 바로 넘어가게 하고 싶으면 리다이렉트(로그인 후)
    // 서버에 응답을 받는 즉시 지정한 URL로 요청하도록 웹브라우저에게 명령한다.
    // 이때 서버는 응답할 때 내용을 보내지 않는다.
    // 어? 그럼 위에서 출력한 내용은 어떻게 되나요?
    // => 위의 코드에서 출력한 내용은 현재 버퍼에 보관되어 있다.
    // => 아직 웹브라우저에게 보낸 상태가 아니다.
    // => 따라서 위 코드에서 출력한 모든 내용, 즉 버퍼에 들어 있는 콘텐트는 모두 버려진다.
    // => 그래서 클라이언트로 내용을 보내지 않는 것이다.
    // => 오직 다시 요청해야 하는 URL 정보만 보낸다.

  }
}







