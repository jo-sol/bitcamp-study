package com.eomcs.oop.ex00.util;

public class Calculator {

  public int result = 0;

  public void plus(int value) {
    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  }

  public void multiple(int value) {
    this.result *= value;
  }

  public void divide(int value) {
    this.result /= value;
  }
  // 인스턴스를 사용하지 않는 메서드라면 클래스 메서드로 놓아라
  static int abs(int value) { // 절대값은 반드시 양수일 수밖에 없는 것을 표현
    return value > 0 ? value : -value;
    // value가 0보다 크면 value를 리턴하고 그게 아니라면 -value를 리턴해라
    // this(인스턴스 변수)를 사용하지 않는다
    // static이 붙어 있으니까 인스턴스 메소드가 아닌 걸 확인할 수 있다
  }
}