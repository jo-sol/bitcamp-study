package com.eomcs.pms0802.menu;

import com.eomcs.util.Prompt;

// 역할
// - 다른 메뉴를 포함하는 컨테이너 역할을 수행한다.

public class MenuGroup extends Menu {

  Menu[] childs = new Menu[100];
  int size; // 몇 개 저장한 건지 -> 기본적으로 0;임
  boolean disablePrevMenu; // 이전 메뉴를 비활성화 시킬 건지?
  String prevMenuTitle = "이전 메뉴"; // 만약 무언가 특별한 걸 하지 않는다면 (dafault 값) 이전 메뉴
  // 기본값은 "이전 메뉴"지만 setter를 통해 "종료"로 바꾸고 싶어서 App에서 setter 넣음

  // 생성자를 정의하지 않으면 컴파일러가 기본 생성자를 자동으로 추가해 준다.
  // 문제는 컴파일러가 추가한 기본 생성자는 수퍼 클래스의 기본 생성자를 호출하기 때문에
  // 컴파일 오류가 발생한다.
  // Menu 클래스에는 기본 생성자가 없다.
  // 따라서 개발자가 직접 생성자를 정의해야 한다.
  public MenuGroup(String title) {
    super(title);
  }

  public MenuGroup(String title, boolean disablePrevMenu) { // 이전 메뉴 비활성화 할 거냐? 선택해라
    super(title);
    this.disablePrevMenu = disablePrevMenu;    
  }

  public void setPrevMenuTitle(String prevMenuTitle) {
    this.prevMenuTitle = prevMenuTitle;
  }

  // MenuGroup이 포함하는 하위 Menu를 다룰 수 있도록 메서드를 정의한다.
  public void add(Menu child) {
    if (this.size == this.childs.length) { // 만약 size가 childs의 길이랑 같다면 
      return; // 하위 메뉴를 저장할 배열이 꽉 찼다면 더 이상 저장해서는 안 된다.
    }
    this.childs[size++] = child;
  }

  // 배열에 들어있는 Menu 객체를 찾아 제거한다.
  public Menu remove(Menu child) { // 어떤 메뉴를 (어떻게) 지울 건지? // public Menu remove(Menu child) -> remove를 호출한 곳에서 판단을 내리라고 하는 것
    int index = indexOf(child);
    if (index == -1) { // 못 찾았으면 삭제하면 안 됨
      return null;
    }
    for (int i = index + 1; i < this.size; i++) {
      this.childs[i - 1] = this.childs[i];
    }
    childs[--this.size] = null; // 찾았으면 당겨서 마지막 빈칸은 null로 세팅
    return child;
  }

  // 배열에 들어있는 Menu 객체의 인덱스를 알아낸다.
  public int indexOf(Menu child) { 
    for (int i = 0; i < this.size; i++) {
      if (this.childs[i] == child) {
        return i;
      }
    }
    return -1;
  }

  // 배열에 들어있는 Menu 객체를 찾는다.
  public Menu getMenu(String title) {
    for (int i = 0; i < this.size; i++) {
      if (this.childs[i].title.equals(title)) {
        return this.childs[i]; // i 번째에 있는 것을 찾아라
      }
    }
    // 완성하시오! ==이 아닌 equals(문자열 객체) 사용
    return null;
  }

  @Override // 컴파일러에게 오버라이딩을 제대로 하는지 조사해 달라고 요구한다.
  public void execute() {
    while (true) {
      System.out.printf("\n[%s]\n", this.title);
      for (int i = 0; i < this.size; i++) {
        System.out.printf("%d. %s\n", i + 1, this.childs[i].title); // 0번이 아니라 1번부터 출력하려고 +1로 줌***
      }

      if (!disablePrevMenu) { // 이전 메뉴가 비활성하지 않을 때만 출력해라
        System.out.printf("0. %s\n", this.prevMenuTitle);
      }

      int menuNo = Prompt.inputInt("선택> ");
      // 메뉴 번호 유효성 검사
      if (menuNo == 0 && !disablePrevMenu) { // 만약 0이고, 비활성화되지 않은 상태면 return 해서 나가라
        return; // 여기에서는 break도 가능
      }

      if (menuNo < 0 || menuNo > this.size) {
        System.out.println("무효한 메뉴 번호입니다.");
        continue;
      }

      this.childs[menuNo -1].execute(); // index보다 하나 큼***
    }
  }

}
