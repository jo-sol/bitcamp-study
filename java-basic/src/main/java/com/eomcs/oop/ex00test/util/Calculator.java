package com.eomcs.oop.ex00test.util;

public class Calculator {
  // 어떤 클래스에 인스턴스를 만드는 것은 그 클래스가 사용할 메서드를 만든다는 것

  // static int result; (메서드들이 공유하는 변수)를 메서드가 소속된 클래스(Calculator.java) 안에 둔 이유는 관리하기 용이하기 위해
  // result 변수가 하나밖에 없을 때는 밖에(Exam0500)에 두는 게 가장 편하다
  // 하지만!! 여러개가 있을 경우에는 메서드가 소속된 클래스에 저장해 두는 게 유지보수에 좋다

  public int result = 0;
  // 값을 여러개 출력하려면 본래 기존의 Exam0500으로 int result값을 여러개 개수에 맞춰 선언해 줘야 하고,
  // 값도 Calculator.plus(result개수번호, 2) 이렇게 개별적으로 하나씩 선언해 줘야 한다 -> 유지보수 차원에서 불편함

  // 그래서 다시 Calculator로 돌아와서 result를 필요한 만큼 사용하기 위해
  // staitc int result; 변수를 non-static 변수(int result;)로 바꿔 준다

  // 이에 따라 Exam0500에는 인스턴스 변수로 만들어 주는 new를 사용하여 
  // 개수에 맞춰 클래스명.변수가 들어있는 주소 = new 클래스명(); 선언

  public void plus(int value) { // void로 바꿔 주는 이유: return 선언하지 않아서
    this.result += value; // return 안 쓰는 이유: 더 이상 반환할 값이 없어서 // int result 값을 위로 빼줬기 때문
  }

  public void minus(int value) { // 결과는 내부에서 관리하기 때문에 파라미터를 사용할 필요가 없어짐
    this.result -= value; // 그래서 (int result, int value) -> (int value)로 변경
  }

  public void multiple(int value) {
    this.result *= value;
  }

  public void divide(int value) {
    this.result /= value;
  }
  // 인스턴스를 사용하지 않는 메서드라면 클래스 메서드로 놓아라
  static int abs(int value) { // 절대값은 반드시 양수일 수밖에 없는 것을 표현
    return value > 0 ? value : -value;
    // value가 0보다 크면 value를 리턴하고 그게 아니라면 -value를 리턴해라
    // this(인스턴스 변수)를 사용하지 않는다
    // static이 붙어 있으니까 인스턴스 메소드가 아닌 걸 확인할 수 있다
  }
}

// **) that은 result의 주소가 어디에 있는지 알려 주기 위해 선언해 준 파라미터 변수(주소값)이다
//     that -> 어떤 인스턴스(주소)를 주냐에 따라 주어진 인스턴스(변수가 있는 메모리)를 쓴다
//     주고받는 건 변수가 있는 주소이다!!!
//  int result;
//  static void plus(Calculator that, int value) {
//    that.result += value;
//  }
// 
//  int result;
//  void plus(int value) { // 1. 인스턴스 주소로 바꿔 주면 파라미터를 사용할 필요 없고
//  this.result += value; // 3. -> 인스턴스 주소에 내장된 this 변수로 알아서 변경됨
//  }
//      => c1.plus(2); // 2. 해당 메서드가 소속된 인스턴스 주소를 앞으로 넘겨서 받을 수 있다
//      => c2.plus(3);