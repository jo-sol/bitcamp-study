package com.eomcs.basic.ex10;

public class Exam0110 {
  public static void main(String[] args) {
    java.util.Date d = new java.util.Date(); // 1. Date 객체를(물건을) 만드는 순간의 시각을 저장해 둔다.
    System.out.println(d.toString());
    System.out.printf("%tY-%tm-%td\n", d, d, d); // 3. 변수 세 개 사용
    System.out.printf("%tY-%1$tm-%1$td\n", d); // 4. 변수 하나만 사용하고 싶으면 "%tY-%1$tm-%1$td"

    // System.out.println(d.toString()); // 2. 이 값이 마음에 안 들면 printf 사용
  }
}

