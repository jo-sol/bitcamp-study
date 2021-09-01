package com.eomcs.pms.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectAddHandler extends AbstractProjectHandler {

  // >> project는 member를 필요로 하는데
  //    AbstractMamberhandler에 promptMember 메서드를 가지고 있을 것이기 때문에
  //    이것의 서브 클래스를 받아서 쓰겠다는 의미로
  //    AbstractMemberHandler memberHandler를 사용해 준다

  AbstractMemberHandler memberHandler;

  public ProjectAddHandler(List<Project> projectList, AbstractMemberHandler memberHandler) {
    super(projectList);
    this.memberHandler = memberHandler;

    // 샘플 프로젝트 미리 입력
    Project project = new Project();
    project.setNo(101);
    project.setTitle("프로젝트1");
    project.setContent("내용!!!");
    project.setStartDate(Date.valueOf("2021-1-1"));
    project.setEndDate(Date.valueOf("2021-2-2"));
    project.setOwner(memberHandler.memberList.get(0)); // memberHandler의 특정 위치에 있는 멤버 사용
    project.setMembers(new ArrayList<>()); // 테스트에 지장 없도록 빈 멤버라도 추가

    projectList.add(project);

    project = new Project();
    project.setNo(102);
    project.setTitle("프로젝트2");
    project.setContent("내용!!!");
    project.setStartDate(Date.valueOf("2021-3-1"));
    project.setEndDate(Date.valueOf("2021-4-2"));
    project.setOwner(memberHandler.memberList.get(1));
    project.setMembers(new ArrayList<>()); // 테스트에 지장 없도록 빈 멤버라도 추가

    projectList.add(project);

    project = new Project();
    project.setNo(103);
    project.setTitle("프로젝트3");
    project.setContent("내용!!!");
    project.setStartDate(Date.valueOf("2021-5-1"));
    project.setEndDate(Date.valueOf("2021-6-2"));
    project.setOwner(memberHandler.memberList.get(2));
    project.setMembers(new ArrayList<>()); // 테스트에 지장 없도록 빈 멤버라도 추가

    projectList.add(project);
  }

  public void add() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();

    project.setNo(Prompt.inputInt("번호? "));
    project.setTitle(Prompt.inputString("프로젝트명? "));
    project.setContent(Prompt.inputString("내용? "));
    project.setStartDate(Prompt.inputDate("시작일? "));
    project.setEndDate(Prompt.inputDate("종료일? "));
    project.setOwner(AuthLoginHandler.getLoginUser()); // 스태틱 인포 > getLoginUser를 받아오기
    project.setMembers(memberHandler.promptMembers("팀원?(완료: 빈 문자열) "));

    projectList.add(project);

    System.out.println("프로젝트를 저장했습니다.");
  }
}





