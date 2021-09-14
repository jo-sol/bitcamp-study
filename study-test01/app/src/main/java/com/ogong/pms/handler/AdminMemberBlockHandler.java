package com.ogong.pms.handler;

import java.util.List;
import com.ogong.pms.domain.Admin;
import com.ogong.pms.domain.Member;
import com.ogong.util.Prompt;

public class AdminMemberBlockHandler implements Command {

  List<Member> memberList;
  PromptPerMember promptPerMember; 
  Admin admin;

  public AdminMemberBlockHandler(List<Member> memberList, PromptPerMember promptPerMember) {
    this.memberList = memberList;
    this.promptPerMember = promptPerMember;
  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("▶ 블랙리스트 등록");
    System.out.println();

    for (Member member : memberList) {
      if (member.getPerNickname() != AuthAdminLoginHandler.getLoginAdmin().getMasterNickname()) {

        int selectMember = Prompt.inputInt(" 블랙리스트에 추가할 회원 번호 : ");

        Member blockMember = promptPerMember.getMemberByPerNo(selectMember);

        String input = Prompt.inputString(" 블랙리스트 회원으로 등록하시겠습니까? (네 / 아니오) ");
        if (!input.equalsIgnoreCase("네")) {
          System.out.println(" 등록이 취소되었습니다.");
          return;
        }
        admin.getBlockMember().add(blockMember);
      }
    }
    blockUserList();
  }

  public void blockUserList() {
    System.out.println();
    System.out.println("▶ 블랙리스트 목록");
    System.out.println();

    int no = 1;

    for (Member member : memberList) {
      if (member.getPerNickname() != AuthAdminLoginHandler.getLoginAdmin().getMasterNickname()) {

        List<Member> blockUserMembers = admin.getBlockMember();

        if (admin.getBlockMember().isEmpty()) {
          System.out.println(" 블랙리스트 회원이 없습니다.");
        }

        for (Member blockUser : blockUserMembers) {
          System.out.printf(" (%d)\n 닉네임 : %s\n 이메일 : %s\n 가입일 : %s\n",
              no++,
              member.getPerNickname(), 
              member.getPerEmail(),
              member.getPerRegisteredDate());
          System.out.println();
        }
      }
    }
    blockUserDelete();
  }

  public void blockUserDelete() {
    System.out.println();
    System.out.println("▶ 회원 차단");

    for (Member member : memberList) {
      if (member.getPerNickname() != AuthAdminLoginHandler.getLoginAdmin().getMasterNickname()) {

        //        List<Member> blockUserMembers = admin.getBlockMember();

        int selectMember = Prompt.inputInt(" 차단할 회원 번호 : ");

        if (admin.getBlockMember().contains(selectMember)) {
          String input = Prompt.inputString(" 회원을 차단하시겠습니까? (네 / 아니오) ");
          if (!input.equalsIgnoreCase("네")) {
            System.out.println(" 차단이 취소되었습니다.");
            return;
          }

          admin.getBlockMember().remove(selectMember);
          memberList.remove(selectMember);
          AuthPerMemberLoginHandler.loginUser = null;
        }
        return;
      }

    }
  }


  //번호를 통해 멤버를 찾아서 리턴한다.
  //  public Member getMemberBlockNo(int inputBlockNo) {
  //    for (Member member : memberList) {
  //      if (inputBlockNo == member.getPerNo()) {
  //        return member;
  //      }
  //    }
  //    return null;
  //  }



}





