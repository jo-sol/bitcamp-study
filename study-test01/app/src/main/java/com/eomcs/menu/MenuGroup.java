package com.eomcs.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.eomcs.pms.handler.AuthLoginHandler;
import com.eomcs.util.Prompt;

// 역할
// - 다른 메뉴를 포함하는 컨테이너 역할을 수행한다.
// 
public class MenuGroup extends Menu {

  // 메뉴의 bread crumb 목록 보관
  // 모든 메뉴가 공유할 객체이기 때문에 스태틱 멤버로 선언한다.
  static Stack<Menu> breadCrumb = new Stack<>();

  ArrayList<Menu> childs = new ArrayList<>(); // 굳이 List라고 할 필요 없고 그냥 ArrayList 해 줘도 됨
  boolean disablePrevMenu;
  String prevMenuTitle = "이전 메뉴";

  // 이전으로 이동시키는 메뉴를 표현하기 위해 만든 클래스
  // 의미 없는 클래스 (더미 클래스)
  private static class PrevMenu extends Menu {
    public PrevMenu() {
      super(""); // 생성자 필요 >> 빈문자열(null)을 줌 >> 여기에서만 쓸 것
    }
    @Override
    public void execute() {
      // 아무 의미 없고 그냥 PrevMenu 만들기 위해 생성
    }
  }
  static PrevMenu prevMenu = new PrevMenu();

  // 생성자를 정의하지 않으면 컴파일러가 기본 생성자를 자동으로 추가해 준다.
  // 문제는 컴파일러가 추가한 기본 생성자는 수퍼 클래스의 기본 생성자를 호출하기 때문에
  // 컴파일 오류가 발생한다. 
  // Menu 클래스에는 기본 생성자가 없다. 
  // 따라서 개발자가 직접 생성자를 정의해야 한다.
  public MenuGroup(String title) {
    super(title);
  }

  public MenuGroup(String title, int accessScope) {
    super(title, accessScope);
  }

  public MenuGroup(String title, boolean disablePrevMenu) { // 모두 접근 가능
    super(title);
    this.disablePrevMenu = disablePrevMenu;
  }

  public MenuGroup(String title, boolean disablePrevMenu, int accessScope) { // 제한 주면 그 제한자만 접근 가능
    super(title, accessScope);
    this.disablePrevMenu = disablePrevMenu;
  }


  public void setPrevMenuTitle(String prevMenuTitle) {
    this.prevMenuTitle = prevMenuTitle;
  }

  // MenuGroup이 포함하는 하위 Menu를 다룰 수 있도록 메서드를 정의한다.
  public void add(Menu child) {
    childs.add(child); 
  }

  // 배열에 들어 있는 Menu 객체를 찾아 제거한다.
  public Menu remove(Menu child) {
    if(childs.remove(child))
      return child;
    return null;
  }

  @Override // 컴파일러에게 오버라이딩을 제대로 하는지 조사해 달라고 요구한다.
  public void execute() {
    // 현재 실행하는 메뉴를 스택에 보관한다.
    breadCrumb.push(this);


    while (true) {
      // Array인지 Linked인지 쓸지 구체적으로 하지 말고
      // List로 사용하는 게 낫다
      printBreadCrumpMenuTitle(); // 1
      List<Menu> menuList = getMenuList(); // 2 (1이랑 순서 바꿔도 상관없음)
      printMenuList(menuList); // 3

      try {
        Menu menu = selectMenu(menuList);
        if (menu == null) {
          System.out.println("무효한 메뉴 번호입니다.");
          continue;
        }
        if (menu instanceof PrevMenu) {
          breadCrumb.pop();
          return; // 이전 메뉴로 나가라
        }

        menu.execute();

      } catch (Exception e) {
        // try {} 블록 안에 있는 코드를 실행하다가 예외가 발생하면
        // 다음 문장을 실행한 후 시스템을 멈추지 않고 실행을 계속한다.
        System.out.println("----------------------------------------------------------");
        System.out.printf("오류 발생: %s\n", e.getClass().getName());
        e.printStackTrace(); // 개발하는 동안 왜 뜬 건지 알 수 있게 해야 함
        System.out.println("----------------------------------------------------------");
      }
    }
  }

  private String getBreadCrumb() {
    String path = "";

    for (int i = 0; i < breadCrumb.size(); i++) {
      if (path.length() > 0) {
        path += " / ";
      } // breadCrumb에 반복문 돌려서 title 생성
      Menu menu = breadCrumb.get(i); 
      path += menu.title;
    }

    return path;
  }

  // [DOM 트리 구조]
  // 조건에 따라 메뉴 리스트 미리 확보하기

  // 출력될 메뉴 목록 준비
  // 왜?
  // - 메뉴 출력 속도를 빠르게 하기 위함.
  // - 메뉴를 출력할 때 출력할 메뉴와 출력하지 말아야 할 메뉴를 구분하는
  //   시간을 줄이기 위해.
  // - 매번 재구축해야 하기 때문에 while 문 안에 선언
  //
  private List<Menu> getMenuList() {
    // 조건에 부합하는 것만 menuList에 담기
    // 리턴되는 타입에서는 List로 선언하는 게 좋고,
    // 메서드 안에서는 상관없다.

    // 사용자의 접근 범위를 가지고 accessScope의 조건을 따져서 간결하게 출력
    ArrayList<Menu> menuList = new ArrayList<>();
    for (Menu menu : childs) {
      // 사용자가 해당 메뉴에 접근할 수 있는지 검사한다.
      // ex) 메뉴의 접근 범위:   0100 = 관리자만 접근 가능
      //     사용자의 접근 수준: 0110 = 관리자 및 일반 메뉴 접근 가능
      //     둘을 & 시키면 결과값은 0100이 나오기 때문에 접근 가능

      // **메뉴에 권한이 있는지 없는지 설정하는 부분
      if ((menu.accessScope & AuthLoginHandler.getUserAccessLevel()) > 0) {
        menuList.add(menu);
      } 
    }
    return menuList;
  }

  // 이렇게 한 줄짜리도 리펙토링 후 메서드로 따로 빼 주면
  // 주석을 달아 줄 필요가 없음 >> 주석이 존재한다는 것 자체가 리펙토링 대상
  private void printBreadCrumpMenuTitle() {
    System.out.printf("\n[%s]\n", getBreadCrumb());
  }

  private void printMenuList(List<Menu> menuList) {
    int i = 1; // i는 0부터 시작해서
    for (Menu menu : menuList) { // 위에서 준비한 menuList를 여기에 주면 됨
      System.out.printf("%d. %-20s\n", i++, menu.title); // 메뉴 리스트의 타이틀을 출력할 때마다 +1
      // 증가된 i값을 출력하라 i++
    }

    if (!disablePrevMenu) { // 이전 메뉴로 가는 걸 비활성화 시킨 게 아니라면
      System.out.printf("0. %s\n", this.prevMenuTitle); // 아~ 이전 메뉴로 가라는 거구나~
    }
  }

  // 녹음 11시부터
  private Menu selectMenu(List<Menu> menuList) {
    int menuNo = Prompt.inputInt("선택> ");

    if (menuNo < 0 || menuNo > menuList.size()) {
      return null;
    }

    if (menuNo == 0 && !disablePrevMenu) {
      // 현재 메뉴에서 나갈 때 스택에서 제거한다.
      // 1) 프리뷰 메뉴를 리턴하든
      return prevMenu; // 호출한 쪽에 '이전 메뉴' 선택을 알리기 위해 이렇게 함
    }

    // 배열에서 바로 가지고 오지 않고 메뉴 리스트에서 가지고 옴
    // 2) 사용자가 선택한 번호를 리턴하든 상관없음
    return menuList.get(menuNo - 1);
  }

}







