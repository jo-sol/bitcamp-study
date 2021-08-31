package com.eomcs.pms.domain;

import java.sql.Date;
import java.util.List;

public class Project {
  private int no;
  private String title;
  private String content;
  private Date startDate;
  private Date endDate;
  private Member owner;
  private List<Member> members;
  private List<Task> tasks;
  // ArrayList와 LinkedList 둘 다 쓸 수 있고 어떤 걸 쓸지 모르기 때문

  // 프로젝트는 Task를 tasks라는 이름으로 포함하기 때문에 이렇게 작성
  // 여러 개니까 List 사용
  // 쌍방향은 유지 보수에 좋지 않지만 우리는 사용해 보는 것

  // 13-e. 프로젝트 관리 로그인 정보 활용 그림 참조
  // class diagram

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

}
