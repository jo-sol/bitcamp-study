// LinkedList 사용법
package com.eomcs.basic.ex04;

import java.util.LinkedList;

public class Exam0110 {

  public static void main(String[] args) {
    String s1 = new String("aaa");
    String s2 = new String("bbb");
    String s3 = new String("ccc");
    String s4 = new String("ddd");
    String s5 = new String("eee");

    LinkedList list = new LinkedList();
    list.add(s1);
    list.add(s2);
    list.add(s3);

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));

    System.out.println(list.size());

    System.out.println(list.remove(1)); // aaa, ccc,
    print(list);

    list.add(s4); // aaa, ccc, ddd
    list.add(1, s5); // aaa, eee, ccc, ddd
    print(list);

    list.add(0, s2); // bbb, aaa, eee, ccc, ddd
    print(list);

    list.add(5, "xxx"); // bbb, aaa, eee, ccc, ddd, xxx
    print(list);
  }

  static void print(LinkedList list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ", ");
    }
    System.out.println();
  }
}

// ArrayList vs LinkedList
// 1) 메모리
// ArrayList
//    => 고정 크기를 갖는다.
//    => 크기를 초과하면 새로 배열을 만들어야 하기 때문에 메모리 낭비가 심하다.
//    => 기존 배열은 가비지가 되기 때문에 가비지가 과다 생산된다.
// LinkedList
//    => 값을 넣을 때마다 새 메모리가 추가되는 가변 크기를 가진다.
//    => (만들었던 파일) node라는 배열을 만들어 값을 넣었음
//    => ArrayList 보다 메모리 낭비가 적고 가비지를 덜 생산한다.
// 2) 속도
// ArrayList
//    => 배열의 특징 상 인덱스를 이용하여 특정 항목을 찾을 때 속도 빠르다.
//    => 삭제할 때 이전 항목을 당겨와야 하기 때문에 속도가 느리다.
//    => 삽입할 때 현재 항목을 다음 항목으로 이동해야 하기 때문에 속도가 느리다.
// LinkedList
//    => 인덱스를 이용하여 특정 항목을 찾을 때 리스트의 처음부터 찾아야 하기 때문에 속도가 느리다.
//    => 삭제할 때 이전 항목과 다음 항목을 바로 연결하면 되기 때문에 속도가 빠르다.
//    => 삽입할 때 현재항목과 다음 항목을 새 항목과 연결하면 되기 때문에 속도가 빠르다.

// 1-1) 인터페이스가 없으면 개발자는 자기 마음대로 메서드를 정의한다. (ex. add(), delete()...)
// => 이를 보완하기 위해 ArrayList와 LinkedList 사용
// 2-1) 인터페이스를 사용하면 개발자가 클래스를 정의할 때,
//    인터페이스에서 정한 규칙에 따라 메서드를 만들어야 한다.
//    => 규칙정의(객체 사용법 정의)
//    => List 라는 인터페이스 사용


// ** Client : 목록을 다루기 위해 ArrayList나 LinkedList를 사용한다.
// Client가 ArrayList / LinkedList를 사용할 때,

// 1-1) 두 클래스의 사용법(구현 방법)이 달라서 프로그래밍 할 때 불편하다.
// => ArrayList를 LinkedList로 교체하기가 쉽지 않다.
// => 코드를 많이 변경해야 한다.
// 2-1) ArrayList와 LinkedList의 사용법이 같기 때문에 프로그래밍에 일관성을 부여한다.
// => ArrayList를 LinkedList로 교체하더라도 변경해야 할 코드가 적다.
// => 유지보수가 쉽다.

// ** 사용법이 똑같은 이유?
// => 둘 다 같은 인터페이스(List)를 사용하기 때문!

// 사용법은 같으나 구현 방법을 다르게 해서
// 프로그래밍이 구현할 기능에 맞춰 **적절한 구현체로 교체**하기가 쉽다.
// 조회가 중요해! -> ArrayList
// 삽입 삭제가 더 많아! -> LinkedList



















