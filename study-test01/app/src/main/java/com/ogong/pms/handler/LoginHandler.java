package com.ogong.pms.handler;

import java.util.List;
import com.ogong.pms.domain.Member;
import com.ogong.util.Prompt;

public class LoginHandler {

  List<Member> memberList;
  MemberHandler memberHandler;

  static Member loginUser;

  public static Member getLoginUser() {
    return loginUser;
  }

  static Member loginMaster;
  public static Member getLoginMaster() {
    return loginMaster;
  }

  public LoginHandler(List<Member> memberList, MemberHandler memberHandler) {
    this.memberList = memberList;
    this.memberHandler = memberHandler;
  }

  public void addLoginPage() {
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
        loginUser = member;
        return;
      }
      System.out.println("비밀번호를 다시 입력하세요.");
      continue;
    } 
  }

  public void masterLoginPage() {
    String inputMasterEmail = Prompt.inputString("이메일: ");
    String inputMasterPassword = "";
    Member member = findByInputMasterEmail(inputMasterEmail);
    if (member == null) {
      System.out.println("등록된 회원이 아닙니다.");
    }
    while (member != null) {
      inputMasterPassword = Prompt.inputString("비밀번호: ");
      if (member.getMasterPassword().equals(inputMasterPassword)) {
        member.setMasterEmail(inputMasterEmail);
        member.setMasterPassword(inputMasterPassword);
        System.out.println("로그인되었습니다.");
        loginMaster = member;
        return;
      }
      System.out.println("비밀번호를 다시 입력하세요.");
      continue;
    } 
  }

  public void logOut() {
    loginUser = null;
    System.out.println("로그아웃 되었습니다.");
  }

  public void naverLogin() {
    System.out.println("NAVER 로그인");
  }
  public void kakaoLogin() {
    System.out.println("KAKAO 로그인");
  }
  public void googleLogin() {
    System.out.println("GOOGLE 로그인");
  }

  private Member findByInputMasterEmail(String masterEmail) {
    for (Member member : memberList) {
      if (member.getMasterEmail().equals(masterEmail)) {
        return member;
      }
    }
    return null;
  }
}


