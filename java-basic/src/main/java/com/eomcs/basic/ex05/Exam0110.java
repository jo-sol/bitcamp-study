// Stack 클래스 사용법 -> JAVA API 참조
package com.eomcs.basic.ex05;

import java.util.Stack;

public class Exam0110 {

  // 스택 초기의 기능을 가지도록 push() 와 pop() 을 이용한다.
  // pop() -> 호출할 때 하나씩 줄어든다
  // peek() -> 가장 꼭대기에 있는 걸 꺼낼 때 사용

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    // push() - 스택의 맨 마지막에 값을 추가한다.
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    // stack.push(new Date()); // 타입 파라미터에 전달한 타입과 일치하지 않으면 오류!

    // pop() - 스택의 맨 마지막에 입력된 값부터 꺼낸다.
    // => 그래서 스택은 LIFO(Last In First Out) 방식으로 데이터를 다룬다.
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());

    // 값이 없는데 꺼내려 하면 EmptyStackException 예외가 발생한다. -> 시스템 멈춤
    System.out.println(stack.pop());
  }

}

