package com.ogong.pms.handler;

import java.util.List;
import com.ogong.menu.Menu;
import com.ogong.menu.MenuGroup;
import com.ogong.pms.domain.Member;
import com.ogong.pms.domain.Study;
import com.ogong.util.Prompt;

public class MyStudyHandler {

  List<Member> memberList;
  List<Study> studyList;
  MemberHandler memberHandler;

  public MyStudyHandler(
      List<Member> memberList, List<Study> studyList,
      MemberHandler memberHandler) {
    this.memberList = memberList;
    this.studyList = studyList;
    this.memberHandler = memberHandler;

  }

  public void list() {
    if (LoginHandler.getLoginUser() == null) {
      System.out.println("로그인 하세요");
      return;
    }
    for (Study study : studyList) {
      System.out.printf("%d , %s, %s, %s\n",
          study.getStudyNo(),
          study.getStudyTitle(),
          study.getSubject(),
          study.getIntroduction());
    }
    System.out.println();
    System.out.println("1. 상세보기");
    System.out.println("2. 뒤로가기");
    int selectNo = Prompt.inputInt("선택> ");
    switch (selectNo) {
      case 1 : detail(); break;
      case 2 : return;
      default : return;
    }

  }

  private void update() {
    // TODO Auto-generated method stub

  }

  private void detail() {
    System.out.println("[내 스터디 상세보기]");

    String members = Prompt.inputString("제목? ");

    Study study = findByStudyMembers(members);

    if (study == null) {
      System.out.println("해당 제목의 스터디가 없습니다.");
      return;
    }

    System.out.printf("스터디명: %s\n", study.getStudyTitle());
    System.out.printf("조장: %s\n", study.getOwner().getPerNickname());
    System.out.printf("분야: %s\n", study.getSubject());
    System.out.printf("지역: %s\n", study.getArea());
    System.out.printf("인원수: %d\n", study.getNumberOfPeple());
    System.out.printf("대면: %s\n", study.getFace());
    System.out.printf("소개글: %s\n", study.getIntroduction());

    myCategory(study).execute();

  }

  private Menu myCategory(Study study) {
    MenuGroup cateMenu = new MenuGroup(study.getStudyTitle());
    MenuGroup updateMenu = new MenuGroup("수정하기");
    cateMenu.add(updateMenu);
    MenuGroup calenderMenu = new MenuGroup("캘린더");
    cateMenu.add(calenderMenu);
    MenuGroup todoMenu = new MenuGroup("투두");
    cateMenu.add(todoMenu);
    MenuGroup freeMenu = new MenuGroup("자유게시판");
    cateMenu.add(freeMenu);
    MenuGroup membersMenu = new MenuGroup("구성원");
    cateMenu.add(membersMenu);
    MenuGroup getOut = new MenuGroup("탈퇴하기");
    cateMenu.add(getOut);

    return cateMenu;
  }

  private Study findByTitle(String inputTitle) {
    for (Study study : studyList) {
      if (study.getStudyTitle().equalsIgnoreCase(inputTitle)) {
        return study;
      }
    }
    return null;
  }

  // >> 내가 가입한 목록 나열
  // >> 선택해서 들어가기
  // >> 
  private Study findByStudyMembers (String members) {
    for (Study study : studyList) {
      if (study.getMembers().equals(members)) {
        return study;
      }
    }
    return null;
  }

}
