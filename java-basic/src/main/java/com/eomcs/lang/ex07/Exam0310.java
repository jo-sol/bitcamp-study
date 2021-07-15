package com.eomcs.lang.ex07;

//# 메서드 : call by value
//
public class Exam0310 {

  static void swap(int a, int b) {
    System.out.printf("swap(): a=%d, b=%d\n", a, b);
    int temp = a;
    a = b;
    b = temp;
    System.out.printf("swap(): a=%d, b=%d\n", a, b); // 여기에서 되돌아가면서 swap()메서드는 끝나고 없어짐
  }

  public static void main(String[] args) { // 로컬변수: args, a, b
    int a = 100;
    int b = 200;

    // swap() 호출할 때 a 변수의 값과 b 변수의 값을 넘긴다.
    // => 그래서 "call by value"라 부른다.
    // => 비록 swap()에서 a와 b라는 이름의 변수가 있지만,
    //    이 변수는 main()에 있는 변수와 다른 변수이다.

    swap(a, b); // 메소드 // swap을 호출하게 되면서 swap(100, 200);이 됨 -> a와 b를 넘긴다는 게 아니라 그(변수) 안에 있는 값을 넘긴다는 뜻!!!
    System.out.printf("main(): a=%d, b=%d\n", a, b);
  }
}

//  => 메서드 실행이 끝나면 그 메서드를 호출할 때 생성했던 프레임이 삭제된다
//                  프레임: 메서드의 로컬 변수가 들어있다.


// call by value
// => 아규먼트가 primitive data type인 경우,
//    메서드를 호출할 때 값을 넘긴다.
// => 자바에서는 primitive data type에 대해서 
//    메모리(변수) 주소를 넘기는 방법이 없다.
// 