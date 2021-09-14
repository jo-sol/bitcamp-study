// 데이터 출력 - int 값 출력
package com.eomcs.io.ex04;

import java.io.FileOutputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("temp/test3.data");

    int money = 1_3456_7890; // = 0x080557d2

    out.write(money); //항상 출력할 때는 맨 끝 1바이트만 출력한다.

    out.close();

    System.out.println("데이터 출력 완료!");

  }

}

// File 포맷이나 저장 규칙에 따라 파일의 속성이 다를 때는(ex. PDF 등)
// FileStream을 사용해라!
// FileReader (ex. txt 등)