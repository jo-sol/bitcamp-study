package com.ogong.menu;

public abstract class Menu {

  public static final int ENABLE_ALL = 0; // 상수 관리하기
  public static final int ENABLE_HOSTLOGIN = 1; // 관리자 로그인 되었을 때만
  public static final int ENABLE_LOGOUT = 2; // 로그아웃 되었을 때만
  public static final int ENABLE_LOGIN = 3; // 회원 로그인 되었을 때만

  String title;

  int enableState;

  public Menu(String title) {
    this.title = title;
  }

  public Menu(String title, int enableState) {
    this(title);
    this.enableState = enableState;
  }

  public abstract void execute();
}
