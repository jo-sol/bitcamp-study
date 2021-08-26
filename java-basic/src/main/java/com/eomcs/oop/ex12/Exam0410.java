// 리턴 문장에 람다(lambda) 활용 - 이자 계산하기(중첩 클래스 사용 전) ***
package com.eomcs.oop.ex12;

public class Exam0410 {

  static interface Interest {
    double compute(int money);
  }

  // 팩토리 메서드
  // => Interest 구현체를 생성하여 리턴하는 메서드
  static Interest getInterest(final double rate) {
    // 로컬 클래스로 인터페이스 구현한 후 객체 리턴하기
    class InterestImpl implements Interest {
      double rate;

      public InterestImpl(double rate) {
        this.rate = rate; // 이자율에 따라
      }

      @Override
      public double compute(int money) {
        return money + (money * rate / 100); // 원금과 이자율을 계산하여 출력
      }
    }
    return new InterestImpl(rate);
  }

  public static void main(String[] args) {
    Interest i1 = getInterest(1.5);
    System.out.printf("금액: %.2f\n", i1.compute(1_0000_0000));

    Interest i2 = getInterest(2.5);
    System.out.printf("금액: %.2f\n", i2.compute(1_0000_0000));
  }

}


