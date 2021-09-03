package com.eomcs.pms.handler; // Auth는 공통 분모가 없기 때문에 추상 클래스로 만들지 않았다

import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class AuthLoginHandler implements Command {

  List<Member> memberList;

  static Member loginUser;
  public static Member getLoginUser() {
    return loginUser;
  }

  public AuthLoginHandler(List<Member> memberList) {
    this.memberList = memberList;
  }

  public void execute() {
    System.out.println("[로그인]");

    String email = Prompt.inputString("이메일? ");
    String password = Prompt.inputString("암호? ");

    Member member = findByEmailPassword(email, password);

    if (member == null) {
      System.out.println("이메일과 암호가 일치하는 회원을 찾을 수 없습니다.");
    } else { // 만약에 찾았다면
      System.out.printf("%s님 환영합니다!\n", member.getName());
      loginUser = member;
    }
  }
  // 해당 클래스에서만 사용할 것이기 때문에 
  // 해당 클래스의 자리에 적용해 주었다
  private Member findByEmailPassword(String email, String password) {
    for (Member member : memberList) {
      if (member.getEmail().equalsIgnoreCase(email) && 
          member.getPassword().equals(password)) { // 암호는 대소문자 구문 필요
        return member; // 같으면 member 리턴하라
      }
    }
    return null; // 그 밖에는 null을 리턴하라
  }
}






