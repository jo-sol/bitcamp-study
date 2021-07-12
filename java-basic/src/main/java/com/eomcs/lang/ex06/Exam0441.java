package com.eomcs.lang.ex06;

// # 흐름 제어문 - for(;;) 와 배열
//
public class Exam0441 {
  public static void main(String[] args) {
    String[] names = {"홍길동", "임꺽정", "유관순", "윤봉길", "안중근"};

    // 인덱스 범위 조정
    for (int i = 2; i < 4; i++) { // 2에서 3까지 반복하라는 의미
      System.out.println(names[i]);
    }

  }
}
