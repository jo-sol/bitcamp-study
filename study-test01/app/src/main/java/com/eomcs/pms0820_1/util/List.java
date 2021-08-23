package com.eomcs.util;

// <타입이름> // itemType => E(element)
// <> 이 자리에 들어가는 타입은 객체를 생성하는 시점에 결정된다

// 인터페이스에 제네릭(일반화 generic)의 타입 파라미터를 적용하면,
// 그 타입의 최종적인 이름은 
// 이 인터페이스를 구현하는 클래스에서 전달한다.
public interface List<E> {
  void add(E item);
  Object[] toArray();
  boolean remove(E obj);
  int size();
  E get(int index); // push와 pop 사용을 위해 사용 // 특정 위치에 있는 값을 뽑아서 쓰기 위해, 실무에서도 사용
  E remove(int index); 
  E[] toArray(E[] arr); // 녹음 175번 24분 정도부터 듣기
}

// 넘어오는 배열의 타입에 따라 앞의 내용이 달라짐
// ex. <T> T[] toArray(T[] arr) 
//     => <T>라고 선언하는 건 T는 인터페이스가 아니라 파라미터 타입이다 알려 주는 것
// 녹음 176의 4분 정도부터 듣기







