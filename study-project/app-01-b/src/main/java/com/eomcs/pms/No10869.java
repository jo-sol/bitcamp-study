package com.eomcs.pms;

import java.util.Scanner;

public class No10869 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in); // 두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)
    // 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.
    int A = in.nextInt();
    int B = in.nextInt();

    System.out.println(A+B);
    System.out.println(A-B);
    System.out.println(A*B);
    System.out.println(A/B);
    System.out.println(A%B);

    in.close();

  }

}
