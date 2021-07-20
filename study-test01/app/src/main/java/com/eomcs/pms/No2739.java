package com.eomcs.pms;

// 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 9보다 작거나 같다.
import java.util.Scanner;

public class No2739 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();

    sc.close();

    for (int i = 1; i <= 9; i++) {
      System.out.println(a + " * " + i + " = " + (a * i));
    }

  }

}
