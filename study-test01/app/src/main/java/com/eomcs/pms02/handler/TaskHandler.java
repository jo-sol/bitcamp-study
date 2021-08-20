package com.eomcs.pms01.handler;

import java.sql.Date;
import com.eomcs.pms01.domain.Task;
import com.eomcs.util.Prompt;

public class TaskHandler {

  static final int MAX_LENGTH = 5; // 클래스 변수

  Task[] tasks = new Task[MAX_LENGTH]; // 인스턴스 변수
  int size = 0;

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void add(MemberHandler memberHandler) { // 앞에서 받기 위해 인스턴스 메서드로 만들기
    System.out.println("[작업 등록]");

    Task task = new Task();

    task.no = Prompt.inputInt("번호? ");
    task.content = Prompt.inputString("내용? ");
    task.deadline = Prompt.inputDate("마감일? ");

    System.out.println("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    task.status = Prompt.inputInt("> ");

    while (true) {
      String owner = Prompt.inputString("담당자?(취소: 빈 문자열) ");
      if (owner.length() == 0) {
        System.out.println("작업 등록을 취소합니다.");
        return; // 현재 메서드의 실행을 멈추고 리턴한다.
      } else if (memberHandler.exist(owner)) { // 
        task.owner = owner;
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    this.tasks[this.size++] = task; // 사용자가 입력한 걸 tasks에 받기
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[작업 목록]");


    for (int i = 0; i < this.size; i++) {
      String stateLabel = null;
      switch (tasks[i].status) {
        case 1:
          stateLabel = "진행중";
          break;
        case 2:
          stateLabel = "완료";
          break;
        default:
          stateLabel = "신규";
      }

      System.out.printf("%d, %s, %s, %s, %s\n",
          this.tasks[i].no, 
          this.tasks[i].content, 
          this.tasks[i].deadline, 
          stateLabel, 
          this.tasks[i].owner);
    }
  }

  public void detail() { 
    System.out.println("[작업 번호 등록]");
    int no = Prompt.inputInt("번호? ");

    Task task = null;

    for (int i = 0; i < this.size; i++) {
      if (tasks[i].no == no) {
        task = tasks[i];
        break;
      }
    }

    System.out.printf("내용? %s\n", task.content);
    System.out.printf("마감일? %s\n", task.deadline);

    String stateLabel = null;
    switch (task.status) { // taks.status의 숫자값에 따라
      case 1:
        stateLabel = "진행중";
        break;
      case 2:
        stateLabel = "완료";
        break;
      default:
        stateLabel = "신규";
    }
    System.out.printf("상태? %s\n", stateLabel);

    System.out.printf("담당자? %s\n", task.owner);
  }

  public void update(MemberHandler memberHandler) { 
    System.out.println("[작업 번호 변경]");
    int no = Prompt.inputInt("번호? ");

    Task task = null;

    for (int i = 0; i < this.size; i++) {
      if (tasks[i].no == no) {
        task = tasks[i];
        break;
      }
    }

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String operation = String.format("내용:(%s)? ", task.content);
    String content = Prompt.inputString(operation);

    operation = String.format("마감일:(%s)? ", task.deadline);
    Date deadline = Prompt.inputDate(operation);

    String stateLabel = null;
    switch (task.status) { // taks.status의 숫자값에 따라
      case 1:
        stateLabel = "진행중";
        break;
      case 2:
        stateLabel = "완료";
        break;
      default:
        stateLabel = "신규";
    }
    System.out.printf("상태:(%s)?\n", stateLabel);
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    int status = Prompt.inputInt("> ");

    String owner = null;
    while (true) {
      owner = Prompt.inputString(String.format(
          "담당자?(취소: 빈 문자열) ", task.owner));
      if (owner.length() == 0) {
        System.out.println("작업 변경을 취소합니다.");
        return; // 현재 메서드의 실행을 멈추고 리턴한다.
      } else if (memberHandler.exist(owner)) { // 
        task.owner = owner;
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    //    // operation = String.format("상태(%s)? ", task.status);
    //    int status = Prompt.inputInt(String.format("상태(%s)? ", task.status));
    //    // stateLebel은 list에서 선언되었기 때문에 app이랑 비슷한 루트인
    //    // update에서는 app에서 선언된 status를 사용하는 게 옳다


    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N)");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 변경이 취소되었습니다.");
      return;
    }

    task.content = content;
    task.deadline = deadline;
    task.status = status;
    task.owner = owner;

    System.out.println("작업을 변경하였습니다.");

  }

  public void delete() { 
    System.out.println("[작업 변경]");
    int no = Prompt.inputInt("번호? ");

    int taskindex = -1; // this.size와 숫자가 겹치면 헷갈리니까 아예 -1 선언

    for (int i = 0; i < this.size; i++) {
      if (this.tasks[i].no == no) {
        taskindex = i;
        break;
      }

      else if (taskindex == -1) {
        System.out.println("해당 번호의 작업이 없습니다.");
        return;
      }
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N)");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 삭제를 취소하였습니다.");
      return;
    }

    for (int i = taskindex +1; i < this.size; i++) {
      this.tasks[i - 1] = this.tasks[i];
    }
    this.tasks[--this.size] = null;


    System.out.println("작업을 삭제하였습니다.");

  }


}