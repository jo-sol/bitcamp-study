package com.eomcs.pms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.eomcs.menu.Menu;
import com.eomcs.menu.MenuGroup;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.domain.Task;
import com.eomcs.pms.handler.AuthHandler;
import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.Prompt;

public class App {
  List<Board> boardList = new ArrayList<>();
  List<Member> memberList = new LinkedList<>();
  List<Project> projectList = new ArrayList<>();
  List<Task> taskList = new LinkedList<>();

  BoardHandler boardHandler = new BoardHandler(boardList);
  MemberHandler memberHandler = new MemberHandler(memberList); // 등록된 memberList에서 찾아야 하기 때문 => 같은 LinkedList 사용
  ProjectHandler projectHandler = new ProjectHandler(projectList, memberHandler);
  TaskHandler taskHandler = new TaskHandler(projectList, taskList, memberHandler);
  AuthHandler authHandler = new AuthHandler(memberList); // 등록된 memberList에서 찾아야 하기 때문 => 같은 LinkedList 사용

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
        authHandler.login();
      }
    });

    mainMenuGroup.add(new Menu("내 정보", Menu.ENABLE_LOGIN) { // 로그인 되어있을 때만 출력
      @Override
      public void execute() {
        authHandler.displayLoginUser();
      }
    });

    mainMenuGroup.add(new Menu("로그아웃", Menu.ENABLE_LOGIN) { // 로그인 되어있을 때만 출력
      @Override
      public void execute() {
        authHandler.logout();
      }
    });

    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);

    boardMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) { // 로그인 되어있을 때만 출력
      public void execute() {
        boardHandler.add(); 
      }});
    boardMenu.add(new Menu("목록") {
      public void execute() {
        boardHandler.list(); 
      }});
    boardMenu.add(new Menu("상세보기") {
      public void execute() {
        boardHandler.detail(); 
      }});
    boardMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) { // 로그인 되어있을 때만 출력
      public void execute() {
        boardHandler.update(); 
      }});
    boardMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) { // 로그인 되어있을 때만 출력
      public void execute() {
        boardHandler.delete(); 
      }});

    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);

    memberMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      public void execute() {
        memberHandler.add(); 
      }});
    memberMenu.add(new Menu("목록") {
      public void execute() {
        memberHandler.list(); 
      }});
    memberMenu.add(new Menu("상세보기") {
      public void execute() {
        memberHandler.detail(); 
      }});
    memberMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      public void execute() {
        memberHandler.update(); 
      }});
    memberMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      public void execute() {
        memberHandler.delete(); 
      }});

    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    projectMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      public void execute() {
        projectHandler.add(); 
      }});
    projectMenu.add(new Menu("목록") {
      public void execute() {
        projectHandler.list(); 
      }});
    projectMenu.add(new Menu("상세보기") {
      public void execute() {
        projectHandler.detail(); 
      }});
    projectMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      public void execute() {
        projectHandler.update(); 
      }});
    projectMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      public void execute() {
        projectHandler.delete(); 
      }});

    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);

    taskMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      public void execute() {
        taskHandler.add(); 
      }});
    taskMenu.add(new Menu("목록") {
      public void execute() {
        taskHandler.list(); 
      }});
    taskMenu.add(new Menu("상세보기") {
      public void execute() {
        taskHandler.detail(); 
      }});
    taskMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      public void execute() {
        taskHandler.update(); 
      }});
    taskMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      public void execute() {
        taskHandler.delete(); 
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












