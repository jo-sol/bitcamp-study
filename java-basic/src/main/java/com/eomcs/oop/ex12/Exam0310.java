// 아규먼트에 람다(lambda) 활용
package com.eomcs.oop.ex12;

public class Exam0310 {

  static interface Player {
    void play();
  }

  static void testPlayer(Player p) {
    p.play();
  }


  public static void main(String[] args) {
    // 로컬 클래스
    class MyPlayer implements Player {
      @Override
      public void play() {
        System.out.println("실행!");
      }
    };

    testPlayer(new MyPlayer());

  }
}

// 순서 2번
//    public static void main(String[] args) {
//      // 익명 클래스
//      Player p = new Player() {
//        @Override
//        public void play() {
//          System.out.println("실행!");
//        }
//      };
//
//    testPlayer(p);
//
//  }
//
//  순서 3번
//  public static void main(String[] args) {
//  testPlayer(public void play() {
//    System.out.println("실행!");
//  }
//});
//
// 순서 4번
//public static void main(String[] args) {
//  testPlayer(() -> {System.out.println("실행!");});
//  }
//
// 순서 5번
//  public static void main(String[] args) {
//   testPlayer = () -> System.out.println("실행!")
//  }   

// 인터페이스를 구현하는 로컬 클래스를 만들 때, 인터페이스를 한 번만 생성한다고 가정한다면
// 굳이 클래스를 만들 필요가 없다.
// 인스턴스는 클래스 정의와 동시에 인스턴스를 생성할 수 있기 때문
// 상속받고 있는 클래스는 익명 클래스를 생성할 수 없다.
// 익명 클래스는 클래스를 상속받거나 또는 인터페이스를 생성하거나 둘 중에 하나만 해야 한다.