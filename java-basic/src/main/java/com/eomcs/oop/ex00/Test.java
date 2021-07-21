package com.eomcs.oop.ex00;

public class Test {
  static int a;
  int b; // new 라는 명령어를 만들면 그때 생성됨!!

  static void m1(int c) {
    int d = c + 100;
  }
  void m2(int c) { // m이라는 메서드가 생성되면 아래의 로컬 변수도 생긴다!!
    int d = c + 100; // 로컬변수
  }
}
