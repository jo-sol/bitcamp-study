package com.eomcs.pms.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.eomcs.csv.CsvValue;

public class Project implements CsvValue {
  private int no;
  private String title;
  private String content;
  private Date startDate;
  private Date endDate;
  private Member owner;
  private List<Member> members = new ArrayList<>();
  private List<Task> tasks = new ArrayList<>();

  @Override
  public String toString() {
    return "Project [no=" + no + ", title=" + title + ", content=" + content + ", startDate="
        + startDate + ", endDate=" + endDate + ", owner=" + owner + ", members=" + members
        + ", tasks=" + tasks + "]";
  }

  // 다음 메서드는 CsvValue 규칙에 따라 정의한 메서드다.
  @Override
  public String toCsvString() { 
    // 프로젝트 정보를 CSV로 출력할 때 멤버 정보와 작업 정보를 포함한다.
    StringBuilder strBuilder = new StringBuilder();

    // 1) 프로젝트 기본 정보를 저장한다.
    strBuilder.append(String.format("%d,%s,%s,%s,%s,%d,%s,",
        this.getNo(),
        this.getTitle(),
        this.getContent(),
        this.getStartDate(),
        this.getEndDate(),
        this.getOwner().getNo(),
        this.getOwner().getName()));

    // 2) 프로젝트 멤버 정보를 저장한다.
    // => 프로젝트 멤버의 수를 저장한다.
    strBuilder.append(String.format("%d,", this.getMembers().size())); 

    // => 프로젝트 멤버들의 정보를 저장한다.
    for (Member m : this.getMembers()) {
      strBuilder.append(String.format("%d,%s,", m.getNo(), m.getName()));
    }

    // 3) 프로젝트 작업 정보를 저장한다.
    // => 작업의 수를 저장한다.
    strBuilder.append(String.format("%d,", this.getTasks().size())); 

    // => 작업들의 정보를 저장한다.
    for (Task t : this.getTasks()) {
      strBuilder.append(String.format("%s,", t.toCsvString()));
    }

    return strBuilder.toString();
  }

  // 다음 메서드는 파라미터로 받은 CSV 문자열에서 값을 추출하여
  // Project 객체의 각 필드에 저장한다.
  // 중요!! 인스턴스가 존재한 상태여야 한다.
  @Override
  public void loadCsv(String csv) {
    String[] values = csv.split(",");

    // 1) 프로젝트 기본 정보를 로딩
    this.setNo(Integer.valueOf(values[0]));
    this.setTitle(values[1]);
    this.setContent(values[2]);
    this.setStartDate(Date.valueOf(values[3]));
    this.setEndDate(Date.valueOf(values[4]));

    // 2) 프로젝트 관리자 정보 로딩
    Member owner = new Member();
    owner.setNo(Integer.valueOf(values[5]));
    owner.setName(values[6]);

    this.setOwner(owner);

    // 3) 프로젝트 멤버 정보 로딩
    // => 프로젝트 멤버가 몇 명인지 읽어 온다.

    // offset : 기준이 되는 위치
    // 7번 > 멤버 수
    // 8번 > 멤버
    // 만약 멤버 수가 2이면 8번부터 11번까지만 읽는다.
    // => 한 명당 번호와 이름이 있기 때문에 두 개씩 가짐
    // offset은 8부터 시작해서 번호는 2칸씩 건너뛰어 8번 멤버 하나를 읽으면 다음 멤버인 10번을 읽는다
    // => 이름은 offset + 1로 설정했기 때문에 8번 멤버를 읽을 때 하나를 지나 그 멤버의 (9번) 이름을 읽는다

    int memberSize = Integer.valueOf(values[7]);

    int lastIndex = 0;
    for (int i = 0, offset = 8; i < memberSize; i ++, offset += 2) {
      // => 파일에서 멤버 번호와 이름을 로딩한다.
      Member m = new Member();
      m.setNo(Integer.valueOf(values[offset]));
      m.setName(values[offset + 1]); // 얘가 마지막 번호

      // => 프로젝트에 멤버를 추가한다.
      this.getMembers().add(m);

      // => 작업 데이터를 읽을 때 사용할 마지막 인덱스 번호를 저장해 둔다.
      lastIndex = offset + 1;
    }

    // 4) 작업 로딩
    // => 작업의 개수를 읽어 온다.
    int taskSize = Integer.valueOf(values[lastIndex + 1]); // 작업을 저장할 위치는 마지막 번호의 다음에 있는 번호(찐 마지막 - 작업 시작점)니까 + 1 해 준다.

    for (int i = 0, offset = lastIndex + 2; i < taskSize; i ++, offset += 6) { // 위에서 t.get어쩌고를 보면 작업은 총 6 개를 저장한다. 따라서 6 개씩 증가해야 함.
      // => 파일에서 작업 데이터를 로딩한다.
      // 0916 ) java-basic > basic > ex02 > Exam0171, Exam0172 참고
      Task t = new Task();
      t.loadCsv(String.join(",",  Arrays.copyOfRange(values, offset, offset + 6))); // 시작점부터 끝점까지
      //      t.loadCsv(String.format("%d,%s,%s,%d,%d,%s",
      //          values[offset],
      //          values[offset + 1],
      //          values[offset + 2],
      //          values[offset + 3],
      //          values[offset + 4],
      //          values[offset + 5]
      //          ));

      // => 프로젝트에 작업을 추가한다.
      this.getTasks().add(t);
    }

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
  public List<Task> getTasks() {
    return tasks;
  }
  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public String getMemberNames() {
    if (this.members == null) {
      return "";
    }

    StringBuilder names = new StringBuilder();
    for (Member member : this.members) {
      if (names.length() > 0) {
        names.append(",");
      }
      names.append(member.getName());
    }
    return names.toString();
  }

  public Task findTaskByNo(int taskNo) {
    for (Task task : this.tasks) {
      if (task.getNo() == taskNo) {
        return task;
      }
    }
    return null;
  }
}
