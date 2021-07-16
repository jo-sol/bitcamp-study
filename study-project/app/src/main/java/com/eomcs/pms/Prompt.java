package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

//1) 사용자로부터 입력 받는 일을 하는 메서드를 별도의 클래스로 분류한다. 
public class Prompt {

  static Scanner keyboardScan = new Scanner(System.in);

  static String inputString(String title) {
    System.out.print(title);
    return keyboardScan.nextLine();
  }
  static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }
  static Date inputDate(String title) {
    return Date.valueOf(inputString(title));
  }

  static void close() {
    keyboardScan.close();
  }

}
