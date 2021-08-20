// inner class : 바깥 클래스의 인스턴스 멤버 접근하기
package com.eomcs.oop.ex11.c;

class B2 { // *** B2 객체가 없다면

  // 인스턴스 멤버
  int v2;
  void m2() {
    System.out.println("B2.v2 = " + this.v2);
  }

  class X { // *** X 객체를 만들 수 없다 // 그러나 static이 붙으면 상관없다 -> 바깥 클래스의 인스턴스를 사용하기 위해 non-static
    // 바깥 객체의 주소를 저장할 빌트인 필드
    //    B2 this$0;

    // inner 객체를 생성할 때 바깥 객체의 주소를 받는 생성자
    //    public X(B2 p) {
    //      this.this$0 = p;
    //    }
    void test() {
      // 바깥 객체의 인스턴스 멤버에 접근하려면,
      // inner 객체에 보관된 바깥 객체 주소를 사용해야 한다.
      // 즉 컴파일러가 내부적으로 자동 생성한 바깥 객체 주소를 담는 필드를 사용해야 한다.
      // 문제는 컴파일러가 자동 생성한 필드 이름이 뭔지 모른다.
      // 그래서 자바는 inner 객체에 보관된 바깥 객체를 가리키기 위해
      // 다음의 문법을 제공하고 있다.
      // =>   바깥클래스명.this
      // 위의 문법을 이용하여 바깥 객체에 접근할 수 있다.
      // 
      // 즉 inner 객체를 만들 때 사용한 바깥 객체에 접근하고 싶다면
      // =>  B2.this 문법을 사용하라!
      // 
      System.out.println(B2.this.v2); // --> this$0.v2
      // (현재 인스턴스 변수 중 현재 인스턴스의 바깥 객체로 찾아가서 그 주소가 저장된 v2를 찾아서 사용한다)
      B2.this.m2();
    }
  }
}

public class Exam0220 {

  public static void main(String[] args) {
    B2 outer = new B2();
    outer.v2 = 100;
    outer.m2();


    B2 outer2 = new B2();
    outer2.v2 = 200;
    outer2.m2();

    // inner 객체 생성
    // B2.this는 자기를 만든 것을 가리킨다
    B2.X inner = outer.new X(); // --> new X(outer)
    B2.X inner2 = outer2.new X(); // --> new X(outer2)

    inner.test();
    inner2.test();

    // 바깥 클래스가 존재하지 않는 상태에서 그 inner 클래스를 생성할 수 없다.
    B2 outer3 = null;
    B2.X inner3 = outer3.new X(); // 불가능한 것
  }

}
