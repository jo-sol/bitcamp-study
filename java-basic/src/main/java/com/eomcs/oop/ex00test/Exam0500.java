package com.eomcs.oop.ex00test;

import com.eomcs.oop.ex00.util.Calculator;

public class Exam0500 {

  public static void main(String[] args) {

    // 식1) 2 + 3 - 1 * 7 / 3 = ?
    // 식2) 3 * 2 + 7 / 4 - 5 = ?
    Calculator c1 = new Calculator(); // Calculator가 작업할 때 사용할 변수를 생성하는 명령어
    Calculator c2 = new Calculator(); // 주의!! new 클래스명() -> 메서드가 만들어지는 게 아님!!
    // 해당 메모리를 쓰려면 메모리 주소를 받아야 함 -> Calculator c1 (클래스명.변수가 들어있는 주소)

    c1.plus(2);
    c2.plus(3);

    c1.plus(3);
    c2.multiple(2);

    c1.minus(1);
    c2.plus(7);

    c1.multiple(7);
    c2.divide(4);

    c1.divide(3);
    c2.minus(5);

    System.out.printf("result = %d\n", c1.result);
    System.out.printf("result = %d\n", c2.result);
  }

}
