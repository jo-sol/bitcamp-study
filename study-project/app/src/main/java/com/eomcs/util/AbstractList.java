package com.eomcs.util;

// 추상 클래스에서 List에 적용할 타입 이름을 E 라는 변수에 받는다.
// 그 변수의 값을 List 인터페이스에 적용한다.
// 이때 추상 클래스에 최종적인 타입 이름은
// 서브 클래스를 정의할 때 전달한다.
public abstract class AbstractList<E> implements List<E> {
  // public abstract : 모디피어 (제한자,변경자)
  // abstract를 붙혀서 추상클래스로 만들어주면
  // 이 클래스는 인스턴스를 만들수 없다
  // 이 추상클래스를 arrylist와 linkedlist가 상속받아
  // 서브클래스에서 인스턴스를 만들어 사용해야한다

  //이 패키지 안에서만 사용
  protected int size;

  @Override
  public int size() {
    return this.size;
  }

}