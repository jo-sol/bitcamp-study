package com.eomcs.lang.ex05;

//# 증감 연산자 : 후위(post-fix) 감소 연산자
//
public class Exam0620 {
  public static void main(String[] args) {
    int i = 7;

    i--;
    // 현재 위치에 i 메모리에 들어 있는 값을 꺼내 놓는다. 
    // i 메모리의 값을 1 감소시킨다.
    //    int temp = i;
    //    i = i - 1;   // 할당값이 없으니 사용이 되지 않아 temp는 사용하지 않지만 i 값이 하나 줄었다


    i--;
    // 컴파일러는 위의 문장을 다음과 같이 바꾼다.
    //    int temp = i;
    //    i = i -1;

    System.out.println(i); // 5

    System.out.println(i--); // 5  // 이론: 일단 i 값(현재 5)를 넣고 다음에 i 값을 뺀다(4가 됨) 
    //                     => 그리고 기존에 임시 변수에 담은 값을 출력한다(기존의 값인 5) // 후위 연산자라 --는 나중에
    // 위의 문장을 컴파일 하면 다음과 같이 바뀐다.
    //    int temp = i;
    //    i = i - 1;
    //    System.out.println(temp); // 줄어들기 전 값이 출력되지만

    System.out.println(i); // 마지막 i 값인 4가 출력된다

  }
}
