// 스택과 Deque : Iterator
package com.eomcs.basic.ex05;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Exam0220 {

  public static void main(String[] args) {
    ArrayDeque<String> stack = new ArrayDeque<>();

    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    // Stack 클래스와는 다르게
    // Deque 구현체의 iterator는 스택 방식(LIFO)으로 데이터를 꺼낸다.
    // 결론!
    // - Iterator 를 통해 데이터를 꺼낼 때 스택의 특성을 그대로 유지하고 싶다면,
    // Stack 클래스 대신 ArrayDeque 클래스를 사용하라!
    Iterator<String> iterator = stack.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    // 여기서 잠깐!
    // Iterator 설계 기법(Design Pattern)의 목적 (존재 이유)
    // - 데이터 조회 방식(LIFO, FIFO)에 상관없이
    //   일관된 방법으로 데이터를 조회할 수 있게 도와준다.
    // - 즉 스택처럼 입력 역순으로 꺼내든,
    //   큐처럼 입력 순으로 꺼내든 상관없이
    //   개발자는 hasNext(), next() 라는 동일한 메서드를 사용하여 데이터를 조회한다.

  }

}
// Iterator 설계 기법(등장한 이유)
// Client
// - 값을 조회할 때 컬렉션 객체에 따라 호출하는 메서드가 다르다.
//   즉 데이터를 조회하는 방식이 다르다.

// - 컬렉션 객체에 상관없이 (stack에서 꺼내든 que에서 꺼내든)
//   일관된 방식으로 데이터를 꺼낼 수 있다.
//    => 데이터 조회 방식을 통일!

// poll() - 입력순으로 꺼내기
// pop() - 입력 역순으로 꺼내기