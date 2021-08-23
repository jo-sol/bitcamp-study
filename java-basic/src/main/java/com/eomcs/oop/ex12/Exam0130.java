// Lambda 문법 - 람다 파라미터 I
package com.eomcs.oop.ex12;

public class Exam0130 {

  interface Player {
    void play(String name);
  }

  public static void main(String[] args) {
    // 1) 파라미터는 괄호() 안에 선언한다.
    Player p1 = (String name) -> System.out.println(name + " 님 환영합니다.");
    p1.play("홍길동");

    // 2) 파라미터 타입을 생략할 수 있다.
    Player p2 = (name) -> System.out.println(name + " 님 환영합니다.");
    p2.play("홍길동");

    // 3) 파라미터가 한 개일 때는 괄호도 생략할 수 있다.
    Player p3 = name -> System.out.println(name + " 님 환영합니다.");
    p3.play("홍길동");

    //    class MyPlayer implements Player {
    //      @Override
    //      public void play(String name) {
    //        System.out.println(name + "님 환영!!!!");
    //      }
    //    }
    //
    //    MyPlayer p4 = new MyPlayer();
    //    p4.play("오호라");

    //    new Player() {
    //      @Override
    //      public void play(String name) {
    //        System.out.println(name + "님 환영!!!!");
    //      }
    //    }.play("하하하");

    Player p4 = name -> System.out.println(name + "님 환영!!!!");
    p4.play("하하하");
  }
}


