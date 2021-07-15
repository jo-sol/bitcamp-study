package com.eomcs.algorithm.quiz;

public class Test {

  static int maxDiff(int[] values) {
    int answer = 1;
    for (int i = 1; i < values.length; i++) {
      if ((values[i] - values[i - 1]) > answer) {
        answer = Math.abs(values[i] - values[i-1]);
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(maxDiff(new int[]{2, 4, 1, 0}));

  }
}

//  int result = 0; // 짝수가 몇 개인지 count하려고 result 변수 넣음 // 3) -> 1 // 6) 12386946일 때 짝수니까 2로 증가시키고 또 반복
//  int n = value; // 1) 1238694636값을 n에 담음 // 4)-> 6을 떼버림 // 7) 10의 단위로 끊어서 버리고 반복
//  while(n != 0) { // 8) n이 0이 아닐 때까지 반복
//    if ((n % 2) == 0) { // 2) n을 2로 나누기 = 0이면 짝수 -> 그러면 1이 되고 // 5) n을 2로 나눴는데 홀수니까 다시 진행하고 반복
//      result++;
//    }
//    n /= 10;
//  }
//    return result;