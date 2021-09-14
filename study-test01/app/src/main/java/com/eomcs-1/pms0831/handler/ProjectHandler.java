package com.eomcs.pms0831.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectHandler {

  List<Project> projectList;
  MemberHandler memberHandler;

  public ProjectHandler(List<Project> projectList, MemberHandler memberHandler) {
    this.projectList = projectList;
    this.memberHandler = memberHandler;

    // 샘플 프로젝트 미리 입력
    Project project = new Project();
    project.setNo(101);
    project.setTitle("프로젝트1");
    project.setContent("내용!!!");
    project.setStartDate(Date.valueOf("2021-1-1"));
    project.setEndDate(Date.valueOf("2021-2-2"));
    project.setOwner(memberHandler.memberList.get(0));
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
    project.setOwner(AuthHandler.getLoginUser()); // 스태틱 인포 > getLoginUser를 받아오기
    project.setMembers(memberHandler.promptMembers("팀원?(완료: 빈 문자열) "));

    projectList.add(project);

    System.out.println("프로젝트를 저장했습니다.");
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
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

  // 2) 해당 메서드에 대해 실제 사용하는 것처럼 정의
  private String getMemberNames(List<Member> members) {
    StringBuilder names = new StringBuilder(); // 문자열을 더하는 방법이 아닌 문자열 담는 그릇 생성
    for (Member member : members) {
      if (names.length() > 0) { // 이 객체 안에 문자가 하나라도 존재한다면
        names.append(",");
      }
      names.append(member.getName());
    }
    return names.toString();
  }

  public void detail() {
    System.out.println("[프로젝트 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    System.out.printf("프로젝트명: %s\n", project.getTitle());
    System.out.printf("내용: %s\n", project.getContent());
    System.out.printf("시작일: %s\n", project.getStartDate());
    System.out.printf("종료일: %s\n", project.getEndDate());
    System.out.printf("만든이: %s\n", project.getOwner().getName());
    System.out.printf("팀원: %s\n", getMemberNames(project.getMembers()));
  }

  public void update() {
    System.out.println("[프로젝트 변경]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    if(project.getOwner().getNo() != AuthHandler.getLoginUser().getNo()) { 
      // 둘 다 getNo를 빼도 돌아가기는 함 >> 둘 다 리턴을 Member로 하기 때문
      // getLoginUser 타고 들어갔을 때 리턴을 Member로 한다
      // 우리가 리턴 자체를 Member로 하고 있으니까
      // 원하는 것만 뽑아 오고 싶다면 이렇게 상세하게 넣어라
      System.out.println("변경 권한이 없습니다. ");
      return;
    }

    String title = Prompt.inputString(String.format("프로젝트명(%s)? ", project.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", project.getContent()));
    Date startDate = Prompt.inputDate(String.format("시작일(%s)? ", project.getStartDate()));
    Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", project.getEndDate()));

    List<Member> members = memberHandler.promptMembers(String.format(
        "팀원(%s)?(완료: 빈 문자열) ", getMemberNames(project.getMembers())));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 변경을 취소하였습니다.");
      return;
    }

    project.setTitle(title);
    project.setContent(content);
    project.setStartDate(startDate);
    project.setEndDate(endDate);
    project.setMembers(members);

    System.out.println("프로젝트를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[프로젝트 삭제]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    if (project.getOwner().getNo() != AuthHandler.getLoginUser().getNo()) {
      System.out.println("삭제 권한이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }

    projectList.remove(project);

    System.out.println("프로젝트를 삭제하였습니다.");
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





