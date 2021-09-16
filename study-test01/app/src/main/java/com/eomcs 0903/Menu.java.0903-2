package com.eomcs.menu; // 접근 범위 변경

public abstract class Menu {
  // lang >> ex05 >> Exam0480, Exam0481 참고

  //  public static final int ENABLE_ALL = 0; // 상수 관리하기
  //  public static final int ENABLE_LOGOUT = 1; // 로그아웃 되었을 때만
  //  public static final int ENABLE_LOGIN = 2; // 로그인 되었을 때만

  public static final int ACCESS_LOGOUT = 0x01;     // 0001
  public static final int ACCESS_GENERAL = 0x02;    // 0010
  public static final int ACCESS_ADMIN = 0x04;      // 0100

  String title;

  //  int enableState; // (어느 상태에서 활성화 시킬 건지?)

  int accessScope; // 접근 범위

  public Menu(String title) { // 밑에 있는 데이터를 가져와서 사용하도록 변경
    this(title, ACCESS_LOGOUT | ACCESS_GENERAL | ACCESS_ADMIN); // 모든 사람 접근 가능
    // 메뉴 제목만 주면 모두 접근 가능 >> 기본 default
  }

  // 생성자를 손대면 기존 데이터도 날아감
  // 그래서 새로 추가
  public Menu(String title, int accessScope) {
    this.title = title; // 기존 생성자가 됨
    this.accessScope = accessScope;
  }

  //  public Menu(String title, int enableState) {
  //    this(title); // 메뉴 이름 설정은 기존 생성자를 통해 처리한다.
  //    this.enableState = enableState;
  //  }

  public abstract void execute();
}
