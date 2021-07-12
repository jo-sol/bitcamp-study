package com.eomcs.lang.ex06;

// # 흐름 제어문 - for 중첩과 break
//
public class Exam0432 {
  public static void main(String[] args) {
    // break 라벨명;
    loop1: {
      for (int i = 1; i <= 10; i++) {
        for (int j = 1; j <= i; j++) {
          System.out.print(j + " ");
          if (j == 5)
            break loop1; // 라벨로 지정한 문장을 나간다.
        }
        System.out.println();
      }
      System.out.println("-------------------------"); // 1) break 후 이 문장을 출력하지 않고 나가기를 원해서
    } // 2) loop1라벨에 중괄호를 걸어 줌  -> 여러 문장을 한 가지의 라벨에 걸고 싶을 때 {}를 걸고, 해당 문장을 나가고 싶다면 break 주기
  }
}


