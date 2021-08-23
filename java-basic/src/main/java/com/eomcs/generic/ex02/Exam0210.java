// 제네릭(Generic) 문법 정리 - 레퍼런스와 인스턴스 생성 
package com.eomcs.generic.ex02;

import java.util.ArrayList;

public class Exam0210 {
  public static void main(String[] args) {
    // 문법
    // => 클래스명 옆에 다루고자 하는 타입의 이름을 지정한다.
    //    클래스명<타입명>
    ArrayList<Member> list = new ArrayList<Member>();

    // => 레퍼런스 선언에 제네릭 정보가 있다면 new 연산자에서는 생략할 수 있다.
    ArrayList<Member> list2 = new ArrayList</*Member*/>(); // OK!

    ArrayList<Member> list3;
    list3 = new ArrayList<>(); // OK! // new ArrayList<Member>(); 생략 가능

    // 제네릭 문법으로 레퍼런스 변수를 선언할 때는 타입명을 생략할 수 없다.
    // 레퍼런스를 선언할 때 타입을 생략할 수 없다.
    // 뒤는 생략이 가능하지만 앞은 생략할 수 없다.
    //    ArrayList<> list4 = new ArrayList<Member>(); // 컴파일 오류!

  }
}







