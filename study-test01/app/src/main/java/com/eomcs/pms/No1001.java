package com.eomcs.pms;

public class No1001 {

  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);//System.in은 입력한 값을 Byte 단위로 읽는 것

    int A = keyboard.nextInt(); //keyboard.next()는 문자열 입력 시 공백 전까지만 받는 걸 의미한다
    int B = keyboard.nextInt();

    System.out.print(A-B);

    keyboard.close(); //항상 닫아줘야 함

  } 

}
