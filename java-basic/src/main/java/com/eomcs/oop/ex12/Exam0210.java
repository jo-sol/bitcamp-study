// Lambda 문법 - functional interface의 자격
package com.eomcs.oop.ex12;

public class Exam0210 {

  // 추상 메서드가 한 개짜리 인터페이스여야 한다.
  interface Player {
    void play();
  }

  public static void main(String[] args) {

    // 추상 메서드를 한 개만 갖고 있는 인터페이스에 대해
    // 람다 문법으로 익명 클래스를 만들 수 있다.
    Player p = () -> System.out.println("Player...");
    p.play();
  }
}

//Player p1 = new Player() {
//@Override
//  public void play() {
//  System.out.println("익명 클래스");
//  }
//};
//p1.play();

//  Player p = () -> System.out.println("Player...");
//  p.play();
//
//

// 람다 문법 만들기
// *) 조건! 추상 메서드가 한 개짜리여야 한다
// 1) 일단 밖의 껍데기를 지움 ( = 뒤의 "new 어쩌고")
// 2) 메소드를 없앰
// 3) 메서드와 바디의 사이에 -> 삽입
// 3-1) 만약 메서드 바디에 문장이 하나라면 문장만 두고 괄호를 지울 수 있음
// 4) 한 줄로 변경



