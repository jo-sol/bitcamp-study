package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Member;

public class AuthDisplayLoginUserHandler {

  // 메서드가 하나밖에 없으니까 메서드 안에 선언 - 뇌피셜
  //  static Member loginUser;
  //  public static Member getLoginUser() {
  //    return loginUser;
  //  }

  public void displayLoginUser() {

    Member loginUser = AuthLoginHandler.getLoginUser();

    System.out.println("[내 정보]");

    if (loginUser == null) {
      System.out.println("로그인 하지 않았습니다.");
      return;
    }

    System.out.printf("이름: %s\n", loginUser.getName());
    System.out.printf("이메일: %s\n", loginUser.getEmail());
    System.out.printf("사진: %s\n", loginUser.getPhoto());
    System.out.printf("전화: %s\n", loginUser.getTel());
    System.out.printf("등록일: %s\n", loginUser.getRegisteredDate());
  }
}






