package com.eomcs.pms1.handler;

import com.eomcs.pms1.domain.Project;
import com.eomcs.util.Prompt02;

public class ProjectHandler {

  static final int MAX_LENGTH = 5;
  static Project[] projects = new Project[MAX_LENGTH];
  static int size = 0;

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public static void add() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();

    project.no = Prompt02.inputInt("번호? ");
    project.title = Prompt02.inputString("프로젝트명? ");
    project.content = Prompt02.inputString("내용? ");
    project.startDate = Prompt02.inputDate("시작일? ");
    project.endDate = Prompt02.inputDate("종료일? ");
    project.owner = Prompt02.inputString("만든이? ");
    project.members = Prompt02.inputString("팀원? ");

    projects[size++] = project;
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public static void list() {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          projects[i].no, 
          projects[i].title, 
          projects[i].startDate, 
          projects[i].endDate, 
          projects[i].owner);
    }
  }
}
