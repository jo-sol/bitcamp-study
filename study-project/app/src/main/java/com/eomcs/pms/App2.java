package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    System.out.printf("[%s]\n", "프로젝트");

    System.out.print("번호? ");
    int no = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("프로젝트명? ");
    String projectname = keyboard.nextLine();

    System.out.print("내용? ");
    String text = keyboard.nextLine();

    System.out.print("시작일? ");
    Date startDate = Date.valueOf(keyboard.nextLine());

    System.out.print("종료일? ");
    Date endDate = Date.valueOf(keyboard.nextLine());

    System.out.print("만든이? ");
    String made = keyboard.nextLine();

    System.out.print("팀원? ");
    String team1 = keyboard.next();
    String team2 = keyboard.next();
    String team3 = keyboard.next();
    String team4 = keyboard.next();
    String team5 = keyboard.next();

    keyboard.close();

    System.out.println("----------------------------");
    System.out.printf("번호: %d\n", no);
    System.out.printf("프로젝트명: %s\n", projectname);
    System.out.println("내용: " + text);  
    System.out.printf("시작일: %s\n", startDate);
    System.out.printf("종료일: %s\n", endDate);
    System.out.printf("만든이: %s\n", made);
    System.out.printf("%s, %s, %s, %s, %s\n", team1, team2, team3, team4, team5);

  }

}
