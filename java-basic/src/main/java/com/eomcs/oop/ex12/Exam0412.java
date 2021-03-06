// 리턴 문장에 람다(lambda) 활용 - 로컬 클래스를 익명 클래스로 변경
package com.eomcs.oop.ex12;

public class Exam0412 {

  static interface Interest {
    double compute(int money);
  }

  static Interest getInterest(final double rate) {
    // 익명 클래스로 인터페이스 구현한 후 객체 리턴하기
    // => 객체를 한 개만 생성할 것이라면 익명 클래스로 정의하라.
    Interest i = new Interest() {
      @Override
      public double compute(int money) {
        return money + (money * rate / 100);
      }
    };
    return i;
  }

  public static void main(String[] args) {
    Interest i1 = getInterest(1.5);
    System.out.printf("금액: %.2f\n", i1.compute(1_0000_0000));

    Interest i2 = getInterest(2.5);
    System.out.printf("금액: %.2f\n", i2.compute(1_0000_0000));
  }

}


