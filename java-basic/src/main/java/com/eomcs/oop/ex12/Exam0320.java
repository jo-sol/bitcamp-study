// 아규먼트에 람다(lambda) 활용 II - 파라미터와 리턴 값이 있는 람다 만들기
package com.eomcs.oop.ex12;

public class Exam0320 {

  static interface Calculator {
    int compute(int a, int b);
  }

  static void test(Calculator c) {
    System.out.println(c.compute(100, 200));
  }

  public static void main(String[] args) {
    // 람다 
    // 파라미터와 리턴 값이 있는 메서드 구현하기
    test((a, b) -> a + b);

  }
}

// 순서 1번
//  public static void main(String[] args) {
//    class MyCalculator implements Calculator {
//      @Override
//      public int compute(int a, int b) {
//        return a + b;
//      }
//    };
//    test(new MyCalculator());
//  }

// 순서 2번
//  public static void main(String[] args) {
//    Calculator c = new Calculator() {
//      @Override
//      public int compute(int a, int b) {
//        return a + b;
//      }
//    };
//    test(c);
//  }

// 순서 3번
//  public static void main(String[] args) {
//    test(new Calculator() {
//      @Override
//      public int compute(int a, int b) {
//        return a + b;
//      }
//    });
//  }

// 순서 4번
//  public static void main(String[] args) {
//    test((int a, int b) -> {return a + b;});
//  }
// int가 겹치니까 삭제 -> return도 지워 줘야 함

// 순서 5번
//  public static void main(String[] args) {
//  // 람다 
//  // 파라미터와 리턴 값이 있는 메서드 구현하기
//      test((a, b) -> a + b);
//
//  }




