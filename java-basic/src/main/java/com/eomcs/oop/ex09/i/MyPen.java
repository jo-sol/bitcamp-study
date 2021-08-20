// 인터페이스 구현 - 인터페이스에 선언된 모든 메서드를 정의해야 한다.
package com.eomcs.oop.ex09.i;

public class MyPen implements Pen {

  boolean use;

  // ***
  // 꼭 완성된 메서드를 재정의하는 것만 오버라이딩이라 하는 게 아니다
  // 추상 메서드를 완성하는 것도 오버라이딩
  @Override
  public void on() {
    this.use = true;
  }

  @Override
  public void off() {
    this.use = false;
  }

  @Override
  public void write(String text) {
    if (!this.use)
      return;

    System.out.println("===> " + text);
  }

}











