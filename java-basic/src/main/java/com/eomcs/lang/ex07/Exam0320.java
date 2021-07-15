package com.eomcs.lang.ex07;

//# 메서드 : call by reference
//
public class Exam0320 {

  static void swap(int[] arr) {
    System.out.printf("swap(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]); // 100, 200 출력
    int temp = arr[0]; // arr[0]이 가리키는 값을 넣기 (현재 100)
    arr[0] = arr[1]; // arr[1]이 가리키는 값을 넣기 (현재 200)
    arr[1] = temp; // temp가 가리키는 값을 넣기 (현재 100)
    System.out.printf("swap(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]); // 200, 100 출력
  } // => 여기에서 호출이 끝나게 되면 swap() 메서드 메모리는 사라진다

  public static void main(String[] args) {
    int[] arr = new int[] {100, 200}; // int[] 메모리 두 개 생성(100, 200)
    swap(arr); // 배열 인스턴스(메모리)를 넘기는 것이 아니다. // ex. 사물함을 예시로 들면 됨 (사물함이 아니라 사물함 번호를 받음) !!!!!
    // 주소를 넘기는 것이다.
    // 그래서 "call by reference" 라 부른다.
    System.out.printf("main(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]); // 200, 100 출력 
  } // -> 맞교환했고 swap 메서드 호출이 끝나도 바뀐 상태라 값이 바뀐 상태로 출력된다
} // -> 변수값이 아니라 주소값을 옮겼기 때문!

// 메인에서 만든 배열의 주소를 넘김 => reference(주소를 저장하는 변수를 의미)