package com.eomcs.pms0831.menu;

public abstract class Menu {

  public static final int ENABLE_ALL = 0; // 상수 관리하기
  public static final int ENABLE_LOGOUT = 1; // 로그아웃 되었을 때만
  public static final int ENABLE_LOGIN = 2; // 로그인 되었을 때만

  String title;

  int enableState; // (어느 상태에서 활성화 시킬 건지?)
  // 만약 아무것도 생성하지 않았다면 기본적으로 값이 0
  public Menu(String title) {
    this.title = title;
  }

  // 생성자를 손대면 기존 데이터도 날아감
  // 그래서 새로 추가
  public Menu(String title, int enableState) {
    this(title); // 메뉴 이름 설정은 기존 생성자를 통해 처리한다.
    this.enableState = enableState;
  }

  public abstract void execute();
}
