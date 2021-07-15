package com.eomcs.lang.ex07;

// # 메서드 : main() 메서드 - 프로그램 아규먼트 응용 II
//
public class Exam0540 {

  public static void main(String[] args) {
    // 학생의 이름과 국영수 점수를 입력 받아 총점과 평균을 출력하라
    // $ java -cp ./bin/main com.eomcs.lang.ex07.Exam0540 홍길동 100 100 90
    // 이름: 홍길동
    // 총점: 290
    // 평균: 96.9
    //

    if (args.length < 4) {
      System.out.println(
          "실행 형식: java -cp ./bin/main com.eomcs.lang.ex07.Exam0540 이름 국어점수 영어점수 수학점수");
      return; // void일 때 return을 주면 메서드 실행 그만해! 라는 뜻이다 -> void니까 return에 값을 주면 안 됨
    }

    int sum = 0;
    for (int i = 1; i < args.length; i++) // 1번에서 4번 전까지
      sum += Integer.parseInt(args[i]); // 아규먼트 타입이 지금 문자열이라 숫자로 바꿔야 함 -> Integer.parseInt

    System.out.printf("이름: %s\n", args[0]);
    System.out.printf("총점: %d\n", sum);
    System.out.printf("평균: %.1f\n", sum / 3f); // 평균을 3으로 나누면 둘 다 정수라 하나를 부동소수점으로 바꿔 줘야 함 -> 소수까지 나옴
  }
}

