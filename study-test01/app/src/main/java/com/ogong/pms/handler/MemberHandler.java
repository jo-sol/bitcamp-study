package com.ogong.pms.handler;

import java.sql.Date;
import java.util.List;
import com.ogong.pms.domain.Member;
import com.ogong.util.Prompt;

public class MemberHandler {

  List<Member> memberList;

  public MemberHandler(List<Member> memberList) {
    this.memberList = memberList;

    Member masterUser = new Member();
    masterUser.setMasterno(0);
    masterUser.setMasterNickname("관리자");
    masterUser.setMasterEmail("ogong@ogong.com");
    masterUser.setMasterPassword("1234");
    masterUser.setMasterRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(masterUser);
    //
    //    Member User = new Member();
    //    User.setPerNo(1);
    //    User.setPerNickname("회원");
    //    User.setPerEmail("naver");
    //    User.setPerPassword("1111");
    //    User.setPerPhoto("naver.jpg");
    //    User.setPerRegisteredDate(new Date(System.currentTimeMillis()));
    //
    //    memberList.add(User);
  }

  public void add() {
    System.out.println("[개인 회원가입]");

    Member member = new Member();

    member.setPerNickname(Prompt.inputString("닉네임? "));
    member.setPerEmail(Prompt.inputString("이메일? "));
    member.setPerPassword(Prompt.inputString("비밀번호? "));
    while (true) {
      String pw =  Prompt.inputString("비밀번호 확인? ");
      if (!pw.equals(member.getPerPassword())) {
        System.out.println("비밀번호가 일치하지 않습니다.");
        continue;
      } else {
        System.out.println("확인되었습니다.");
      }
      break;
    }
    member.setPerPhoto(Prompt.inputString("사진? "));
    memberList.add(member);
  }


  public void list() {
    System.out.println("[개인회원 가입확인]");


    for (Member member : memberList) {
      System.out.printf("닉네임 : %s, 이메일 : %s, 가입일 : %s\n",
          member.getPerNickname(), 
          member.getPerEmail(),
          member.getPerRegisteredDate());
    }
  }

  public void detail() {
    System.out.println("[개인회원 상세보기]");
    String inputEmail = Prompt.inputString("이메일? ");

    Member member = findByEmail(inputEmail);

    if (member == null) {
      System.out.println("해당 이메일의 회원이 없습니다.");
      return;
    }

    System.out.printf("닉네임: %s\n", member.getPerNickname());
    System.out.printf("이메일: %s\n", member.getPerEmail());
    System.out.printf("사진: %s\n", member.getPerPhoto());
    System.out.printf("등록일: %s\n", member.getPerRegisteredDate());
  }

  public void update() {
    System.out.println("[개인회원 수정하기]");
    String inputEmail = Prompt.inputString("이메일? ");

    Member member = findByEmail(inputEmail);

    if (member == null) {
      System.out.println("해당 이메일의 회원이 없습니다.");
      return;
    }

    String perNickName = Prompt.inputString("닉네임(" + member.getPerNickname()  + ")? ");
    String perEmail = Prompt.inputString("이메일(" + member.getPerEmail() + ")? ");
    String perPassword = Prompt.inputString("암호(" + member.getPerPassword() + ")? ");
    String perPhoto = Prompt.inputString("사진(" + member.getPerPhoto() + ")? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("개인회원 변경을 취소하였습니다.");
      return;
    }

    member.setPerNickname(perNickName);
    member.setPerEmail(perEmail);
    member.setPerPassword(perPassword);
    member.setPerPhoto(perPhoto);

    System.out.println("개인회원 정보를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[개인회원 탈퇴]");
    String inputEmail = Prompt.inputString("이메일? ");

    Member member = findByEmail(inputEmail);

    if (member == null) {
      System.out.println("해당 이메일의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 탈퇴하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 탈퇴를 취소하였습니다.");
      return;
    }

    memberList.remove(member);

    System.out.println("회원이 탈퇴되었습니다.");
  }

  public void findEmail() {
    System.out.println("이메일 찾기");
    while (true) {
      String inputNick =  Prompt.inputString("닉네임: ");
      Member member = findByNick(inputNick);
      if (member == null) {
        // 엄강사님찬스
        System.out.println("해당 닉네임이 존재하지 않습니다.");
        continue;
      } else {
        System.out.print("이메일 >> ");
        System.out.println(member.getPerEmail());
      }
      break;
    }
    String input = Prompt.inputString("비밀번호 찾기로 넘어가시겠습니까?(y/N)");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("찾기를 종료합니다.");
      return;
    } 
    findPw();
  }

  public void findPw() {
    System.out.println("비밀번호 찾기");
    while (true) {
      String inputEmail =  Prompt.inputString("이메일: ");
      Member member = findByEmail(inputEmail);
      if (member == null) {
        // 엄강사님찬스
        System.out.println("해당 이메일이 존재하지 않습니다.");
        continue;
      } else {
        System.out.print("임시 비밀번호>> ");
        System.out.println(member.getPerPassword().hashCode());
        String hashPW = String.valueOf(member.getPerPassword().hashCode());
        member.setPerPassword(hashPW);
      }
      break;
    }
  }

  public Member findByInputEmail(String perEmail) {
    for (Member member : memberList) {
      if (member.getPerEmail().equals(perEmail)) {
        return member;
      }
    }
    return null;
  }

  private Member findByNick(String inputNick) {
    for (Member member : memberList) {
      if (inputNick.equals(member.getPerNickname())) {
        return member;
      }
    }
    return null;
  }

  private Member findByEmail(String inputEmail) {
    for (Member member : memberList) {
      if (inputEmail.equals(member.getPerEmail())) {
        return member;
      }
    }
    return null;
  }

  //-------------prompt는 login에서 사용(은채)------------------------------------------------
  public boolean exist(String perEmail) {
    Member[] list = memberList.toArray(new Member[0]);
    for (Member member : list) {
      if (member.getPerEmail().equals(perEmail)) {
        return true;
      }
    }
    return false;
  }

  public String promptMemberEmail(String email) {
    while (true) {
      String emailBox = Prompt.inputString(email);
      if (this.exist(emailBox)) {
        return emailBox;
      } else if (emailBox.length() == 0) {
        return null;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  public String promptMemberPassword(String passWord) {
    while (true) {
      String passwordBox = Prompt.inputString(passWord);
      if (this.exist(passwordBox)) {
        return passwordBox;
      } else if (passwordBox.length() == 0) {
        return null;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }


}







