package com.eomcs.lang.ex07;

//# 메서드 : call by reference II
//
public class Exam0330 {

  // main()에서 만든 int a와 int b의 값을 바꾸고 싶다면,
  // primitive data type 값을 직접 넘기지 말고 
  // 객체에 담아 넘겨라!
  static class MyObject {
    // => class는 메모리의 구조를 설계하는 문법이다.
    // => new 명령을 이용하여 변수를 생성할 수 있다.
    int a;
    int b;
  } // int a, b -> new라는 명령어를 줬을 때 heap에 만들어지는 변수

  static void swap(MyObject ref) {
    System.out.printf("swap(): a=%d, b=%d\n", ref.a, ref.b); // 100, 200
    int temp = ref.a; // 100
    ref.a = ref.b; // 200
    ref.b = temp; // 100
    System.out.printf("swap(): a=%d, b=%d\n", ref.a, ref.b); // 200, 100
  } // int temp, ref a, b -> swap 이라는 메서드가 호출될 때 JVM Stack에 만들어짐

  public static void main(String[] args) { // 기본 변수 8 개(int, boolean, double, char 등)를 제외한 나머지는 모두 주소 변수!!!!!!
    // MyObject 설계도에 따라 int a와 int b 메모리를 만든다.
    // 그리고 그 메모리(인스턴스=객체)의 주소를 ref 변수에 저장한다.
    MyObject ref = new MyObject();  // ** 만약 주소가 4800이면 new Myobject() 위치에 4800이 들어간다(가정)
    ref.a = 100;
    ref.b = 200;

    // a, b 변수가 들어 있는 인스턴스(객체=메모리)의 주소를 
    // swap()에 넘긴다. => 그래서 "call by reference"인 것이다.
    swap(ref); // ** 그러면 여기의 값은 swap(4800)이 된다(가정)
    System.out.printf("main(): a=%d, b=%d\n", ref.a, ref.b);
  } // ref a, b -> main 이라는 메서드가 호출될 때 JVM Stack에 만들어짐
}
