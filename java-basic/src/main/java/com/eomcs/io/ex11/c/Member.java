package com.eomcs.io.ex11.c;

public class Member implements java.io.Serializable { // writeObject 사용해서 출력할 수 있습니다~! 허락해 줌

  String name;
  int age;
  boolean gender; // true(여자), false(남자)

  // Exam0320의 두 번째 테스트를 실행할 때 주석을 풀라!
  //  String tel;

  @Override
  public String toString() {
    return "Member [name=" + name +
        ", age=" + age +
        ", gender=" + gender +
        // Exam0320의 두 번째 테스트를 실행할 때 주석을 풀라!
        //        ", tel=" + tel +
        "]";
  }
}

// 필드명을 그대로 유지한다면!
// 필드의 순서가 바뀌어도 상관없으며,
// 시리얼 버전을 실행하는 데 아무런 문제가 없다.