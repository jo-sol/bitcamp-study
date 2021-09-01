package com.eomcs.pms.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Project {
  private int no;
  private String title;
  private String content;
  private Date startDate;
  private Date endDate;
  private Member owner;
  private List<Member> members;
  private List<Task> tasks = new ArrayList<>();
  // task를 등록할 때마다 한 개씩 한 개씩 add 시킨다는 의미
  // 그래서 빈 프로젝트라도 가지고 있어야 함
  // 그래야 하나씩 add 할 수 있으니까
  // ArrayList와 LinkedList 둘 다 쓸 수 있고 어떤 걸 쓸지 모르기 때문

  @Override
  public String toString() {
    return "Project [no=" + no + ", title=" + title + ", content=" + content + ", startDate="
        + startDate + ", endDate=" + endDate + ", owner=" + owner + ", members=" + members
        + ", tasks=" + tasks + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Member getOwner() {
    return owner;
  }
  public void setOwner(Member owner) {
    this.owner = owner;
  }
  public List<Member> getMembers() {
    return members;
  }
  public void setMembers(List<Member> members) {
    this.members = members;
  }

  // tasks를 사용할 수 있는 getter/setter 추가

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  // [getMemberNames 리펙토링 2]
  // >> 프로젝트 멤버의 이름만 추출하는 역할
  // >> AbstractProjectHandler에 있었다면 static으로 해 주면 되는데
  //    이 클래스에서는 Project 도메인 클래스 안에서 받아 주기 때문에
  //    (위에서 private List<Member> members; 이렇게 받음)
  //    파라미터가 필요하지 않다

  public String getMemberNames() {
    if (this.members == null) {
      return ""; // null이면 빈 문자열
    }
    StringBuilder names = new StringBuilder(); 
    for (Member member : this.members) { // 현재 이 인스턴스의 members라는 필드에서 꺼내서 리턴한다
      if (names.length() > 0) { 
        names.append(",");
      }
      names.append(member.getName());
    }
    return names.toString();
  }

  // [Task findByNo 리팩토링 2] - 프로젝트에서 특정 작업을 조회하는 메서드를 이동한다
  // 찾는 정보가 많기 때문에 findTaskByNo로 정정

  public Task findTaskByNo(int taskNo) {
    for (Task task : this.tasks) {
      if (task.getNo() == taskNo) {
        return task;
      }
    }
    return null;
  }
}
