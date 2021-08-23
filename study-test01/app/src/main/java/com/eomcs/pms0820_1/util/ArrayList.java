package com.eomcs.util;

import java.util.Arrays;

// 일반 클래스에 제네릭을 적용하면
// 최종적인 타입 이름은
// 해당 클래스의 인스턴스를 생성할 때 전달한다.
// 추상 클래스의 타입 이름은 서브 클래스를 정의할 때 전달한다.
public class ArrayList<E> extends AbstractList<E> {

  static final int MAX_LENGTH = 5;

  Object[] list = new Object[MAX_LENGTH];

  @Override
  public void add(E obj) {
    if (size == list.length) {
      Object[] arr = new Object[list.length + (list.length >> 1)];
      for (int i = 0; i < size; i++) {
        arr[i] = list[i];
      }
      list = arr;
    }
    this.list[this.size++] = obj;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[this.size]; // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다.
    for (int i = 0; i < this.size; i++) { // 배열에 저장된 값을 새 배열에 복사한다.
      arr[i] = list[i];
    }
    return arr; // 새 배열을 리턴한다.
  }

  @Override
  public boolean remove(E obj) {
    int index = indexOf(obj);
    if (index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }
    this.list[--this.size] = null;

    return true;
  }

  private int indexOf(E obj) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i] == obj) {
        return i;
      }
    }
    return -1;
  }

  @SuppressWarnings("unchecked")
  @Override
  // => 컴파일러에게 지금 정의할 메서드는 수퍼 클래스에 정의된 메서드로서
  // 서브클래스의 역할에 맞춰 재정의하는 중입니다를 의미
  public E get(int index) {
    if (index < 0 || index >= this.size) { // 유효하지 않은 인덱스인 경우
      return null; // null 값을 리턴한다
    }
    return (E) this.list[index]; // 여기에서는 형변환 시켜줘야 함
  }

  // 지정된 index 찾아서 당기기 (push) // ***녹음 171의 8분 정도부터 듣기 
  // SuppressWarings // 녹음 174 40분 정도부터 듣기

  @SuppressWarnings("unchecked")
  @Override
  public E remove(int index) { // remove의 값은 삭제될 항목을 리턴한다는 의미

    if (index < 0 || index >= this.size) { // 인덱스가 무효하다면
      return null; // 이 값은 null이 된다
    }

    E deleted = (E) this.list[index]; // 삭제할 항목 저장

    for (int i = index + 1; i < this.size; i++) { 
      this.list[i - 1] = this.list[i];
    }
    this.list[--this.size] = null;

    return deleted; // 삭제한 항목 리턴
  }

  @SuppressWarnings("unchecked") // 예외 던지지 마셈
  @Override
  public E[] toArray(E[] arr) { // T가 무엇인지는 메서드가 호출되는 시점에 결정될 거야

    if (arr.length >= this.size) {
      // 1) 파라미터(위의 arr)로 받은 배열이 현재 목록에 있는 값을 담을 만큼 충분히 크다면
      //    현재 목록에 있는 값을 파라미터로 받은 배열에 복사한다.

      //      for (int i = 0; i < this.size; i++) {
      //        arr[i] = (E) this.list[i];
      //      }

      //    배열을 복사할 때 자바에서 제공하는 클래스를 사용하면
      //    반복문을 작성할 필요 없이 보다 쉽게 배열을 복사할 수 있다.
      //    => System.arraycopy(
      //                원래 배열, 복사 시작 인덱스, 값을 받을 배열, 복사 시작 인덱스, 복사할 개수)
      System.arraycopy(this.list, 0, arr, 0, this.size);
      return arr; // 최종적으로 기존에 그대로 받은 파라미터 배열을 그대로 리턴한다.

    } else {
      // 2) 파라미터로 받은 배열이 현재 목록에 들어 있는 값을 담을 만큼 크지 않다면,
      //    새 배열을 만들어 복사한다.

      // 그러나 다음과 같이 제네릭을 적용한 배열 인스턴스는 생성할 수 없다.
      // E[] temp = new E[this.size]; // 컴파일 오류! => 제네릭 타입의 배열은 만들 수 없다

      // 그래서 다른 클래스의 도움을 받아 생성해야 한다.

      // 방법 1과 2의 Array 패키지가 서로 다르기 때문에
      // 방법 1은 Array이고 방법 2는 Arrays이다.

      // 방법 1. 새 배열을 만들어 기존 배열의 값을 복사한다.
      //    => Array.newInstance(배열 항목의 타입, 생성할 배열의 크기);
      // 참고! => arr.getClass() => 배열의 타입  예) String[], Project[]
      //          arr.getClass().getComponentType() => 배열의 각 항목의 타입  예) String, Project
      //
      //      E[] temp = (E[]) Array.newInstance(arr.getClass().getComponentType(), this.size);
      //      System.arraycopy(this.list, 0, temp, 0, this.size);
      //      return temp;

      // 방법 2. 
      // 제네릭이 적용된 배열을 만들 때는 Arrays.copyOf를 사용해야 한다.
      // 
      //    => Arrays.copyOf(
      //                     원래 배열, 복사할 개수, 새로 만들 배열의 타입)
      E[] temp = (E[]) Arrays.copyOf(
          this.list, // 원래 배열
          this.size, // 복사할 개수. 현재 배열에 들어있는 값들의 개수
          arr.getClass() // 생성할 배열의 타입(파라미터의 배열과 같은 타입의 배열을 생성할 것이다)
          );
      return temp;
    }
  }
}


//@Override
//public Object[] toArray() {
//  Object[] arr = new Object[this.size]; // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다.
//  for (int i = 0; i < this.size; i++) { // 배열에 저장된 값을 새 배열에 복사한다.
//    arr[i] = list[i];
//  }
//  return arr; // 새 배열을 리턴한다.
//}