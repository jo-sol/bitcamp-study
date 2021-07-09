package com.eomcs.pms; //강사님파일

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    System.out.println("[프로젝트]");

    final int MAX_LENGTH = 10;

    int[] no = new int[MAX_LENGTH];
    String[] title = new String[MAX_LENGTH];
    String[] content = new String[MAX_LENGTH];
    Date[] startDate = new Date[MAX_LENGTH];
    Date[] endDate = new Date[MAX_LENGTH];
    String[] owner = new String[MAX_LENGTH];
    String[] members = new String[MAX_LENGTH];

    Scanner keyboardScan = new Scanner(System.in);

    int size = 0;

    for (int i = 0; i < MAX_LENGTH; i = i + 1) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());
      
      System.out.print("프로젝트명? ");
      title[i] = keyboardScan.nextLine();
      
      System.out.print("내용? ");
      content[i] = keyboardScan.nextLine();
      
      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyboardScan.nextLine()); 
      
      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyboardScan.nextLine());
      
      System.out.print("만든이? ");
      owner[i] = keyboardScan.nextLine();
      
      System.out.print("팀원? ");
      members[i] = keyboardScan.nextLine();
      
      size = size + 1;
      System.out.println();

      System.out.print("계속 입력하시겠습니까? (y/N) ");
      String input = keyboardScan.nextLine();
      if (input.equals("N") || input.equals("")) {
        break;
      }
      System.out.println();
    }

    keyboardScan.close();

    System.out.println("--------------------------------");

    for (int i = 0; i < size; i = i + 1) {
      System.out.printf("%d, %s, %tY-%3$tm-%3$td, %tY-%4$tm-%4$td, %s\n",
    no[i],
    title[i],
    startDate[i],
    endDate[i],
    owner[i]);
    }
  }
}