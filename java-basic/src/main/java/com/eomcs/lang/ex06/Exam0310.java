package com.eomcs.lang.ex06;

//# 흐름 제어문 - 반복문 while
//
public class Exam0310 {

  public static void main(String[] args) {

    int count = 0;

    // 문법1:
    //      while (조건) 문장;
    // => 조건이 참인 동안 문장을 계속 실행한다.
    while (count < 5) System.out.println(count++);  // 현재 카운트 값을 count++ 자리에 놓고 count값 증가시키고 놓았던 값을 출력
    // 0부터 4까지 딱 5 번 반복하는 것
    System.out.println("---------------------------");


    // 문법2:
    //      while (조건)
    //          문장;
    // => 조건이 참인 동안 문장을 계속 실행한다.
    count = 0;
    while (count < 5) {
      System.out.println(count++);
    }

    System.out.println("---------------------------");

    // 문법3:
    //      while (조건) {}
    // => 여러 개의 문장을 반복 실행하려면 블록으로 묶어라!
    count = 0; // => 한 문장일 경우는 중활호{}를 넣지 않지만 여러 문장일 경우에는 넣는 게 좋다
    while (count < 5) {
      System.out.println(count);
      count++;
    }
  }
}






