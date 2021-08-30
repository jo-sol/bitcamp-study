// 예외 처리 문법을 적용하기 전 - 리턴 값을 이용한 오류 알림!
package com.eomcs.exception.ex1;

public class Exam0110 {
  public static void main(String[] args) {
    // 유효한 값을 지정하여 메서드를 호출할 때,
    int result = Calculator.compute("+", 100, 200);
    System.out.println(result); // 이건 무조건 맞다고 나오는 거라 맞지 않음
  }
}
