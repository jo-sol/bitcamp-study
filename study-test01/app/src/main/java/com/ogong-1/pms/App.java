package com.ogong.pms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.ogong.menu.Menu;
import com.ogong.menu.MenuGroup;
import com.ogong.pms.domain.Admin;
import com.ogong.pms.domain.AskBoard;
import com.ogong.pms.domain.Cafe;
import com.ogong.pms.domain.CafeReservation;
import com.ogong.pms.domain.CafeReview;
import com.ogong.pms.domain.Calender;
import com.ogong.pms.domain.CeoMember;
import com.ogong.pms.domain.FreeBoard;
import com.ogong.pms.domain.Member;
import com.ogong.pms.domain.NoticeBoard;
import com.ogong.pms.domain.Study;
import com.ogong.pms.domain.ToDo;
import com.ogong.pms.handler.AdminHandler;
import com.ogong.pms.handler.AskBoardHandler;
import com.ogong.pms.handler.CafeHandler;
import com.ogong.pms.handler.CafeReservationHandler;
import com.ogong.pms.handler.CalenderHandler;
import com.ogong.pms.handler.CeoMemberHandler;
import com.ogong.pms.handler.FreeBoardHandler;
import com.ogong.pms.handler.LoginHandler;
import com.ogong.pms.handler.ManagerHandler;
import com.ogong.pms.handler.MemberHandler;
import com.ogong.pms.handler.NoticeBoardHandler;
import com.ogong.pms.handler.StudyHandler;
import com.ogong.pms.handler.ToDoHandler;
import com.ogong.util.Prompt;

public class App {
  List<Study> studyList = new LinkedList<>();
  List<Member> memberList = new LinkedList<>();
  List<NoticeBoard> noticeBoardList = new ArrayList<>();
  List<AskBoard> askBoardList = new ArrayList<>();
  List<Cafe> cafeList = new ArrayList<>();
  List<CafeReview> cafeReview = new ArrayList<>();
  List<CafeReservation> reserList = new ArrayList<>();
  List<ToDo> toDoList = new ArrayList<>();
  List<FreeBoard> freeBoardList = new ArrayList<>();
  List<Calender> calenderList = new ArrayList<>();
  List<Admin> adminList = new ArrayList<>();
  List<CeoMember> ceoMemberList = new ArrayList<>();

  AdminHandler adminHandler = new AdminHandler(adminList);
  MemberHandler memberHandler = new MemberHandler(memberList);
  StudyHandler studyHandler = new StudyHandler(studyList, memberHandler);
  LoginHandler loginHandler = new LoginHandler(memberList, memberHandler);
  ManagerHandler managerHandler = new ManagerHandler(noticeBoardList, adminHandler);
  NoticeBoardHandler noticeboardHandler = new NoticeBoardHandler(noticeBoardList, managerHandler);
  AskBoardHandler askBoardHandler = new AskBoardHandler(askBoardList);
  CafeHandler cafeHandler = new CafeHandler(cafeList, cafeReview, reserList);
  ToDoHandler toDoHandler = new ToDoHandler(toDoList);
  FreeBoardHandler freeBoardHandler = new FreeBoardHandler(memberList, freeBoardList, loginHandler);
  CalenderHandler calenderHandler = new CalenderHandler(calenderList);
  CafeReservationHandler cafeRservationHandler = new CafeReservationHandler(reserList);
  CeoMemberHandler ceoMemberHandler = new CeoMemberHandler(ceoMemberList);

  public static void main(String[] args) {
    App app = new App(); 
    app.welcomeservice();
  }

  void welcomeservice() {
    welcome().execute();
    service();
  }

  void service() {
    createMenu().execute();
    Prompt.close();
  }

  static Menu welcome() {
    ////////////////////////////////////////////////////////////////
    System.out.println("\u2728" + "오늘의 공부" + "\u2728");
    System.out.println("\u0020\u2229__\u2229\u0020\u00a0\u00a0\u00a0\u0020\u2229__\u2229\u0020");
    System.out.println("\u0028\u0020\u0027\u03c0\u0027\u0029\u00a0\u00a0\u00a0\u0028\u0027\u03c0\u0027\u00a0\u0029");
    System.out.println("\u0028\u0020\u2283\u2755\u2282\u0029\u00a0\u00a0\u00a0\u0028\u2283\u2755\u2282\u00a0\u0029");
    ////////////////////////////////////////////////////////////////
    MenuGroup welcomeMenuGroup = new MenuGroup("발표를 시작하겠습니다");
    welcomeMenuGroup.setPrevMenuTitle("시작");
    return welcomeMenuGroup;
  }

  Menu createMenu() {
    //---------------------------------------------------
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    mainMenuGroup.add(createAdminMenu());
    mainMenuGroup.add(createUserMenu());
    //    mainMenuGroup.add(createCeoMenu());

    //---------------------------------------------------
    return mainMenuGroup;
  }

  // 관리자
  Menu createAdminMenu() {
    MenuGroup adminMenuGroup = new MenuGroup("관리자");
    //-------------------------------------------------------------
    //로그인o, 로그아웃o
    adminMenuGroup.add(new Menu("로그인", Menu.ENABLE_ADMINLOGOUT) {
      @Override
      public void execute() {
        adminHandler.addAdminLoginPage();
      }});

    // 제일 하단으로 내리기
    adminMenuGroup.add(new Menu("로그아웃", Menu.ENABLE_ADMINLOGIN) {
      @Override
      public void execute() {
        adminHandler.logOut();
      }});

    //--------------------------------------------------------------- 
    // 관리자 프로필o
    MenuGroup adminpageMenu = new MenuGroup("마이 페이지", Menu.ENABLE_ADMINLOGIN); 
    adminMenuGroup.add(adminpageMenu);

    adminpageMenu.add(new Menu("관리자 정보") {
      @Override
      public void execute() {
        adminHandler.detail();
        adminHandler.selectAdminPage();
        return;
      }
    });

    //--------------------------------------------------------------- 

    // 관리자 회원 관리
    // 목록안에서 상세보기 기능x 삭제x (수정>보류)x
    MenuGroup adminUserMenu = new MenuGroup("회원 관리", Menu.ENABLE_ADMINLOGIN); 
    adminMenuGroup.add(adminUserMenu);

    adminUserMenu.add(new Menu("개인 회원 조회") {
      @Override
      public void execute() {
        memberHandler.list();
        selectUserModifyPage();
        return;
      }
    });

    // 목록안에서 상세보기x,삭제x,(수정>보류)x,가게승인x
    adminUserMenu.add(new Menu("사장 회원 조회") {
      @Override
      public void execute() {
        ceoMemberHandler.list();
        return;
      }
    });
    //--------------------------------------------------------------- 

    //--------------------------------------------------------------- 

    // 스터디 관리 
    // 회원이 등록한 스터디 삭제기능x, 목록x 상세보기x 
    MenuGroup adminStudyMenu = new MenuGroup("스터디 관리");
    adminMenuGroup.add(adminStudyMenu);
    //---------------------------------------------------------------

    // 장소 후기 관리 
    // 회원이 쓴 후기 삭제기능x, 목록x 상세보기x 
    MenuGroup adminReviewMenu = new MenuGroup("장소 후기 관리");
    adminMenuGroup.add(adminReviewMenu);
    //---------------------------------------------------------------

    // 관리자 고객센터 관리
    MenuGroup managerMenu = new MenuGroup("고객센터 관리");
    adminMenuGroup.add(managerMenu);

    // 관리자 고객센터 관리 - 공지사항
    MenuGroup adminNoticeMenu = new MenuGroup("공지사항", Menu.ENABLE_ADMINLOGIN); 
    managerMenu.add(adminNoticeMenu);

    adminNoticeMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        managerHandler.add();
        return;
      }});
    adminNoticeMenu.add(new Menu("수정") {
      @Override
      public void execute() {
        managerHandler.update(); 
      }});
    adminNoticeMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        managerHandler.delete(); 
      }});

    adminNoticeMenu.add(new Menu("공지사항 목록") {
      @Override
      public void execute() {
        noticeboardHandler.list(); 
      }});
    adminNoticeMenu.add(new Menu("공지사항 상세보기") {
      @Override
      public void execute() {
        noticeboardHandler.detail(); 
      }});
    //---------------------------------------------------


    // 관리자 고객센터 - 문의사항
    MenuGroup askMenu = new MenuGroup("문의사항", Menu.ENABLE_ADMINLOGIN);
    adminMenuGroup.add(askMenu);

    // 댓글 기능x, 회원이 쓴 문의글 삭제기능x  
    askMenu.add(new Menu("문의사항 목록") {
      @Override
      public void execute() {
        askBoardHandler.list(); 
      }});
    askMenu.add(new Menu("문의사항 상세보기") {
      @Override
      public void execute() {
        askBoardHandler.detail(); 
      }});
    askMenu.add(new Menu("문의사항 삭제") {
      @Override
      public void execute() {
        askBoardHandler.delete(); 
      }});

    return adminMenuGroup;
  }

  // 회원
  Menu createUserMenu() {
    MenuGroup userMenuGroup = new MenuGroup("개인"); 
    userMenuGroup.add(new Menu("회원가입", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        memberHandler.add();
      }});

    //-------------------------------------------------------------
    //로그인o, SNS로그인o, ID/PW 찾기o, 회원가입o, 로그아웃o
    MenuGroup loginMenu = new MenuGroup("로그인", Menu.ENABLE_LOGOUT); 
    userMenuGroup.add(loginMenu);
    loginMenu.add(new Menu("로그인", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        loginHandler.addLoginPage();
      }});
    loginMenu.add(new Menu("NAVER로 시작하기", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        loginHandler.naverLogin();
      }});
    loginMenu.add(new Menu("KAKAO로 시작하기", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        loginHandler.kakaoLogin();
      }});
    loginMenu.add(new Menu("GOOGLE로 시작하기", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        loginHandler.googleLogin();
      }});
    loginMenu.add(new Menu("ID/PW 찾기", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        memberHandler.selectFindEmailPw();
      }});
    loginMenu.add(new Menu("회원 가입", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        memberHandler.add();
      }});
    userMenuGroup.add(new Menu("로그아웃", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        loginHandler.logOut();
      }});
    //--------------------------------------------------------------- 

    //-------------------------------------------------------------- 
    MenuGroup mypageMenu = new MenuGroup("마이 페이지", Menu.ENABLE_LOGIN); 
    userMenuGroup.add(mypageMenu);
    // 리턴위치 지정(탈퇴시 메인으로 돌아가기)
    // 마이페이지 - 개인정보 - (수정o 탈퇴o 문의내역x) 
    // 마이페이지 - 예약내역 - (내역보기x 취소하기x 후기보기x) 
    mypageMenu.add(new Menu("개인 정보") {
      @Override
      public void execute() {
        memberHandler.detail();
        selectMyPage();
        return;
      }});
    mypageMenu.add(new Menu("예약 내역") {
      @Override
      public void execute() {
        cafeHandler.listReservation();
      }});
    //--------------------------------------------------------------

    //-------------------------------------------------------------- 
    MenuGroup allStudyMenu = new MenuGroup("모든 스터디"); 
    userMenuGroup.add(allStudyMenu);
    // 등록o 목록보기o 상세보기△(참여x) 검색x 필터x(switch문 활용) 

    allStudyMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        studyHandler.add();
      }});

    // 나중구현: 목록 안에서 상세 보기를 해야함 
    allStudyMenu.add(new Menu("목록 보기") {
      @Override
      public void execute() {
        studyHandler.list();
      }});
    // 나중구현: 상세 보기 안에서 참여 신청 해야함
    allStudyMenu.add(new Menu("상세 보기") {
      @Override
      public void execute() {
        studyHandler.detail();
      }});
    //--------------------------------------------------------------

    //--------------------------------------------------------------
    MenuGroup myStudyMenu = new MenuGroup("내 스터디"); 
    userMenuGroup.add(myStudyMenu);
    // 캘린더, 투두, 자유 게시판, 구성원, 화상채팅

    // 내 스터디 하위 메뉴 1 - 구성원
    // 내 스터디 하위 메뉴 2 - 캘린더
    MenuGroup calenderMenu = new MenuGroup("캘린더");
    myStudyMenu.add(calenderMenu);

    calenderMenu.add(new Menu("일정 등록") {
      @Override
      public void execute() {
        calenderHandler.add(); 
      }});
    calenderMenu.add(new Menu("일정 목록") {
      @Override
      public void execute() {
        calenderHandler.list(); 
      }});
    calenderMenu.add(new Menu("일정 상세보기") {
      @Override
      public void execute() {
        calenderHandler.detail(); 
      }});
    calenderMenu.add(new Menu("일정 변경") {
      @Override
      public void execute() {
        calenderHandler.update(); 
      }});
    calenderMenu.add(new Menu("일정 삭제") {
      @Override
      public void execute() {
        calenderHandler.delete(); 
      }});

    // 내 스터디 하위 메뉴 3 - 투두리스트
    MenuGroup todoMenu = new MenuGroup("To-Do List");
    myStudyMenu.add(todoMenu);

    todoMenu.add(new Menu("To-Do List 등록") {
      @Override
      public void execute() {
        toDoHandler.add(); 
      }});
    todoMenu.add(new Menu("To-Do List 목록") {
      @Override
      public void execute() {
        toDoHandler.list(); 
      }});
    todoMenu.add(new Menu("To-Do List 상세보기") {
      @Override
      public void execute() {
        toDoHandler.detail(); 
      }});
    todoMenu.add(new Menu("To-Do List 변경") {
      @Override
      public void execute() {
        toDoHandler.update(); 
      }});
    todoMenu.add(new Menu("To-Do List 삭제") {
      @Override
      public void execute() {
        toDoHandler.delete(); 
      }});

    // 내 스터디 하위 메뉴 4 - 자유게시판
    // 댓글 기능x
    MenuGroup freeBoardMenu = new MenuGroup("자유게시판");
    myStudyMenu.add(freeBoardMenu);

    freeBoardMenu.add(new Menu("자유게시판 게시글 작성") {
      @Override
      public void execute() {
        freeBoardHandler.add(); 
      }});
    freeBoardMenu.add(new Menu("자유게시판 게시글 목록") {
      @Override
      public void execute() {
        freeBoardHandler.list(); 
      }});
    freeBoardMenu.add(new Menu("자유게시판 게시글 상세보기") {
      @Override
      public void execute() {
        freeBoardHandler.detail(); 
      }});
    freeBoardMenu.add(new Menu("자유게시판 게시글 수정") {
      @Override
      public void execute() {
        freeBoardHandler.update(); 
      }});
    freeBoardMenu.add(new Menu("자유게시판 게시글 삭제") {
      @Override
      public void execute() {
        freeBoardHandler.delete(); 
      }});

    // 내 스터디 하위 메뉴 5 - 화상미팅
    // 내 스터디 하위 메뉴 6 - 탈퇴





    //-------------------------------------------------------------- 
    // 리뷰, 예약(by Song)
    MenuGroup cafeMenu = new MenuGroup("스터디 장소"); 
    userMenuGroup.add(cafeMenu);

    cafeMenu.add(new Menu("장소 등록/기업 권한") {
      @Override
      public void execute() {
        cafeHandler.add();
      }});
    cafeMenu.add(new Menu("장소 목록") {
      @Override
      public void execute() {
        cafeHandler.list();
      }});
    cafeMenu.add(new Menu("장소 검색") {
      @Override
      public void execute() {
        cafeHandler.find();
      }});
    cafeMenu.add(new Menu("장소 상세보기") {
      @Override
      public void execute() {
        cafeHandler.detail();
      }});
    cafeMenu.add(new Menu("장소 정보 변경하기") {
      @Override
      public void execute() {
        cafeHandler.update();
      }});
    cafeMenu.add(new Menu("장소 삭제하기") {
      @Override
      public void execute() {
        cafeHandler.delete();
      }});
    cafeMenu.add(new Menu("장소 예약 내역 보기") {
      @Override
      public void execute() {
        cafeHandler.listReservation();
      }});
    //-------------------------------------------------------------- 



    MenuGroup csMenu = new MenuGroup("고객 센터"); 
    userMenuGroup.add(csMenu);
    //  
    //    //---------------------------------------------------
    //    //---------------------------------------------------
    //    MenuGroup askMenu = new MenuGroup("문의사항/회원");
    //    mainMenuGroup.add(askMenu);
    //    askMenu.add(new Menu("문의사항 등록") {
    //      @Override
    //      public void execute() {
    //        askBoardHandler.add(); 
    //      }});
    //    askMenu.add(new Menu("문의사항 목록") {
    //      @Override
    //      public void execute() {
    //        askBoardHandler.list(); 
    //      }});
    //    askMenu.add(new Menu("문의사항 상세보기") {
    //      @Override
    //      public void execute() {
    //        askBoardHandler.detail(); 
    //      }});
    //    askMenu.add(new Menu("문의사항 변경") {
    //      @Override
    //      public void execute() {
    //        askBoardHandler.update(); 
    //      }});
    //    askMenu.add(new Menu("문의사항 삭제") {
    //      @Override
    //      public void execute() {
    //        askBoardHandler.delete(); 
    //      }});
    return userMenuGroup;
  }

  // 기업
  Menu createCeoMenu() {
    return null;
  }

  private void selectMyPage() {

    if (LoginHandler.getLoginUser() != null) {
      System.out.println();
      System.out.println("1. 수정하기");
      System.out.println("2. 문의 내역");
      System.out.println("3. 탈퇴하기");
      System.out.println("4. 뒤로가기");

      int selectNo = Prompt.inputInt("선택> ");
      switch (selectNo) {
        case 1: memberHandler.update(); break;
        case 2: askBoardHandler.list(); break;
        case 3: memberHandler.delete(); return;
        default : return;
      }
    }
    return;
  }

  // 들어가면 오류 뜸 권한이 없음 --------------
  private void selectUserModifyPage() {
    System.out.println();
    System.out.println("1. 상세보기");
    System.out.println("2. 수정하기");
    System.out.println("3. 삭제하기");
    System.out.println("4. 뒤로가기");

    int selectAdminNo = Prompt.inputInt("선택> ");
    switch (selectAdminNo) {
      case 1: memberHandler.detail(); break;
      case 2: memberHandler.update(); break;
      case 3: memberHandler.delete(); break;
      default : return;
    }
  }
  // ---------------------------------------------















  //    //---------------------------------------------------
  //    MenuGroup studyMenu = new MenuGroup("모든 스터디");
  //    mainMenuGroup.add(studyMenu);
  //    studyMenu.add(new Menu("내 스터디 변경하기/마이페이지 권한") {
  //      @Override
  //      public void execute() {
  //        newStudyHandler.update(); 
  //      }});
  //    studyMenu.add(new Menu("내 스터디 삭제하기//마이페이지 권한") {
  //      @Override
  //      public void execute() {
  //        newStudyHandler.delete(); 
  //      }});

}

