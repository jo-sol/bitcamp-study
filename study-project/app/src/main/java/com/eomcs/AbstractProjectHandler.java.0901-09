package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public abstract class AbstractProjectHandler {

  // >> AbstractProjectHandler에서는 memberHandler를 사용할 이유가 없기 때문에
  //    굳이 대표로 뽑지 않고 사용하는 부분에서만 직접 선언하여 적용해 주었다
  protected List<Project> projectList;

  public AbstractProjectHandler(List<Project> projectList) {
    this.projectList = projectList;
  }

  // member 이름을 주면 리턴하기
  protected String getMemberNames(List<Member> members) {
    StringBuilder names = new StringBuilder(); // 문자열을 더하는 방법이 아닌 문자열 담는 그릇 생성
    for (Member member : members) {
      if (names.length() > 0) { // 이 객체 안에 문자가 하나라도 존재한다면
        names.append(",");
      }
      names.append(member.getName());
    }
    return names.toString();
  }

  public Project findByNo(int no) {
    for (Project project : projectList) {
      if (project.getNo() == no) {
        return project;
      }
    }
    return null;
  }

  // 리펙토링
  public Project promptProject() {
    System.out.println("프로젝트: ");
    for (Project project : projectList) {
      System.out.printf("  %d. %s\n", project.getNo(), project.getTitle());
    }
    while (true) { // 무한 루프 돌리기
      int projectNo = Prompt.inputInt("프로젝트 번호 선택? (취소: 0) ");
      if (projectNo == 0) {
        return null;
      }
      Project selectedProject = findByNo(projectNo); // 프로젝트 번호로 프로젝트를 찾아야 함
      if (selectedProject != null) { // 0이 아니라 다른 번호를 입력했는데 그 번호가 있다면 리턴하고
        return selectedProject;
      }
      System.out.println("프로젝트 번호가 옳지 않습니다."); // 못 찾으면 반복문 다시 돌리기
    }
  }
}





