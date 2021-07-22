package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberHandler {

  static final int MAX_LENGTH = 5;

  // Member 인스턴스의 주소를 저장할 레퍼런스를 3개 생성한다.
  Member[] members = new Member[MAX_LENGTH];
  int size = 0;

  // 다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void add() {
    System.out.println("[회원 등록]");

    // 새 회원 정보를 담을 변수를 준비한다.
    // 낱 개의 변수가 아니라 Member에 정의된 대로 묶음 변수를 만든다.
    Member member = new Member();

    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    this.members[this.size++] = member;
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          this.members[i].no, 
          this.members[i].name, 
          this.members[i].email, 
          this.members[i].tel, 
          this.members[i].registeredDate);
    }
  }

  public boolean exist(String name) {
    for (int i = 0; i < this.size; i++) {
      if (this.members[i].name.equals(name)) {
        return true;
      }
    }
    return false;
  }

  public void detail() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Member member = null;

    for (int i = 0; i < this.size; i++) {
      if (members[i].no == no) {
        member = members[i];
        break;
      }
    }

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름? %s\n", member.name);
    System.out.printf("이메일? %s\n", member.email);
    System.out.printf("암호? %s\n", member.password);
    System.out.printf("사진? %s\n", member.photo);
    System.out.printf("전화? %s\n", member.tel);
    System.out.printf("등록일? %s\n", member.registeredDate);
  }

  public void update() {
    System.out.println("[회원 변경]");
    int no = Prompt.inputInt("번호? ");

    Member member = null;

    for (int i = 0; i < this.size; i++) {
      if (members[i].no == no) {
        member = members[i];
        break;
      }
    }

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String person = String.format("이름:(%s)? ", member.name);
    String name = Prompt.inputString(person);

    person = String.format("이메일:(%s)? ", member.email);
    String email = Prompt.inputString(person);

    person = String.format("암호:(%s)? ", member.password);
    String password = Prompt.inputString(person);

    person = String.format("사진:(%s)? ", member.photo);
    String photo = Prompt.inputString(person);

    person = String.format("전화:(%s)? ", member.tel);
    String tel = Prompt.inputString(person);

    person = String.format("등록일:(%s)? ", member.registeredDate);
    Date registeredDate = Prompt.inputDate(person);

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.name = name;
    member.email = email;
    member.password = password;
    member.photo = photo;
    member.tel = tel;
    member.registeredDate = registeredDate;
    System.out.println("회원을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    int no = Prompt.inputInt("번호? ");

    int memberIndex = -1;

    for (int i = 0; i < this.size; i++) {
      if (members[i].no == no) {
        memberIndex = i;
        break;
      }
    }

    if (memberIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    for (int i = memberIndex +1; i <this.size; i++) {
      members[i - 1] = members[i];
    }
    members[--this.size] = null;

    System.out.println("회원을 삭제하였습니다.");
  }

}





