package com.eomcs.pms;

public class Apptest2 {

  public static void main(String[] args) {
    java.util.Date currentDate = new java.util.Date();

    java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");

    String dateString = format.format(currentDate);

    System.out.println(dateString);


  }

}
