package com.eomcs.pms;

import java.sql.Date;

public class MemberHandler {

  static final int MAX_LENGTH = 5;
  //  int a; -> int 변수 1개 만드는 것(정수값)
  //  int[] arr = new int[100]; -> int 변수 100개 만드는 것
  // Member m; // -> 멤버 인스턴스의 주소를 저장할 레퍼런스를 1개 만드는 것
  // Member 인스턴스의 주소를 저장할 레퍼런스를 5개 생성한다.
  static Member[] members = new Member[MAX_LENGTH]; // -> 멤버 인스턴스의 주소를 저장할 레퍼런스를 5개 만드는 것
  static int size = 0;

  static void add() {
    System.out.println("[회원 등록]");

    // 새 회원 정보를 담을 변수를 준비한다.
    // 낱개의 변수가 아니라 Member에 정의된 대로 묶음 변수를 만든다.
    Member member = new Member();

    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo= Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    members[size++] = member;
  }

  static void list() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          members[i].no,
          members[i].name,
          members[i].email, 
          members[i].tel,
          members[i].registeredDate); // members의 주소를 찾아가서 해당 주소를 꺼낸다 = 레퍼런스
    }
  }
}