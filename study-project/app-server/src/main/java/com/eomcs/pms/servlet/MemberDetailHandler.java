package com.eomcs.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
public class MemberDetailHandler extends GenericServlet {
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

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<DOCTYPE html");
    out.println("<html>");
    out.println("<head>");
    out.println("   <title>회원상세</title>");
    out.println("   <style>");
    out.println("     label {");
    out.println("       margin-right: 5px;");
    out.println("       text-align: right;");
    out.println("       display: inline-block;");
    out.println("       width: 60px;");
    out.println("       }");
    out.println("   </style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 상세</h1>");

    // no를 받아서 오겠습니다
    // 브라우저에게 넘겨 주기
    int no = Integer.parseInt(request.getParameter("no"));

    try {
      Member member = memberDao.findByNo(no);


      if (member == null) {
        out.println("해당 번호의 회원이 없습니다.");

      } else {
        out.println("<form action='update'>");
        out.printf("<label for='f-no'>번호</label> <input id='f-no' type='text' name='no' value='%d' readonly><br>\n", member.getNo());
        out.printf("<label for='f-name'>이름</label> <input id='f-name' type='text' name='name' value='%s'><br>\n", member.getName());
        out.printf("<label for='f-email'>이메일</label> <input id='f-email' type='email' name='email' value='%s'><br>\n", member.getEmail());
        out.printf("<label for='f-password'>암호</label> <input id='f-password' type='password' name='password'><br>\n");
        out.printf("<label for='f-photo'>사진</label> <input id='f-photo' type='text' name='photo' value='%s'><br>\n", member.getPhoto());
        out.printf("<label for='f-tel'>전화</label> <input id='f-tel' type='tel' name='tel' value='%s'><br>\n", member.getTel());
        out.printf("<label for='f-registeredDate'>등록일</label> <span id='f-registeredDate'>%s</sapn><br>", member.getRegisteredDate());
        out.println();

        out.println("<button>변경</button>");
        out.printf(" <a href='delete?no=%d'>[삭제]</a>", member.getNo());
        out.println(" <a href='list'>[목록]</a><br>"); // 목록은 부를 no 없으니까
        out.println("</form>");
      }
    } catch (Exception e) {
      // 직접 던질 수는 없으니까 new! ServletException에 (e)을 담아 던지기!
      throw new ServletException(e);
    }
    out.println("</body>");
    out.println("</html>");

  }

}







