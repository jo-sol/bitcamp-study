package com.eomcs.pms.servlet;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
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
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/member/add")
public class MemberAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  MemberDao memberDao;

  // 객체 생성할 때 딱 한 번 호출
  // 오버라이드 init(안에 아무것도 없어야 함) 얘로 함
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
      Member member = new Member();

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

        Thumbnails.of(getServletContext().getRealPath("/upload/member") + "/" + filename)
        .size(20, 20)
        .outputFormat("jpg")
        .crop(Positions.CENTER) // 원본 이미지를 위 사이즈에 맞게 컷팅
        .toFiles(new Rename() {
          public String apply(String name, ThumbnailParameter param) {
            return name + "_20x20";
          }
        });

        Thumbnails.of(getServletContext().getRealPath("/upload/member") + "/" + filename)
        .size(100, 100)
        .outputFormat("jpg")
        .crop(Positions.CENTER) // 원본 이미지를 위 사이즈에 맞게 컷팅
        .toFiles(new Rename() {
          public String apply(String name, ThumbnailParameter param) {
            return name + "_100x100";
          }
        });
      }

      memberDao.insert(member);
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=list"); 
      request.setAttribute("pageTitle", "회원목록");
      request.setAttribute("contentUrl", "/member/MemberAdd.jsp");
      request.getRequestDispatcher("/template1.jsp").forward(request, response);

    } catch (Exception e) {
      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
      request.setAttribute("error", e);

      // 오류가 발생하면 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }

    // 리프래시(refresh)
    // 웹브라우저에게 서버가 보내 준 HTML을 출력한 후
    // 1초가 경과하면 지정한 URL을 다시 요청하도록 명령한다.
    // url=http://localhost:8080/pms/member/list (상대경로)
  }
}






