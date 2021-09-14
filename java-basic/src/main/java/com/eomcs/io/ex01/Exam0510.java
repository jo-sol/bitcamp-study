// 디렉토리에 들어 있는 파일이나 하위 디렉토리 정보 알아내기
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0510 {

  public static void main(String[] args) throws Exception {

    // 현재 폴더의 정보를 알아낸다.
    File dir = new File(".");

    // 현재 폴더에 있는 파일이나 하위 디렉토리 이름을 알아내기
    String[] names = dir.list();
    // 이름만 필요하면 list를 호출해서 스트링 배열로 받기

    for (String name : names) {
      System.out.println(name);
    }
  }
}


