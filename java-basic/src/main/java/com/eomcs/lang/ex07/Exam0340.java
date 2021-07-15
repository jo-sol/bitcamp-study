package com.eomcs.lang.ex07;

//# 메서드 : 레퍼런스를 리턴하기
//
public class Exam0340 {

  // swap()에서 만든 int a와 int b의 값을 main()에서 사용하기
  // primitive data type 값을 객체에 담아 넘겨라!

  static class MyObject {
    int a;
    int b;
  }

  static MyObject swap(int a, int b) { // swap을 호출할 때 넘겨 줄 값(int a, int b = 파라미터)
    MyObject ref = new MyObject();
    ref.a = b;
    ref.b = a;
    return ref; //ref에 들어있는 주소를 return 하겠다는 의미 // 1) 메서드 호출이 끝나면 주소가 return됨
  }

  public static void main(String[] args) {
    int a = 100;
    int b = 200;

    MyObject ref = swap(a, b); // 2) ref 변수 여기에 return 됨

    System.out.printf("main(): ref.a=%d, ref.b=%d\n", ref.a, ref.b);
  }
}
