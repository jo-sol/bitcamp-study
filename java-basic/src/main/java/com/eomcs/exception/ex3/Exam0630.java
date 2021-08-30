// 예외 처리 후 마무리 작업 - try-with-resources // Autocloseable 규칙
package com.eomcs.exception.ex3;

import java.io.FileReader;
import java.util.Scanner;

public class Exam0630 {

  // static void m() throws Exception {
  //    int[] arr = new int[10];
  //    class MyList implements Iterable {
  //      @Override
  //      public Iterator iterator() {
  //        return null;
  //      }
  //    }
  //    MyList list = new MyList();
  //    for (Object obj : list) { // list의 자리에는 배열이나 iterable 구현체 인스턴스만 올 수 있음!!
  //      // 이 클래스가 인터페이스 규칙에 따라 만들었기 때문
  //    }
  // }
  // 위처럼 아래도 마찬가지로 해당 구현체만 올 수 있다는 것을 설명해 줌

  static void m() throws Exception {


    // 자원해제시키는 코드를 매번 finally 블록을 만들어 작성하기가 귀찮다!
    // => try-with-resources 라는 문법을 사용하면
    //   ** 굳이 finally 블록에서 close()를 직접 호출할 필요가 없다.
    //   자동으로 처리한다.
    // => 단 java.lang.AutoCloseable 구현체에 대해서만 가능하다!
    // => 문법
    // try (java.lang.AutoCloseable 구현체) {...}
    // => AutoCloseable에는 close() 메서드 하나만 있다.
    // => 이 자리에는 AutoCloseable 구현체이거나 상속해 준 클래스만 올 수 있다.
    // => 자동으로 끝낼 대상만 선언해 줘라

    try (Scanner keyScan = new Scanner(System.in); // OK!
        // 변수 선언 후 초기화 문법까지 된 것만 올 수 있음!
        //
        // Scanner keyScan; // No
        // 단순한 변수 선언은 안 됨! 인스턴스 객체 선언까지 해 줘야 함!
        //
        // Scanner keyScan;
        // try (keyScan = new Scanner(System.in);) // No!
        // 바깥에 변수 선언해 주고 안에 인스턴스만 사용해도 안 됨!

        // FileReader 클래스도 java.lang.AutoCloseable 구현체이다.
        FileReader in = new FileReader("Hello.java"); // OK!

        // 반드시 AutoCloseable 구현체이어야 한다.
        //        String s = "Hello"; // 컴파일 오류!

        // 변수 선언만 올 수 있다.
        //        if (true) {} // 컴파일 오류!

        ) {
      System.out.print("입력> ");
      int value = keyScan.nextInt();
      System.out.println(value * value);
    }
  }

  public static void main(String[] args) throws Exception {
    m();
  }

}
