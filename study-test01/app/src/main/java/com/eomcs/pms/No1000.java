package com.eomcs.pms;

import java.util.Scanner;

public class No1000 {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in); //System.in은 입력한 값을 Byte 단위로 읽는 것
    int A = in.nextInt(); //in.next()는 문자열 입력 시 공백 전까지만 받는 걸 의미한다
    int B = in.nextInt();

    System.out.print(A+B);

  }

}
