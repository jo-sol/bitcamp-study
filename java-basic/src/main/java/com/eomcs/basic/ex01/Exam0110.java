// Object 클래스 - 자바 최상위 클래스
package com.eomcs.basic.ex01;



//클래스를 정의할 때 수퍼 클래스를 지정하지 않으면 
//컴파일러는 자동으로 Object를 상속 받는다.
//어느 클래스든 상관없이 다 붙임
public class Exam0110 /*extends Object*/ {

  static class My /*extends Object*/ {
  }

  public static void main(String[] args) {

    // instanceof 연산자를 사용하여 해당 인스턴스가 Object 타입인지 확인해 보자.
    // instanceof 연산자?
    // => 레퍼런스가 가리키는 인스턴스가 지정한 클래스를 인스턴스 이거나 또는 조상으로 갖는지 검사한다.
    Object obj = new My(); // My도 결국 Object의 자식이기 때문
    // Object의 레퍼런스에 My 인스턴스 주소를 저장할 수 있다는 것은
    // My 클래스가 Object 크래스의 서브 클래스임을 증명하는 것이다.

    System.out.println(obj instanceof My);
    System.out.println(obj instanceof String);
    System.out.println(obj instanceof Object);

    // Object를 조상으로 갖는다면 당연히 Object의 메서드를 사용할 수 있을 것이다.
    System.out.println(obj.toString());
    System.out.println(obj.hashCode()); // com.eomcs.basic.ex01.Exam0110$My@3d075dc0 -> @3d075dc0 해시코드를 10진수로 출력했음
    System.out.println(obj.equals("Hello"));

    // 결론!
    // => 자바의 모든 클래스는 Object의 자손이다.
  }

}

// Object 클래스의 주요 메서드
// 1) toString()
//    => 클래스이름과 해시코드(인스턴스마다 고유하게 부여되는 숫자 // 인스턴스를 식별하는 값)를 리턴한다.
// 2) equals()
//    => 같은 인스턴스인지 검사한다. 
// 3) hashCode()
//    => **인스턴스를 식별하는 값**을 리턴한다. // 주소 아님!!!!! 자바에서는 인스턴스 주소 확인할 방법 없음!
// 4) getClass()
//    => 인스턴스의 클래스 정보를 리턴한다.
// 5) clone()
//    => 인스턴스를 복제한 후 그 복제 인스턴스를 리턴한다.
// 6) finalize()
//    => 가비지 컬렉터에 의해 메모리에서 해제되기 직전에 호출된다.
//    => 가비지 컬렉터가 프로그램이 종료되기 전에 호출된다는 보장은 없음.
//    => 가비지 컬렉터는 메모리가 부족하면 동작하기 때문.
// 







