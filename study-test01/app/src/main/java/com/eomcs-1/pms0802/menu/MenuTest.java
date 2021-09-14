package com.eomcs.pms0802.menu;

public class MenuTest {

  public static void main(String[] args) {
    //    Menu m1 = new Menu("okok"); // Menu 자체가 추상 클래스이기 때문에 인스턴스를 만들 수 없음
    MenuGroup rootMenu = new MenuGroup("메인", true); // 이전 메뉴로 가는 걸 활성화 or 비활성화 시킬 건지 선택권 줌 (true || false)
    MenuGroup boardMenu = new MenuGroup("게시판");
    MenuGroup memberMenu = new MenuGroup("회원");
    MenuGroup projectMenu = new MenuGroup("프로젝트");
    MenuGroup taskMenu = new MenuGroup("작업");

    rootMenu.add(boardMenu);
    rootMenu.add(memberMenu);
    rootMenu.add(projectMenu);
    rootMenu.add(taskMenu);

    MenuItem2 boardAddMenu = new MenuItem2("등록");
    boardAddMenu.addActionListener(new BoardAddListener());
    // BoardAddListener라는 클래스는 ActionListener라는 클래스를 implements(준수, 수행, 이행한다)한다.

    MenuItem2 boardListMenu = new MenuItem2("목록");
    boardListMenu.addActionListener(new BoardListListener());
    // ActionListener라는 규칙에 따라 BoardListListener를 호출한 것

    MenuItem2 boardDetailMenu = new MenuItem2("상세조회");
    boardDetailMenu.addActionListener(new BoardDetailListener());

    MenuItem2 boardUpdateMenu = new MenuItem2("변경");
    MenuItem2 boardDeleteMenu = new MenuItem2("삭제");

    boardMenu.add(boardAddMenu);
    boardMenu.add(boardListMenu);
    boardMenu.add(boardDetailMenu);
    boardMenu.add(boardUpdateMenu);
    boardMenu.add(boardDeleteMenu);

    MenuItem2 memberAddMenu = new MenuItem2("등록");
    MenuItem2 memberListMenu = new MenuItem2("목록");
    MenuItem2 memberDetailMenu = new MenuItem2("상세조회");
    MenuItem2 memberUpdateMenu = new MenuItem2("변경");
    MenuItem2 memberDeleteMenu = new MenuItem2("삭제");

    memberMenu.add(memberAddMenu);
    memberMenu.add(memberListMenu);
    memberMenu.add(memberDetailMenu);
    memberMenu.add(memberUpdateMenu);
    memberMenu.add(memberDeleteMenu);


    rootMenu.execute(); // 루트 메뉴 실행

  }

}
