package com.eomcs.pms;

public class Apptest {

  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.println("[회원]");

    System.out.print("번호? "); // println은 줄바꿈이 포함된 명령어이기 때문에
    // print를 사용해야 자동 줄바꿈이 실행되지 않는다
    int no = keyboard.nextInt(); // 번호니까 정수인 int를 사용해 보는데 nextInt는 엔터 포함이다
    keyboard.nextLine(); // 따라서 키보드 메모리에 남아 있는 찌꺼기 엔터 코드 제거 위해 nextLine 추가

    System.out.print("이름? "); // 한 줄 입력받아서 리턴하면 어딘가에 담겨야 하는
    String name = keyboard.nextLine(); // 그래서 문자열 변수인 "String"을 넣어 준다

    System.out.print("이메일? ");
    String email = keyboard.nextLine();

    System.out.print("암호? ");
    String password = keyboard.nextLine();

    System.out.print("사진? ");
    String photo = keyboard.nextLine();

    System.out.print("전화? ");
    String tel = keyboard.nextLine();

    java.sql.Date registeredDate = new java.sql.Date(System.currentTimeMillis());

    /* System.out.print("가입일? ");
    String registeredDate = keyboard.nextLine(); */ 

    // 문제: 가입일은 회원 정보를 입력 받은 시간을 보관했다가 출력한다.

    keyboard.close();

    System.out.println("------------------------------");
    System.out.printf("번호: %d\n", no); // s1 변수에 들어있는 문자열을 붙여서 하나의 문자열로 만들어 출력해라
    // int로 받았기 때문에 %d로 받아야 한다
    System.out.printf("이름: %s\n", name); // 변수값을 문자열로 삽입하는 방법: %s
    System.out.printf("이메일: %s\n", email); // %s 넣으면 + 대신 , 사용한다
    System.out.printf("암호: %s\n", password); // , 다음에 오는 변수의 값을 %s 자리에 넣어라
    System.out.printf("사진: %s\n", photo); // printf는 줄바꿈이 되지 않기 때문에
    System.out.printf("전화: %s\n", tel); // \n이라는 강제 줄바꿈을 강제로 삽입해야 한다
    System.out.printf("가입일: %s\n", registeredDate);


  }

}
