// Object 클래스 - getClass() 와 배열의 항목 이름
package com.eomcs.basic.ex01;

public class Exam0162 {

  public static void main(String[] args) {

    // 배열의 클래스 정보
    // 배열인 경우 클래스 정보를 뽑아내면 배열을 리턴
    String[] obj2 = new String[10];

    // *** 물론 obj2가 String 배열인지 int 배열인지 알고 싶을 때 아래처럼 하면 안 됨
    //  => 배열의 클래스 정보를 뽑은 후 getComponentType 메서드 호출하여
    //  => 항목 정보를 추출해야 정확하게 알 수 있음 ***
    Class classInfo = obj2.getClass();
    System.out.println(classInfo.getName()); //[Ljava.lang.String;

    // 배열 항목의 타입 정보를 가져온다.
    // 배열인 경우 getComponentType을 이용하여 클래스 정보를 뽑아내면 배열의 한 항목의 타입을 리턴
    Class compTypeInfo = classInfo.getComponentType();
    System.out.println(compTypeInfo.getName()); //java.lang.String

    // 값을 한 번 밖에 사용하지 않을 것이라면
    // 위의 경우처럼 한 번씩 호출하고, 리턴 값을 가지고 또 호출하는 방식으로 값을 꺼내지 않는다.
    // 체인(chain) 방식으로 호출한다.
    System.out.println(obj2.getClass().getComponentType().getName()); //java.lang.String
  }
}







