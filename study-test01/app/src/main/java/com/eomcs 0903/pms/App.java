package com.eomcs.pms;   // 리팩토링 >> static 멤버를 미리 import 해 줌 >> 사용할 때 다 빼도 됨

import static com.eomcs.menu.Menu.ACCESS_ADMIN;
import static com.eomcs.menu.Menu.ACCESS_GENERAL;
import static com.eomcs.menu.Menu.ACCESS_LOGOUT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import com.eomcs.menu.Menu;
import com.eomcs.menu.MenuGroup;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.handler.AuthLoginHandler;
import com.eomcs.pms.handler.AuthLogoutHandler;
import com.eomcs.pms.handler.AuthUserInfoHandler;
import com.eomcs.pms.handler.BoardAddHandler;
import com.eomcs.pms.handler.BoardDeleteHandler;
import com.eomcs.pms.handler.BoardDetailHandler;
import com.eomcs.pms.handler.BoardListHandler;
import com.eomcs.pms.handler.BoardSearchHandler;
import com.eomcs.pms.handler.BoardUpdateHandler;
import com.eomcs.pms.handler.Command;
import com.eomcs.pms.handler.MemberAddHandler;
import com.eomcs.pms.handler.MemberDeleteHandler;
import com.eomcs.pms.handler.MemberDetailHandler;
import com.eomcs.pms.handler.MemberListHandler;
import com.eomcs.pms.handler.MemberPrompt;
import com.eomcs.pms.handler.MemberUpdateHandler;
import com.eomcs.pms.handler.ProjectAddHandler;
import com.eomcs.pms.handler.ProjectDeleteHandler;
import com.eomcs.pms.handler.ProjectDetailHandler;
import com.eomcs.pms.handler.ProjectListHandler;
import com.eomcs.pms.handler.ProjectPrompt;
import com.eomcs.pms.handler.ProjectUpdateHandler;
import com.eomcs.pms.handler.TaskAddHandler;
import com.eomcs.pms.handler.TaskDeleteHandler;
import com.eomcs.pms.handler.TaskDetailHandler;
import com.eomcs.pms.handler.TaskListHandler;
import com.eomcs.pms.handler.TaskUpdateHandler;
import com.eomcs.util.Prompt;

public class App {
  List<Board> boardList = new ArrayList<>();
  List<Member> memberList = new LinkedList<>();
  List<Project> projectList = new ArrayList<>();
  // 각각의 taskList는 프로젝트에서 다룰 것

  // 1) commandMap 사용을 위한 생성자 만들기 
  HashMap<String,Command> commandMap = new HashMap<>();

  MemberPrompt memberPrompt = new MemberPrompt(memberList);
  ProjectPrompt projectPrompt = new ProjectPrompt(projectList);

  // non-static 중첩 클래스로서 inner 클래스
  class MenuItem extends Menu {
    String menuId;

    public MenuItem(String title, String menuId) {
      super(title);
      this.menuId = menuId;
    }

    public MenuItem(String title, int accessScope, String menuId) {
      super(title, accessScope);
      this.menuId = menuId;
    }

    @Override
    public void execute() {
      Command command = commandMap.get(menuId);
      command.execute();
    }
  }


  public static void main(String[] args) {
    App app = new App(); 
    app.service();
  }

  // 2) commandMap 사용을 위한 생성자 만들기
  public App() {
    commandMap.put("/board/add", new BoardAddHandler(boardList));
    commandMap.put("/board/list", new BoardListHandler(boardList));
    commandMap.put("/board/detail", new BoardDetailHandler(boardList));
    commandMap.put("/board/update", new BoardUpdateHandler(boardList));
    commandMap.put("/board/delete", new BoardDeleteHandler(boardList));
    commandMap.put("/board/search", new BoardSearchHandler(boardList));

    commandMap.put("/member/add", new MemberAddHandler(memberList));
    commandMap.put("/member/list", new MemberListHandler(memberList));
    commandMap.put("/member/detail", new MemberDetailHandler(memberList));
    commandMap.put("/member/update", new MemberUpdateHandler(memberList));
    commandMap.put("/member/delete", new MemberDeleteHandler(memberList));

    commandMap.put("/project/add", new ProjectAddHandler(projectList, memberPrompt));
    commandMap.put("/project/list", new ProjectListHandler(projectList));
    commandMap.put("/project/detail", new ProjectDetailHandler(projectList));
    commandMap.put("/project/update", new ProjectUpdateHandler(projectList, memberPrompt));
    commandMap.put("/project/delete", new ProjectDeleteHandler(projectList));

    // projectListHandler >> AbstractProjectHandler의 ProjectPrompt를 사용
    // ProjectPrompt 분리하기
    // projectListHandler >> projectPrompt
    commandMap.put("/task/add", new TaskAddHandler(projectPrompt));
    commandMap.put("/task/list", new TaskListHandler(projectPrompt));
    commandMap.put("/task/detail", new TaskDetailHandler(projectPrompt));
    commandMap.put("/task/update", new TaskUpdateHandler(projectPrompt));
    commandMap.put("/task/delete", new TaskDeleteHandler(projectPrompt));

    commandMap.put("/auth/login", new AuthLoginHandler(memberList));
    commandMap.put("/auth/userinfo", new AuthUserInfoHandler());
    commandMap.put("/auth/logout", new AuthLogoutHandler());
  }

  void service() {
    createMainMenu().execute();
    Prompt.close();
  }

  Menu createMainMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    // 어떤 메뉴 아이디를 실행할지 Command 메뉴에서 이미 코드를 다 짰기 때문에
    // 사용할 어떤 메뉴를 Command 객체를 뒤에 저장해 준다
    mainMenuGroup.add(new MenuItem("로그인", ACCESS_LOGOUT, "/auth/login"));
    mainMenuGroup.add(new MenuItem("내 정보", ACCESS_GENERAL | ACCESS_ADMIN, "/auth/userinfo"));
    mainMenuGroup.add(new MenuItem("로그아웃", ACCESS_GENERAL | ACCESS_ADMIN, "/auth/logout"));

    mainMenuGroup.add(createBoardMenu());
    mainMenuGroup.add(createMemberMenu());
    mainMenuGroup.add(createProjectMenu());
    mainMenuGroup.add(createTaskMenu());
    mainMenuGroup.add(createAdminMenu());

    return mainMenuGroup;
  }

  private Menu createBoardMenu() {
    MenuGroup boardMenu = new MenuGroup("게시판");

    boardMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/board/add"));
    boardMenu.add(new MenuItem("목록", "/board/list"));
    boardMenu.add(new MenuItem("상세보기", "/board/detail"));
    boardMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/board/update"));
    boardMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/board/delete"));
    boardMenu.add(new MenuItem("검색", "/board/search"));

    return boardMenu;
  }

  private Menu createMemberMenu() {
    MenuGroup memberMenu = new MenuGroup("회원");

    memberMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/member/add"));
    memberMenu.add(new MenuItem("목록", "/member/list"));
    memberMenu.add(new MenuItem("상세보기", "/member/detail"));
    memberMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/member/update"));
    memberMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/member/delete"));

    return memberMenu;
  }

  private Menu createProjectMenu() {
    MenuGroup projectMenu = new MenuGroup("프로젝트");

    projectMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/project/add"));
    projectMenu.add(new MenuItem("목록", "/project/list"));
    projectMenu.add(new MenuItem("상세보기", "/project/detail"));
    projectMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/project/update"));
    projectMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/project/delete"));

    return projectMenu;
  }

  private Menu createTaskMenu() {
    MenuGroup taskMenu = new MenuGroup("작업");

    taskMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/task/add"));
    taskMenu.add(new MenuItem("목록", "/task/list"));
    taskMenu.add(new MenuItem("상세보기", "task/detail"));
    taskMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/task/update"));
    taskMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/task/delete"));

    return taskMenu;
  }

  // 테스트용 - 메뉴 통제가 가능한지 확인만
  private Menu createAdminMenu() {
    MenuGroup adminMenu = new MenuGroup("관리자", ACCESS_ADMIN);
    adminMenu.add(new MenuItem("회원 등록", "/member/add"));
    adminMenu.add(new MenuItem("프로젝트 등록", "/project/add"));
    adminMenu.add(new MenuItem("작업 등록", "task/add"));
    adminMenu.add(new MenuItem("게시글 등록", "/board/add"));
    return adminMenu;
  }

}












