package com.eomcs.pms0709;

import java.sql.Date;
import java.util.Scanner;

public class App02 {
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

/* package com.eomcs.pms; //강사님파일

import java.sql.Date; // 4-4 이처럼 적으면 4번처럼 적을 필요가 없다 (5번처럼 짧게 작성 가능)
import java.util.Scanner;

// new.java.sql.Date(밀리초) => 1. 날짜 정보를 다루는 물건을 생성  // 설계도로 직접 만드는 형식
// java.sql.Date.valueOf(날짜 문자열) => 2. 형식은 반드시 yyyy-MM-dd 으로 진행해야 한다 // 날짜 정보를 다루는 물건을 생성 // 자판기 형식
// 1번은 밀리초를 두어야 하고 2번은 yyyy-MM-dd를 두어야 한다

public class App2 {

  public static void main(String[] args) {
    System.out.println("[프로젝트]");

    Scanner keyboardScan = new Scanner(System.in);

    System.out.print("번호? ");
    int no = keyboardScan.nextInt();
    keyboardScan.nextLine(); // 번호 뒤에 남아 있는 줄바꿈 코드를 제거한다.

    System.out.print("프로젝트명? ");
    String title = keyboardScan.nextLine();

    System.out.print("내용? ");
    String content = keyboardScan.nextLine();

    System.out.print("시작일? ");
    // 3. Date startDate = keyboardScan.nextLine(); 이 방법도 가능하지만 아래에 있는 형식을 사용하는 게 더 좋다.
    // 4. java.sql.Date StartDate = java.sql.Date.valueOf(keyboardScan.nextLine()); 이 방법도 좋지만 너무 길어지니까 미리 4-4로 적어야 편하다
    Date startDate = Date.valueOf(keyboardScan.nextLine()); // 5. 짧게 작성 가능 // 2번처럼 반드시 yyyy-MM-dd 형식으로 해야 한다

    System.out.print("종료일? ");
    Date endDate = Date.valueOf(keyboardScan.nextLine());

    System.out.print("만든이? ");
    String owner = keyboardScan.nextLine();

    System.out.print("팀원? ");
    String members = keyboardScan.nextLine();

    keyboardScan.close();

    System.out.println("--------------------------------");

    System.out.printf("번호: %d\n", no);
    System.out.printf("프로젝트명: %s\n", title);
    System.out.printf("내용: %s\n", content);
    System.out.printf("시작일: %s\n", startDate);
    System.out.printf("종료일: %s\n", endDate);
    System.out.printf("만든이: %s\n", owner);
    System.out.printf("팀원: %s\n", members);
  }
}
 */
