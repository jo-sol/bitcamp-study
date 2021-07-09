package com.eomcs.lang.ex05;

//# 비트 연산자 & 를 이용하여 % 연산 구현하기 응용 I
//
public class Exam0352 {
  public static void main(String[] args) {
    // % 연산자를 이용하여 짝수/홀수 알아내기
    System.out.println(57 % 2 == 0 ? "짝수" : "홀수");

    // & 연산자를 이용하여 짝수/홀수 알아내기
    System.out.println((57 & 0x1) == 0 ? "짝수" : "홀수");
    // 맨 끝의 1비트를 가지고 와서 57을 나누었을 때 그 값이 짝수냐 홀수냐 판별

  }
}

