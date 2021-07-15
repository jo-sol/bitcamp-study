package com.eomcs.lang.ex07;

// # 메서드 : 개념 및 기본 문법
// - 특정 기능을 수행하는 명령어들을 모아 둔 블록
// 
// ## 메서드 문법
//   [리턴값의 타입] 함수명(파라미터선언, ...) {명령어들}
// - 리턴 값(return value)의 타입?
//   => 함수 블록에 들어있는 명령어를 수행 완료한 후 
//      그 결과로 놓이는 값의 타입.
// - 파라미터(parameter) 선언?
//   => 함수 블록을 실행할 때 외부로부터 받은 값을 저장할 변수 선언.
//
// 1) 명령어 블록을 실행할 때 값을 넘겨주지 않고 결과도 넘겨 받지 않는다.
// void 메서드명() {
//   문장1;
//   문장2;
// }
//
// 2) 명령어 블록을 실행할 때 값을 넘겨준다. 그러나 결과는 받지 않는다.
// void 메서드명(변수선언1, 변수선언2, ...) {
//   문장1;
//   문장2;
// }
//
// 3) 명령어 블록을 실행할 때 값을 넘겨주지 않는다. 결과는 받는다.
// 리턴타입 메서드명() {
//   문장1;
//   문장2;
// }
//
// 4) 명령어 블록을 실행할 때 값을 넘겨주고 결과를 받는다.
// 리턴타입 메서드명(변수선언1, 변수선언2, ...) {
//   문장1;
//   문장2;
// }
//
public class Exam0210 {
  // 
  // 예1) 메서드 : 리턴값(X), 파라미터(X)
  // - 함수 블록을 실행할 때 특정 값을 함수에 넘겨 줄 필요가 없고,
  //   함수 블록 실행을 완료한 후 어떤 값도 돌려주지 않는다.
  // - "여러분, 부자되세요!", "여러분, 식사하고 오세요!"
  //
  static void hello() {
    System.out.println("안녕하세요!");
    System.out.println("이 메서드는 어떤 값도 리턴하지 않습니다.");
  }

  public static void main(String[] args) {

    // ## 메서드를 사용하는 방법
    // [리턴값을 받을 변수] = 메서드명(아규먼트);
    // - 아규먼트(argument)?
    //   => 메서드 블록에 들어 있는 명령을 실행하기 위해 넘겨주는 값
    //   => 즉 파라미터 변수에 넘겨주는 값
    //   => 파라미터 변수의 타입과 개수와 순서에 맞게 값을 넘겨줘야 한다.
    //      만약 변수의 타입과 값의 타입이 다르면 컴파일 오류!
    //      만약 변수의 개수와 값의 개수가 다르면 컴파일 오류!
    //      변수 선언 순서와 값의 순서가 다르면 컴파일 오류!
    //
    // - 리턴값을 받을 변수
    //   => 메서드 블록을 실행한 후 리턴되는 값을 받을 변수이다.
    //   => 메서드가 값을 리턴한다 하더라도 값을 받기 싫으면
    //      변수를 선언하지 않아도 된다.
    //      그러면 리턴 되는 값은 버려진다.
    //   => 값을 리턴하지 않는 메서드에 대해 변수를 선언하면 컴파일 오류!

    // ## 메서드 블록의 명령을 실행하기
    // => 메서드 실행하기
    // => 메서드 호출하기
    //    즉 다음은 "hello"라는 이름을 가진 메서드 블록을 찾아가서 실행하라는 의미.
    hello();
    // ## 실행 과정
    // 1) hello() 메서드의 블록으로 간다.
    // 2) 메서드 바디를 실행한다.
    // 3) 다시 원래 위치로 돌아온다.
    // 4) 다음 줄을 실행한다.

    System.out.println("hello() 실행 완료!");


    // hello 메서드는 파라미터 변수가 없기 때문에 호출할 때 값을 넣으면
    //    hello(100);// 컴파일 오류!

    // hello 메서드는 값을 리턴하지 않기 때문에 변수로 값을 받으려 하면
    int i;
    //    i = hello(); // 컴파일 오류!

  }
}

// ## 메서드(method) = 함수(function)?
// - 명령어를 기능 단위로 관리하기 쉽게 별도로 분리하여 묶어 놓은 것.
// - 반복적으로 자주 사용하는 명령어를 재사용하기 쉽도록 별도로 분리하여 묶어 놓은 것.
// - "코드를 관리하기 쉽고 재사용하기 쉽도록 기능 단위로 묶어 놓는 문법"
//
// ## 용어
// - 메서드명, 변수선언 : 메서드 시그너처(method signature)  => void hello()
// - 메서드 블록 : 메서드 몸체(method body)  => { System.out.println("안녕하세요!"); System.out.println("이 메서드는 어떤 값도 리턴하지 않습니다."); }
//
// ## 메서드 종류?
// 1) 클래스 메서드
//    - 클래스에 소속되어 있다.
//    - 모든 인스턴스가 공유한다.
//    - static이 붙는다.
// 2) 인스턴스 메서드
//    - 특정 인스턴스에 대해 사용한다.
//    - static이 붙지 않는다.
