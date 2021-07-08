package com.eomcs.pms;

public class App {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.printf("[%s]\n", "회원");

    System.out.print("번호? ");
    String no = keyboard.nextLine();
    System.out.print("이름? ");
    String name = keyboard.nextLine();
    System.out.print("이메일? ");
    String mail = keyboard.nextLine();
    System.out.print("암호? ");
    String number = keyboard.nextLine();
    System.out.print("사진? ");
    String photo = keyboard.nextLine();
    System.out.print("전화? ");
    String tel = keyboard.nextLine();

    keyboard.close();

    java.sql.Date now = new java.sql.Date(System.currentTimeMillis());

    System.out.println("--------------------------------");

    System.out.println("번호: " + no);
    System.out.println("이름: " + name);
    System.out.println("이메일: " + mail);
    System.out.println("암호: " + number);
    System.out.println("사진: " + photo);
    System.out.println("전화: " + tel);
    System.out.println("가입일: " + now);



  }
}
