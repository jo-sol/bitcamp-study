// 인터페이스와 추상 클래스 : 인터페이스 직접 구현
package com.eomcs.oop.ex09.d;


public class Exam0110 {

  interface ProtocolA {
    void rule1();
    void rule2();
    void rule3();
    void rule4();
  }

  // 인터페이스를 준수한다는 것은
  // 인터페이스의 **모든 규칙을 구현해야 함**을 의미한다.
  // 하나라도 빠지는 순간 해당 메서드는 추상 메서드로 남아 있으며,
  // 이에 따라 해당 클래스도 추상 클래스로 남아 있게 된다.
  // 이렇게 되면 ProtocolAImpl는 일반 클래스가 아닌 추상 클래스가 되며,
  // 일반 클래스처럼 인스턴스를 가질 수 없다.
  class ProtocolAImpl implements ProtocolA {
    @Override
    public void rule1() {}

    @Override
    public void rule2() {}

    @Override
    public void rule3() {}

    @Override
    public void rule4() {}
  }
}
