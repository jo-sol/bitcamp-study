package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberHandler {

  List memberList;

  public MemberHandler(List memberList) {
    this.memberList = memberList;
  }

  public void add() {
    System.out.println("[회원 등록]");

    Member member = new Member();

    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    memberList.add(member);
  }

  public void list() {
    System.out.println("[회원 목록]");

    Object[] list = memberList.toArray();

    for (Object obj : list) {
      Member member = (Member) obj; // 원래 obj 타입이니까 member로 형변환 시켜 주기
      System.out.printf("%d, %s, %s, %s, %s\n", 
          member.no, 
          member.name, 
          member.email, 
          member.tel, 
          member.registeredDate);
    }
  }

  public void detail() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", member.name);
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("사진: %s\n", member.photo);
    System.out.printf("전화: %s\n", member.tel);
    System.out.printf("등록일: %s\n", member.registeredDate);
  }

  public void update() {
    System.out.println("[회원 변경]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String name = Prompt.inputString("이름(" + member.name  + ")? ");
    String email = Prompt.inputString("이메일(" + member.email + ")? ");
    String password = Prompt.inputString("암호? ");
    String photo = Prompt.inputString("사진(" + member.photo + ")? ");
    String tel = Prompt.inputString("전화(" + member.tel + ")? ");

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

    System.out.println("회원을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    memberList.remove(member);

    System.out.println("회원을 삭제하였습니다.");
  }

  private Member findByNo(int no) {
    Object[] arr = memberList.toArray();
    for (Object obj : arr) {
      Member member = (Member) obj; // 반복문을 돌 때마다 하는 게 아니라 여기에서 한 번 쓰는 것
      if (member.no == no) {
        return member; // member에서만 하는 거니까 -> 변수명(int no 등)이 같을 거라는 보장을 못하기 때문!
      }
    }
    return null;
  }

  public boolean exist(String name) {
    Object[] arr = memberList.toArray();
    for (Object obj : arr) {
      Member member = (Member) obj; // 반복문을 돌 때마다 하는 게 아니라 여기에서 한 번 쓰는 것
      if (member.name.equals(name)) {
        return true; // 같으면 true
      }
    }
    return false; // 아니면 false
  }

  public String promptMember(String label) { // 리팩토링 기법 중 무브 메서드(메서드 이동)기법
    while (true) {
      String owner = Prompt.inputString(label);
      if (this.exist(owner)) {
        return owner;
      } else if (owner.length() == 0) {
        return null;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  public String promptMembers(String label) { // 리팩토링 기법 중 무브 메서드(메서드 이동)기법
    String members = "";
    while (true) {
      String member = Prompt.inputString(label);
      if (this.exist(member)) {
        if (members.length() > 0) {
          members += ",";
        }
        members += member;
        continue;
      } else if (member.length() == 0) {
        break;
      } 
      System.out.println("등록된 회원이 아닙니다.");
    }
    return members;
  }
}







