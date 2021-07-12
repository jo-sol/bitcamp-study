package com.eomcs.lang.ex06;

// # 흐름 제어문 - for(;;) 와 배열
//
public class Exam0440 {
  public static void main(String[] args) {

    //    String[] names = new String[5];  // 가능한 방법 1
    //    names[0] = "홍길동"; 
    //    names[1] = "임꺽정"; 
    //    names[2] = "유관순";
    //    names[3] = "윤봉길"; 
    //    names[4] = "안중근";

    //    String[] names; // 주소를 만들고 배열을 따로 만들기 // 가능한 방법 2
    //    names = new String[] {"홍길동", "임꺽정", "유관순", "윤봉길", "안중근"};

    // 배열 변수 선언과 동시에 배열 초기화를 실행할 때는  new String[] 을 생략할 수 있다. 
    String[] names = {"홍길동", "임꺽정", "유관순", "윤봉길", "안중근"};  // 가능한 방법 3  // 문자열 배열 만들고 주소인 names에 저장

    for (int i = 0; i < names.length; i++) // 배열 반복하는 반복문 // 0부터 시작해서 5 바로 직전까지 반복
      System.out.println(names[i]);

  }
}
