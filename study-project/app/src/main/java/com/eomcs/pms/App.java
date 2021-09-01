package com.eomcs.pms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.eomcs.menu.Menu;
import com.eomcs.menu.MenuGroup;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.handler.AuthDisplayLoginUserHandler;
import com.eomcs.pms.handler.AuthLoginHandler;
import com.eomcs.pms.handler.AuthLogoutHandler;
import com.eomcs.pms.handler.BoardAddHandler;
import com.eomcs.pms.handler.BoardDeleteHandler;
import com.eomcs.pms.handler.BoardDetailHandler;
import com.eomcs.pms.handler.BoardListHandler;
import com.eomcs.pms.handler.BoardSearchHandler;
import com.eomcs.pms.handler.BoardUpdateHandler;
import com.eomcs.pms.handler.MemberAddHandler;
import com.eomcs.pms.handler.MemberDeleteHandler;
import com.eomcs.pms.handler.MemberDetailHandler;
import com.eomcs.pms.handler.MemberListHandler;
import com.eomcs.pms.handler.MemberPromptHandler;
import com.eomcs.pms.handler.MemberUpdateHandler;
import com.eomcs.pms.handler.ProjectAddHandler;
import com.eomcs.pms.handler.ProjectDeleteHandler;
import com.eomcs.pms.handler.ProjectDetailHandler;
import com.eomcs.pms.handler.ProjectListHandler;
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

  // 각각의 기능별로 BoardHandler를 쪼갬
  BoardAddHandler boardAddHandler = new BoardAddHandler(boardList);
  BoardListHandler boardListHandler = new BoardListHandler(boardList);
  BoardDetailHandler boardDetailHandler = new BoardDetailHandler(boardList);
  BoardUpdateHandler boardUpdateHandler = new BoardUpdateHandler(boardList);
  BoardDeleteHandler boardDeleteHandler = new BoardDeleteHandler(boardList);
  // search() 추가
  // >> 하나의 명령어를 하나의 메서드가 담당하고 있을 때 쪼개기가 가능
  BoardSearchHandler boardSearchHandler = new BoardSearchHandler(boardList);

  // 각각의 기능별로 MemberHandler를 쪼갬
  MemberAddHandler memberAddHandler = new MemberAddHandler(memberList);
  MemberListHandler memberListHandler = new MemberListHandler(memberList);
  MemberDetailHandler memberDetailHandler = new MemberDetailHandler(memberList);
  MemberUpdateHandler memberUpdateHandler = new MemberUpdateHandler(memberList);
  MemberDeleteHandler memberDeleteHandler = new MemberDeleteHandler(memberList);
  // 멤버 생성
  MemberPromptHandler memberPromptHandler = new MemberPromptHandler(memberList);

  // 각각의 기능별로 ProjectHandler를 쪼갬
  // 파라미터로 memberPromptHandler를 줌
  ProjectAddHandler projectAddHandler = new ProjectAddHandler(projectList, memberPromptHandler);
  ProjectListHandler projectListHandler = new ProjectListHandler(projectList);
  ProjectDetailHandler projectDetailHandler = new ProjectDetailHandler(projectList);
  ProjectUpdateHandler projectUpdateHandler = new ProjectUpdateHandler(projectList, memberPromptHandler);
  ProjectDeleteHandler projectDeleteHandler = new ProjectDeleteHandler(projectList);

  // 각각의 기능별로 TaskHandler를 쪼갬
  TaskAddHandler taskAddHandler = new TaskAddHandler(projectListHandler);
  TaskListHandler taskListHandler = new TaskListHandler(projectListHandler);
  TaskDetailHandler taskDetailHandler = new TaskDetailHandler(projectListHandler);
  TaskUpdateHandler taskUpdateHandler = new TaskUpdateHandler(projectListHandler);
  TaskDeleteHandler taskDeleteHandler = new TaskDeleteHandler(projectListHandler);

  // 각각의 기능별로 AuthHandler를 쪼갬
  AuthLoginHandler authLoginHandler = new AuthLoginHandler(memberList);
  AuthDisplayLoginUserHandler authDisplayLoginUserHandler = new AuthDisplayLoginUserHandler();
  AuthLogoutHandler authLogoutHandler = new AuthLogoutHandler();

  public static void main(String[] args) {
    App app = new App(); 
    app.service();
  }

  void service() {
    createMenu().execute();
    Prompt.close();
  }

  Menu createMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    mainMenuGroup.add(new Menu("로그인", Menu.ENABLE_LOGOUT) { // 로그아웃 되어있을 경우에만 활성화
      @Override
      public void execute() {
        authLoginHandler.login();
      }
    });

    mainMenuGroup.add(new Menu("내 정보", Menu.ENABLE_LOGIN) { // 로그인 되어있을 때만 출력
      @Override
      public void execute() {
        authDisplayLoginUserHandler.displayLoginUser();
      }
    });

    mainMenuGroup.add(new Menu("로그아웃", Menu.ENABLE_LOGIN) { // 로그인 되어있을 때만 출력
      @Override
      public void execute() {
        authLogoutHandler.logout();
      }
    });

    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);

    boardMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) { // 로그인 되어있을 때만 출력
      public void execute() {
        boardAddHandler.add(); 
      }});
    boardMenu.add(new Menu("목록") {
      public void execute() {
        boardListHandler.list(); 
      }});
    boardMenu.add(new Menu("상세보기") {
      public void execute() {
        boardDetailHandler.detail(); 
      }});
    boardMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) { // 로그인 되어있을 때만 출력
      public void execute() {
        boardUpdateHandler.update(); 
      }});
    boardMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) { // 로그인 로그아웃 상관없이 실행
      public void execute() {
        boardDeleteHandler.delete(); 
      }});
    boardMenu.add(new Menu("검색") {
      public void execute() {
        boardSearchHandler.search(); 
      }});

    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);

    memberMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      public void execute() {
        memberAddHandler.add(); 
      }});
    memberMenu.add(new Menu("목록") {
      public void execute() {
        memberListHandler.list(); 
      }});
    memberMenu.add(new Menu("상세보기") {
      public void execute() {
        memberDetailHandler.detail(); 
      }});
    memberMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      public void execute() {
        memberUpdateHandler.update(); 
      }});
    memberMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      public void execute() {
        memberDeleteHandler.delete(); 
      }});

    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    projectMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      public void execute() {
        projectAddHandler.add(); 
      }});
    projectMenu.add(new Menu("목록") {
      public void execute() {
        projectListHandler.list(); 
      }});
    projectMenu.add(new Menu("상세보기") {
      public void execute() {
        projectDetailHandler.detail(); 
      }});
    projectMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      public void execute() {
        projectUpdateHandler.update(); 
      }});
    projectMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      public void execute() {
        projectDeleteHandler.delete(); 
      }});

    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);

    taskMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      public void execute() {
        taskAddHandler.add(); 
      }});
    taskMenu.add(new Menu("목록") {
      public void execute() {
        taskListHandler.list(); 
      }});
    taskMenu.add(new Menu("상세보기") {
      public void execute() {
        taskDetailHandler.detail(); 
      }});
    taskMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      public void execute() {
        taskUpdateHandler.update(); 
      }});
    taskMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      public void execute() {
        taskDeleteHandler.delete(); 
      }});
    //
    //    MenuGroup mg1 = new MenuGroup("관리1");
    //    mainMenuGroup.add(mg1);
    //
    //    MenuGroup mg2 = new MenuGroup("관리2");
    //    mg1.add(mg2);
    //
    //    MenuGroup mg3 = new MenuGroup("관리3");
    //    mg2.add(mg3);

    return mainMenuGroup;
  }
}












