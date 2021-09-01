package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Project;

public class ProjectListHandler extends AbstractProjectHandler {

  public ProjectListHandler(List<Project> projectList) {
    super(projectList);
  }

  public void list() {
    System.out.println("[프로젝트 목록]");

    for (Project project : projectList) {
      System.out.printf("%d, %s, %s ~ %s, %s, [%s]\n", // 시작일 ~ 종료일(언제부터 언제까지)
          project.getNo(), 
          project.getTitle(), 
          project.getStartDate(), 
          project.getEndDate(), 
          project.getOwner().getName(),
          getMemberNames(project.getMembers())); // 1) 이런 메서드가 있다고 가정
    }  // 멤버 리스트가 있는 걸 getMemberNames에게 주면 이름만 뽑아서 출력해 줌
  }
}





