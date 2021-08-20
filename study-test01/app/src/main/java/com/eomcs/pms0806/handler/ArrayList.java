package com.eomcs.pms.handler;

public class ArrayList implements List { // List를 implements(구현한다)

  static final int MAX_LENGTH = 5;
  // Board, Member, Project, Task의 수퍼 클래스는 Object이다
  // Object는 어떤 클래스든 다 담을 수 있다
  Object[] list = new Object[MAX_LENGTH]; // 다양한 값을 담을 거니까 list
  int size = 0;

  public void add(Object obj) {
    if (size == list.length) {
      Object[] arr = new Object[list.length + (list.length >> 1)]; // 기존 크기에서 + 50% 더 큰 만큼 더해서 만들기
      for (int i = 0; i < size; i++) {
        arr[i] = list[i];
      }
      list = arr; // boards에 저장된 옛날 배열 주소를 버리고 새 배열 주소를 저장한다.
    }
    this.list[this.size++] = obj;
  }

  public Object[] toArray() { // 여기에 들어있는 게 어떤 클래스인지 몰라서 Object
    Object[] arr = new Object[this.size]; // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다.
    for (int i = 0; i < this.size; i++) { // 배열에 저장된 값을 새 배열에 복사한다.
      arr[i] = list[i]; // 기존의 list에 들어있는 것 (클래스를 한정해 주면 안 됨)
    }
    return arr; // 새 배열을 리턴한다.
  }

  public boolean remove(Object obj) { // 주소만 일치하면 됨 -> Object obj
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

  private int indexOf(Object obj) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i] == obj) {
        return i;
      }
    }
    return -1;
  }
}
