package com.eomcs.pms0;

import java.util.Scanner;

public class No1008 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    //문제: 실제 정답과 출력값의 절대오차 또는 상대오차가 10-9 이하이면 정답이다.
    double A = in.nextInt(); //'오차 범위'가 10-9 이하여야 하기 때문에 출력 할 때도 출력 할 소수점 자리를 9개 이상 출력
    double B = in.nextInt(); //그러므로 float이 아닌 double을 사용한다.

    System.out.println(A/B);
  }

}
