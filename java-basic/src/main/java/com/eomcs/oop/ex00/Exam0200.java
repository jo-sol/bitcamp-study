package com.eomcs.oop.ex00;

public class Exam0200 {
  public static void main(String[] args) { // main 메소드
    // 인스턴스 변수 테스트

    // 인스턴스 변수
    // => new 명령을 실행해서 만든다.
    // => 힙(Heap) 영역에 생성된다.
    // => 가비지가 된 후 가비지 컬렉터에 의해 제거된다.
    Test t1 = new Test(); // 1) 인스턴스 생성 후

    test1(t1); // 2) t1 주소를 넘긴다

    System.out.println(t1.b); // t1에 적힌 주소 찾아가서 b를 실행함 -> 3000 실행됨

    Test t2 = new Test();

    test1(t2);

    System.out.println(t2.b);
  }

  static void test1(Test p) {
    p.b = 3000;
  }

}
