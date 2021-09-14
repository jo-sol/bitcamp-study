package com.ogong.pms.handler;

import java.util.List;
import com.ogong.pms.domain.Admin;
import com.ogong.util.Prompt;

public abstract class AbstractAdminHandler implements Command {

  List<Admin> adminList;

  static Admin loginAdmin;
  public static Admin getLoginAdmin() {
    return loginAdmin;
  }

  public AbstractAdminHandler(List<Admin> adminList) {
    this.adminList = adminList;
  }

  protected void goAdminProUpdate() {
    System.out.println();
    System.out.println("1. 수정하기");
    System.out.println("0. 뒤로가기");

    int selectAdminNo = Prompt.inputInt("선택> ");
    switch (selectAdminNo) {
      case 1: update(); break;
      default : return;
    }
  }

  public void update() {
    System.out.println();
    System.out.println("▶ 프로필 수정하기");
    System.out.println();

    Admin adminmodify = AuthAdminLoginHandler.getLoginAdmin();

    String adminModifyNickName = Prompt.inputString(
        "닉네임(" + adminmodify.getMasterNickname()  + ") : ");
    String adminModifyEmail = Prompt.inputString(
        "이메일(" + adminmodify.getMasterEmail() + ") : ");
    String adminModifyPassword = Prompt.inputString(
        "비밀번호(" + adminmodify.getMasterPassword() + ") : ");

    String input = Prompt.inputString("정말 변경하시겠습니까? (네 / 아니오) ");
    if (input.equalsIgnoreCase("아니오") || input.length() == 0) {
      System.out.println("취소되었습니다.");
      return;
    }

    adminmodify.setMasterNickname(adminModifyNickName);
    adminmodify.setMasterEmail(adminModifyEmail);
    adminmodify.setMasterPassword(adminModifyPassword);

    System.out.printf("%s님의 정보가 변경되었습니다.", adminmodify.getMasterNickname());
    System.out.println();
  }



}
