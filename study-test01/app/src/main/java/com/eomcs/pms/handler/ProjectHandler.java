package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;
import com.eomcs.pms.util.Prompt;

public class ProjectHandler {

  static final int MAX_LENGTH = 1000;
  static Project[] projects = new Project[MAX_LENGTH];
  static int size = 0;

  public static void add() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();

    project.no = Prompt.inputInt("번호? ");
    project.title = Prompt.inputString("프로젝트명? ");
    project.content = Prompt.inputString("내용? ");
    project.startDate = Prompt.inputDate("시작일? ");
    project.endDate = Prompt.inputDate("종료일? ");

    while (true) {
      String owner  = Prompt.inputString("만든이?(취소: 빈 문자열) ");
      if (MemberHandler.exist(owner)) {
        project.owner = owner;
        break;
      } else if (owner.length() == 0) {
        System.out.println("프로젝트 등록을 취소합니다.");
        return;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    String members = ""; // ***이걸 왜 넣었는지??
    while (true) {
      String member = Prompt.inputString("팀원?(완료: 빈 문자열) ");
      if (MemberHandler.exist(member)) {
        members += "," + member;
        continue;
      } else if (member.length() == 0) {
        break;
      } 
      System.out.println("등록된 회원이 아닙니다.");
    }
    project.members = members;

    projects[size++] = project;
  }

  public static void list() {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          projects[i].no, 
          projects[i].title, 
          projects[i].content, 
          projects[i].startDate, 
          projects[i].endDate, 
          projects[i].owner, 
          projects[i].members);
    }
  }


}
