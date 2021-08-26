// Lambda 문법 - functional interface의 자격
package com.eomcs.oop.ex12;

public class Exam0240 {

  static abstract class Player {
    public abstract void play();
  }

  public static void main(String[] args) {
    // 인터페이스가 아닌 추상 클래스는 람다 구현의 대상이 아니다!
    //    Player p = () -> System.out.println("Player..."); // 컴파일 오류!
  }

}

// **)인터페이스일 때만 람다 문법 구현이 가능하고,
// 추상 클래스는 절대 람다 문법 구현할 수 없다.
// **)인터페이스에서 메서드가 static이거나 default인 경우에 상관없이
// 추상 메서드라면 람다 문법 구현이 가능하다.

