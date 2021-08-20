// Object 클래스 - getClass() 와 배열 // ** 특징 잘 보기!! ** // 녹음 133 15분 정도
package com.eomcs.basic.ex01;

public class Exam0161 {

  public static void main(String[] args) {

    String obj1 = new String(); // String 클래스의 배열
    Class classInfo = obj1.getClass();
    System.out.println(classInfo.getName()); // java.lang.String

    // 배열의 클래스 정보
    String[] obj2 = new String[10]; // ***String 레퍼런스의 배열 (= "[L ... ;") 객체 생성***
    classInfo = obj2.getClass();
    System.out.println(classInfo.getName()); //[Ljava.lang.String;
    // [L : 넘어오는 객체 주소가 어떤 주소인지 알려 주는 것

    //    int i = 100;
    //    classInfo = i.getClass(); // primitive type은 object의 서브 클래스가 아니다.

    int[] obj3 = new int[10];
    classInfo = obj3.getClass();
    System.out.println(classInfo.getName()); //[I

    float[] obj4 = new float[10];
    classInfo = obj4.getClass();
    System.out.println(classInfo.getName()); //[F

    double[] obj5 = new double[10];
    classInfo = obj5.getClass();
    System.out.println(classInfo.getName()); //[D

    System.out.println(new byte[10].getClass().getName()); //[B
    System.out.println(new short[10].getClass().getName()); //[S
    System.out.println(new long[10].getClass().getName()); //[J
    System.out.println(new char[10].getClass().getName()); //[C
    System.out.println(new boolean[10].getClass().getName()); //[Z
    // 배열 주소는 object 타입
  }
}





