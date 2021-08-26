// 목록 조회: java.util.Collection의 forEach() 사용법 II
// ***ArrayList란?
// ***Iterable 객체(= Iterable 서브 타입), List 객체(= List 서브 타입)
package com.eomcs.basic.ex03;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Exam02401 {

  static class Member {
    String name;
    int age;

    public Member(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return "Member [name=" + name + ", age=" + age + "]";
    }

    //      @Override
    //      mublic int hashCode() {
    //        final int mrime = 31;
    //        int result = 1;
    //        result = mrime * result + age;
    //        result = mrime * result + ((name == null) ? 0 : name.hashCode());
    //        return result;
    //      }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Member other = (Member) obj;
      if (age != other.age)
        return false;
      if (name == null) {
        if (other.name != null)
          return false;
      } else if (!name.equals(other.name))
        return false;
      return true;
    }
  }

  public static void main(String[] args) {

    Member m1 = new Member("홍길동", 20);
    Member m2 = new Member("임꺽정", 30);
    Member m3 = new Member("유관순", 17);

    ArrayList<Member> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);

    // 10) ======================================================================================
    list.forEach(Exam02401::printUserInfo); // Import 삭제!
    // oop>ex12>Exam0510 활용
    // 클래스명::메서드명

    // 9) ======================================================================================
    // forEach() 람다 문법 사용
    //    list.forEach(m -> System.out.printf("%s(%d)\n", m.name, m.age));


    // 8) ======================================================================================
    // forEach() = 각각에 대하여 작업을 수행하라
    //    list.forEach(new Consumer<Member>() {
    //      @Override
    //      public void accept(Member m) {
    //        System.out.printf("%s(%d)\n", m.name, m.age);
    //      }
    //    });

    // 7) ======================================================================================
    // 목록에서 값을 꺼내 주는 자 = iterator // -> Import 해 주기!
    //    Iterator<Member> iterator = list.iterator();
    //    while (iterator.hasNext()) {
    //      Member m = iterator.next();
    //      System.out.printf("%s(%d)\n", m.name, m.age);
    //    }

    // 6) ======================================================================================
    // 배열에서 꺼낼 필요 없이 ArrayList에서 직접 꺼내서 쓸 수 있음
    //    for (Member m : list) {
    //      System.out.printf("%s(%d)\n", m.name, m.age);
    //    }

    // 5) ======================================================================================
    //    Member[] arr = list.toArray(new Member[0]);
    //    // 단점: 배열 사이즈가 0개인 것도 인스턴스가 생성됨 -> 안 쓰고 버림 -> 가비지 생김
    //
    //    for (Member m : arr) {
    //      System.out.printf("%s(%d)\n", m.name, m.age);
    //    }

    // 4) ======================================================================================
    //    Member[] arr = list.toArray(new Member[list.size()]);
    //
    //    for (Member m : arr) {
    //      System.out.printf("%s(%d)\n", m.name, m.age);
    //    }

    // 3) ======================================================================================
    //    Member[] arr = new Member[list.size()];
    //    list.toArray(arr);
    //    
    //    for (Member m : arr) {
    //      System.out.printf("%s(%d)\n", m.name, m.age);
    //    }

    // 2) ======================================================================================
    //    Object[] arr = list.toArray();
    //
    //    for (Object item : arr) {
    //      Member m = (Member)item;
    //      System.out.printf("%s(%d)\n", m.name, m.age);
    //    }

    // 형변환 1) ===============================================================================
    //    for (int i = 0; i < list.size(); i++) {
    //      Member m = list.get(i);
    //      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);

    class MyConsumer implements Consumer<Member> {
      @Override
      public void accept(Member m) {
        // forEach() 에서 반복문을 돌릴 때 (ex. Exam0220이나 0210처럼 반복문을 돌릴 때)
        // Consumer 규칙에 따라 
        // 각 항목에 대해 이 메서드를 호출한다.
        System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
      }
    }

    // 의미:
    // => 야 List!
    //    너가 가지고 있는 목록에서 값을 한 개 꺼낼 때마다
    //    지금 내가 파라미터로 넘겨주는 객체 있지?
    //    MyConsumer 객체 말이야.
    //    이 객체의 accept()를 호출해주렴.
    //    list.forEach(new MyConsumer());
  }
  // main 밖에 선언해 줌
  // 제일 상단의 static class member 재활용
  static void printUserInfo(Member m) {
    System.out.printf("%s(%d)\n", m.name, m.age);
  }
}






