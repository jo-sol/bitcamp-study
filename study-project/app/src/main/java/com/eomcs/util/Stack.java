package com.eomcs.util;

public class Stack extends ArrayList {

  // 스택에 값을 추가한다.
  // => 맨 끝에 추가하기 때문에 기존의 add() 메서드로(= 메서드를 사용하여) 처리한다.
  // push(), pop() 이라는 메서드가 중요함
  public void push(Object item) { // 기존 파라미터명 item 그대로 씀
    this.add(item);
  }

  public Object pop() {
    return this.remove(this.size() - 1);
  }
}
