// Stack 클래스 사용법 - empty()
package com.eomcs.basic.ex05;

import java.util.Stack;

public class Exam0120 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    // push() - 스택의 맨 마지막에 값을 추가한다.
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    // empty야 stack이 비어있지는 않았지?
    // 비어있는 게 아니라면 꺼내줘!
    while (!stack.empty()) {
      System.out.println(stack.pop());
    }
  }

}

// Last In
// First Out
// => LIFO = FILO