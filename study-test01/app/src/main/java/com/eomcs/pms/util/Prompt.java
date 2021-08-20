package com.eomcs.pms.util;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {

  static Scanner keyS = new Scanner(System.in);

  public static String inputString(String title) {
    System.out.print(title);
    return keyS.nextLine();
  }

  public static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }

  public static Date inputDate(String title) {
    return Date.valueOf(inputString(title));
  }

  public static void close() {
    keyS.close();
  }
}
