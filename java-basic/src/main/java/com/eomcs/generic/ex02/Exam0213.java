// 제네릭(Generic) 문법 정리 - 레퍼런스와 인스턴스 생성 
package com.eomcs.generic.ex02;

import java.util.ArrayList;

public class Exam0213 {

  static class A {}
  static class B1 extends A {}
  static class B2 extends A {}
  static class C extends B1 {}
  /*
   *   Object
   *     |
   *     A
   *    / \
   *   B1 B2
   *   |
   *   C
   */

  public static void main(String[] args) {

    ArrayList<A> list1; // 이 ArrayList는 A만!! 다루기로 했기 때문에 A만 보관할 수 있음!!!
    //***다형적 변수와 하단의 add 전까지 헷갈리면 안 됨!

    list1 = new ArrayList(); // 이렇게 사용하지 말고, 명확히 제네릭의 타입을 지정하라.
    // 제네릭을 안 적어도 가능하지만 되도록 적어라!
    //    list1 = new ArrayList<Object>(); // 컴파일 오류!
    list1 = new ArrayList<>(); // A 생략 가능
    list1 = new ArrayList<A>();
    //    list1 = new ArrayList<B1>(); // 컴파일 오류!
    //    list1 = new ArrayList<B2>(); // 컴파일 오류!
    //    list1 = new ArrayList<C>(); // 컴파일 오류!

    list1.add(new B2()); // add(new -) 자리에는 A의 수퍼 클래스를 제외한 무엇이 들어가도 상관없음!

    ArrayList<B2> list2;

    list2 = new ArrayList(); // 이렇게 사용하지 말고, 명확히 제네릭의 타입을 지정하라.
    //list2 = new ArrayList<Object>(); // 컴파일 오류!
    list2 = new ArrayList<>();
    //list2 = new ArrayList<A>(); // 컴파일 오류!
    //list2 = new ArrayList<B1>(); // 컴파일 오류!
    list2 = new ArrayList<B2>();
    //list2 = new ArrayList<C>(); // 컴파일 오류!
  }
}








