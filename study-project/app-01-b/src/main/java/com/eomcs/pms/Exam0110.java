package com.eomcs.pms;

public class Exam0110 {
  public static void main(String[] args) {
    long millis = System.currentTimeMillis();
    System.out.println(millis); // 2. println을 수행할 때 전달하는 값을 argument

    java.sql.Date d = new java.sql.Date(millis); // 5. sql은 기존의 util 방에 있는 것을 업그레이드한 것
    System.out.println(d.toString()); // 4. 현재 이 물건 안에 설정된 그 시간을 가지고 계산해서 연,월,일을 문자열로 만들어 주는 기능
  }
}

// double d = System.currentTimeMillis(); // 1. double도 가능하지만 글자가 잘린다 같은 8byte지만 지수부와 가수부로 잘리기 때문
// java.util.Date(); // 3. 이 설계도는 우리가 원하는 양식(2021-07-08)으로 안 만들어 줌
// 6. 날짜를 뽑아낼 내용을 new java.sql.Date(millis); <- "millis"와 같이 넣어 줘야 함