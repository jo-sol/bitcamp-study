package com.eomcs.lang.ex06;

// # 흐름 제어문 - for 중첩과 break
//
public class Exam0430 {
  public static void main(String[] args) {
    // for 문의 중첩
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) { // 1) i가 1일 때 j는 1에서 i까지 반복하기
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }
}


