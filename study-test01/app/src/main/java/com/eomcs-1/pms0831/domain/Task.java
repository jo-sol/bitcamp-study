package com.eomcs.pms0831.domain;

import java.sql.Date;

public class Task {
  private int no;
  private String content;
  private Date deadline;
  private Member owner;
  private int status;
  private Project project;
  // task가 project를 사용할 것이기 때문

  // 되도록 쌍방향 참조는 구현하지 않음(사용이 겹치기 때문)
  // 둘이 간결합이 일어남
  // - task를 사용하려면 항상 project 클래스가 있어야 하고
  // - project를 사용하려면 항상 task 클래스가 있어야 함
  // - 이처럼 강력하게 붙어 있는 상태가 됨
  // - task로 다른 걸 개발하고 싶을 때 project도 같이 가지고 와야 함
  // >> 따라서 단방향 참조를 권장함

  // 객체의 내용을 출력할 때 println으로 바로바로 출력하면
  // 개발하는 동안 확인하기 쉽기 때문에 toString()을 오버라이딩 함

  @Override
  public String toString() {
    return "Task [no=" + no + ", content=" + content + ", deadline=" + deadline + ", owner=" + owner
        + ", status=" + status + ", project=" + project + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getDeadline() {
    return deadline;
  }
  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public void setOwner(Member owner) {
    this.owner = owner;
  }

  public Member getOwner() {
    return owner;
  }

  // project에 대한 게터 세터 추가
  public Project getProject() {
    return project;
  }
  public void setProject(Project project) {
    this.project = project;
  }

}
