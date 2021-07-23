package com.eomcs.pms0;

import java.util.Scanner;

public class No1330 {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    int A = keyboard.nextInt();
    int B = keyboard.nextInt();

    if (A>B) {
      System.out.println(">");
    }
    if (A<B) {
      System.out.println("<");
    }
    if (A==B) {
      System.out.println("==");
    }

    keyboard.close();

  }

}
