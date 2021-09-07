package com.eomcs.pms.handler;

import com.eomcs.menu.Menu;

public class AuthLogoutHandler implements Command {

  public void execute() {
    System.out.println("[로그아웃]");

    // 로그아웃 하면 accessLevel 날리기
    AuthLoginHandler.loginUser = null;
    AuthLoginHandler.userAccessLevel = Menu.ACCESS_LOGOUT;
    System.out.println("로그아웃 하였습니다.");
  }

}






