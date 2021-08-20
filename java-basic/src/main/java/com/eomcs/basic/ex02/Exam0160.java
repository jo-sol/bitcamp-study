// String - mutable vs immutable 객체 // 변경할 수 있는 vs 변경할 수 없는
package com.eomcs.basic.ex02;

public class Exam0160 {
  public static void main(String[] args) {
    // String 객체는 immutable 객체이다.
    // 즉 한 번 객체에 값을 담으면 변경할 수 없다.
    // 한 번 값이 결정되면 바뀌지 않는다.

    String s1 = new String("Hello"); //***s1은 변경되지 않는

    // String 클래스의 메서드는 원본 인스턴스의 데이터를 변경하지 않는다. 
    // 다만 새로 String 객체를 만들 뿐이다.
    String s2 = s1.replace('l', 'x');
    System.out.println(s1 == s2);
    System.out.printf("%s : %s\n", s1, s2); // 원본은 바뀌지 않는다.

    String s3 = s1.concat(", world!"); // s1과 ", world!"를 합친 새로운 문자열 s3을 출력
    System.out.printf("%s : %s\n", s1, s3); // 원본은 바뀌지 않는다.
  }
}





