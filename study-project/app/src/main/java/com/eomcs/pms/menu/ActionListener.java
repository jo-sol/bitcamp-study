package com.eomcs.pms.menu;

// 인터페이스의 존재 이유 - 인터페이스의 호출 규칙을 정의하기
// MenuItem이 리스너 객체를 실행할 때 호출할 메서드의 규칙을 정의한다.
public interface ActionListener {
  void doAction(); // public abstract라고 해도 되지만 당장은 적지 마라
  // 인터페이스의 메서드는 규칙을 표현하는 것이다.
  // 그래서 추상 메서드이다.
  // 그리고 모두의 접근을 허락하는 public이다.
}