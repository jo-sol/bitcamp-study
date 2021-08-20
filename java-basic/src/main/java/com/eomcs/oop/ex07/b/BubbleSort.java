package com.eomcs.oop.ex07.b;

public class BubbleSort {
  public void run(int[] values) { // int[] values 여기에 배열값을 주면 아래 식이 돌아간다

    int size = values.length;

    for (int i = 0; i < size - 1; i++) {
      for (int j = 0; j < size - i - 1; j++) {
        if (values[j] > values[j + 1]) {
          //System.out.printf("%d <==> %d\n", values[j], values[j + 1]);
          int temp = values[j];
          values[j] = values[j + 1];
          values[j + 1] = temp;
        }
      }
    }
  }
}

// 더 큰 수를 만나기 직전까지 쭉 감
// 가다가 더 큰 수를 만나면 멈추고 그 큰 수는 다음 수와 비교해서
// 또 다시 더 큰 수를 만나기 직전까지 쭉 감

// 만약 전체 개수가 15 개라면 14 번만 반복
// 1~15까지 반복 >> 1~14까지 반복 >> 1~13까지 반복 >> ... >> 이렇게 14번 반복

// visualgo.net/en 참고하기