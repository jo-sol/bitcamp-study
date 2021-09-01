package com.ogong.pms.handler;

import java.util.List;
import com.ogong.pms.domain.Member;
import com.ogong.util.Prompt;

public class HostHandler {

  List<Member> memberList;
  MemberHandler memberHandler;

  static Member loginMaster;
  public static Member getLoginMaster() {
    return loginMaster;
  }

  public HostHandler(List<Member> memberList, MemberHandler memberHandler) {
    this.memberList = memberList;
    this.memberHandler = memberHandler;
  }

  public void masterLoginPage() {
    String inputEmail = Prompt.inputString("이메일: ");
    String inputPassword = "";
    Member member = memberHandler.findByInputEmail(inputEmail);
    if (member == null) {
      System.out.println("등록된 회원이 아닙니다.");
    }
    while (member != null) {
      inputPassword = Prompt.inputString("비밀번호: ");
      if (member.getPerPassword().equals(inputPassword)) {
        member.setPerEmail(inputEmail);
        member.setPerPassword(inputPassword);
        System.out.println("로그인되었습니다.");
        loginMaster = member;
        return;
      }
      System.out.println("비밀번호를 다시 입력하세요.");
      continue;
    } 
  }

  //  public void masterLoginPage() {
  //    System.out.println("[관리자]");
  //
  //    String email = Prompt.inputString("이메일? ");
  //    String password = Prompt.inputString("암호? ");
  //
  //    Member master = memberHandler.findByInputMasterEmail(email, password);
  //
  //    if (master == null) {
  //      System.out.println("이메일과 암호가 일치하는 회원을 찾을 수 없습니다.");
  //    } else { // 만약에 찾았다면
  //      System.out.printf("%s님 환영합니다!\n", master.getMasterNickname());
  //      loginMaster = master;
  //    }
  //  }

  //  private Member findByEmailPassword(String email, String password) {
  //    for (Member master : memberList) {
  //      if (loginMaster.getMasterEmail().equalsIgnoreCase(email) && 
  //          loginMaster.getMasterPassword().equals(password)) { // 암호는 대소문자 구문 필요
  //        return loginMaster; // 같으면 member 리턴하라
  //      }
  //    }
  //    return null; // 그 밖에는 null을 리턴하라
  //  }
}
