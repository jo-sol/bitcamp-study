// 추상 클래스와 추상 메서드의 활용: 적용 전 -> // visualgo.net/en 참고하기 
package com.eomcs.oop.ex07.b;

import java.util.Arrays;

public class Exam01 {

  static int[] createRandomNumbers(final int size) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = i;
    }

    // ex. x 를 n번 >> 연산할 때, x >> n 는  x / 2n과 같다.
    //     오른쪽으로 이동하면서 부호유지를 위해 음수일 경우, 빈값을 1로 채운다.
    int count = size >> 1; // 오른쪽으로 1 이동 >> 절반만 반복
    for (int i = 0; i < count; i++) {
      int index1 = (int)(Math.random() * size); // 1) 랜덤으로 막 섞여 있는 숫자
      int index2 = (int)(Math.random() * size);
      int temp = arr[index1];
      arr[index1] = arr[index2];
      arr[index2] = temp;
    }
    return arr;
  }

  public static void main(String[] args) {

    int[] values = createRandomNumbers(100000); // 2) createRandomNumbers: 십만개의 배열을 만들고 그 숫자들을 막 섞는다
    int[] values2 = Arrays.copyOf(values, values.length); // values.length: 위에 있는 기존 원본 배열을 그대로 복사해서 만들겠다
    // 두 배열은 서로 다른 배열이지만 값이 똑같은 배열을 복사해서 만들겠다.

    // 똑같은 값이 나오는지 확인
    //    for (int i = 0; i < values.length; i++) {
    //      System.out.println(values[i] + " --- " + values[2]);
    //    }
    //    System.out.println();

    BubbleSort s1 = new BubbleSort();
    QuickSort s2 = new QuickSort();

    // 두 개의 정렬 객체가 서로 다른 타입이기 때문에
    // 정렬을 수행하고 출력할 메서드를 따로 따로 만들어야 한다.
    // 클래스의 사용법도 달라서 불편하다.
    // BubbleSort 객체는 run()을 호출해야 하고,
    // QuickSort 객체는 start()를 호출해야 한다.
    //
    // 정렬을 수행하는 시간이 얼마나 걸리는지 구해 보기
    display(s1, values);
    display(s2, values2);

  }

  // 정렬을 수행하는 객체와 값을 주면
  // 그 값을 정렬한 후 출력하는 메서드이다.
  static void display(BubbleSort sorter, int[] values) {

    //System.out.println("[정렬 전]");
    //printNumbers(values);

    // 정렬 전 현재 시간
    long start = System.currentTimeMillis();

    // BubbleSort 사용법에 맞춰 정렬을 수행한다.
    sorter.run(values);

    long end = System.currentTimeMillis();
    System.out.printf("걸린시간: %d\n", end - start);

    //System.out.println("[정렬 후]--------------------------");
    //printNumbers(values);
  }

  static void display(QuickSort sorter, int[] values) {

    //System.out.println("[정렬 전]");
    //printNumbers(values);

    long start = System.currentTimeMillis();

    // QuickSort 사용법에 맞춰 정렬을 수행한다.
    sorter.start(values, 0, values.length - 1);

    long end = System.currentTimeMillis();
    System.out.printf("걸린시간: %d\n", end - start);

    //System.out.println("[정렬 후]--------------------------");
    //printNumbers(values);
  }

  static void printNumbers(int[] values) {
    for (int  value : values) {
      System.out.print(value + ",");
    }
    System.out.println();
  }
}






