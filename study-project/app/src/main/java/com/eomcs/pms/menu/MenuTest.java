package com.eomcs.pms.menu;

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

    MenuItem boardAddMenu = new MenuItem("등록");
    boardAddMenu.addActionListener(new BoardAddListener());
    // BoardAddListener라는 클래스는 ActionListener라는 클래스를 implements(준수, 수행, 이행한다)한다.

    MenuItem boardListMenu = new MenuItem("목록");
    boardListMenu.addActionListener(new BoardListListener());
    // ActionListener라는 규칙에 따라 BoardListListener를 호출한 것

    MenuItem boardDetailMenu = new MenuItem("상세조회");
    boardDetailMenu.addActionListener(new BoardDetailListener());

    MenuItem boardUpdateMenu = new MenuItem("변경");
    MenuItem boardDeleteMenu = new MenuItem("삭제");

    boardMenu.add(boardAddMenu);
    boardMenu.add(boardListMenu);
    boardMenu.add(boardDetailMenu);
    boardMenu.add(boardUpdateMenu);
    boardMenu.add(boardDeleteMenu);

    MenuItem memberAddMenu = new MenuItem("등록");
    MenuItem memberListMenu = new MenuItem("목록");
    MenuItem memberDetailMenu = new MenuItem("상세조회");
    MenuItem memberUpdateMenu = new MenuItem("변경");
    MenuItem memberDeleteMenu = new MenuItem("삭제");

    memberMenu.add(memberAddMenu);
    memberMenu.add(memberListMenu);
    memberMenu.add(memberDetailMenu);
    memberMenu.add(memberUpdateMenu);
    memberMenu.add(memberDeleteMenu);


    rootMenu.execute(); // 루트 메뉴 실행

  }

}
