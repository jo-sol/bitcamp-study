package com.eomcs.pms0802.menu;

// MenuItem과 MenuGroup을 같은 타입으로 묶기 위해 정의한 클래스
// 이 클래스 자체는 직접 인스턴스를 만들어 사용하기 위함이 아니라
// 상속해 주는 용도이기 때문에 추상 클래스로 정의한다.
public abstract class Menu { // (그래서 얘를 추상 클래스로 만들어 줌) -> 자체에 추상 메서드 포함되었음과 인스턴스도 없기 때문

  String title; // 반드시 메뉴를 설정할 때는 title이 있어야 함

  // 메뉴 이름 없이 인스턴스를 생성할 수 없도록
  // 기본 생성자를 정의하지 않는다.
  // 대신 인스턴스를 만들 때 반드시 메뉴 이름을 입력하도록 강요하기 위해
  // 다음과 같이 String을 파라미터로 받는 생성자를 정의한다.
  public Menu(String title) {
    this.title = title;
  }

  // 서브 클래스에서 해야 할 일을 정의한다.
  // 단, 서브 클래스에서 반드시 재정의 할 메서드이기 때문에
  // 구체적으로 구현하지 않는다.
  public abstract void execute(); // 추상 메서드 생성(추상 클래스만 생성 가능)
}
