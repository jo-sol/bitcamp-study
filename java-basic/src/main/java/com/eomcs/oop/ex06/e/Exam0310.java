// final 사용법: 상수 필드 만들기
package com.eomcs.oop.ex06.e;

class C {
  // 필드에 final 을 붙이면 상수 필드가 된다.
  // 생성자에서 초기화시켜야 한다.
  //
  final int v1; // **final은 한 번만 초기화 가능하다!!

  public C() { // **그래서 여기에서 또 초기화 하려고 해도 안 되고
    v1 = 100;
  }

  public void m1() { // ** 여기에서 또 초기화 하려고 해도 안 된다
    // 상수 필드는 값을 변경할 수 없다.
    //    v1 = 200; // 컴파일 오류!
  }
}


public final class Exam0310 {
  public static void main(String[] args) {
    C c = new C();
    System.out.println(c.v1);
  }
}
