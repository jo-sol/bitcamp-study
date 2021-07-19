package com.eomcs.pms1.handler;

import java.sql.Date;
import com.eomcs.pms1.domain.Member;
import com.eomcs.util.Prompt02;

public class MemberHandler {

  static final int MAX_LENGTH = 5;

  // Member 인스턴스의 주소를 저장할 레퍼런스를 3개 생성한다.
  static Member[] members = new Member[MAX_LENGTH];
  static int size = 0;

  // 다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public static void add() {
    System.out.println("[회원 등록]");

    // 새 회원 정보를 담을 변수를 준비한다.
    // 낱 개의 변수가 아니라 Member에 정의된 대로 묶음 변수를 만든다.
    Member member = new Member();

    member.no = Prompt02.inputInt("번호? ");
    member.name = Prompt02.inputString("이름? ");
    member.email = Prompt02.inputString("이메일? ");
    member.password = Prompt02.inputString("암호? ");
    member.photo = Prompt02.inputString("사진? ");
    member.tel = Prompt02.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    members[size++] = member;
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public static void list() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          members[i].no, 
          members[i].name, 
          members[i].email, 
          members[i].tel, 
          members[i].registeredDate);
    }

  }
}
