package com.eomcs.lang.ex06;

//# 흐름 제어문 - break와 continue 활용
//
public class Exam0321 {
  public static void main(String[] args) {
    int count = 0;
    int sum = 0;


    // 1부터 100까지의 짝수의 합은?
    // => continue 사용 전
    count = 0;
    sum = 0;
    while (count < 100) { // 100번 반복한다 0~99까지
      count++;
      if ((count & 0x01) == 0) { // count & 1 ==> count & 0x01 ==> count % 2 // 이 조건이 참이면 아래 sum에 넣겠다는 의미
        // if ((count & 1) == 0)도 가능
        // -> 맨 끝의 비트를 추출해서 그게(= 나누고 나머지가) 0이면 짝수
        // 값을 추출해서 나머지가 1이면 홀수 0이면 짝수
        sum += count;
      }
    }
    System.out.printf("count=%d, sum=%d\n", count, sum);

    System.out.println("------------------------");

    // => continue 사용 후
    count = 0;
    sum = 0;
    while (count < 100) {
      count++;
      if (count % 2 == 1) // 홀수 // 홀수일 때는 아래를 실행하지 않고 countinue; (-> 다시 조건문)으로 가라
        continue; // 다음 문장을 실행하지 않고 즉시 조건 검사로 이동한다.
      sum += count;
    }
    System.out.printf("count=%d, sum=%d\n", count, sum);
  }
}
